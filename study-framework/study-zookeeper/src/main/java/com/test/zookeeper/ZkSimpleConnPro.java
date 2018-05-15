package com.test.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * ZK简易连接
 *
 * @author liangyq
 * @version [1.0, 2018/5/15 10:15]
 */
public class ZkSimpleConnPro implements Watcher {

	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

	public static void main(String[] args) throws Exception {
		ZooKeeper zookeeper = new ZooKeeper("www.dranawhite.com:2181", 5000, new ZkSimpleConnPro());
		System.out.println(zookeeper.getState());
		try {
			connectedSemaphore.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ZooKeeper session established.");
	}

	@Override
	public void process(WatchedEvent event) {
		System.out.println("Receive watched event：" + event);
		if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
			connectedSemaphore.countDown();
		}
	}

}
