package com.aliyun.tianchi.services.machine.internal;

import org.osgi.service.component.ComponentContext;

import com.aliyun.tianchi.runtime.rest.IRestServiceApplication;
import com.aliyun.tianchi.services.machine.MachineOsResource;
import com.aliyun.tianchi.services.machine.MachineResourceImpl;

public class MachineResourceComponent {
	private IRestServiceApplication app;
	public void activate(ComponentContext context){
		app.registerServiceClasses(MachineResourceImpl.class);
//		app.registerServiceClasses(MachineOsResource.class);
		
	}
	public void deactivate(ComponentContext context){
		app.unregisterServiceClasses(MachineResourceImpl.class);
	}
	public void setRestServiceApp(IRestServiceApplication app){
		this.app = app;
	}
	
	
}
