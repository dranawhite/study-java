package com.study.jvm.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 *
 * @author dranawhite
 * @version $Id: ChineseClient.java, v 0.1 2019-01-17 14:47 dranawhite Exp $$
 */
public class ChineseClient {

    public static void main(String[] args) {
        try (SocketChannel channel = SocketChannel.open()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.connect(new InetSocketAddress("127.0.0.1", 8080));
            if (channel.finishConnect()) {
                String msg = "我是中文，我会乱码，咬我呀!";
                System.out.println(msg);
                buffer.put(msg.getBytes());
                buffer.flip();
                channel.write(buffer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
