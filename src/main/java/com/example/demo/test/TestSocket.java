package com.example.demo.test;

import java.io.*;
import java.net.Socket;

/**
 * 测试socket
 */
public class TestSocket {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("172.18.2.103",17520);

        boolean autoflush = true;
        PrintWriter out = new PrintWriter(socket.getOutputStream(),autoflush);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // send an HTTP request to the web server
        out.println("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection: Close");
        out.println();

        // read the response
        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while (loop) {
            if (in.ready()){
                int i = 0 ;
                while (i != -1){
                    i = in.read();
                    sb.append((char)i);
                }
                loop = false;
            }
            Thread.currentThread().sleep(50);
        }

        // display the response to the out console
        System.out.println(sb.toString());
        socket.close();
    }
}
