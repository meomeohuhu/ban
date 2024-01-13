package quanlithu;

public class Nuoc {

	public int id1;
	public String name;
	public Float total;
	public int getId() {
		return id1;
	}
	public void setId(int id1) {
		this.id1 = id1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Nuoc(int id1, String name, Float total) {
		
		this.id1 = id1;
		this.name = name;
		this.total = total;
	}
	
}
