package com.study.jvm.locale;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author dranawhite
 * @version $Id: LocalePro.java, v 0.1 2019-01-22 16:56 dranawhite Exp $$
 */
public class LocalePro {

    public static void main(String[] args) {
        String pkg = "com.study.jvm.locale.localeTest";

        ResourceBundle LocalePro = ResourceBundle.getBundle(pkg);
        System.out.println("LocalePro: " + LocalePro.getString("aa"));

        ResourceBundle defau = ResourceBundle.getBundle(pkg, Locale.FRENCH);
        System.out.println("default: " + defau.getString("aa"));

        ResourceBundle china = ResourceBundle.getBundle(pkg, Locale.CHINA);
        System.out.println("china: " + china.getString("aa"));

        ResourceBundle es = ResourceBundle.getBundle(pkg, java.util.Locale.US);
        System.out.println("us: " + es.getString("aa"));
    }
}
