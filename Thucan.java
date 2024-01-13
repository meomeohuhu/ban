package quanlithu;

public class Thucan {
	public String tenmon;
	public Float giatien;
	public int id;
	public String getTenmon() {
		return tenmon;
	}
	public Thucan(int id,String tenmon, Float giatien) {
		this.tenmon = tenmon;
		this.id = id;
		this.giatien = giatien;
	}
	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}
	public Float getGiatien() {
		return giatien;
	}
	public void setGiatien(Float giatien) {
		this.giatien = giatien;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
