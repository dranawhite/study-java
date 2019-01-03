package com.study.zookeeper.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * @author liangyq
 * @version [1.0, 2018/5/17 15:07]
 */
public class ZkOperation {

	private ZkClient zkClient;

	public void conn() {
		zkClient = new ZkClient("www.dranawhite.com:2181", 5000);
	}

	public void create(String path, Object data) {
		zkClient.createEphemeral(path, data);
	}

	public void delete(String path) {
		zkClient.delete(path);
	}

	public List<String> getChildren(String path) {
		return zkClient.getChildren(path);
	}

	public Object read(String path) {
		return zkClient.readData(path);
	}

	public void update(String path, Object data) {
		zkClient.writeData(path, data);
	}

	public boolean exists(String path) {
		return zkClient.exists(path);
	}

	public void watcher(String path) {
		zkClient.subscribeDataChanges(path, new IZkDataListener() {
			@Override
			public void handleDataChange(String dataPath, Object data) {
				System.out.println("Data Changed!");
			}

			@Override
			public void handleDataDeleted(String dataPath) {
				System.out.println("Data Deleted!");
			}
		});
	}
}
