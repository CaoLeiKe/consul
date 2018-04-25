package com.zd.configuration;

import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;

/**
 * 消息中心
 *
 * @User 曹磊科
 * @Time 2018/1/23 14:11
 */
// 如果获取不到数据抛出异常
@ConsulNameSpace(url = "/zd/notice/", nullThrowException = NullThrowException.yes)
public interface Notice {

	/**
	 * 获取sms的地址
	 *
	 * @return 返回地址
	 */
	@ConsulKey(url = "sms/url")
	String getSmsUrl();

	/**
	 * 获取rong的地址
	 *
	 * @return 返回地址
	 */
	@ConsulKey(url = "rong/url")
	String getRongUrl();

	/**
	 * 获取DING_MARKDOWN_URL地址
	 *
	 * @return 返回地址
	 */
	@ConsulKey(url = "ding/markdown/url")
	String getDingMarkdownUrl();

	/**
	 * 获取DING_TEXT_URL地址
	 *
	 * @return 返回地址
	 */
	@ConsulKey(url = "ding/text/url")
	String getDingTextUrl();

	/**
	 * 获取系统错误钉钉通知地址
	 *
	 * @return 返回地址
	 */
	@ConsulKey(url = "ding/system/exception")
	String getDingSystemExceptionUrl();

	/**
	 * 获取MAIL_URL地址
	 *
	 * @return 返回地址
	 */
	@ConsulKey(url = "mail/url")
	String getMailUrl();
}
