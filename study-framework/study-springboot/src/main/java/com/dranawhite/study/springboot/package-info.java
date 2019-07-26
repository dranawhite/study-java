/**
 * 1) 配置SSL 在使用内嵌tomcat的情况下，使用JDK自带的keytool工具生成一个证书;
 * keytool -genkey -alias tomcat -dname "CN=Andy,OU=kfit,O=kfit,L=HaiDian,ST=BeiJing,C=CN" -storetype PKCS12 -keyalg
 * RSA -keysize 2048 -keystore keystore.p12 -validity 365
 * 复制到工程根目录下，并配置application.properties文件
 */
package com.dranawhite.study.springboot;