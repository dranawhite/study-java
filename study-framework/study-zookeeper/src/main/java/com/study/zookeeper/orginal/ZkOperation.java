package com.study.zookeeper.orginal;

import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * ZK简易操作
 * <pre>
 *     ZK中的Version主要用来CAS操作，确保分布式更新时数据的准确性
 * </pre>
 *
 * @author dranawhite
 * @version [1.0, 2018/5/15 10:15]
 */
public class ZkOperation implements Watcher {

    protected ZooKeeper zooKeeper;

    public void conn() {
        try {
            // ZK连接的创建是一个异步的过程
            zooKeeper = new ZooKeeper("www.dranawhite.com:2181", 5000, this);
        } catch (Exception ex) {
            throw new DranaSystemException("ZK连接错误!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    public void create(String path, byte[] data) {
        try {
            zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (Exception ex) {
            throw new DranaSystemException("ZK创建节点错误!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    public void delete(String path) {
        try {
            zooKeeper.delete(path, -1);
        } catch (Exception ex) {
            throw new DranaSystemException("ZK删除节点错误!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    public Stat update(String path, byte[] data, int version) {
        try {
            return zooKeeper.setData(path, data, version);
        } catch (Exception ex) {
            throw new DranaSystemException("ZK创建节点错误!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    public List<String> getChildren(String path) {
        try {
            return zooKeeper.getChildren(path, true);
        } catch (Exception ex) {
            throw new DranaSystemException("ZK读取节点错误!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    public byte[] read(String path, Stat stat) {
        try {
            if (stat == null) {
                stat = new Stat();
            }
            return zooKeeper.getData(path, true, stat);
        } catch (Exception ex) {
            throw new DranaSystemException("ZK读取数据错误!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    public Stat exists(String path) {
        try {
            return zooKeeper.exists(path, true);
        } catch (Exception ex) {
            throw new DranaSystemException("ZK查询节点错误!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    public void setAuth() {
        zooKeeper.addAuthInfo("digest", "foo:true".getBytes());
    }

    public static void main(String[] args) {
        ZkOperation op = new ZkOperation();
        op.conn();

        op.create("/zk_tmp", "Hello ZooKeeper!".getBytes());
        List<String> subNodes = op.getChildren("/");
        System.out.println("ZK根路径下节点: " + subNodes);
        System.out.println();

        Stat stat = new Stat();
        String data = new String(op.read("/zk_tmp", stat));
        System.out.println("/zk_tmp节点下数据：" + data);
        System.out.println("/zk_tmp节点下创建事务ID：" + stat.getCzxid());
        System.out.println("/zk_tmp节点下更新事务ID：" + stat.getMzxid());
        System.out.println("/zk_tmp节点下数据版本：" + stat.getVersion());
        System.out.println();

        Stat upStat = op.update("/zk_tmp", "Welcome!".getBytes(), stat.getVersion());
        System.out.println("/zk_tmp更新后数据：Welcome");
        System.out.println("/zk_tmp更新后创建事务ID：" + upStat.getCzxid());
        System.out.println("/zk_tmp更新后更新事务ID：" + upStat.getMzxid());
        System.out.println("/zk_tmp更新后数据版本：" + upStat.getVersion());
        System.out.println();

        op.delete("/zk_tmp");
        System.out.println("/zk_tmp节点删除");
        System.out.println();

        Stat existStat = op.exists("/zk_tmp");
        System.out.println("/zk_tmp是否节点：" + (existStat == null ? false : true));
    }

    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case NodeCreated:
                System.out.println("Watcher创建节点");
                break;
            case NodeDeleted:
                System.out.println("Watcher删除节点");
                break;
            case NodeDataChanged:
                System.out.println("Watcher更改节点数据");
                break;
            case NodeChildrenChanged:
                System.out.println("Watcher更改子节点");
                break;
        }
    }
}