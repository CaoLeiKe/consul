package com.zd.consul.factory;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;
import com.orbitz.consul.ConsulException;
import com.orbitz.consul.KeyValueClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Email caoleike@zoomdu.com
 * @User 曹磊科
 * @Time 2018/1/18 10:12
 */
public class DefaultFactoryConsulImpl implements FactoryConsul {

	private static final Logger log = LoggerFactory.getLogger(DefaultFactoryConsulImpl.class);

	private static Consul consul;

	private String host;

	private Integer port;

	private static int count = 1;

	@Override
	public void init() {
		try {
			DefaultFactoryConsulImpl.consul = Consul.builder().withHostAndPort(HostAndPort.fromParts(host, port)).build();
		} catch (ConsulException e) {
			log.error("连接consul失败，请检查配置项和consul是否启动......{}", count++);
			init();
		}
	}

	@Override
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public KeyValueClient getKeyValueClient() {
		return consul.keyValueClient();
	}
}
