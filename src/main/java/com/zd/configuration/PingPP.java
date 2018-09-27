package com.zd.configuration;

import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;

/**
 * Ping++
 *
 * @User 曹磊科
 * @Time 2018/1/24 14:43
 */
@ConsulNameSpace(url = "zd/ping/", nullThrowException = NullThrowException.yes)
public interface PingPP {

	/**
	 * 获取 API_KEY
	 *
	 * @return API_KEY
	 */
	@ConsulKey(url = "key")
	String getKey();

	/**
	 * 获取 API_KEY
	 *
	 * @return API_KEY
	 */
	@ConsulKey(url = "privateKey")
	String getPrivateKey();

	/**
	 * 获取 API_ID
	 *
	 * @return API_ID
	 */
	@ConsulKey(url = "id")
	String getId();

	/**
	 * 获取 WEBHOOKSPARSE
	 *
	 * @return WEBHOOKSPARSE
	 */
	@ConsulKey(url = "webHookSparse")
	String getWebHookSparse();

}
