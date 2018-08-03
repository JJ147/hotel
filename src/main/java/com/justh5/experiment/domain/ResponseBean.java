package com.justh5.experiment.domain;

import java.util.UUID;

/**
 * api层数据返回参数
 * 
 * @author wangjiaxi update by jiawei
 *
 */
public class ResponseBean implements java.io.Serializable {//声明返回对象

	private static final long serialVersionUID = 1L;

	private int code;

	private int status;

	private String msg;

    private String transactionId;

	private Object data;

	private Object errMsg;

	/**
	 *  当前页
	 */
	private Integer page;

	/**
	 * 每页数量
	 */
	private Integer limit;

	/**
	 * 每页数量
	 */
	private Long count;

	public ResponseBean(){
	    this.transactionId = System.currentTimeMillis()+ UUID.randomUUID().toString();
    }


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(Object errMsg) {
		this.errMsg = errMsg;
	}

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ResponseBean{" +
				"code=" + code +
				", status=" + status +
				", msg='" + msg + '\'' +
				", transactionId='" + transactionId + '\'' +
				", data=" + data +
				", errMsg=" + errMsg +
				", page=" + page +
				", limit=" + limit +
				", count=" + count +
				'}';
	}
}
