package jb.com;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {

	public static void main(String[] args) {

		String msg=HttpClient.sendGet("https://test.drms.ascentac.com/4b0QSlivP3A8btxXf2lrUA/drms/v1/cpix/wvservice.rest?p=4b0QSlivP3A8btxXf2lrUA&c=abc&token=291f8157b939c2912206564fa82168c8");
		System.out.println(msg);
		//String msg2=httpClient.sendPost("https://test.drms.ascentac.com/4b0QSlivP3A8btxXf2lrUA/drms/v1/cpix/wvservice.rest?p=4b0QSlivP3A8btxXf2lrUA&c=abc&token=291f8157b939c2912206564fa82168c8");
		//System.out.println(msg2);
	}
	/**
	 * 傳送HttpGet請求
	 * @param url
	 * @return
	 */
	public static String sendGet(String url) {
		//1.獲得一個httpclient物件
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//2.生成一個get請求
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse response = null;
		try {
			//3.執行get請求並返回結果
			response = httpclient.execute(httpget);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String result = null;
		try {
			//4.處理結果，這裡將結果返回為字串
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity);
			}
		} catch (ParseException | IOException e) {
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
	 * 傳送不帶引數的HttpPost請求
	 * @param url
	 * @return
	 */
	public static String sendPost(String url) {
		//1.獲得一個httpclient物件
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//2.生成一個post請求
		HttpPost httppost = new HttpPost(url);
		CloseableHttpResponse response = null;
		try {
			//3.執行get請求並返回結果
			response = httpclient.execute(httppost);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//4.處理結果，這裡將結果返回為字串
		HttpEntity entity = response.getEntity();
		String result = null;
		try {
			result = EntityUtils.toString(entity);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
