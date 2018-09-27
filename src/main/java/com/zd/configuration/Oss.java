package com.zd.configuration;

import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;

/**
 * OSS
 *
 * @Email caoleike@zoomdu.com
 * @User 曹磊科
 * @Time 2018/1/23 19:03
 */
@ConsulNameSpace(url = "zd/oss/", nullThrowException = NullThrowException.yes)
public interface Oss {

	/**
	 * 获取 keyId
	 *
	 * @return keyId
	 */
	@ConsulKey(url = "keyId")
	String getKeyId();

	/**
	 * 获取 ACCESSKEYSECRET
	 *
	 * @return KeySecret
	 */
	@ConsulKey(url = "keySecret")
	String getKeySecret();

	/**
	 * 获取 ROLEARN
	 *
	 * @return roLearn
	 */
	@ConsulKey(url = "roLearn")
	String getRoLearn();

	/**
	 * 获取 ROLESESSIONNAME
	 *
	 * @return roleSessionName
	 */
	@ConsulKey(url = "roleSessionName")
	String getRoleSessionName();

	/**
	 * 获取 POLICY
	 * @return policy
	 */
	@ConsulKey(url = "policy")
	String getPolicy();

	/**
	 * 获取 REGION_CN_HANGZHOU
	 *
	 * @return region
	 */
	@ConsulKey(url = "region")
	String getRegion();

	/**
	 * 获取 STS_API_VERSION
	 *
	 * @return stsApiVersion
	 */
	@ConsulKey(url = "stsApiVersion")
	String getStsApiVersion();
}
