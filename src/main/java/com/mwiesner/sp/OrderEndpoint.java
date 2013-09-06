package com.mwiesner.sp;


public class OrderEndpoint {
	
	public void processBoxOrder(String order) {
		System.out.println("BOX ORDER: "+order);
	}
	
	public void processDownloadOrder(String order) {
		System.out.println("DOWNLOAD ORDER: "+order);
	}
	
	

}
