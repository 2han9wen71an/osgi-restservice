package com.aliyun.tianchi.runtime.rest.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.service.http.HttpService;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;



public class Activator implements BundleActivator{
	
	private Logger logger = Logger.getLogger(Activator.class.getName());
	private static BundleContext context;
	private ServiceTracker<EventAdmin,EventAdmin> eventAdminServiceTracker = null;
	private ServiceTracker<HttpService,HttpService> httpServiceTracker = null;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		
		Activator.context = bundleContext;
		logger.log(Level.INFO, "--------");
//		httpServiceTracker = new ServiceTracker<HttpService, HttpService>(Activator.context,HttpService.class.getName(),new HttpServiceTrackerCustomizer());
//		this.httpServiceTracker.open();
		
		
//		// register the rest servcie event handler
//		String[] eventTopic = new String[]{RestServiceAddEvent.RESTSERVICE_REGISTERED_TOPIC};
//		Dictionary<String,Object> propites = new Hashtable<String,Object>();
//		propites.put(EventConstants.EVENT_TOPIC, eventTopic);
//		EventHandler restServiceEventHandler = new RestServiceEventHandler();
//		Activator.getContext().registerService(EventHandler.class, restServiceEventHandler, propites);
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	

}
