package com.study.tomcat.connector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/**
 * @author dranawhite
 * @version $Id: ServerSocketFactory.java, v 0.1 2019-03-09 18:07 dranawhite Exp $$
 */
public interface ServerSocketFactory {

    /**
     * 创建ServerSocket，并绑定到特定的端口
     *
     * @param port 监听的端口
     * @throws java.io.IOException                     I/O或者网络错误
     * @throws java.security.KeyStoreException         SSL时实例化KeyStore异常
     * @throws java.security.NoSuchAlgorithmException  SSL时不支持的算法异常
     * @throws java.security.cert.CertificateException SSL时产生证书错误
     * @throws java.security.UnrecoverableKeyException SSL时证书内部的KeyStore异常
     * @throws java.security.KeyManagementException    SSL时key管理层异常
     */
    ServerSocket createSocket(int port) throws IOException, KeyStoreException, NoSuchAlgorithmException,
            CertificateException, UnrecoverableKeyException, KeyManagementException;


    /**
     * 创建ServerSocket，并绑定到特定的端口
     *
     * @param port    监听的端口
     * @param backlog 队列中的链接数
     * @throws java.io.IOException                     I/O或者网络错误
     * @throws java.security.KeyStoreException         SSL时实例化KeyStore异常
     * @throws java.security.NoSuchAlgorithmException  SSL时不支持的算法异常
     * @throws java.security.cert.CertificateException SSL时产生证书错误
     * @throws java.security.UnrecoverableKeyException SSL时证书内部的KeyStore异常
     * @throws java.security.KeyManagementException    SSL时key管理层异常
     */
    ServerSocket createSocket(int port, int backlog) throws IOException, KeyStoreException, NoSuchAlgorithmException,
            CertificateException, UnrecoverableKeyException, KeyManagementException;


    /**
     * 创建ServerSocket，并绑定到特定的端口
     *
     * @param port      监听的端口
     * @param backlog   支持的并发链接数
     * @param ifAddress 地址
     * @throws java.io.IOException                     I/O或者网络错误
     * @throws java.security.KeyStoreException         SSL时实例化KeyStore异常
     * @throws java.security.NoSuchAlgorithmException  SSL时不支持的算法异常
     * @throws java.security.cert.CertificateException SSL时产生证书错误
     * @throws java.security.UnrecoverableKeyException SSL时证书内部的KeyStore异常
     * @throws java.security.KeyManagementException    SSL时key管理层异常
     */
    ServerSocket createSocket(int port, int backlog, InetAddress ifAddress) throws IOException, KeyStoreException,
            NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException, KeyManagementException;

}
