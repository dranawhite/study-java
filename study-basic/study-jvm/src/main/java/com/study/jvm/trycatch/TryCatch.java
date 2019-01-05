package com.study.jvm.trycatch;

import java.io.IOException;

/**
 * JDK1.7 的try() catch语法糖
 * <pre>
 *     try()中的内容必须实现AuthClosabled接口
 * </pre>
 *
 * @author dranawhite 2017/10/25
 * @version 1.0
 */
public class TryCatch {


 /**
  * 编译后字节码如下：
  *
  * public void barResource() {
        BarResource bar = new BarResource();
        Throwable var2 = null;

        try {
            throw new NullPointerException("执行时出现空指针！");
        } catch (Throwable var10) {
            var2 = var10;
            throw var10;
        } finally {
            if (bar != null) {
                if (var2 != null) {
                    try {
                        bar.close();
                    } catch (Throwable var9) {
                        var2.addSuppressed(var9);
                    }
                } else {
                    bar.close();
                }
            }

        }
    }*/
    public void barResource() {
        try (BarResource bar = new BarResource()) {
           throw new NullPointerException("执行时出现空指针！");
        }
    }


    /**
     * 实现AutoClosable接口，使用try-with-resources方式使用的资源。如果close方法抛出异常，则会保留原有的异常
     */
    public void fooResource() {
        try (FooResource foo = new FooResource()) {
            throw new IOException("运行中出现IO异常!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fooNormalResource() {
        FooResource foo = null;
        try {
            foo = new FooResource();
            throw new IOException("运行中出现IO异常!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                foo.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void tryWithResourceFinally() {
        try (FooResource resource = new FooResource();) {
            System.out.println("正常语句块");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Finally语句块");
        }
    }

    /**
     * Catch捕获多个异常
     */
    public void mulityException() {
        try {
            new MulityException().throwExp();
        } catch (IOException | ClassNotFoundException e) {
            // 执行Exception.printStackTrace();
            e.printStackTrace();
        }
    }

}

/**
 * 自定义资源类，实现了AutoCloseable接口
 */
class FooResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("执行Close逻辑");
        throw new IOException("Close时出现IO异常!");
    }
}

class BarResource implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("Invoke close method!");
        throw new NullPointerException("Close时出现空指针异常!");
    }
}

class MulityException {

    public void throwExp() throws IOException, ClassNotFoundException {

    }

}
