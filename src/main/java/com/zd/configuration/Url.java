package com.zd.configuration;

import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;

/**
 * 项目地址
 *
 * @User 曹磊科
 * @Time 2018/1/24 14:55
 */
@ConsulNameSpace(url = "zd/url/", nullThrowException = NullThrowException.yes)
public interface Url {

    /**
     * webView，行程分享地址的URL
     */
    @ConsulKey(url = "webView/tripShare")
    String getWebViewTripShare();

    /**
     * webView，行程分享地址的URL
     */
    @ConsulKey(url = "webView/guideShare")
    String getWebViewGuideShare();

    /**
     * 获取后台正式地址
     *
     * @return 后台正式地址
     */
    @ConsulKey(url = "domain")
    String getDomain();

    /**
     * 获取导游端正式地址
     *
     * @return 导游端正式地址
     */
    @ConsulKey(url = "guide")
    String getGuide();

    /**
     * 获取游客端正式地址
     *
     * @return 游客端正式地址
     */
    @ConsulKey(url = "tourist")
    String getTourist();

    /**
     * 获取上传测试地址
     *
     * @return 上传测试地址
     */
    @ConsulKey(url = "upload")
    String getUpload();


    /**
     * 获取上传测试地址
     * test =  https://order-test.zoomdu.com
     * real =  https://order.zoomdu.com
     *
     * @return 上传测试地址
     */
    @ConsulKey(url = "order")
    String getOrder();


    /**
     * 获取b端地址
     * <p>
     * test =  https://bapi-test.zoomdu.com
     * real =  https://bapi.zoomdu.com
     *
     * @return 上传测试地址
     */
    @ConsulKey(url = "travel")
    String getTravel();
}
