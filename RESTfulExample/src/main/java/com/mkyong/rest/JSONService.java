package com.mkyong.rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mkyong.Status;

public class JSONService {

	@GET
	@Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
	public Status getMainApplicationStats() {

		Status status = new Status();
		if(isAccessable("http://www.stackoverflow.com", 1000))
		{
			status.setStatus("Up");
		}else{
			status.setStatus("Down");
		}

		return status;

	}
	
	@GET
	@Path("/dependancy-1/status")
	@Produces(MediaType.APPLICATION_JSON)
	public Status getDependant1Status() {

		Status status = new Status();
		if(isAccessable("http://www.stackoverflow.com", 1000))
		{
			status.setStatus("Up");
		}else{
			status.setStatus("Down");
		}

		return status;

	}
	
	@GET
	@Path("/dependancy-2/status")
	@Produces(MediaType.APPLICATION_JSON)
	public Status getDependant2Status() {

		Status status = new Status();
		if(isAccessable("http://www.stackoverflow.com", 1000))
		{
			status.setStatus("Up");
		}else{
			status.setStatus("Down");
		}

		return status;

	}


	public static boolean isAccessable(String url, int timeout) {
		url = url.replaceFirst("https", "http"); // Otherwise an exception may
													// be thrown on invalid SSL
													// certificates.

		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setConnectTimeout(timeout);
//			connection.setReadTimeout(timeout);
			connection.setRequestMethod("HEAD");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				return false;
			}
		} catch (IOException exception) {
			return false;
		}
		return true;
	}

}