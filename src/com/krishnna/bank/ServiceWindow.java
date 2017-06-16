package com.krishnna.bank;

import java.util.Random;
import java.util.concurrent.Executors;

/**
 * 业务调用的窗口
 */

public class ServiceWindow {
	private CustomerType type = CustomerType.COMMON;
	private int windowId = 1;
	public void setType(CustomerType type) {
		this.type = type;
	}
	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}


	public void start(){
		Executors.newFixedThreadPool(1).execute(new Runnable(){

			@Override
			public void run() {
				while(true){
					switch(type){
					case COMMON:
						CustomerService(type,windowId);
						break;
					case EXPERSS:
						CustomerService(type,windowId);
						break;
					case VIP:
						CustomerService(type,windowId);
						break;
					
					}
				}
			}
		});
	}
	
	public void CustomerService(CustomerType type,int windowId) {
		String windowName = "第"+windowId+"号"+"=="+type+"=="+"窗口";
		//获取客户号码
		Integer num = fetchNumberService(type);
		System.out.println(windowName+"正在接取任务！wait...");
		
		//若客户号码不为空
		if(num != null){
			System.out.println(windowName+"正在为第"+num+"号"+"=="+type+"=="+"客户进行服务！ing...");
			long BeginTime = System.currentTimeMillis();
			try {
				Thread.sleep(new Random().nextInt(Constants.MAX_TIME)+1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long costTime = System.currentTimeMillis() - BeginTime;
			System.out.println(windowName+"正在处理"+num+"号"+"=="+type+"=="+"客户业务！消耗了"+costTime/1000+"秒！finsh...");
		} else{
			sleepService(type,windowName,windowId);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void sleepService(CustomerType type,String windowName,int windowId) {
		if(type == type.COMMON){
			System.out.println(windowName+"没有接到任务,休息一秒钟");
		}
		else{
			CustomerService(type.COMMON,windowId);
		}
	}
	
	private Integer fetchNumberService(CustomerType type) {
		switch(type){
		case COMMON:
			return NumberMachine.getInstance().getCommonNumberManager().fetchNumber();
		case EXPERSS:
			return NumberMachine.getInstance().getExpressNumberManager().fetchNumber();
		case VIP:
			return NumberMachine.getInstance().getVipNumberManager().fetchNumber();
		}
		
		return null;
	}
}
