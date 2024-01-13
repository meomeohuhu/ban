package quanlithu;

public class Sotop {
	public String ngay;
	public int soluong;
	float tongthu;
	public float getTongthu() {
		return tongthu;
	}
	public void setTongthu(float tongthu) {
		this.tongthu = tongthu;
	}
	public Sotop(String ngay, int soluong,float tongthu) {
		this.tongthu=tongthu;
		this.ngay = ngay;
		this.soluong = soluong;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	

}
