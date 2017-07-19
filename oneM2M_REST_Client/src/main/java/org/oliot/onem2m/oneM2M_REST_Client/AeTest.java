package org.oliot.onem2m.oneM2M_REST_Client;

public class AeTest {
	
	//static final String aeName = "oneM2MAE";
	static final String aeName = "mobius-yt";
	static final String appId = "2";
	static final String containerName = "test1";
	static final String content = "102";
	
	public static void main(String args[]) throws Exception {
		System.out.println("[ID-AE] AE start");
		
		System.out.println("[ID-AE] AE Create request : " + aeName);
		//InteractionRequest.aeRegistrationMessage(aeName, appId);
		
		System.out.println("[ID-AE] AE container Create request" + containerName);
		//InteractionRequest.containerCreateMessage(appId, containerName);
		
		System.out.println("[ID-AE] AE contentInstance Create request");
		InteractionRequest.contentInstanceCreateMessage(appId, containerName, content);
		
		while(true) {
			
		}
	}
}
