package com.zd.consul.factory;

import com.orbitz.consul.KeyValueClient;

/**
 * Consul工厂
 *
 * @User 曹磊科
 * @Time 2018/1/18 10:12
 */
public interface FactoryConsul {

	/**
	 * 设置主机地址
	 *
	 * @param host 主机地址
	 */
	void setHost(String host);

	/**
	 * 设置端口号
	 *
	 * @param port 端口号
	 */
	void setPort(Integer port);

	/**
	 * 初始化操作
	 */
	void init();

	/**
	 * 获取KeyValueClient
	 *
	 * @return KeyValueClient
	 */
	KeyValueClient getKeyValueClient();
}
