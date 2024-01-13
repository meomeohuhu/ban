package quanlithu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ketnoithucan {
	private int id;
	private String tenmon;
	private float giatien;
	public Ketnoithucan(int id, String tenmon, float giatien) {
		this.id = id;
		this.tenmon = tenmon;
		this.giatien=giatien;
	}
	private int id1;
	private String name;
	private float total;
   public Ketnoithucan(int id1, String name, Float total) {
		
		this.id1 = id1;
		this.name = name;
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
	public static List<Thucan>findAll(){
	List<Thucan>FoodList=new ArrayList<>();
	try {
		
		Connection c =getConnection();
		Statement stmt =c.createStatement();
		 String query = "SELECT * FROM thucan";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
		Thucan nt=new Thucan(rs.getInt("id"), rs.getString("name"), rs.getFloat("total"));
			FoodList.add(nt);
//			System.out.println("fas");
		
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return FoodList;
}
	public static void insert(Thucan nt) {
	    String query = "INSERT INTO `thucan`(`id` ,`name`, `total`) VALUES (?, ?,?)";
	    try {
	        Connection c = getConnection();
	        PreparedStatement pstmt = c.prepareStatement(query);
	        pstmt.setInt(1, nt.getId());
	        pstmt.setString(2, nt.getTenmon());
	        pstmt.setFloat(3, nt.getGiatien());
	        pstmt.execute();
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // Xử lý ngoại lệ một cách thích hợp, có thể là ghi log hoặc ném ngoại lệ
	    }
	}
	
	public static void delete(Thucan nt) {
		String query="delete from thucan where id ='"+nt.getId()+"'";
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
	 public static List<Thucan> find(Thucan nt) {
	        List<Thucan> FoodList1 = new ArrayList<>();
	        String query = "SELECT * FROM thucan WHERE name=?";
	        try (Connection c = getConnection();
	             PreparedStatement pstmt = c.prepareStatement(query)) {
	        	 

	            pstmt.setString(1, nt.getTenmon());
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	              Thucan t = new Thucan(rs.getInt("id"), rs.getString("name"),
	                        rs.getFloat("total"));
	                FoodList1.add(t);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return FoodList1;
	    }

	 //nước 
	 //****@@@@
	 
	 public static List<Nuoc>findnuoc(){
			List<Nuoc>nuocList=new ArrayList<>();
			try {
				
				Connection c =getConnection();
				Statement stmt =c.createStatement();
				 String query = "SELECT * FROM nuoc";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next()) {
					Nuoc t=new Nuoc(rs.getInt("id"), rs.getString("name"), rs.getFloat("total"));
					nuocList.add(t);
//					System.out.println("nuoc");
				
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return nuocList;
	 }
	 
	 
	 public static void insert1(Nuoc t) {
		    String query = "INSERT INTO `nuoc`( `id` ,`name`, `total`) VALUES (?, ?,?)";
		    try {
		        Connection c = getConnection();
		        PreparedStatement pstmt = c.prepareStatement(query);
		        pstmt.setInt(1, t.getId());
		        pstmt.setString(2, t.getName());
		        pstmt.setFloat(3, t.getTotal());
		        pstmt.execute();
		        
		    } catch (Exception e) {
		        e.printStackTrace(); // Xử lý ngoại lệ một cách thích hợp, có thể là ghi log hoặc ném ngoại lệ
		    }
		}
	 public static void delete1(Nuoc t) {
			String query="delete from nuoc where id ='"+t.getId()+"'";
			try {
				Connection c=getConnection();
				PreparedStatement pstmt=c.prepareStatement(query);
			pstmt.executeUpdate();
			
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	 public static List<Nuoc> find1(Nuoc n) {
	        List<Nuoc> nuoclist1 = new ArrayList<>();
	        String query = "SELECT * FROM nuoc WHERE name=?";
	        try (Connection c = getConnection();
	             PreparedStatement pstmt = c.prepareStatement(query)) {
	        	 

	            pstmt.setString(1, n.getName());
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	              Nuoc nc = new Nuoc(rs.getInt("id"), rs.getString("name"), rs.getFloat("total"));
	               nuoclist1.add(nc);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return nuoclist1;
	    }

//	 public static float tongthu() {
//		 float	tongthu=0;
//		 try (Connection c = getConnection()) {
//	            String query = "SELECT SUM(total) AS tongthu FROM thu";
//	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
//	                try (ResultSet rs = pstmt.executeQuery()) {
//	                    if (rs.next()) {
//	                        tongthu = rs.getFloat("tongthu");
//	                    }
//	                }
//	            }
//	        } catch (SQLException ex) {
//	            ex.printStackTrace();
//	        
//	        }
//	        return tongthu;
//	    }
//	


}
