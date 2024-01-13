package quanlithu;

import java.util.Date;

public class Nguonthu {
	 private int id;
	 private String name;
	 private String ngaythang;
	
	 


		public String getNgaythang() {
		return ngaythang;
	}

	public void setNgaythang(String ngaythang) {
		this.ngaythang = ngaythang;
	}

		public float total;
	   
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

		public Nguonthu(int id, String name, float total,String ngaythang) {
			
			this.id = id;
			this.name = name;
			this.ngaythang = ngaythang;
		
			this.total = total;
		}

	
	    
	
	}

