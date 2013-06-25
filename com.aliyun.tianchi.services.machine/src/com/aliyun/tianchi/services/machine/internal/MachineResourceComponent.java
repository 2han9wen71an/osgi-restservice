package com.aliyun.tianchi.services.machine.internal;

import org.osgi.service.component.ComponentContext;

import com.aliyun.tianchi.runtime.rest.IRestServiceApplication;
import com.aliyun.tianchi.services.machine.MachineOsEntity;
import com.aliyun.tianchi.services.machine.MachineOsResource;
import com.aliyun.tianchi.services.machine.MachineResource;

public class MachineResourceComponent {
	private IRestServiceApplication app;
	public void activate(ComponentContext context){
		app.registerServiceClasses(MachineResource.class,MachineOsResource.class);
//		app.registerServiceClasses(MachineOsResource.class);
		
	}
	public void deactivate(ComponentContext context){
		app.unregisterServiceClasses(MachineResource.class);
	}
	public void setRestServiceApp(IRestServiceApplication app){
		this.app = app;
	}
	
	
}
