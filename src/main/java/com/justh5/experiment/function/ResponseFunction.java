package com.justh5.experiment.function;

import com.justh5.experiment.constants.ApiConstant;
import com.justh5.experiment.domain.ResponseBean;
import com.justh5.experiment.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jibingfeng
 *
 */
public class ResponseFunction {
    public static Logger logger = LoggerFactory.getLogger(ResponseFunction.class);

    public static ResponseBean getResponseBeanNew(Object obj) {
        ResponseBean rb = null;
        if (null != obj) {
            rb = getResponseBean(ApiConstant.C0, obj);
        }else {
            rb = getResponseBean(ApiConstant.C1000);
        }
        return rb;
    }

    /**
     * 返回响应对象,
     *
     * @param code
     * @param data
     * @return
     */
    public static ResponseBean getResponseBean(int code, Object data) {
        return getResponseBean(code, ApiConstant.getMsg(code), data);
    }


    /**
     * 获取响应对象
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static ResponseBean getResponseBean(int code, String msg, Object data) {
        return getResponseBean(code, msg, data, null);
    }

    /**
     * @Description:
     * @author jw
     * @date 2017/12/21
     * @param code 状态编码
     * @param msg 状态信息
     * @param data 数据信息
     * @param errMsg 错误信息
     * @return com.youxinpai.cloud.entity.base.ResponseBean
     */
    public static ResponseBean getResponseBean(int code, String msg, Object data,Object errMsg) {

        ResponseBean res = new ResponseBean();
        res.setCode(code);
        if(StringUtil.isNotBlank(msg)){
            res.setMsg(msg);
        }else{
            res.setMsg(ApiConstant.getMsg(code));
        }
        res.setData(data);
        res.setErrMsg(errMsg);
        return res;
    }

    /**
     * 获取响应对象
     *
     * @param code
     * @return
     */
    public static ResponseBean getResponseBean(int code) {

        ResponseBean res = new ResponseBean();
        res.setCode(code);
        res.setMsg(ApiConstant.getMsg(code));
        return res;
    }
}

