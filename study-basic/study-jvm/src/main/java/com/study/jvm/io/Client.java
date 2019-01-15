package com.study.jvm.io;

import com.dranawhite.common.common.ThreadUnit;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 *
 * @author dranawhite
 * @version $Id: Client.java, v 0.1 2019-01-15 11:45 dranawhite Exp $$
 */
public class Client {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try (SocketChannel socketChannel = SocketChannel.open()) {
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
            if (socketChannel.finishConnect()) {
                int i = 0;
                while (true) {
                    ThreadUnit.sleep(5);
                    System.out.println("Sending " + i);
                    String info = "This is the no " + i++ + " message from " + Thread.currentThread().getName();
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    if (buffer.hasRemaining()) {
                        socketChannel.write(buffer);
                    }
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
