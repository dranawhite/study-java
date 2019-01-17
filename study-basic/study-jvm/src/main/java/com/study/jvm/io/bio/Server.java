package com.study.jvm.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 *
 * @author dranawhite
 * @version $Id: Server_1.java, v 0.1 2019-01-15 11:50 dranawhite Exp $$
 */
public class Server {

    public static void main(String[] args) throws IOException {
        InputStream in = null;
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress("127.0.0.1", 8080));
            int recvMessageSize;
            byte[] buffer = new byte[1024];
            while (true) {
                System.out.println("Wait for connect!");
                Socket socket = serverSocket.accept();
                System.out.println("Remote Address : " + socket.getInetAddress().toString());
                in = socket.getInputStream();
                System.out.println("Wait for data!");
                while ((recvMessageSize = in.read(buffer)) != -1) {
                    byte[] tmp = Arrays.copyOf(buffer, recvMessageSize);
                    System.out.println("Receive Message: " + new String(tmp));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
