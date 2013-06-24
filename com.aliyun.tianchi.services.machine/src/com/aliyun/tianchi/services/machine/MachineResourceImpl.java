package com.aliyun.tianchi.services.machine;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.fasterxml.jackson.databind.ObjectMapper;
@Path("/machines")
public class MachineResourceImpl{
	private static ObjectMapper objectMapper = new ObjectMapper();
	private MachineEntity entity = new MachineEntity();
	public MachineResourceImpl(){
		
		
	}
	@GET
	@Path("/{machine-sn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMachine(@PathParam("machine-sn") String machineServiceTag){
		//"2102317715N0A1000503"
		String machineInfo = Amory.retriveMachineDeviceInfo(machineServiceTag);
		try {
			Map<String,Object> machineInfoMap = this.objectMapper.readValue(machineInfo, Map.class);
			int num = (int) machineInfoMap.get("num");
			if (num <=0){
				return Response.status(404).entity("").build();
			}
			
			String jsonValue = this.objectMapper.writeValueAsString(((List)machineInfoMap.get("result")).get(0));
			System.out.println(jsonValue);
			return Response.ok().entity(jsonValue).build();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
			return Response.serverError().build();
		}
		

	}
	
//	@Path("/os")
//	public MachineOsResource getMachineOSInfo(@PathParam("machineTag") String machineTag) {
//		return new MachineOsResource(this.uriInfo,machineTag);
//	}
}
