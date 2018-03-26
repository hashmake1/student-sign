package com.stu.sign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class StudentSignTest extends TestCase {

	public static void main(String[] args) throws Exception {
		// HttpClient httpclient = new DefaultHttpClient();
		// HttpPost httpPost = new
		// HttpPost("http://127.0.0.1:8080/studentSign");
		// List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// nvps.add(new BasicNameValuePair("studentNum", "vip"));
		// nvps.add(new BasicNameValuePair("weekNum", "secret"));
		// httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		// httpclient.execute(httpPost);
		// httpclient.getConnectionManager().shutdown();
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8080/studentSign");
		List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
		nvps.add(new BasicNameValuePair("studentNum", "vip"));
		nvps.add(new BasicNameValuePair("weekNum", "secret"));
		post.setEntity(new UrlEncodedFormEntity(nvps));
		// HttpEntity hh=new StringEntity(params,"UTF-8");
		UrlEncodedFormEntity he = new UrlEncodedFormEntity(nvps, "UTF-8");
		post.setEntity(he);
		HttpResponse res = httpclient.execute(post);
		HttpEntity entity = res.getEntity();
		String msg = EntityUtils.toString(entity, "UTF-8");
		System.out.println(msg);
	}

}
