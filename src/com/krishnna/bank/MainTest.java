package com.krishnna.bank;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainTest {

	public static void main(String[] args) {

		//开启四个银行普通窗口，开始工作
		for(int i=1; i<5;i++){
			ServiceWindow commonWindow = new ServiceWindow();
			commonWindow.setWindowId(i);
			commonWindow.start();	
		}
		
		//开启一个银行快速窗口，开始工作
		ServiceWindow expressWindow = new ServiceWindow();
		expressWindow.setType(CustomerType.EXPERSS);
		expressWindow.setWindowId(5);
		expressWindow.start();
		
		
		//开启一个银行vip窗口，开始工作
		ServiceWindow vipWindow = new ServiceWindow();
		vipWindow.setType(CustomerType.VIP);
		vipWindow.setWindowId(6);
		vipWindow.start();
		
		//随机生成普通用户
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable(){
					@Override
					public void run() {
						Integer number = NumberMachine.getInstance().getCommonNumberManager().generateNewNumber();
						System.out.println("第"+number+"号--普通--客户等待服务！");	
					}
				}, 
				0, 
				1, 
				TimeUnit.SECONDS
			);
		
		//随机生成快速用户
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable(){
					@Override
					public void run() {
						int number = NumberMachine.getInstance().getExpressNumberManager().generateNewNumber();
						System.out.println("第"+number+"号--快速--客户等待服务！");	
					}
				}, 
				0, 
				3, 
				TimeUnit.SECONDS
			);
		
		//随机生成VIP用户
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable(){
					@Override
					public void run() {
						int number = NumberMachine.getInstance().getVipNumberManager().generateNewNumber();
						System.out.println("第"+number+"号--VIP--客户等待服务！");	
					}
				}, 
				0, 
				6, 
				TimeUnit.SECONDS
			);
		
	}

}
