package com.tare.shoot;
/** 奖励接口 */
public interface Award {
	public int DOUBLE_FIRE = 0;//奖励类型1.双倍火力
	public int LIFE = 1;//2.命数
	/** 获得对象奖励类型的方法 */
	public int getType();//返回0表示双倍火力，返回1表示命数
}
