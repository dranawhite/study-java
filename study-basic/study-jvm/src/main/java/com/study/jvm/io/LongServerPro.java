package com.study.jvm.io;


import com.dranawhite.common.common.ThreadUnit;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟服务端耗时操作，抓包截取信息
 *
 * @author dranawhite
 * @version $Id: LongServerPro.java, v 0.1 2019-01-30 17:44 dranawhite Exp $$
 */
public class LongServerPro {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream ins = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                InputStreamReader reader = new InputStreamReader(ins);
                char[] buffer = new char[1024];
                reader.read(buffer);

                String info = new String(buffer);
                System.out.println("Receive message: " + info);
                ThreadUnit.sleep(10);
                out.write("HTTP/1.1 200 OK\r\n".getBytes());
                out.write("content-type:text/html\r\n\r\n".getBytes());
                out.write("<h1>Hi Client, Got your message!</h1>".getBytes());
                out.flush();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
