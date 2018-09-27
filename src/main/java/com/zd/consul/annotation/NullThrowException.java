package com.zd.consul.annotation;

/**
 * 是否抛出异常的枚举
 *
 * @User 曹磊科
 * @Time 2018/1/9 16:27
 */
public enum NullThrowException {
	yes("抛出异常", 1),
	no("不抛异常", 2),
	tacitly("什么也不做", 3);
	String meaning;
	Integer identifier;

	NullThrowException(String meaning, int identifier) {
		this.meaning = meaning;
		this.identifier = identifier;
	}
}