package com.aliyun.tianchi.services.machine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MachineEntity {
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	public int getHarddisk() {
		return harddisk;
	}
	public void setHarddisk(int harddisk) {
		this.harddisk = harddisk;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public String getOob_ip() {
		return oob_ip;
	}
	public void setOob_ip(String oob_ip) {
		this.oob_ip = oob_ip;
	}
	public String getIdc_room() {
		return idc_room;
	}
	public void setIdc_room(String idc_room) {
		this.idc_room = idc_room;
	}
	private String sn;
	private String ip;
	private String hostname;
	private int cpu;
	private int harddisk;
	private int memory;
	private String oob_ip;
	private String idc_room;
	
	
}
