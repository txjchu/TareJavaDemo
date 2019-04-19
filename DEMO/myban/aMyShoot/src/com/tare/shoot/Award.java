package com.tare.shoot;
/** 奖励接口 */
public interface Award {
	public int DOUBLE_FIRE = 0;//奖励类型0：双倍火力
	public int LIFE = 1;//奖励类型1：生命
	/** 被击中后获得的奖励类型，返回0是奖励双倍火力，返回1是奖励1生命 */
	public int getType();
}
