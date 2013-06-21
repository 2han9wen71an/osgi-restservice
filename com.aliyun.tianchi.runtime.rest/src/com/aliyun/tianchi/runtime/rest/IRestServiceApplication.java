package com.aliyun.tianchi.runtime.rest;


public interface IRestServiceApplication {

	void registerServiceClasses(Class<?>... classes);
	
	void unregisterServiceClasses(Class<?>... classes);
}
