package com.rajat.resources;

import java.nio.charset.Charset;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.rajat.entities.UrlEntity;
import com.rajat.service.UrlService;

@Path("/")
public class Url {
	
	@POST
	@Path("/storeurl")
	@Consumes(MediaType.TEXT_PLAIN)
	public void setUrl(@QueryParam("url") String url) {
		//save that into a table with a unique short key and a count(usage count) initialised to 0.
		byte[] array = new byte[7];
		new Random().nextBytes(array);
	    String shortKey = new String(array, Charset.forName("UTF-8"));
	    
		UrlEntity urlEntity = new UrlEntity(url, shortKey);
		new UrlService().addUrl(urlEntity);
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public String getShortKey(@QueryParam("url") String url) {
		// return the unique short key after incrementing the usage count.
		return new UrlService().getShortKey(url);
	}
	@GET
	@Path("/count")
	@Produces(MediaType.TEXT_PLAIN)
	public int getCount(@QueryParam("url") String url) {
		// return the latest usage count
		return new UrlService().getCount(url);
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.TEXT_PLAIN)
	public String getList(@QueryParam("page") int page, @QueryParam("size") int size) {
		return page+" - "+size;
	}
	
	
	
}
