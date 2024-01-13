package quanlithu;

public class Datban {
	public int id;
	public String tenban;
	public String tinhtrang;
	public String vitri;
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenban() {
		return tenban;
	}
	public void setTenban(String tenban) {
		this.tenban = tenban;
	}
	public String getVitri() {
		return vitri;
	}
	public void setVitri(String vitri) {
		this.vitri = vitri;
	}
	public Datban(int id, String tenban, String tinhtrang, String vitri) {
		this.id = id;
		this.tenban = tenban;
		this.tinhtrang = tinhtrang;
		this.vitri = vitri;
	}
	
	
	

}
