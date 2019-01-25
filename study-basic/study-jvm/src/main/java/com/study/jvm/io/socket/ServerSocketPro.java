/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.jvm.io.socket;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletOutputStream;

/**
 *
 * @author liangyuquan
 * @version $Id: ServerSocketPro.java, v 0.1 2019-01-24 20:40 liangyuquan Exp $$
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
                System.out.println("Got data " + new String(buffer) + "; Size = " + num);
                System.out.println(System.currentTimeMillis());
                out.write(new String("HTTP/1.1 200 OK").getBytes());
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
