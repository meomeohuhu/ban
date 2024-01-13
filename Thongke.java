package quanlithu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Thongke extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField batdau;
	private JTextField ketthuc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thongke frame = new Thongke();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Thongke() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 505);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu tienich = new JMenu("Tiện ích");
		menuBar.add(tienich);
		
		JMenuItem home = new JMenuItem("Trở về trang chủ");
		tienich.add(home);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		home.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       JFrame Trangchu =new Trangchu();
		       Trangchu.setVisible(true);
		       Trangchu.setLocationRelativeTo(null);
		       dispose();		       
		    }
		});
		
		///
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		table = new JTable();
		table.setBounds(204, 195, 1, 1);
		contentPane.add(table);
		
		JLabel soluong = new JLabel("Số sản phấm đã bán"+ String.valueOf(Ketnoithu.so0()));
		soluong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		soluong.setBounds(144, 171, 265, 54);
		contentPane.add(soluong);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 52, 184, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ngày bán chạy");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 46, 164, 57);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Nhieu=new Nhieu();
				Nhieu.setVisible(true);
				Nhieu.setLocationRelativeTo(null);
				Nhieu.setDefaultCloseOperation(Thongke.DISPOSE_ON_CLOSE);
			
			}
			
		});
		panel.add(btnNewButton);
		
		JButton btnBoCoHng = new JButton("Hàng bán chạy");
		btnBoCoHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Banchay=new Banchay();
				Banchay.setVisible(true);
				Banchay.setLocationRelativeTo(null);
				Banchay.setDefaultCloseOperation(Thongke.DISPOSE_ON_CLOSE);
			}
			
		});
		btnBoCoHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBoCoHng.setBounds(10, 139, 164, 57);
		panel.add(btnBoCoHng);
		
		JButton x = new JButton("");
		x.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\1564505_close_delete_exit_remove_icon (1).png"));
		x.setBackground(new Color(0, 255, 255));
		x.setBounds(139, 0, 45, 35);
		x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int dai=190;
            	int rong=800;
            	for(int i=dai;i>0;i--) {
            		panel.setSize(i, rong);
            	}
            	
    
               
            }
        });
		
		panel.add(x);
		
		JButton doanhthuthang = new JButton("Doanh thu tháng");
		doanhthuthang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		doanhthuthang.setBounds(10, 236, 164, 57);
		panel.add(doanhthuthang);
		doanhthuthang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JFrame Dthu=new Dthu();
            Dthu.setVisible(true);
            Dthu.setLocationRelativeTo(null);
            Dthu.setDefaultCloseOperation(Thongke.DISPOSE_ON_CLOSE);
    
               
            }
        });
		
	
		
		JButton menu = new JButton("");
		menu.setBackground(new Color(0, 0, 160));
		menu.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\134216_menu_lines_hamburger_icon.png"));
		menu.setBounds(0, 0, 54, 41);
		menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int dai=184;
            	int rong=800;
            	for(int i=0;i<dai;i++) {
            		panel.setSize(i, rong);
            	}
            	
    
               
            }
        });
		contentPane.add(menu);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 128, 64));
		panel1.setBounds(422, 52, 345, 250);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		
		
		
		batdau = new JTextField();
		batdau.setBounds(120, 83, 148, 31);
		panel1.add(batdau);
		batdau.setColumns(10);
		
		ketthuc = new JTextField();
		ketthuc.setColumns(10);
		ketthuc.setBounds(120, 144, 148, 31);
		panel1.add(ketthuc);
		
		JLabel lblNewLabel_1 = new JLabel("Bắt đầu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 83, 93, 31);
		panel1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kết thúc");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 144, 93, 31);
		panel1.add(lblNewLabel_1_1);
		
		
		
		JLabel lblDoanhThu = new JLabel("Doanh thu: " +String.valueOf(Ketnoithu.tongthu()));
		lblDoanhThu.setBounds(144, 62, 244, 54);
		contentPane.add(lblDoanhThu);
		lblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton today = new JButton("Hôm nay");
		today.setFont(new Font("Tahoma", Font.PLAIN, 15));
		today.setBounds(5, 11, 98, 38);
		today.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDoanhThu.setText("Doanh thu : "+ String.valueOf(Ketnoithu.tongthungay()));
				soluong.setText("Số sản phẩm đã bán : " +String.valueOf(Ketnoithu.so()));
			}
		});
		panel1.add(today);
		JButton tuan = new JButton("Tuần");
		tuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tuan.setBounds(113, 11, 98, 38);
		tuan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	lblDoanhThu.setText("Doanh thu : "+ String.valueOf(Ketnoithu.tongthutuan()));
            	soluong.setText("Số sản phẩm đã bán : " +String.valueOf(Ketnoithu.so1()));
            	
            
            	
            	
    
               
            }
        });
		panel1.add(tuan);

		JButton thang = new JButton("Tháng");
		thang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		thang.setBounds(221, 11, 98, 38);
		thang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	lblDoanhThu.setText("Doanh thu : "+ String.valueOf(Ketnoithu.tongthuthang()));
            
            	soluong.setText("Số sản phẩm đã bán : " +String.valueOf(Ketnoithu.so2()));
            	
    
               
            }
        });
		
		panel1.add(thang);
		JButton xacnhan = new JButton("Xác nhận");
		xacnhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		xacnhan.setBounds(221, 203, 98, 38);
		
		xacnhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	xacnhan.addActionListener(new ActionListener() {
            	    @Override
            	    public void actionPerformed(ActionEvent e) {
            	        try {
            	            Connection c = Ketnoithu.getConnection();
            	            String start = batdau.getText();
            	            String end = ketthuc.getText();

            	            // Sử dụng PreparedStatement để tránh SQL injection
            	            String query = "SELECT SUM(total) AS tongthu FROM thu WHERE ngay BETWEEN ? AND ?";
            	            String queryy="SELECT COUNT(*) AS id FROM thu WHERE ngay BETWEEN ? AND ?";
            	            try (PreparedStatement pstmt = c.prepareStatement(query) ) {
            	                pstmt.setString(1, start);
            	                pstmt.setString(2, end);

            	                float tongthu = 0;
            	                try (ResultSet rs = pstmt.executeQuery()) {
            	                    if (rs.next()) {
            	                        tongthu = rs.getFloat("tongthu");
            	                    }
            	                }
            	                

            	               
            	                lblDoanhThu.setText("Doanh thu : " + tongthu);
            	                
            	            }
            	            try (PreparedStatement pstmt = c.prepareStatement(queryy) ) {
            	                pstmt.setString(1, start);
            	                pstmt.setString(2, end);

            	                float tong = 0;
            	                try (ResultSet rs = pstmt.executeQuery()) {
            	                    if (rs.next()) {
            	                        tong = rs.getInt("id");
            	                    }
            	                }
            	                

            	                lblDoanhThu.setText("Doanh thu : " + tong);
            	                
            	            }
            	           
            	        } catch (Exception e2) {
            	            e2.printStackTrace();
            	        }
            	    }

            	});

            
            	
            	
    
               
            }
        });
		panel1.add(xacnhan);
		
		
