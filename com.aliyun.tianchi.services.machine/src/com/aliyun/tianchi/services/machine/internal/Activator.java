package com.aliyun.tianchi.services.machine.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.EventAdmin;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import com.aliyun.tianchi.runtime.rest.IRestServiceApplication;
import com.aliyun.tianchi.services.machine.MachineResourceImpl;

public class Activator implements BundleActivator,ServiceTrackerCustomizer<EventAdmin,EventAdmin> {

	private static BundleContext context;
	private ServiceTracker<EventAdmin,EventAdmin> eventAdminServiceTracker = null;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	@Override
	public EventAdmin addingService(ServiceReference<EventAdmin> reference) {
		// TODO Auto-generated method stub
		EventAdmin service = Activator.getContext().getService(reference);
		service.sendEvent(null);
		return service;
	}

	@Override
	public void modifiedService(ServiceReference<EventAdmin> reference,
			EventAdmin service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removedService(ServiceReference<EventAdmin> reference,
			EventAdmin service) {
		// TODO Auto-generated method stub
		
	}

	

}
