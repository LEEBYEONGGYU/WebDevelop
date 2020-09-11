package shop.DBbean;

public class ProductBasketData {
	private String userid;
	private String b_num;
	private String b_name;
	private String b_price;
	private String b_count;
	
	/*옵션*/
	private String opt1;
	private String opt2;
	private String opt3;
	
	public String getUserid() {
		return userid;
	}
	public String getB_num() {
		return b_num;
	}
	public String getB_name() {
		return b_name;
	}
	public String getB_price() {
		return b_price;
	}
	public String getB_count() {
		return b_count;
	}
	public String getOpt1() {
		return opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public String setUserid(String userid) {
		return this.userid = userid;
	}
	public String setB_num(String b_num) {
		return this.b_num = b_num;
	}
	public String setB_name(String b_name) {
		return this.b_name = b_name;
	}
	public String setB_price(String b_price) {
		return this.b_price = b_price;
	}
	public String setB_count(String b_count) {
		return this.b_count = b_count;
	}
	public String setOpt1(String opt1) {
		return this.opt1 = opt1;
	}
	public String setOpt2(String opt2) {
		return this.opt2 = opt2;
	}
	public String setOpt3(String opt3) {
		return this.opt3 = opt3;
	}
	
	
	
	
}
