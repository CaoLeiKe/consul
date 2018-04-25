package com.zd.configuration;

import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;

/**
 * 微信
 *
 * @User 曹磊科
 * @Time 2018/1/24 13:55
 */
@ConsulNameSpace(url = "/zd/weChat/", nullThrowException = NullThrowException.yes)
public interface WeChat {

	/**
	 * 获取 WXAPPID --公众号id
	 *
	 * @return WXAPPID
	 */
	@ConsulKey(url = "officialAccount/id")
	String getOfficialAccountId();

	/**
	 * 获取 APPSECRET --公众号秘钥
	 *
	 * @return APPSECRET
	 */
	@ConsulKey(url = "officialAccount/secret")
	String getOfficialAccountSecret();

	/**
	 * 获取 MCH_ID --支付商户号
	 *
	 * @return MCH_ID
	 */
	@ConsulKey(url = "pay/id")
	String getPayId();

	/**
	 * 获取 APP_PAY_APPSECRET --支付商户密钥
	 *
	 * @return APP_PAY_APPSECRET
	 */
	@ConsulKey(url = "pay/secret")
	String getPaySecret();

	/**
	 * 获取 WXOPENAPPID --开放平台id
	 *
	 * @return WXOPENAPPID
	 */
	@ConsulKey(url = "exoteric/tourist/id")
	String getExotericId();

	/**
	 * 获取 OPENAPPSECRET --开放平台密钥
	 *
	 * @return OPENAPPSECRET
	 */
	@ConsulKey(url = "exoteric/tourist/secret")
	String getExotericSecret();

	/**
	 * 获取 OPEN_MCH_ID --开放平台支付商户号
	 *
	 * @return OPEN_MCH_ID
	 */
	@ConsulKey(url = "exoteric/tourist/pay/id")
	String getExotericPayId();

	/**
	 * 获取 OPEN_PAY_APPSECRET --开放平台支付密钥
	 *
	 * @return OPEN_PAY_APPSECRET
	 */
	@ConsulKey(url = "exoteric/tourist/pay/secret")
	String getExotericPaySecret();

	/**
	 * 获取 NOTIFY_URL
	 *
	 * @return NOTIFY_URL
	 */
	@ConsulKey(url = "exoteric/tourist/notifyUrl")
	String getExotericNotifyUrl();

	/**
	 * 获取 WXOPENAPPID --开放平台id
	 *
	 * @return WXOPENAPPID
	 */
	@ConsulKey(url = "exoteric/guide/id")
	String getExotericGuideId();

	/**
	 * 获取 OPEN_MCH_ID --开放平台支付商户号
	 *
	 * @return OPEN_MCH_ID
	 */
	@ConsulKey(url = "exoteric/guide/pay/id")
	String getExotericGuidePayId();

	/**
	 * 获取 OPEN_PAY_APPSECRET --开放平台支付密钥
	 *
	 * @return OPEN_PAY_APPSECRET
	 */
	@ConsulKey(url = "exoteric/guide/pay/secret")
	String getExotericGuidePaySecret();

	/**
	 * 获取 NOTIFY_URL
	 *
	 * @return NOTIFY_URL
	 */
	@ConsulKey(url = "exoteric/guide/notifyUrl")
	String getExotericGuideNotifyUrl();
}
