package org.oliot.onem2m.oneM2M_REST_Client;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class InteractionRequest {
	//public static final String aeInternalIpAddress = "203.254.173.133";
	public static final String aeInternalIpAddress = "143.248.55.183:7579";
	
	//String csebase="/nCube";
	static String csebase="/mobius-yt";
	//static String csebase="/mqtt:";
	
	public static String aeRegistrationMessage(String aeName, String appId) throws Exception {
		String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
							"<m2m:ae xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" + 
							"<api>app-sensor</api>"+
							"<rr>false</rr>"+
							"<rn>"+"ae-"+ appId +"</rn>"+
							"<App-ID>" + appId + "</App-ID>\n" +
							"</m2m:ae>";

		StringEntity entity = new StringEntity(
				new String(requestBody.getBytes()));

		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost(aeInternalIpAddress)
				.setPath(csebase)
				//.setParameter("ty", "AE")
				.setParameter("ty", "2")
				.setParameter("nm", aeName)
				.build();
		
		HttpPost post = new HttpPost(uri);
				post.setHeader("From", "localhost");
				post.setHeader("X-M2M-RI", "0001");
				post.setHeader("X-M2M-Origin", "SOrigin");
				post.setHeader("Accept", "application/onem2m-resource+xml");
				post.setHeader("Content-Type", "application/onem2m-resource+xml; ty=2");
				post.setEntity(entity);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpResponse response = httpClient.execute(post);
		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Return Http response code : " + responseCode);
		
		HttpEntity responseEntity = response.getEntity();
		
		String responseString = EntityUtils.toString(responseEntity);
		
		System.out.println("Return Http response body : " + responseString);
		
		httpClient.close();
		
		return responseString;
	}
	
	public static String containerCreateMessage(String appId, String containerName) throws Exception {
		String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
							"<m2m:cnt xmlns:m2m=\"http://www.onem2m.org/xml/protocols\" rn=\"" + containerName+"\">\n" + 
							"<containerType>testType</containerType>\n" +
							"</m2m:cnt>";

		StringEntity entity = new StringEntity(
				new String(requestBody.getBytes()));

		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost(aeInternalIpAddress)
				.setPath(csebase + "/ae-" + appId)
				//.setParameter("ty", "container")
				.setParameter("ty", "3")
				.setParameter("nm", containerName)
				.build();
		
		HttpPost post = new HttpPost(uri);
				post.setHeader("From", "localhost");
				post.setHeader("X-M2M-RI", "0001");
				post.setHeader("X-M2M-Origin", "SOrigin");
				post.setHeader("Accept", "application/onem2m-resource+xml");
				post.setHeader("Content-Type", "application/onem2m-resource+xml; ty=3");
				post.setEntity(entity);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpResponse response = httpClient.execute(post);
		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Return Http response code : " + responseCode);
		
		HttpEntity responseEntity = response.getEntity();
		
		String responseString = EntityUtils.toString(responseEntity);
		
		System.out.println("Return Http response body : " + responseString);
		
		httpClient.close();
		
		return responseString;
	}
	
	public static String contentInstanceCreateMessage(String appId, String containerName, String content) throws Exception {
		String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
							"<m2m:cin"
							+ " xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" + 
							"<typeOfContent>String</typeOfContent>\n" + 
							//"<content>" + content + "</content>\n" +
							//"<rn>ae-22</rn>"+
							"<con>" + content + "</con>\n" +
							"<linkType>no</linkType>\n" +
							"</m2m:cin>";

		StringEntity entity = new StringEntity(
				new String(requestBody.getBytes()));

		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost(aeInternalIpAddress)
				.setPath(csebase + "/AE-" + appId + "/" + containerName)
				//.setParameter("ty", "contentInstance")
				.setParameter("ty", "4")
				.build();
		
		HttpPost post = new HttpPost(uri);
				post.setHeader("From", "localhost");
				post.setHeader("X-M2M-RI", "0001");
				post.setHeader("X-M2M-Origin", "SOrigin");
				post.setHeader("Accept", "application/onem2m-resource+xml");
				post.setHeader("Content-Type", "application/onem2m-resource+xml; ty=4");
				post.setEntity(entity);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpResponse response = httpClient.execute(post);
		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Return Http response code : " + responseCode);
		
		HttpEntity responseEntity = response.getEntity();
		
		String responseString = EntityUtils.toString(responseEntity);
		
		System.out.println("Return Http response body : " + responseString);
		
		httpClient.close();
		
		return responseString;
	}
}
