package com.ijuncao.www.model;
/**
 * 树功能模板
 * @author wwj
 *
 */
public class FunctionVo {
	/**
	 * 分别对应功能id,功能名字,是否是叶子,父类id
	 */
	private  int authorityId;
	private  String authorityName;
	private  int isMenu;
	private  int parentId;
	private  boolean  open = true;
	public int getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public int getIsMenu() {
		return isMenu;
	}
	public void setIsMenu(int isMenu) {
		this.isMenu = isMenu;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = true;
	}
	
	

}
