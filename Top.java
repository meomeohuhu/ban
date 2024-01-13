package quanlithu;

public class Top {
	public String name1;
	public float total1;
	public int soluong;
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public float getTotal1() {
		return total1;
	}
	public void setTotal1(float total1) {
		this.total1 = total1;
	}
	public Top(String name1, float total1,int soluong) {
		this.soluong=soluong;
		this.name1 = name1;
		this.total1 = total1;
	}
	

}