//		JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBackground(new Color(0, 128, 128));
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
//		lblNewLabel_1.setText("Số dư của bạn");
//		lblNewLabel_1.setBounds(20, 188, 176, 58);
//		contentPane.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_1_1 = new JLabel();
//		lblNewLabel_1_1.setBackground(new Color(128, 255, 0));
//		lblNewLabel_1_1.setText("Tổng thu của bạn");
//		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
//		lblNewLabel_1_1.setBounds(20, 63, 176, 58);
//		contentPane.add(lblNewLabel_1_1);
//		
//		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBackground(new Color(0, 255, 0));
//		lblNewLabel_1_2.setText("Tổng chi tiêu");
//		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
//		lblNewLabel_1_2.setBounds(20, 119, 176, 58);
//		contentPane.add(lblNewLabel_1_2);
//		
//		JLabel chi = new JLabel(String.valueOf(Ketnoichi.tongchi()));
//		chi.setBackground(new Color(0, 255, 0));
//		chi.setFont(new Font("Tahoma", Font.PLAIN, 19));
//		chi.setBounds(232, 127, 119, 43);
//		contentPane.add(chi);
//		
//		JLabel thu = new JLabel(String.valueOf(Ketnoithu.tongthu()));
//		thu.setBackground(new Color(0, 255, 0));
//		thu.setFont(new Font("Tahoma", Font.PLAIN, 19));
//		thu.setBounds(232, 71, 119, 43);
//		contentPane.add(thu);
//		
//		JLabel thongke = new JLabel(String.valueOf(thongke()));
//		thongke.setFont(new Font("Tahoma", Font.PLAIN, 19));
//		thongke.setBounds(232, 196, 119, 43);
//		contentPane.add(thongke);
//		
//		JLabel lblNewLabel_1_3 = new JLabel();
//		lblNewLabel_1_3.setText("Tỉ lệ phần trăm");
//		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
//		lblNewLabel_1_3.setBounds(20, 257, 176, 58);
//		contentPane.add(lblNewLabel_1_3);
//		
//		JLabel phantram = new JLabel(String.valueOf(phantram()+"%"));
//		phantram.setFont(new Font("Tahoma", Font.PLAIN, 19));
//		phantram.setBounds(232, 265, 119, 43);
//		contentPane.add(phantram);
//		
//		JLabel lblNewLabel = new JLabel("Thống kê chi tiêu");
//		lblNewLabel.setBackground(new Color(0, 64, 128));
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
//		lblNewLabel.setBounds(112, 15, 250, 37);
//		contentPane.add(lblNewLabel);
//		System.out.println(thongke());
	}
public float thongke() {
	float thongke=0;
	thongke=Ketnoithu.tongthu()-Ketnoichi.tongchi();
	return thongke;
}
public float phantram() {
	float phantram=0;
	phantram=(Ketnoithu.tongthu()/Ketnoichi.tongchi())*100;
	
	return phantram;
}
}

