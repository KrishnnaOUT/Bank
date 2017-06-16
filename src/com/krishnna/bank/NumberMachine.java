package com.krishnna.bank;

/**]
 * 号码管理器
 * @author Ningkui
 *
 */
public class NumberMachine {

	private NumberManager commonNumberManager = new NumberManager();
	private NumberManager expressNumberManager = new NumberManager();
	private NumberManager vipNumberManager = new NumberManager();
	
	public NumberManager getCommonNumberManager() {
		return commonNumberManager;
	}
	public NumberManager getExpressNumberManager() {
		return expressNumberManager;
	}
	public NumberManager getVipNumberManager() {
		return vipNumberManager;
	}
	
	private NumberMachine(){
	}
	
	private static NumberMachine numberManager = new NumberMachine();
	
	public static NumberMachine getInstance() {
		return numberManager;
	}
}
