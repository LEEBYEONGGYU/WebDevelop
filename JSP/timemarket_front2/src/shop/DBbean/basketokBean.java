package shop.DBbean;

public class basketokBean {
		private  String procode ;
		private String uid;
		private   String pilsu ;
		private String oplens ;
		private String opsdcard ;
		private String samgak ;
		private int price;
		
		public String getProcode() {
			return procode;
		}
		public String getuid() {
			return uid;
		}
		public String getPilsu() {
			return pilsu;
		}
		public String getOplens() {
			return oplens;
		}
		public String getOpsdcard() {
			return opsdcard;
		}
		public String getSamgak() {
			return samgak;
		}public int getprice() {
			return price;
		}
		public void setProcode(String procode) {
			this.procode = procode;
			
		}
		public void setuid(String uid) {
			this.uid = uid;
		}
		public void setPilsu(String pilsu) {
			this.pilsu = pilsu;
		}
		public void setOplens(String oplens) {
			this.oplens = oplens;
		}
		public void setOpsdcard(String opsdcard) {
			this.opsdcard = opsdcard;
		}
		public void setSamgak(String samgak) {
			this.samgak = samgak;
		}
		public void setprice(int price) {
			this.price = price;
		}
}
