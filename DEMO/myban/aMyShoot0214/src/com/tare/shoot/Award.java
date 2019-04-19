package com.tare.shoot;
/** 奖励接口*/
public interface Award {
	public int DOUBLE_FIRE = 0;//奖励火力类型
	public int LIFE = 1;//奖励生命类型设置为1
	/** 被击中后获得的奖励类型的方法 */
	public int getType();
}
