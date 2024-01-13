package quanlithu;

public class Bill {

	public int id2;
	public String tenmon2;
	public int soluong;
	public float total1;
	
	
	
	public float getTotal1() {
		return total1;
	}
	public void setTotal1(float total1) {
		this.total1 = total1;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	public String getTenmon2() {
		return tenmon2;
	}
	public void setTenmon2(String tenmon2) {
		this.tenmon2 = tenmon2;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Bill(int id2, String tenmon2, int soluong, float total1) {
		
		this.id2 = id2;
		this.tenmon2 = tenmon2;
		this.soluong = soluong;
		this.total1 = total1;
	}
	
	
}
