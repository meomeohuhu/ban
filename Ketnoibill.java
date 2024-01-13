package quanlithu;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ketnoibill {
	
	
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
	public static List<Bill>findAll(){
	List<Bill>billList=new ArrayList<>();
	try {
		
		Connection c =getConnection();
		Statement stmt =c.createStatement();
		 String query = "SELECT * FROM bill";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			   int id = rs.getInt("id");
               String name = rs.getString("tenmon");
               int soluong=rs.getInt("soluong");
               float total1=rs.getFloat("total1");
            Bill nt=new Bill(id, name, soluong,total1);
		
			billList.add(nt);
			System.out.println("fas");
		
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return billList;
}
	public static void insert(Bill nt) {
	    String query = "INSERT INTO `bill`(`tenmon`,`soluong`,`total1`) VALUES (?, ?,?)";
	    try {
	        Connection c = getConnection();
	        PreparedStatement pstmt = c.prepareStatement(query);
	        pstmt.setString(1, nt.getTenmon2());
	        pstmt.setInt(2, nt.getSoluong());
	        pstmt.setFloat(3, nt.getTotal1());
	        
	        pstmt.execute();
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // Xử lý ngoại lệ một cách thích hợp, có thể là ghi log hoặc ném ngoại lệ
	    }
	}

	public static void delete(Bill nt) {
		String query="delete from bill where id ='"+nt.getId2()+"'";
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
	 public static List<Bill> find(Bill t) {
	        List<Bill> billL = new ArrayList<>();
	        String query = "SELECT * FROM bill WHERE name=?";
	        try (Connection c = getConnection();
	             PreparedStatement pstmt = c.prepareStatement(query)) {
	        	 

	            pstmt.setString(1, t.getTenmon2());
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                Bill nt = new Bill(rs.getInt("id"), rs.getString("tenmon"),
	                        rs.getInt("soluong"),rs.getFloat("total1"));
	                billL.add(nt);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return billL;
	    }
//	 public static float tongchi() {
//		 float	tongchi=0;
//		 try (Connection c = getConnection()) {
//	            String query = "SELECT SUM(total) AS tongchi FROM chi";
//	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
//	                try (ResultSet rs = pstmt.executeQuery()) {
//	                    if (rs.next()) {
//	                        tongchi = rs.getFloat("tongchi");
//	                    }
//	                }
//	            }
//	        } catch (SQLException ex) {
//	            ex.printStackTrace();
//	            // Xử lý ngoại lệ phù hợp, ví dụ: ghi log hoặc thông báo lỗi đến người dùng
//	        }
//	        return tongchi;
//	    }
//
	 public static void xoa() {
		    try {
		        Connection c = getConnection();
		        String query = "TRUNCATE TABLE bill";
		        PreparedStatement pstmt = c.prepareStatement(query);

		        // Thực thi câu lệnh SQL
		        pstmt.executeUpdate();

		        System.out.println("Dữ liệu đã được xóa khỏi bảng bill.");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}


	 public static float tongbill() {
		 float	tongbill=0;
		 try (Connection c = getConnection()) {
	            String query = "SELECT SUM(total1) AS total1 FROM bill";
	            try (PreparedStatement pstmt = c.prepareStatement(query)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        tongbill= rs.getFloat("total1");
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        
	        }
	        return tongbill;
	    }
	
	
}
