package com.ijuncao.www.model;

public class Device {
	/**
	 * 分别对应设备的 编码,别名,用途类型,设备分组型号,工作状态码,城市,区域,经纬度,地区
	 */
		private  String  sn;
		private  String  alias;
		private  String  type;
		private  String  series;
		private  String  code;
		private  String  city;
		private  String  district;
		private  String  lat;
		private  String  lng;
		private  String  province;
		public String getSn() {
			return sn;
		}
		public void setSn(String sn) {
			this.sn = sn;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getSeries() {
			return series;
		}
		public void setSeries(String series) {
			this.series = series;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public String getLat() {
			return lat;
		}
		public void setLat(String lat) {
			this.lat = lat;
		}
		public String getLng() {
			return lng;
		}
		public void setLng(String lng) {
			this.lng = lng;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public Device(String sn, String alias, String type, String series, String code, String city, String district,
				String lat, String lng, String province) {
			super();
			this.sn = sn;
			this.alias = alias;
			this.type = type;
			this.series = series;
			this.code = code;
			this.city = city;
			this.district = district;
			this.lat = lat;
			this.lng = lng;
			this.province = province;
		}
		public Device() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		
		
}
