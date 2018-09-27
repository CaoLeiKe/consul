package com.zd.configuration;

import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;

/**
 * 融云TM
 *
 * @User 曹磊科
 * @Time 2018/1/23 18:15
 */
@ConsulNameSpace(url = "zd/rong/", nullThrowException = NullThrowException.yes)
public interface RongYun {

	/**
	 * 获取key
	 * @return key
	 */
	@ConsulKey(url = "key")
	String getKey();

	/**
	 * 获取keysec
	 * @return keysec
	 */
	@ConsulKey(url = "keySec")
	String getKeySec();
}
