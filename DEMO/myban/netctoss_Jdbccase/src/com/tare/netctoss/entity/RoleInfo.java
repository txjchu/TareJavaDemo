package com.tare.netctoss.entity;
/**
 * 职员表的实体类
 * @author Administrator
 *
 */
public class RoleInfo {
	private int roleId;
	private String name;
	public RoleInfo(){}
	public RoleInfo(int roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + roleId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleInfo other = (RoleInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roleId != other.roleId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RoleInfo [name=" + name + ", roleId=" + roleId + "]";
	}
	
	
}
