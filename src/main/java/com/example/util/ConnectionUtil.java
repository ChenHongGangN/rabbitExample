package com.example.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author chenhonggang
 * @description
 * @date 2019/8/27
 */
public class ConnectionUtil {
    public static Connection getConnection() throws Exception{
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务器地址
        factory.setHost("127.0.0.1");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("chgrabbit");
        //通过工程获取连接
        Connection connection = factory.newConnection();
        return  connection;
    }
}
