package com.tare.shoot;
/** 奖励接口 */
public interface Award {
	public int DOUBLE_FIRE = 0;//奖励类型1：火力
	public int LIFE = 1;//奖励类型2：命
	/** 被击中后获得奖励的方法 */
	public int getType();
}
