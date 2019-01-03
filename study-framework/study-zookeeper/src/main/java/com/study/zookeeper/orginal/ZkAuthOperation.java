package com.study.zookeeper.orginal;

import com.dranawhite.exception.DranawhiteException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

/**
 * @author liangyq
 * @version [1.0, 2018/5/16 17:21]
 */
public class ZkAuthOperation extends ZkOperation {

	@Override
	public void create(String path, byte[] data) {
		try {
			zooKeeper.create(path, data, ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);
		} catch (Exception ex) {
			throw new DranawhiteException("ZK创建节点错误!", ex);
		}
	}

	public static void main(String[] args) {
		ZkOperation zkOp = new ZkOperation();
		ZkAuthOperation zkAuthOp = new ZkAuthOperation();

		zkAuthOp.conn();
		zkAuthOp.setAuth();
		zkAuthOp.create("/zk_tmp", "Hello ZooKeeper!".getBytes());
		String data = new String(zkAuthOp.read("/zk_tmp", null));
		System.out.println("读取数据： " + data);

		zkOp.conn();
		zkOp.read("/zk_tmp", null);
	}

}
