package com.opsigte.chatroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.opsigte.chatroom.dao")
public class ChatroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatroomApplication.class, args);
    }

}

