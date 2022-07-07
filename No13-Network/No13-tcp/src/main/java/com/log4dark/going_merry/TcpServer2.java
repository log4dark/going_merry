package com.log4dark.going_merry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class TcpServer2 {
    private ServerSocket serverSocket;
    public TcpServer2(String hostname, int port) {

        System.out.printf("TcpServer(%s:%d) start...\n", hostname, port);

        try {
            serverSocket = new ServerSocket(); // 서버 소켓 생성
            serverSocket.bind(new InetSocketAddress(hostname, port)); // 주소와 포트 바인딩

            while(true) {
                System.out.printf("listen...\n");
                Socket socket = serverSocket.accept(); // 클라이언트 연결 수락

                // 클라이언트 연결 수락 될 때 마다 Thread 생성 후 처리...
                Thread client = new Thread(() -> {

                    Thread thread = Thread.currentThread();

                    InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                    System.out.printf("thread(%s) - accept client(%s)\n", thread.getName(), isa.toString());

                    try {
                        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                        pw.println("220 OK");
                        //pw.println("499 ERROR");

                        // Character Set
                        Charset charset = Charset.forName("EUC-KR");

                        for (; ; ) {
                            // 데이터 수신
                            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), charset));
                            String message = br.readLine();
                            System.out.printf("Recv: %s\n", message);

                            if (message.equals("QUIT")) break;

                            pw.println("250 OK");
                        }
                    } catch (Exception e) {
                        System.out.printf("Exception: %s\n", e.toString());
                    }
                });
                client.start();
            }
        } catch (Exception e) {
            System.out.println("e: " + e.toString());
        }

        if (!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
