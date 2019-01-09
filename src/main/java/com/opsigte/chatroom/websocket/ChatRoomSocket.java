package com.opsigte.chatroom.websocket;

import com.opsigte.chatroom.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/socket/{uid}")
@Component
public class ChatRoomSocket {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static ConcurrentHashMap<String, ChatRoomSocket> webSocketSet = new ConcurrentHashMap<String, ChatRoomSocket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private String userId = "";

    @Autowired
    private UserRelationService userRelationService;

    @OnOpen
    public void onOpen(@PathParam(value = "uid") String uid, Session session){
        this.session = session;
        this.userId = uid;
        webSocketSet.put(uid, this);
        addOnlineCount();
        System.out.println("当前在线人数：" + onlineCount);

    }

    @OnClose
    public void onClose(){
        if (!"".equals(userId)) {
            webSocketSet.remove(userId);
            subOnlineCount();
            System.out.println("当前在线人数：" + onlineCount);
        }
    }


    /**
     * 服务端接收到客户端发来的消息，然后根据最后一个 "|" 来区分是群发还是个人消息
     *
     * @Title onMessage
     * @param message
     * @return void
     * @throws
     */
    @OnMessage
    public void onMessage(String message){
        // 判断是群发消息还是个人消息
        if (message != null) {
            int index = message.lastIndexOf("|");
            String msg = message.substring(0, index);
            String uids = message.substring(index+1);
            String[] split = uids.split(",");
            String targetUid = split[0];
            String uid = split[1];

            // 根据sourceUid和targetUid查询关系id
            String relationId = userRelationService.selectRelationIdByUid(uid, targetUid);

            if (!"".equals(targetUid)) {
                // 个人消息
                sendToUserRelation(msg,targetUid,relationId);
            } else {
                // 群发消息
                sendToAll(msg);
            }
        }
    }





    /**
     * 发送给指定用户
     *
     * @Title sendToUserRelation
     * @param msg, targetUid:接收人uid，uid:发送人uid
     * @return void
     * @throws
     */
    private void sendToUserRelation(String msg,String targetUid,String uid){
        if (webSocketSet.get(targetUid) != null) {
            try {
                webSocketSet.get(targetUid).sendMessage(msg+"|"+uid);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 群发消息
     *
     * @Title sendToAll
     * @param msg
     * @return void
     * @throws
     */
    private void sendToAll(String msg){
        for (String key : webSocketSet.keySet()) {
            if (!key.equals(userId)) {
                //判断接收用户是否是当前发消息的用户
                try {
                    webSocketSet.get(key).sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    /**
     * webSocket发送消息
     *
     * @Title sendMessage
     * @param message
     * @return void
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    private static synchronized void addOnlineCount(){
        ChatRoomSocket.onlineCount++;
    }
    private static synchronized void subOnlineCount(){
        ChatRoomSocket.onlineCount--;
    }
    private static synchronized int getOnlineCount(){
        return ChatRoomSocket.onlineCount;
    }
}
