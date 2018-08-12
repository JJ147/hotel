package com.justh5.experiment.constants;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jibingfeng
 *
 */
public class ApiConstant {

    public static final int C0 = 0;
    public static final int C1000 = 1000;
    public static final int C1001 = 1001;
    public static final int C1002 = 1002;
    public static final int C1003 = 1003;
    public static final int C1004 = 1004;
    public static final int C9999 = 9999;
    public static final int C9997 = 9997;
    public static final int C9998 = 9998;
    public static final int C1010 = 1010;
    public static final int C1011 = 1011;
    public static final int C1012 = 1012;
    public static final int C1100 = 1100;
    public static final int C1015 = 1015;
    public static final int C9996 = 9996;
    private static final Map<Integer, String> EC_TO_MSG = new HashMap();

    public ApiConstant() {
    }

    public static String getMsg(int code) {
        return (String)EC_TO_MSG.get(code);
    }

    static {
        EC_TO_MSG.put(0, "success");
        EC_TO_MSG.put(1000, "数据不存在");
        EC_TO_MSG.put(1001, "JSON转换异常");
        EC_TO_MSG.put(1002, "文件未找到");
        EC_TO_MSG.put(1003, "转码错误");
        EC_TO_MSG.put(1004, "必填属性为空");
        EC_TO_MSG.put(1010, "参数错误");
        EC_TO_MSG.put(1011, "用户无此权限");
        EC_TO_MSG.put(1012, "用户未登录");
        EC_TO_MSG.put(1100, "验证码生成异常");
        EC_TO_MSG.put(9996, "sql异常");
        EC_TO_MSG.put(9997, "网络繁忙，请稍候再试");
        EC_TO_MSG.put(9998, "接口不存在");
        EC_TO_MSG.put(1015, "Sign 验证未通过");
        EC_TO_MSG.put(9999, "未知异常");
    }
}