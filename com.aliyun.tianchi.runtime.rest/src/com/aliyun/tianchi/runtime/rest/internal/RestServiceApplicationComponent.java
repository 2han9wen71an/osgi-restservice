package com.aliyun.tianchi.runtime.rest.internal;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import com.aliyun.tianchi.runtime.rest.IRestServiceApplication;

public class RestServiceApplicationComponent implements IRestServiceApplication {
	private Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
	private ServletContainer container = new ServletContainer(new ResourceConfig());
	private Logger logger = Logger.getLogger(RestServiceApplicationComponent.class.getName());
	public void activate(ComponentContext context){
	}
	public void setHttpService(HttpService service){
		try {
			service.registerServlet("/test", container, null, null);
			
		} catch (ServletException | NamespaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void reloadContainer(){
		ResourceConfig newConfig = new ResourceConfig(this.serviceClasses);
		this.container.reload(newConfig);
	}
	
	@Override
	public void registerServiceClasses(Class<?>... classes) {
		// TODO Auto-generated method stub
		for (Class<?> serviceClass:classes){
			this.serviceClasses.add(serviceClass);
		}
		this.reloadContainer();
	}
	
	@Override
	public void unregisterServiceClasses(Class<?>... classes) {
		// TODO Auto-generated method stub
		for (Class<?> serviceClass:classes){
			this.serviceClasses.remove(serviceClass);
		}
		this.reloadContainer();
		
	}
	
}
