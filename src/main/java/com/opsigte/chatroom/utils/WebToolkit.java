package com.opsigte.chatroom.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebToolkit {

    /**
     * @param htmlStr
     * @return String
     * @Title: delHTMLTag
     * @Description: 判断是否是html标签
     */
    public static String delHTMLTag(String htmlStr) {
        //定义script的正则表达式
        String regexScript = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        //定义style的正则表达式
        String regexStyle = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        String regexHtml ="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern pScript = Pattern.compile(regexScript, Pattern.CASE_INSENSITIVE);
        Matcher mScript = pScript.matcher(htmlStr);
        htmlStr = mScript.replaceAll(""); //过滤script标签

        Pattern pStyle = Pattern.compile(regexStyle, Pattern.CASE_INSENSITIVE);
        Matcher mStyle = pStyle.matcher(htmlStr);
        htmlStr = mStyle.replaceAll(""); //过滤style标签

        Pattern pHtml = Pattern.compile(regexHtml , Pattern.CASE_INSENSITIVE);
        Matcher mHtml = pHtml.matcher(htmlStr);
        htmlStr = mHtml.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符串
    }
}
