package com.krishnna.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * 银行排队号码生成器类
 * @author Ningkui
 *
 */
public class NumberManager {

	private int lastNumber = 1;//最后生成的号码
	//存储生成号码的集合
	private List<Integer> numberList = new ArrayList<Integer>();
	
	/**
	 * 生成排队号码
	 * @return 返回生成的号码
	 */
	@SuppressWarnings("unused")
	public synchronized Integer generateNewNumber(){
		//将生成的号码添加到集合numberList中
		numberList.add(lastNumber);
		//return
		return lastNumber++;
	}
	
	/**
	 * 调用号码，即对应业务中接待对应号码的客户
	 */
	@SuppressWarnings("unused")
	public synchronized Integer fetchNumber() {
		Integer num = null;
		if(numberList.size()>0){
			num = numberList.remove(0);
		}
		return num;
	}
	
}
