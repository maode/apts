/**
 * 
 */
package com.shanghai.our.utils;

/**
 * @author code0
 * service层业务处理结果
 */
public class ExecuteResult<T> {

	/**
	 * 返回内容
	 */
	private T result;
	
	/**
	 * 操作是否成功
	 */
	private boolean success=false;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	

}
