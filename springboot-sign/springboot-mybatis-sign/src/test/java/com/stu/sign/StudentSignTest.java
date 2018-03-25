package com.stu.sign;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class StudentSignTest extends TestCase {
	// private static String doHttp(String xml) throws Exception {
	// HttpClient client = new HttpClient();
	// client.getHttpConnectionManager().getParams().setConnectionTimeout(0);
	// client.getHttpConnectionManager().getParams().setSoTimeout(0);
	// PostMethod method = new PostMethod(prop.getProperty("service"));
	// method.addRequestHeader("Content-Type",
	// "application/x-www-form-urlencoded; charset=UTF-8");
	// method.addRequestHeader("Connection", "keep-alive");
	// DefaultHttpMethodRetryHandler retry = new
	// DefaultHttpMethodRetryHandler(0, false);
	// RequestEntity objRequestEntity = new
	// ByteArrayRequestEntity(xml.getBytes("UTF-8"));
	// method.setRequestEntity(objRequestEntity);
	// method.getParams().setParameter("http.method.retry-handler", retry);
	// client.executeMethod(method);
	// String rtn = method.getResponseBodyAsString();
	// try {
	// method.releaseConnection();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return rtn;
	// }

	public String client(String url, HttpMethod method, MultiValueMap<String, String> params) {
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		// 请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		// 执行HTTP请求
		ResponseEntity<String> response = client.exchange(url, HttpMethod.POST, requestEntity, String.class);
		return response.getBody();
	}
}
