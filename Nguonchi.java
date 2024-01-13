package quanlithu;

import java.util.Date;

public class Nguonchi {
	public int id;
	public String name;
    public float total;
    public String ngaythang;
    
  

    public String getNgaythang1() {
    	return ngaythang;
    }
    public void setNgaythang1(String ngaythang) {
    	this.ngaythang=ngaythang;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
	public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    public Nguonchi(int id, String name, float total, String ngaythang) {
		super();
		this.id = id;
		this.name = name;
		this.total = total;
		this.ngaythang = ngaythang;
	}
   
   

}




