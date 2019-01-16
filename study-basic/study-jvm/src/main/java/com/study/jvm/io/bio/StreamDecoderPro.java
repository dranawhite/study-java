/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.jvm.io.bio;

import sun.nio.cs.StreamDecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author liangyuquan
 * @version $Id: StreamDecoderPro.java, v 0.1 2019-01-16 14:05 liangyuquan Exp $$
 */
public class StreamDecoderPro {

    public static void main(String[] args) {
        StreamDecoderPro pro = new StreamDecoderPro();
        pro.streamDecoder();
    }

    private void streamDecoder() {
        File file = new File("F:\\idea_workspaces\\study-java\\reversion.sh");
        try (FileInputStream ins = new FileInputStream(file)) {
            StreamDecoder streamDecoder = StreamDecoder.forInputStreamReader(ins, this, UTF_8);
            CharBuffer buffer = CharBuffer.allocate(4096);
            streamDecoder.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print(buffer.get());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
