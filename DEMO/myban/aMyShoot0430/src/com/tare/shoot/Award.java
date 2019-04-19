package com.tare.shoot;
/** 奖励接口 */
public interface Award {
	public int DOUBLE_FIRE = 0;//双倍火力
	public int LIFE = 1;//命
	
	/** 获取奖励类型 */
	public int getType();//返回0表示双倍火力，返回1表示命
}
