package com.study.jvm.serialization;

import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.common.exception.file.DranaFileException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dranawhite
 * @version $Id: KryoSerializer.java, v 0.1 2019-02-23 11:44 dranawhite Exp $$
 */
public class KryoSerializer {

    private static final ThreadLocal<Kryo> kryoThreadLocal = ThreadLocal.withInitial(() -> {
        Kryo kryo = new Kryo();
        // configure kryo instance, customize settings
        kryo.setReferences(false);
        kryo.register(Collection.class);
        kryo.register(Map.class);
        return kryo;
    });

    private static Map<Class, Registration> registrationMap = new ConcurrentHashMap<>();

    /**
     * 序列化
     *
     * @param obj 序列化对象
     * @return 序列化后的byte[]值
     */
    public static <T> byte[] serializer(T obj) {
        Class<T> clazz = (Class<T>) obj.getClass();
        Kryo kryo = kryoThreadLocal.get();
        if (!registrationMap.containsKey(clazz)) {
            Registration registration = kryo.register(clazz);
            registrationMap.put(clazz, registration);
        }

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             Output output = new Output(outputStream)) {
            kryo.writeObject(output, obj);
            output.flush();
            return outputStream.toByteArray();
        } catch (IOException ex) {
            throw new DranaFileException("序列化对象失败", ResultCodeEnum.SERVICE_UNAVAILABLE, ex);
        }
    }

    /**
     * 反序列化
     *
     * @param data  序列化后的byte[]值
     * @param clazz 反序列化后的对象
     * @return 返回的对象
     */

    public static <T> T deserializer(byte[] data, Class<T> clazz) {
        Kryo kryo = kryoThreadLocal.get();
        Registration registration = registrationMap.get(clazz);
        if (registration == null) {
            registration = kryo.register(clazz);
            registrationMap.put(clazz, registration);
        }
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
             Input input = new Input(byteArrayInputStream)) {
            return (T) kryo.readObject(input, registration.getType());
        } catch (IOException ex) {
            throw new DranaFileException("反序列化对象失败", ResultCodeEnum.SERVICE_UNAVAILABLE, ex);
        }
    }

    public static void main(String[] args) {
        FooObj foo = new FooObj();
        foo.setId(1);
        foo.setName("John");

        byte[] data = KryoSerializer.serializer(foo);
        FooObj result = KryoSerializer.deserializer(data, FooObj.class);
        System.out.println("Result = " + result);
    }
}
