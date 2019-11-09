package com.study.zookeeper.curator;

import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @author dranawhite
 * @version [1.0, 2018/5/17 15:32]
 */
public class ZkOperation {

	private CuratorFramework client;

	public void conn() {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		// Fluent风格的API接口，其中namespace便于业务上区分；实际就是根节点，之后所有操作就在该节点下面
		client = CuratorFrameworkFactory.builder()
				.connectString("www.dranawhite.com:2181")
				.sessionTimeoutMs(5000)
				.connectionTimeoutMs(3000)
				.retryPolicy(retryPolicy)
				.namespace("/zk_tmp")
				.build();
		client.start();
	}


	public void create(String path, byte[] data) {
		try {
			// 递归创建父节点，ZooKeeper中只有叶节点可以是临时节点，其余节点必须是持久节点
			client.create()
					.creatingParentsIfNeeded()
					.withMode(CreateMode.EPHEMERAL)
					.inBackground(new Watcher())
					.forPath(path, data);
		} catch (Exception ex) {
			throw new DranaSystemException("创建节点错误", GenericResultCode.SYSTEM_ERROR, ex);
		}
	}

	public void delete(String path) {
		try {
			client.delete()
					.guaranteed()
					.deletingChildrenIfNeeded()
					.withVersion(-1)
					.forPath(path);
		} catch (Exception ex) {
			throw new DranaSystemException("删除节点错误", GenericResultCode.SYSTEM_ERROR, ex);
		}
	}

	public void read(String path, Stat stat) {
		try {
			client.getData().storingStatIn(stat).forPath(path);
		} catch (Exception ex) {
			throw new DranaSystemException("读取节点错误", GenericResultCode.SYSTEM_ERROR, ex);
		}
	}

	public void update(String path, byte[] data) {
		try {
			client.setData().withVersion(0).forPath(path, data);
		} catch (Exception ex) {
			throw new DranaSystemException("更新节点错误", GenericResultCode.SYSTEM_ERROR, ex);
		}
	}

	class Watcher implements BackgroundCallback {

		@Override
		public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) {
			System.out.println(curatorEvent.getType());
		}
	}
}
