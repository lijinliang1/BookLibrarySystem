package com.eleven.booklibrary.util;   

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**
* 创建时间：2018年5月21日 上午9:57:05
* 项目名称：BookLibrarySystem
* @author lijinliang
* @version 1.0
* 文件名称：HttpUtil.java
* 类说明：
*/
public class HttpUtil {
	
	static final int maxRetry = 5;// 每路并发,很重要的参数 
	static final int maxTotal = 500;// 最大总并发,很重要的参数  
	static final int maxPerRoute = 100;// 每路并发,很重要的参数 
	
	public static CloseableHttpClient getHttpClient() {
		// 请求重试处理  
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {  
            public boolean retryRequest(IOException exception,  
                    int executionCount, HttpContext context) {  
                if (executionCount >= maxRetry) {// 如果已经重试了maxRetry次，就放弃  
                    return false;  
                }  
                if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试  
                    return true;  
                }  
                if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常  
                    return false;  
                }  
                if (exception instanceof InterruptedIOException) {// 超时  
                    return false;  
                }  
                if (exception instanceof UnknownHostException) {// 目标服务器不可达  
                    return false;  
                }  
                if (exception instanceof ConnectTimeoutException) {// 连接被拒绝  
                    return false;  
                }  
                if (exception instanceof SSLException) {// SSL握手异常  
                    return false;  
                }  

                HttpClientContext clientContext = HttpClientContext.adapt(context);  
                HttpRequest request = clientContext.getRequest();  
                  
                if (!(request instanceof HttpEntityEnclosingRequest)) {  
                    return true;  
                }  
                return false;  
            }  

        };  
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(maxTotal);
        cm.setDefaultMaxPerRoute(maxPerRoute);
        CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(httpRequestRetryHandler)
                .setConnectionManager(cm).build();
        return httpClient;
    }
	
	
	private static RequestConfig requestConfig = RequestConfig.custom()  
	            .setSocketTimeout(15000)  
	            .setConnectTimeout(15000)  
	            .setConnectionRequestTimeout(15000)  
	            .build();  

    /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String sendGet(String url) {

        HttpGet httpget = new HttpGet(url);
        httpget.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = HttpUtil.getHttpClient().execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送HttpPost请求，参数为map
     * @param url
     * @param map
     * @return
     */
    public static String sendPost(String url, Map<String, String> map) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = HttpUtil.getHttpClient().execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity1 = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送不带参数的HttpPost请求
     * @param url
     * @return
     */
    public static String sendPost(String url) {
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            response = HttpUtil.getHttpClient().execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
