package com.study.jvm.io.bio;

import org.mozilla.javascript.IdFunctionObjectES6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 *
 * @author dranawhite
 * @version $Id: StreamToReaderPro.java, v 0.1 2019-01-16 13:51 dranawhite Exp $$
 */
public class StreamToReaderPro {

    public static void main(String[] args) {
        printByCharacter();
        System.out.println("\n=================");
        printByStream();
    }

    private static void printByStream() {
        File file = new File("F:\\idea_workspaces\\study-java\\reversion.sh");
        try (InputStream ins = new FileInputStream(file)) {
            Channel channel = ((FileInputStream) ins).getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            ((FileChannel) channel).read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print(buffer.get());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void printByCharacter() {
        File file = new File("F:\\idea_workspaces\\study-java\\reversion.sh");
        try (InputStream ins = new FileInputStream(file);
             InputStreamReader reader = new InputStreamReader(ins)) {
            CharBuffer buffer = CharBuffer.allocate(4096);
            reader.read(buffer);
            buffer.flip();
            while(buffer.hasRemaining()) {
                System.out.print(buffer.get());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
