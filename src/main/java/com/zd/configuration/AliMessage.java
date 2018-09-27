package com.zd.configuration;

import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;

/**
 * 阿里短信
 *
 * @Email caoleike@zoomdu.com
 * @User 曹磊科
 * @Time 2018/1/24 15:34
 */
@ConsulNameSpace(url = "zd/aliMessage/", nullThrowException = NullThrowException.yes)
public interface AliMessage {

	/**
	 * 获取 DYAPPID
	 *
	 * @return DYAPPID
	 */
	@ConsulKey(url = "id")
	String getId();

	/**
	 * 获取 DYAPPSECRET
	 *
	 * @return DYAPPSECRET
	 */
	@ConsulKey(url = "secret")
	String getSecret();

	/**
	 * 获取 DYTMP1 --验证码
	 *
	 * @return DYTMP1 --验证码
	 */
	@ConsulKey(url = "captcha")
	String getCaptcha();

	/**
	 * 获取 DYTMP2 --支付成功
	 *
	 * @return DYTMP2 --支付成功
	 */
	@ConsulKey(url = "payDone")
	String getPayDone();

	/**
	 * 获取 DYTMP3 --订单完成
	 *
	 * @return DYTMP3 --订单完成
	 */
	@ConsulKey(url = "order/done")
	String getOrderDone();

	/**
	 * 获取 DYTMP4 --通过审核 	导游端审核通知
	 *
	 * @return DYTMP4 --通过审核 	导游端审核通知
	 */
	@ConsulKey(url = "guide/audit/done")
	String getGuideAuditDone();

	/**
	 * 获取 DYTMP5 --驳回审核 	导游未通过审核      旧SMS_58945148
	 *
	 * @return DYTMP5 --驳回审核 	导游未通过审核      旧SMS_58945148
	 */
	@ConsulKey(url = "guide/audit/refuse")
	String getGuideAuditRefuse();

	/**
	 * 获取 DYTMP6 --提现审核通知
	 *
	 * @return DYTMP6 --提现审核通知
	 */
	@ConsulKey(url = "withdrawals/audit")
	String getWithdrawalsAudit();

	/**
	 * 获取 DYTMP7 --提现成功通知
	 *
	 * @return DYTMP7 --提现成功通知
	 */
	@ConsulKey(url = "withdrawals/done")
	String getWithdrawalsDone();

	/**
	 * 获取 DYTMP8 --账号临时冻结不能提现通知
	 *
	 * @return DYTMP8 --账号临时冻结不能提现通知
	 */
	@ConsulKey(url = "withdrawals/freeze")
	String getWithdrawalsFreeze();

	/**
	 * 获取 DYTMP9 --账号解除冻结可以提现通知
	 *
	 * @return DYTMP9 --账号解除冻结可以提现通知
	 */
	@ConsulKey(url = "withdrawals/unfreeze")
	String getWithdrawalsUnfreeze();

	/**
	 * 获取 DYTMP10 --短信通知未审核通过的原因,可编写,可点选状态
	 *
	 * @return DYTMP10 --短信通知未审核通过的原因,可编写,可点选状态
	 */
	@ConsulKey(url = "message/auditRefuse")
	String getMessageAuditRefuse();

	/**
	 * 获取 DYTMP11 --提现申请失败反馈
	 *
	 * @return DYTMP11 --提现申请失败反馈
	 */
	@ConsulKey(url = "withdrawals/failed")
	String getWithdrawalsFailed();

	/**
	 * 获取 DYTMP12 --提现设置密码
	 *
	 * @return DYTMP12 --提现设置密码
	 */
	@ConsulKey(url = "withdrawals/setPassword")
	String getWithdrawalsSetPassword();

	/**
	 * 获取 DYTMP13 --B端导游有订单短信通知
	 *
	 * @return DYTMP13 --B端导游有订单短信通知
	 */
	@ConsulKey(url = "guide/order/notifications")
	String getGuideOrderNotifications();

	/**
	 * 获取 DYTMP14 --B端导游订单评价成功通知
	 *
	 * @return DYTMP14 --B端导游订单评价成功通知
	 */
	@ConsulKey(url = "guide/order/evaluate")
	String getGuideOrderEvaluate();

}
