package com.tare.shoot;
/** 奖励类型 */
public interface Award {
	public int DOUBLE_FIRE = 0;//双倍火力奖励类型
	public int  LIFE = 1;//命数奖励类型
	/** 获取奖励类型的方法 */
	public int getType();//返回0表示火力，返回1表示命数
}
