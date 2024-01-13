package quanlithu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Ketnoichi {
	
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
	public static List<Nguonchi>findAll(){
	List<Nguonchi>nguonchiList=new ArrayList<>();
	try {
		
		Connection c =getConnection();
		Statement stmt =c.createStatement();
		 String query = "SELECT * FROM chi";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			   int id = rs.getInt("id");
               String name = rs.getString("name");
               float total = rs.getFloat("total");
               String ngay=rs.getString("ngay");
            
			Nguonchi nt=new Nguonchi(id, name, total, ngay);
			nguonchiList.add(nt);
			System.out.println("fas");
		
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return nguonchiList;
}
	public static void insert(Nguonchi nt) {
	    String query = "INSERT INTO `chi`(`name`, `total`,`ngay`) VALUES (?, ?, ?)";
	    try {
	        Connection c = getConnection();
	        PreparedStatement pstmt = c.prepareStatement(query);
	        pstmt.setString(1, nt.getName());
	        pstmt.setFloat(2, nt.getTotal());
	        pstmt.setString(3,nt.getNgaythang1());
	        
	        pstmt.execute();
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // Xử lý ngoại lệ một cách thích hợp, có thể là ghi log hoặc ném ngoại lệ
	    }
	}

	public static void delete(Nguonchi nt) {
		String query="delete from chi where id ='"+nt.getId()+"'";
		try {
			Connection c=getConnection();
			PreparedStatement pstmt=c.prepareStatement(query);
		pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
//	public static void Update(Nguonchi nt) {
//			String query="Update thu set name=?,total=? where name='"+nt.getName()+"'";
//			try {
//				Connection c=getConnection();
//				PreparedStatement pstmt=c.prepareStatement(query);
//				pstmt.setString(1, nt.getName());
//				pstmt.setFloat(2, nt.getTotal());
//				pstmt.setString(3,nt.getNgay());
//				pstmt.executeUpdate();
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//	}
	 public static List<Nguonchi> find(Nguonchi t) {
	        List<Nguonchi> nguonchiL = new ArrayList<>();
	        String query = "SELECT * FROM chi WHERE name=?";
	        try (Connection c = getConnection();
	             PreparedStatement pstmt = c.prepareStatement(query)) {
	        	 

	            pstmt.setString(1, t.getName());
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                Nguonchi nt = new Nguonchi(rs.getInt("id"), rs.getString("name"),
	                        rs.getFloat("total"),rs.getString("ngay"));
	                nguonchiL.add(nt);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return nguonchiL;
	    }
	 public static float tongchi() {
		 float	tongchi=0;
		 try (Connection c = getConnection()) {
	            String query = "SELECT SUM(total) AS tongchi FROM chi";
	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        tongchi = rs.getFloat("tongchi");
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            // Xử lý ngoại lệ phù hợp, ví dụ: ghi log hoặc thông báo lỗi đến người dùng
	        }
	        return tongchi;
	    }
	
	
	
}
