package com.aliyun.tianchi.services.machine;

import javax.xml.bind.annotation.XmlRootElement;

import com.aliyun.tianchi.services.machine.MachineOsResource.MACHINE_OS_STATE;

@XmlRootElement
public class MachineOsEntity {
	
	private String os;
	private String osProfile;
	private String appProfile;
	private MACHINE_OS_STATE state = MACHINE_OS_STATE.ALIVE;
	
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getOsProfile() {
		return osProfile;
	}
	public void setOsProfile(String osProfile) {
		this.osProfile = osProfile;
	}
	public String getAppProfile() {
		return appProfile;
	}
	public void setAppProfile(String appProfile) {
		this.appProfile = appProfile;
	}
	public MACHINE_OS_STATE getState() {
		return state;
	}
	public void setState(MACHINE_OS_STATE state) {
		this.state = state;
	}
	
	
	
}
