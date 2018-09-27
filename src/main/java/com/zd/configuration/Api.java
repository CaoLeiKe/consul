package com.zd.configuration;

import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;

/**
 * 设备
 *
 * @Email caoleike@zoomdu.com
 * @User 曹磊科
 * @Time 2018/1/24 13:45
 */
@ConsulNameSpace(url = "zd/api/", nullThrowException = NullThrowException.yes)
public interface Api {

    /**
     * 获取 key
     *
     * @return key
     */
    @ConsulKey(url = "key")
    String getKey();

    /**
     * 获取 keysec
     *
     * @return keysec
     */
    @ConsulKey(url = "keySec")
    String getKeySec();

    /**
     * 获取 keyother
     *
     * @return keyother
     */
    @ConsulKey(url = "keyOther")
    String getKeyOther();

    /**
     * 获取 keysecother
     *
     * @return keysecother
     */
    @ConsulKey(url = "keySecOther")
    String getKeySecOther();

    /**
     * 获取 WEATHEROLD --天气预报_国家气象局接口
     *
     * @return WEATHEROLD --天气预报_国家气象局接口
     */
    @ConsulKey(url = "constant/oldWeather")
    String getConstantOldWeather();

    /**
     * 获取 WEATHER --天气预报_新浪接口
     *
     * @return WEATHER --天气预报_新浪接口
     */
    @ConsulKey(url = "constant/weather")
    String getConstantWeather();

    /**
     * 获取 TAG
     *
     * @return TAG
     */
    @ConsulKey(url = "constant/tag")
    String getConstantTag();

    /**
     * 获取 Language
     *
     * @return Language
     */
    @ConsulKey(url = "constant/language")
    String getConstantLanguage();

    /**
     * 获取 DATAV_ERSION
     *
     * @return DATAV_ERSION
     */
    @ConsulKey(url = "constant/dataVersion")
    String getConstantDataVersion();

    /**
     * 获取 PRO
     *
     * @return PRO
     */
    @ConsulKey(url = "constant/pro")
    String getConstantPro();

    /**
     * 获取 GUIDEEXP
     *
     * @return GUIDEEXP
     */
    @ConsulKey(url = "constant/guide/exp")
    String getConstantGuideExp();

    /**
     * 获取 SORTGUIDE
     *
     * @return SORTGUIDE
     */
    @ConsulKey(url = "constant/guide/sort")
    String getConstantGuideSort();

    /**
     * 获取 SEARCHGUIDE
     *
     * @return SEARCHGUIDE
     */
    @ConsulKey(url = "constant/guide/search")
    String getConstantGuideSearch();

    /**
     * 获取 DEMO_PRICE
     *
     * @return DEMO_PRICE
     */
    @ConsulKey(url = "constant/guide/demoPrice")
    String getConstantGuideDemoPrice();

    /**
     * 高德地图api的key
     * 普通key 一天调用api次数最高2000次
     * 企业key 次数高达30万次
     */
    @ConsulKey(url = "aMapKey")
    String getAMapKey();

    /**
     * redis项目公共前缀
     */
    @ConsulKey(url = "redisCommonKeyPrefix")
    String getRedisCommonKeyPrefix();
}
