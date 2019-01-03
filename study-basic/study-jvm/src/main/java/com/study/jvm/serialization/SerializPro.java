package com.study.jvm.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * JVM使用ObjectOutputStream对对象序列化
 *
 * @author liangyq
 * @version [1.0, 2018/4/14 11:10]
 */
public class SerializPro {

	public static void main(String[] args) throws IOException {
		FooObj foo = new FooObj();
		foo.setId(1);
		foo.setName("Jerry");

		ByteArrayOutputStream byteOuts = new ByteArrayOutputStream();
		ObjectOutputStream objIns = new ObjectOutputStream(byteOuts);
		objIns.writeObject(foo);
	}

}
