package com.zd.consul.exception;

/**
 * @Email caoleike@zoomdu.com
 * @User 曹磊科
 * @Time 2018/1/11 10:29
 */
public class ValueNullException extends RuntimeException {

	// 请求地址
	private String location;

	public String getLocation() {
		return location;
	}

	public ValueNullException() {
	}

	public ValueNullException(String mes) {
		super(mes);
	}

	public ValueNullException(String mes, String location) {
		super(mes);
		this.location = location;
	}

	public ValueNullException(Throwable cause) {
		super(cause);
	}

	public ValueNullException(String message, Throwable cause) {
		super(message, cause);
	}

	protected ValueNullException(String message, Throwable cause,
	                             boolean enableSuppression,
	                             boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
