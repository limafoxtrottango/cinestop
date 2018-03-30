package com.cinestop.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.cinestop.constants.OmdbAPIConstants;

public class OmdbAPIHelper {
	
	/**
	 * Calls omdb public api and fetches media information
	 * @param mediaName
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProtocolException
	 */
	public String getMediaDetail(final String mediaName) throws MalformedURLException, IOException, ProtocolException  {

		String url = "http://www.omdbapi.com/?t=" + mediaName + "&apikey=" + OmdbAPIConstants.API_KEY;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		// add request header
		con.setRequestProperty(OmdbAPIConstants.REQUEST_PROP_KEY, OmdbAPIConstants.REQUEST_PROP_VAL);
		int responseCode = con.getResponseCode();
		if(responseCode!=HttpURLConnection.HTTP_OK) {
			return null;
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

}
