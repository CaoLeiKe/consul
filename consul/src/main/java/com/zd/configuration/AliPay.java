package com.zd.configuration;

import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;

/**
 * 支付宝
 *
 * @User 曹磊科
 * @Time 2018/1/24 13:31
 */
@ConsulNameSpace(url = "zd/aliPay/", nullThrowException = NullThrowException.yes)
public interface AliPay {

	/**
	 * 获取 URL
	 *
	 * @return URL
	 */
	@ConsulKey(url = "transfer/url")
	String getTransferUrl();

	/**
	 * 获取 APP_ID
	 *
	 * @return APP_ID
	 */
	@ConsulKey(url = "transfer/id")
	String getTransferId();

	/**
	 * 获取 APP_PRIVATE_KEY
	 *
	 * @return APP_PRIVATE_KEY
	 */
	@ConsulKey(url = "transfer/privateKey")
	String getTransferPrivateKey();

	/**
	 * 获取 FORMAT
	 *
	 * @return FORMAT
	 */
	@ConsulKey(url = "transfer/format")
	String getTransferFormat();

	/**
	 * 获取 CHARSET
	 *
	 * @return CHARSET
	 */
	@ConsulKey(url = "transfer/charset")
	String getTransferCharset();

	/**
	 * 获取 ALIPAY_PUBLIC_KEY
	 *
	 * @return ALIPAY_PUBLIC_KEY
	 */
	@ConsulKey(url = "transfer/publicKey")
	String getTransferPublicKey();

	/**
	 * 获取 SIGN_TYPE
	 *
	 * @return SIGN_TYPE
	 */
	@ConsulKey(url = "transfer/signType")
	String getTransferSignType();

	/**
	 * 获取 ALIPAY_APPID
	 *
	 * @return ALIPAY_APPID
	 */
	@ConsulKey(url = "pay/id")
	String getPayId();

	/**
	 * 获取 ALIPAY_PRIVATE_KEY
	 *
	 * @return ALIPAY_PRIVATE_KEY
	 */
	@ConsulKey(url = "pay/privateKey")
	String getPayPrivateKey();

	/**
	 * 获取 ALICHARSET
	 *
	 * @return ALICHARSET
	 */
	@ConsulKey(url = "pay/charset")
	String getPayCharset();

	/**
	 * 获取 ALIPAY_PUBLIC_KEY_APP
	 *
	 * @return ALIPAY_PUBLIC_KEY_APP
	 */
	@ConsulKey(url = "pay/publicKey")
	String getPayPublicKey();

	/**
	 * 获取 ALIPAY_NOTIFY_URL
	 *
	 * @return ALIPAY_NOTIFY_URL
	 */
	@ConsulKey(url = "pay/notifyUrl")
	String getPayNotifyUrl();

}
