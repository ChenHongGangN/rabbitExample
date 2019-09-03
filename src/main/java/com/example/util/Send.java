package com.example.util;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @Author chenhonggang
 * @description
 * @date 2019/8/27
 */
public class Send {
    private final static String QUEUE_NAME = "q_test_01";
    public static void main(String[] args) throws Exception{
        //获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建通道
        Channel channel = connection.createChannel();
        //声明（创建）队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //消息内容
        String message = "HELLO word";
        for(int i=0;i<11;i++){
            channel.basicPublish("",QUEUE_NAME,null,(message+i).getBytes());
            System.out.println("[x] Send '"+(message+i)+"'");
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
