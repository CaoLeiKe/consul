package com.zd.configuration;

import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;

/**
 * 测试用例
 * ConsulNameSpace配置前缀
 * ConsulKey配置后缀
 *
 * @User 曹磊科
 * @Time 2018/1/9 15:45
 */
// 默认所有的方法获取不到value则抛出异常，方法注解优先
@ConsulNameSpace(url = "/zd/zfb/", nullThrowException = NullThrowException.yes)
public interface Demo {

	// 如果获取不到value则返回默认值，并且不会抛出异常
	@ConsulKey(url = "one", defaultValue = "notValueOne", nullThrowException = NullThrowException.no)
	String getOne();

	// 如果获取不到value则直接抛出异常
	@ConsulKey(url = "two", defaultValue = "notValueTwo", nullThrowException = NullThrowException.yes)
	String getTwo();

	// 接口注解抛出异常，如果获取不到value则抛出异常，如果接口没有注解抛出异常的话并且获取value为空则返回"";
	@ConsulKey(url = "three")
	String getThree();
}
