package quanlithu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ketnoidatban {
	public int id;
	public String tenban;
	public String tinhtrang;
	public String vitri;
	public Ketnoidatban(int id, String tenban, String tinhtrang,String vitri) {
		this.id = id;
		this.tenban = tenban;
		this.tinhtrang = tinhtrang;
		this.vitri=vitri;
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
	public static List<Datban>findAll(){
	List<Datban>DatbanList=new ArrayList<>();
	try {
		
		Connection c =getConnection();
		Statement stmt =c.createStatement();
		 String query = "SELECT * FROM datban";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
		Datban nt=new Datban(rs.getInt("id"), rs.getString("tenban"), rs.getString("tinhtrang"),rs.getString("vitri"));
			DatbanList.add(nt);
			System.out.println("fas");
		
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return DatbanList;
}
	public static void insert(Datban nt) {
	    String query = "INSERT INTO `datban`(`tenban`, `tinhtrang`,`vitri`) VALUES (?, ?, ?)";
	    try {
	        Connection c = getConnection();
	        PreparedStatement pstmt = c.prepareStatement(query);
	        pstmt.setString(1, nt.getTenban());
	        pstmt.setString(2, nt.getTinhtrang());
	        pstmt.setString(3, nt.getVitri());
	        pstmt.execute();
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // Xử lý ngoại lệ một cách thích hợp, có thể là ghi log hoặc ném ngoại lệ
	    }
	}

	public static void delete(Datban nt) {
		String query="delete from datban where id ='"+nt.getId()+"'";
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
	 public static List<Datban> find(Datban t) {
	        List<Datban> datbanL = new ArrayList<>();
	        String query = "SELECT * FROM datban WHERE name=?";
	        try (Connection c = getConnection();
	             PreparedStatement pstmt = c.prepareStatement(query)) {
	        	 

	            pstmt.setString(1, t.getTenban());
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                Datban nt = new Datban(rs.getInt("id"), rs.getString("tenban"),rs.getString("tinhtrang"),rs.getString("vitri"));
	                datbanL.add(nt);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return datbanL;
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
	

		    public static void updateStatusToDaCoKhach(int banId) {
		        try (Connection c = getConnection()) {
		            String query = "UPDATE datban SET tinhtrang = 'Đã có khách' WHERE id = ?";
		            try (PreparedStatement pstmt = c.prepareStatement(query)) {
		                pstmt.setInt(1, banId);
		                pstmt.executeUpdate();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		
	
	

}
