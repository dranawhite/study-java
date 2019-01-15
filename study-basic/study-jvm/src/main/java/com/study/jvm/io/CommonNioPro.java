package com.study.jvm.io;

import com.dranawhite.common.resource.ResourceLoader;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author dranawhite
 * @version $Id: CommonNioPro.java, v 0.1 2019-01-14 20:32 dranawhite Exp $$
 */
public class CommonNioPro {

    public static void main(String[] args) throws IOException {
        String name = ResourceLoader.getClasspathResource("com/study/jvm/io/CommonNioPro.class");
        RandomAccessFile file = new RandomAccessFile(name, "rw");
        Channel channel = file.getChannel();

        byte[] tmpBuffer = new byte[4096];
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        while (((FileChannel) channel).read(buffer) != -1) {
            buffer.flip();
            buffer.get(tmpBuffer, 0, buffer.remaining());
            buffer.clear();
        }
        System.out.println(new String(tmpBuffer, StandardCharsets.UTF_8));
    }

}