package com.study.jvm.io.socket;

import com.dranawhite.common.common.ThreadUnit;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author dranawhite
 * @version $Id: SocketPro.java, v 0.1 2019-01-24 23:00 dranawhite Exp $$
 */
public class SocketPro {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8080);
        socket.setKeepAlive(true);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();

        byte[] data = "Hi Server!".getBytes();
        byte[] result = new byte[1024];
        out.write(data);
        out.flush();
        in.read(result);
        System.out.println("Result = " + new String(result));
        ThreadUnit.sleep(5);
        out.write(data);
        out.flush();
        in.read(result);
        System.out.println("Result = " + new String(result));

        System.in.read();
    }

}
