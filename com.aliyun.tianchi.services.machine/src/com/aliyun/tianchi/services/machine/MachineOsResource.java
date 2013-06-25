package com.aliyun.tianchi.services.machine;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.map.ObjectMapper;



@Path("/machines/{machineSN}/os")
public class MachineOsResource {
	public static enum MACHINE_OS_STATE {
		UNDEFINED(0),ALIVE(1),DOWN(2),INSTALLING(3),RESTARTING(4);
		
		private int value;

		MACHINE_OS_STATE(int value){
			this.value = value;
		}
		

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.valueOf(this.value);
		}
		
		public static MACHINE_OS_STATE valueOf(int value){
			switch(value){
			case 1:
				return ALIVE;
			case 2:
				return DOWN;
			case 3:
				return INSTALLING;
			case 4:
				return RESTARTING;
			default:
				return UNDEFINED;
			}
		}
		
	}
	private static ObjectMapper objectMapper = new ObjectMapper();
	private String machineTag;
	private MachineOsEntity entity = new MachineOsEntity();
	@Context 
	UriInfo uriInfo;
	public MachineOsResource(@PathParam("machineSN") String machineTag){
		this.machineTag = machineTag;
//		AmoryHelper.start();
//		Map<String,String> responseData = AmoryHelper.getLastInstalledOSInfo(machineTag);
//		AmoryHelper.stop();
//		entity.setAppProfile(responseData.get("appProfile"));
//		entity.setOs(responseData.get("os"));
//		entity.setOsProfile(responseData.get("osProfile"));
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMachineOSInfo(){
		String responseData = null;
		try {
			String result = Amory.retriveMachineOsInfo(this.machineTag);
			System.out.println(result);
			List<Map<String,String>> machineOsDatas = null;
			Map<String, Object>  resultMap = objectMapper.readValue(result,Map.class);
			machineOsDatas = (List<Map<String, String>>) resultMap.get("data");
			if (machineOsDatas == null || machineOsDatas.size() <= 0){
				return Response.status(404).entity(machineOsDatas).build();
			}
			responseData = this.objectMapper.writeValueAsString(machineOsDatas.get(0));
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok().entity(responseData).build();
//		return new MachineOsEntity();
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMachineOsInfo(@FormParam("state") int updatedState){
		MACHINE_OS_STATE state = MACHINE_OS_STATE.valueOf(updatedState);
		if (state == MACHINE_OS_STATE.RESTARTING){
			
		}
		return Response.ok().entity(entity).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response installOS(@FormParam("osProfile") String osProfile, @FormParam("appProfile") String appProfile) {
		URI createdUri = uriInfo.getAbsolutePathBuilder().path("/installation").build();
		this.entity.setAppProfile(appProfile);
		this.entity.setOsProfile(osProfile);
		// clone this machine with specified os
//		AmoryHelper.installOs(this.machineTag, this.entity.getOsProfile(), this.entity.getAppProfile());
		return Response.created(createdUri).entity(this.entity).build();
	}
	

	
	
}
