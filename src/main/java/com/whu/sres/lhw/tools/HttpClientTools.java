package com.whu.sres.lhw.tools;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Desc: HTTP客户端工具类，执行GET和POST请求
 * Created by lvhongwei on 2018/9/4.
 */
public final class HttpClientTools {

    private HttpClientTools() {
    }

    /**
     * 处理get请求
     * @param getUrl    get请求的URL
     */
    public static String doGet(String getUrl) {
        //getUrl = getUrl + "&r=" + Math.random();
        GetMethod getMethod = new GetMethod(getUrl);
        return doMethod(getMethod);
    }

    public static String doPost(String postUrl, List<NameValuePair> nameValuePairs) {
        PostMethod postMethod = new PostMethod(postUrl);
        NameValuePair[] array = new NameValuePair[nameValuePairs.size()];
        nameValuePairs.toArray(array);

        postMethod.setRequestBody(array);
        postMethod.addRequestHeader("Content-Type", PostMethod.FORM_URL_ENCODED_CONTENT_TYPE
                + "; charset=utf-8");
        return doMethod(postMethod);
    }

    public static String doPost(String postUrl, Map<String, Object> params) {
        List<NameValuePair> pairs = Lists.newArrayList();
        if (null != params && 0 < params.size()) {
            for (Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new NameValuePair();
                Object vo = entry.getValue();
                String value = null == vo ? "" : vo.toString();

                pair.setName(entry.getKey());
                pair.setValue(value);
                pairs.add(pair);
            }
        }
        return doPost(postUrl, pairs);
    }

    /**
     * 执行传递JSON对象的POST请求
     * @param postUrl   POST请求URL
     * @param bodyParam 参数对象
     */
    public static String doJsonPost(String postUrl, Object bodyParam) {
        PostMethod postMethod = new PostMethod(postUrl);
        try {
            RequestEntity entity = new StringRequestEntity(JSON.toJSONString(bodyParam) , "application/json", "UTF-8");
            postMethod.setRequestEntity(entity);
            postMethod.addRequestHeader("Content-Type", "application/json; charset=UTF-8");
            return doMethod(postMethod);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String doMethod(HttpMethod method) {
        String url = method.getPath();

        HttpClient httpClient = new HttpClient(new SimpleHttpConnectionManager());
        try {
            int statusCode = httpClient.executeMethod(method);

            InputStream is = method.getResponseBodyAsStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            StringBuilder strBuilder = new StringBuilder();
            String line;
            while ((line = bf.readLine()) != null) {
                strBuilder.append(line);
            }

            String responseStr = strBuilder.toString();
            if (200 == statusCode) {
                return responseStr;
            }
            String msg = String.format("abnormal status code : %s  from requesting %s. response body is : %s",
                    statusCode, url, responseStr);
            throw new RuntimeException(msg);
        } catch (Exception e) {
            String msg = String.format("exception occurs when requesting %s.", url);
            throw new RuntimeException(msg, e);
        } finally {
            // 关闭连接，否则需要等待服务器端超时后，才能自动关闭
            method.releaseConnection();
        }
    }
}
