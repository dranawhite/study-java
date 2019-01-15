package com.study.jvm.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 *
 * @author dranawhite
 * @version $Id: Server.java, v 0.1 2019-01-15 11:50 dranawhite Exp $$
 */
public class Server {

    public static void main(String[] args) throws IOException {
        InputStream in = null;
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            int recvMessageSize = 0;
            byte[] buffer = new byte[1024];
            while (true) {
                System.out.println("Wait for connect!");
                Socket socket = serverSocket.accept();
                System.out.println("Remote Address : " + socket.getInetAddress().toString());
                in = socket.getInputStream();
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
