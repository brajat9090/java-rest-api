package com.rajat.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Url {
	
	@POST
	@Path("/storeurl")
	@Consumes(MediaType.TEXT_PLAIN)
	public String setUrl(@QueryParam("url") String url) {
		return url;
	}
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUrl(@QueryParam("url") String url) {
		// return the unique short key after incrementing the usage count.
		return url;
	}
	@GET
	@Path("/count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount(@QueryParam("url") String url) {
		// return the latest usage count
		return url;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.TEXT_PLAIN)
	public String getList(@QueryParam("page") int page, @QueryParam("size") int size) {
		return page+" - "+size;
	}
	
	
	
}
