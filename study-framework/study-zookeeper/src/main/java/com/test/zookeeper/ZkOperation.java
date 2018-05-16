package com.test.zookeeper;

import com.dranawhite.exception.DranawhiteException;
import org.apache.zookeeper.CreateMode;
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
 * @author liangyq
 * @version [1.0, 2018/5/15 10:15]
 */
public class ZkOperation {

	private ZooKeeper zooKeeper;

	public void conn() {
		try {
			zooKeeper = new ZooKeeper("www.dranawhite.com:2181", 5000, null);
		} catch (Exception ex) {
			throw new DranawhiteException("ZK连接错误!", ex);
		}
	}

	public void create(String path, byte[] data) {
		try {
			zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		} catch (Exception ex) {
			throw new DranawhiteException("ZK创建节点错误!", ex);
		}
	}

	public void delete(String path) {
		try {
			zooKeeper.delete(path, -1);
		} catch (Exception ex) {
			throw new DranawhiteException("ZK创建节点错误!", ex);
		}
	}

	public Stat update(String path, byte[] data, int version) {
		try {
			return zooKeeper.setData(path, data, version);
		} catch (Exception ex) {
			throw new DranawhiteException("ZK创建节点错误!", ex);
		}
	}

	public List<String> getChildren(String path) {
		try {
			return zooKeeper.getChildren(path, false);
		} catch (Exception ex) {
			throw new DranawhiteException("ZK读取节点错误!", ex);
		}
	}

	public byte[] read(String path, Stat stat) {
		try {
			if (stat == null) {
				stat = new Stat();
			}
			return zooKeeper.getData(path, false, stat);
		} catch (Exception ex) {
			throw new DranawhiteException("ZK读取数据错误!", ex);
		}
	}

	public Stat exists(String path) {
		try {
			return zooKeeper.exists(path, false);
		} catch (Exception ex) {
			throw new DranawhiteException("ZK读取节点错误!", ex);
		}
	}

	public static void main(String[] args) {
		ZkOperation op = new ZkOperation();
		op.conn();

		op.create("/zk_tmp", "Hello ZooKeeper!".getBytes());
		List<String> subNodes = op.getChildren("/");
		System.out.println("ZK根路径下节点: " + subNodes);

		Stat stat = new Stat();
		String data = new String(op.read("/zk_tmp", stat));
		System.out.println("/zk_tmp节点下数据：" + data);
		System.out.println("/zk_tmp节点下创建事务ID：" + stat.getCzxid());
		System.out.println("/zk_tmp节点下更新事务ID：" + stat.getMzxid());
		System.out.println("/zk_tmp节点下数据版本：" + stat.getVersion());

		Stat upStat = op.update("/zk_tmp", "Welcome!".getBytes(), stat.getVersion());
		System.out.println("/zk_tmp更新后数据：Welcome");
		System.out.println("/zk_tmp更新后创建事务ID：" + upStat.getCzxid());
		System.out.println("/zk_tmp更新后更新事务ID：" + upStat.getMzxid());
		System.out.println("/zk_tmp更新后数据版本：" + upStat.getVersion());

		op.delete("/zk_tmp");

		Stat existStat = op.exists("/zk_tmp");
		System.out.println("/zk_tmp是否节点：" + (existStat == null ? false : true));
	}
}
