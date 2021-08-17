package com.rajat.resources;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.rajat.showroom.model.Product;

import com.rajat.entities.UrlEntity;
import com.rajat.service.UrlService;

@Path("/")
public class Url {
	
	UrlService service = new UrlService();
	
	@POST
	@Path("/storeurl")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setUrl(@QueryParam("url") String url) {
		//save that into a table with a unique short key and a count(usage count) initialised to 0.
		int lowerLimit = 97, upperLimit = 122;
		Random random = new Random();
		StringBuffer shortKey = new StringBuffer(5);
		for (int i = 0; i < 5; i++) {
            int nextRandomChar = lowerLimit + (int)(random.nextFloat() * (upperLimit - lowerLimit + 1));
            shortKey.append((char)nextRandomChar);
        }
	    
		UrlEntity urlEntity = new UrlEntity(url, shortKey.toString());
		service.addUrl(urlEntity);
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public String getShortKey(@QueryParam("url") String url) {
		// return the unique short key after incrementing the usage count.
		service.increaseUsageCount(url);
		return service.getShortKey(url);
	}
	@GET
	@Path("/count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount(@QueryParam("url") String url) {
		// return the latest usage count
		return service.getCount(url);
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UrlEntity> getList(@QueryParam("page") int page, @QueryParam("size") int size) {
		System.out.println(page+" "+size);
		List<UrlEntity> urlEntities;
		urlEntities = service.getList(page, size);
		
//		if(end > 0) {
//			productList = productList.subList(start, end);
//		}
		
		return urlEntities;
	}
	
	
	
}
