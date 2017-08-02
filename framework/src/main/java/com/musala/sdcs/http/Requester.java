package com.musala.sdcs.http;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Requester {

	private Logger logger;

	public Requester() {
		this.logger = LoggerFactory.getLogger(Requester.class);
	}

	public void makePostRestJSONCall(String url, String jsonObj) {
		makePostRestJSONCall(url, jsonObj, null);
	}

	public void makePostRestJSONCall(String url, String jsonObj, String authorization) {

		HttpClient httpclient = HttpClientBuilder.create().build();
		StringEntity requestEntity = new StringEntity(jsonObj,
				ContentType.create(ContentType.APPLICATION_JSON.getMimeType(), Consts.UTF_8));

		HttpPost postMethod = new HttpPost(url);
		postMethod.addHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
		if (authorization != null) {
			postMethod.addHeader(HttpHeaders.AUTHORIZATION, authorization);
		}
		postMethod.setEntity(requestEntity);

		HttpResponse response = null;
		try {
			response = httpclient.execute(postMethod);
		} catch (ClientProtocolException e) {
			logger.error("Failed to establish connection", e);
		} catch (IOException e) {
			logger.error("Failed to establish connection", e);
		} finally {
			// Release the connection
			postMethod.releaseConnection();
		}

		if (response.getStatusLine().getStatusCode() != 200) {
			logger.error(String.format("Bad rest call to %s. Status code: %s", url,
					response.getStatusLine().getStatusCode()));
		}
	}

}
