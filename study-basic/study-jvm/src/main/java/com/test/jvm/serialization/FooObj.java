package com.test.jvm.serialization;

import lombok.Data;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author liangyq
 * @version [1.0, 2018/4/14 11:08]
 */
@Data
public class FooObj implements Serializable {

	private int id;

	private String name;

	private static String address;

	private void writeObject(ObjectOutputStream outs) {
		System.out.println(this);
	}

	private void readObject(ObjectInputStream ins) {
		System.out.println(this);
	}

}
