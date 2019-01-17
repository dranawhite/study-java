package com.study.jvm.io.nio;

import sun.nio.cs.StreamDecoder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * Byte To Character
 *
 * @author dranawhite
 * @version $Id: CommonServer.java, v 0.1 2019-01-17 14:27 dranawhite Exp $$
 */
public class CommonServer {

    public static void main(String[] args) {
        printAsCharacter();
    }

    private static void printAsByte() {
        try (ServerSocketChannel socketChannel = ServerSocketChannel.open()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.bind(new InetSocketAddress("127.0.0.1", 8080));
            SocketChannel channel = socketChannel.accept();
            if (channel.read(buffer) != -1) {
                buffer.flip();
                System.out.println("Got message!");
                while (buffer.hasRemaining()) {
                    System.out.print(buffer.get());
                }
                buffer.clear();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void printAsCharacter() {
        try (ServerSocketChannel socketChannel = ServerSocketChannel.open()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            CharBuffer charBuffer = CharBuffer.allocate(512);
            socketChannel.bind(new InetSocketAddress("127.0.0.1", 8080));
            SocketChannel channel = socketChannel.accept();
            StreamDecoder streamDecoder = StreamDecoder.forDecoder(channel, StandardCharsets.UTF_8.newDecoder(),
                    buffer.remaining());
            if (streamDecoder.read(charBuffer) != -1) {
                charBuffer.flip();
                while (charBuffer.hasRemaining()) {
                    System.out.print(charBuffer.get());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
