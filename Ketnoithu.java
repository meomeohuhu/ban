package quanlithu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Ketnoithu {
	private int id;
	private String name;
	private float total;
	private String ngaythang;
	
	private String name1;
	private float total1;
	public Ketnoithu(String name1,float total1) {
		this.name1=name1;
		this.total1=total1;
	}
	public Ketnoithu(int id, String name, String ngaythang, float total) {
		
		this.id = id;
		this.name = name;
		this.ngaythang = ngaythang;
	
		this.total = total;
	}
	static String url="jdbc:mysql://localhost:3306/banhangmysql";
	static String user ="root";
	static String password="";
	public static Connection getConnection() {
		Connection c=null;
		
try {
	 Class.forName("com.mysql.cj.jdbc.Driver");
			c =DriverManager.getConnection(url, user, password);
System.out.println("ok");

	}         catch (Exception e) {
		// TODO: handle exception
		System.out.println("no");
		e.printStackTrace();
	}	
return c;
} 
	public static List<Nguonthu>findAll(){
	List<Nguonthu>nguonthuList=new ArrayList<>();
	try {
		
		Connection c =getConnection();
		Statement stmt =c.createStatement();
		 String query = "SELECT * FROM thu";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			Nguonthu nt=new Nguonthu(rs.getInt("id"), rs.getString("name"), rs.getFloat("total"), rs.getString("ngay"));
			
	
			nguonthuList.add(nt);
			System.out.println("fas");
		
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return nguonthuList;
}
	public static void insert(Nguonthu nt) {
	    String query = "INSERT INTO `thu`(`name`, `total`, `ngay`) VALUES (?, ?, ?)";
	    try {
	        Connection c = getConnection();
	        PreparedStatement pstmt = c.prepareStatement(query);
	        pstmt.setString(1, nt.getName());
	        pstmt.setFloat(2, nt.getTotal());
	    
	        pstmt.setString(3, nt.getNgaythang());
	        
	        pstmt.execute();
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // Xử lý ngoại lệ một cách thích hợp, có thể là ghi log hoặc ném ngoại lệ
	    }
	}

	public static void delete(Nguonthu nt) {
		String query="delete from thu where id ='"+nt.getId()+"'";
		try {
			Connection c=getConnection();
			PreparedStatement pstmt=c.prepareStatement(query);
		pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
//	public static void Update(Nguonthu nt) {
//			String query="Update thu set name=?,total=?,ngay=? where name="+nt.getName();
//			try {
//				
//				Connection c=getConnection();
//				PreparedStatement pstmt=c.prepareStatement(query);
//				pstmt.setString(1, nt.getName());
//				pstmt.setFloat(2, nt.getTotal());
//				pstmt.setString(3, nt.getNgaythang());
//				pstmt.executeUpdate();  
//				int affectedRows = pstmt.executeUpdate();
//				if (affectedRows > 0) {
//		            System.out.println("Update thành công!");
//		        } else {
//		            System.out.println("Không có dòng nào được cập nhật.");
//		        }
//				
//		    
//			} catch (Exception e) {
//				// TODO: handle exception
//				 System.out.println("Lỗi SQL: " + e.getMessage());
//			}
//			
//	}
	 public static List<Nguonthu> find(Nguonthu t) {
	        List<Nguonthu> nguonthuL = new ArrayList<>();
	        String query = "SELECT * FROM thu WHERE name=?";
	        try (Connection c = getConnection();
	             PreparedStatement pstmt = c.prepareStatement(query)) {
	        	 

	            pstmt.setString(1, t.getName());
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                Nguonthu nt = new Nguonthu(rs.getInt("id"), rs.getString("name"),
	                        rs.getFloat("total"),rs.getString("ngay"));
	                nguonthuL.add(nt);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return nguonthuL;
	    }
	 public static List<Top> find() {
	        List<Top> top = new ArrayList<>();
	        String query = "SELECT name, total as total,COUNT(*) as soluong FROM thu GROUP BY name ORDER BY total DESC LIMIT 6;";
	        try (Connection c = getConnection();
	             PreparedStatement pstmt = c.prepareStatement(query)) {
	        	 

	           
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	              Top t = new Top(rs.getString("name"), rs.getFloat("total"),rs.getInt("soluong"));
	                top.add(t);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return top;
	    }
	
	
	 public static float tongthu() {
		 float	tongthu=0;
		 try (Connection c = getConnection()) {
	            String query = "SELECT SUM(total) AS tongthu FROM thu";
	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        tongthu = rs.getFloat("tongthu");
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        
	        }
	        return tongthu;
	    }
	
	 public static float tongthungay() {
		 float	tongthu=0;
		 try (Connection c = getConnection()) {
	            String query = "SELECT SUM(total) AS tongthu FROM thu WHERE DATE(STR_TO_DATE(ngay, '%Y-%m-%d')) = CURRENT_DATE";
	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        tongthu = rs.getFloat("tongthu");
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        
	        }
	        return tongthu;
	    }
	 public static float tongthutuan() {
		 float	tongthu=0;
		 try (Connection c = getConnection()) {
	            String query = "SELECT SUM(total) AS tongthu FROM thu WHERE WEEK(STR_TO_DATE(ngay, '%Y-%m-%d')) = WEEK(NOW()) AND YEAR(STR_TO_DATE(ngay, '%Y-%m-%d')) = YEAR(NOW())";
	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        tongthu = rs.getFloat("tongthu");
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        
	        }
	        return tongthu;
	    }
	 public static float tongthuthang() {
		 float	tongthu=0;
		 try (Connection c = getConnection()) {
	            String query = "SELECT SUM(total) AS tongthu FROM thu WHERE MONTH(STR_TO_DATE(ngay, '%Y-%m-%d')) = MONTH(NOW()) AND YEAR(STR_TO_DATE(ngay, '%Y-%m-%d')) = YEAR(NOW())";
	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        tongthu = rs.getFloat("tongthu");
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        
	        }
	        return tongthu;
	    }
	 public static float so0() {
		 float	tongthu=0;
		 try (Connection c = getConnection()) {
	            String query = "SELECT COUNT(*) AS id FROM thu";
	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        tongthu = rs.getInt("id");
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        
	        }
	        return tongthu;
	    }
	
	 public static float so() {
		 float	tongthu=0;
		 try (Connection c = getConnection()) {
	            String query = "SELECT COUNT(*) AS id FROM thu WHERE DATE(STR_TO_DATE(ngay, '%Y-%m-%d')) = CURRENT_DATE";
	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        tongthu = rs.getInt("id");
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        
	        }
	        return tongthu;
	    }
	 public static float so1() {
		 float	tongthu=0;
		 try (Connection c = getConnection()) {
	            String query = "SELECT COUNT(*) AS id FROM thu WHERE WEEK(STR_TO_DATE(ngay, '%Y-%m-%d')) = WEEK(NOW()) AND YEAR(STR_TO_DATE(ngay, '%Y-%m-%d')) = YEAR(NOW())";
	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        tongthu = rs.getInt("id");
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        
	        }
	        return tongthu;
	    }
	 public static float so2() {
		 float	tongthu=0;
		 try (Connection c = getConnection()) {
	            String query = "SELECT COUNT(*) AS id FROM thu WHERE MONTH(STR_TO_DATE(ngay, '%Y-%m-%d')) = MONTH(NOW()) AND YEAR(STR_TO_DATE(ngay, '%Y-%m-%d')) = YEAR(NOW())";
	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        tongthu = rs.getInt("id");
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        
	        }
	        return tongthu;
	    }
	 public static List<Sotop> find1() {
	        List<Sotop> top1 = new ArrayList<>();
	        String query = "SELECT ngay, COUNT(*) AS soluong, SUM(total) AS tongthu FROM thu GROUP BY ngay ORDER BY soLuong DESC LIMIT 8;";
	        try (Connection c = getConnection();
	             PreparedStatement pstmt = c.prepareStatement(query)) {
	        	 

	           
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	             Sotop t =new Sotop(rs.getString("ngay"),rs.getInt("soluong"),rs.getFloat("tongthu"));
	                top1.add(t);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return top1;
	    }
	
	


	
	
	
}
