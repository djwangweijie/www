package com.ijuncao.www.model;

import java.util.List;

public class Function {
	/**
	 * 功能id,功能名字,功能父id以及子节点功能,功能图标,功能连接,目标地址,所属用户id
	 */
		private  int id;
		private  String title;
		private  int pid;
		private  String icon;
		private  String href;
		private  String target;
		List<Function> child;
		private  int userid;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getHref() {
			return href;
		}
		public void setHref(String href) {
			this.href = href;
		}
		public String getTarget() {
			return target;
		}
		public void setTarget(String target) {
			this.target = target;
		}
		public List<Function> getChild() {
			return child;
		}
		public void setChild(List<Function> child) {
			this.child = child;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		

		
}
