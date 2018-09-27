package cn.alittler.web.filter;

/**
 * 响应内容重新包装
 *
 * @author LiuDeCai
 */
public class RestResponse<T> {

	/**
	 * 说明如果apiStatus、sysStatus为Integer，没做设置就会是null， 如果时int没做设置就是0
	 */

	/**
	 * 当前API接口状态码
	 */
	private int apiStatus;
	/**
	 * 系统状态码，使用int类型，不用设置，默认为0
	 */
	private int sysStatus;
	/**
	 * 提示消息
	 */
	private String message;
	/**
	 * 当前响应的时间戳
	 */
	private Long timestamp = System.currentTimeMillis();
	/**
	 * 返回的数据
	 */
	private T data;

	public RestResponse() {

	}

	/**
	 * 默认apiStatus为0
	 *
	 * @param data
	 *            要包装的数据
	 * @return 返回包装后的结果
	 */
	public static RestResponse<Object> buildResponse(Object data) {
		RestResponse<Object> restResponse = new RestResponse<>();
		restResponse.setData(data);
		restResponse.setApiStatus(0);
		return restResponse;
	}

	public static <T> RestResponse<?> buildRestResponse(T t) {
		RestResponse<T> restResponse = new RestResponse<>();
		restResponse.setData(t);
		return restResponse;
	}

	public static <T> RestResponse<?> buildRestResponse(T t, String message) {
		RestResponse<T> restResponse = new RestResponse<>();
		restResponse.setData(t);
		restResponse.setMessage(message);
		return restResponse;
	}

	public static RestResponse<Object> buildResponse(Object data, Integer apiStatus) {
		RestResponse<Object> restResponse = new RestResponse<>();
		restResponse.setData(data);
		restResponse.setApiStatus(apiStatus);
		return restResponse;
	}

	public static RestResponse<Object> buildResponse(Object data, Integer apiStatus, String message) {
		RestResponse<Object> restResponse = new RestResponse<>();
		restResponse.setData(data);
		restResponse.setApiStatus(apiStatus);
		restResponse.setMessage(message);
		return restResponse;
	}

	public static RestResponse<?> buildResponse(String message) {
		RestResponse<?> restResponse = new RestResponse<>();
		restResponse.setMessage(message);
		restResponse.setApiStatus(0);
		return restResponse;
	}

	public static RestResponse<?> buildExceptionResponse(String errorMessage) {
		RestResponse<?> restResponse = new RestResponse<>();
		restResponse.setMessage(errorMessage);
		restResponse.setApiStatus(-1);
		return restResponse;
	}

	public static RestResponse<?> buildExceptionResponse(String errorMessage, Integer apiStatus) {
		RestResponse<?> restResponse = new RestResponse<>();
		restResponse.setMessage(errorMessage);
		restResponse.setApiStatus(apiStatus);
		return restResponse;
	}

	public Integer getApiStatus() {
		return apiStatus;
	}

	public void setApiStatus(Integer apiStatus) {
		this.apiStatus = apiStatus;
	}

	public Integer getSysStatus() {
		return sysStatus;
	}

	public void setSysStatus(Integer sysStatus) {
		this.sysStatus = sysStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
