package com.krishnna.bank;

public enum CustomerType {
	COMMON,EXPERSS,VIP;
	
	public String toString(){
		switch(this){
		case COMMON: 
			return "普通";
		case EXPERSS: 
			return "快速";
		case VIP: 
			return name();
		}
		return null;
	}
}
