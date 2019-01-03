package com.study.jvm.file;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author liangyq 2018/1/14
 */
public class FilePro {

    public static void main(String[] args) {
        Resource res = new ClassPathResource("file/Test.txt");
        char[] data = new char[1024];
        try (FileReader file = new FileReader(res.getFile())) {
            file.read(data);
            System.out.println(new String(data));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
