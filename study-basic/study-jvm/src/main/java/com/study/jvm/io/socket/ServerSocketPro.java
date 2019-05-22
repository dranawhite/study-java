package com.study.jvm.io.socket;

import com.dranawhite.common.common.ThreadUnit;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用Content-Length和Transfer-Encoding:chunked保持长连接
 *
 * Transfer-Encoding:chunked的报文实体中需要改为一系列分块传输，每个分块包含十六进制的长度值和数据，长度值独占一行，长度不包括结尾的CRLF，
 * 最后一个分块的长度值必须为0，对应的分块数据没有内容，表示实体结束。
 *
 * @author dranawhite
 * @version $Id: ServerSocketPro.java, v 0.1 2019-01-24 20:40 dranawhite Exp $$
 */
public class ServerSocketPro {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
        Socket socket = serverSocket.accept();
        System.out.println("Access Linkage!");
        System.out.println(System.currentTimeMillis());
        socket.setKeepAlive(true);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        InputStream ins = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        char[] buffer = new char[2048];
        try {
            while (true) {
                InputStreamReader reader = new InputStreamReader(ins);
                int num = reader.read(buffer);
                String inMsg = new String(buffer);
                System.out.println("Got data " + inMsg + "; Size = " + num);
                System.out.println(System.currentTimeMillis());
//                String header = "HTTP/1.1 200 OK\r\nContent-Type:text/html\r\nContent-Length:12\r\n\r\nHello World!";
                StringBuilder chunkedSb = new StringBuilder();
                chunkedSb.append("HTTP/1.1 200 OK\r\n");
                chunkedSb.append("Content-Type:text/html\r\n");
                chunkedSb.append("Transfer-Encoding:chunked\r\n");
                chunkedSb.append("\r\n");

                // 第一个数据块
                chunkedSb.append("c\r\n");
                chunkedSb.append("Hello World!\r\n");
                System.out.println("First Chunked!");
                ThreadUnit.sleep(3);

                // 第二个数据块
                chunkedSb.append("5\r\n");
                chunkedSb.append("Dogie\r\n");
                System.out.println("Second Chunked!");
                ThreadUnit.sleep(3);

                // 最后一个数据块
                chunkedSb.append("0\r\n");
                chunkedSb.append("\r\n");
                System.out.println("Last Chunked!");

                String header = chunkedSb.toString();
                out.write(header.getBytes());
                out.flush();
            }
        } catch (Exception ex) {
            System.out.println("Time Out! Close Stream!");
            System.out.println(System.currentTimeMillis());
            ins.close();
            socket.close();
            ex.printStackTrace();
        }
    }
}