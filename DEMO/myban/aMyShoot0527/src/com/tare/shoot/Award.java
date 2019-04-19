package com.tare.shoot;
/** 奖励接口 */
public interface Award {
	public int DOUBLE_FIRE = 0;//双倍火力
	public int LIFE = 1;//生命
	
	/** 击中奖励类型对象，获取其奖励类型的方法 */
	public int getType();
}
