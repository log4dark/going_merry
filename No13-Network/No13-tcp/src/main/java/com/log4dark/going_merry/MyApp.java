package com.log4dark.going_merry;

public class MyApp {
    public static void main(String[] args) {
        System.out.printf("Hello Dark...\n");

        // TCP Server start...
        TcpServer tcpServer = new TcpServer("127.0.0.1", 9100);

        // TCP Server with Thread per request...
//        TcpServer2 tcpServer = new TcpServer2("127.0.0.1", 9100);
    }
}
