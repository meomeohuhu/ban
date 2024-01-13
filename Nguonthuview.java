package quanlithu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Nguonthuview extends JFrame {
	
	DefaultTableModel Tablemodel;
	private List<Nguonthu> list =new ArrayList<>();
	private DefaultTableModel tblModel =new DefaultTableModel();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtthu;
	private JTextField txttotal;
	private  static JTable table;
	public Nguonthu nt;
	private JTextField txtngay;
	private int id;
	private String name;
	private float total;
	private String ngaythang;
	private JTextField txtid;
	private String tenban;
	private String vitri;
 
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) { 
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nguonthuview frame = new Nguonthuview();
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
	public Nguonthuview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 512);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tiện ích");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnNewMenu);
		
		
		//
		JMenuItem home = new JMenuItem("Trở về trang chủ");
		mnNewMenu.add(home);
		
		
		home.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       JFrame Trangchu =new Trangchu();
		       Trangchu.setVisible(true);
		       Trangchu.setLocationRelativeTo(null);
		       dispose();
		       
		    }
		});
		
		
	
		//tang
		
		
	
		
		JMenuItem tang = new JMenuItem("Sắp xếp tăng dần");
		tang.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu.add(tang);
		tang.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Connection c = Ketnoithu.getConnection();
		            String query = "SELECT * FROM thu ORDER BY total";
		            PreparedStatement stmt = c.prepareStatement(query);
		            ResultSet rs = stmt.executeQuery();
		            
		            // Xóa dữ liệu cũ trong bảng
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            model.setRowCount(0);

		            // Thêm dữ liệu từ ResultSet vào bảng
		            while (rs.next()) {
		                int id = rs.getInt("id");
		                String name = rs.getString("name");
		                float total = rs.getFloat("total");
		                String ngay = rs.getString("ngay");

		                Object[] rowData = { id, name, total, ngay };
		                model.addRow(rowData);
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		        }
		    }
		});
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);


		////
		
		JMenuItem giam = new JMenuItem("Sắp xếp giảm dần");
		mnNewMenu.add(giam);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		
		giam.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Connection c = Ketnoithu.getConnection();
		            String query = "SELECT * FROM thu ORDER BY total DESC";
		            PreparedStatement stmt = c.prepareStatement(query);
		            ResultSet rs = stmt.executeQuery();
		            
		            // Xóa dữ liệu cũ trong bảng
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            model.setRowCount(0);

		            // Thêm dữ liệu từ ResultSet vào bảng
		            while (rs.next()) {
		                int id = rs.getInt("id");
		                String name = rs.getString("name");
		                float total = rs.getFloat("total");
		                String ngay = rs.getString("ngay");

		                Object[] rowData = { id, name, total, ngay };
		                model.addRow(rowData);
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		        }
		    }
		});
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		JMenuItem tong1 = new JMenuItem("Tổng thu của bạn");
		mnNewMenu.add(tong1);
		tong1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	             //tính tổng thu
	                float tongThu = Ketnoithu.tongthu();
	                JOptionPane.showMessageDialog(null, "Tổng Thu: " + tongThu, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	            }
	        });
		
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lí nguồn thu");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\532625_cash_coins_hand_income_investment_icon (1).png"));
		lblNewLabel.setBounds(246, 0, 339, 63);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nguồn thu");
		lblNewLabel_1.setBounds(10, 89, 120, 51);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng thu");
		lblNewLabel_1_1.setBounds(10, 151, 120, 51);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_1);
		
		txtthu = new JTextField();
		txtthu.setBounds(180, 102, 114, 29);
		contentPane.add(txtthu);
		txtthu.setColumns(10);
		
		txttotal = new JTextField();
		txttotal.setBounds(180, 164, 114, 29);
		txttotal.setColumns(10);
		contentPane.add(txttotal);
		
		JButton txtdelete = new JButton("Xóa");
		txtdelete.setBounds(381, 351, 104, 43);
		txtdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nguonthu nt=new Nguonthu(WIDTH, name, total, ngaythang);
				nt.setId(Integer.parseInt(txtid.getText()));
				nt.setName(txtthu.getText());
				nt.setNgaythang(txtngay.getText());
				Ketnoithu.delete(nt);
				showData(Ketnoithu.findAll());
			}
			
		});
		contentPane.add(txtdelete);
		//thêm dữ liệu vào sql sever
		
		
		JButton txtthem = new JButton("Thêm");
		txtthem.setBounds(26, 345, 104, 43);
		txtthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nt=new Nguonthu(WIDTH, name, total, ngaythang);
				nt.setName(txtthu.getText());
				nt.setTotal(Float.parseFloat(txttotal.getText()));
				nt.setNgaythang(txtngay.getText());
			       Ketnoithu.insert(nt); 
			       JOptionPane.showMessageDialog(null, "Đã thêm thành công");
			       showData(Ketnoithu.findAll());
			}
			
		});
		contentPane.add(txtthem);
		
		JButton txtupdate = new JButton("Update");
		txtupdate.setBounds(153, 345, 104, 43);
		txtupdate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Connection c = Ketnoithu.getConnection();
		            int row = table.getSelectedRow();
		            
		            if (row == -1) {
		                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để cập nhật.");
		                return;
		            }

		            int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
		            String query = "UPDATE thu SET name=?, total=?,tenban=?,vitri=?, ngay=? WHERE id=?";
		            PreparedStatement pstmt = c.prepareStatement(query);

		            pstmt.setString(1, txtthu.getText());
		            pstmt.setFloat(2, Float.parseFloat(txttotal.getText()));  
		            pstmt.setString(3, txtngay.getText());
		        
		            
		            pstmt.setInt(4, id);

		            pstmt.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Update thành công!");
		        } catch (Exception e2) {
		            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật dữ liệu: " + e2.getMessage());
		        }
		        showData(Ketnoithu.findAll());
		    }
		});
		contentPane.add(txtupdate);
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setBounds(507, 351, 104, 43);
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nt=new Nguonthu(WIDTH, name, total, ngaythang);
				nt.setName(txtthu.getText());
				showData(Ketnoithu.find(nt));
			
			}
		});
		contentPane.add(btnTmKim);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setBounds(267, 345, 91, 43);
		//làm mới 
		btnLmMi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txtthu.setText("");
				txttotal.setText("");
				
				
			}
		});
		contentPane.add(btnLmMi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(359, 54, 531, 286);
		contentPane.add(scrollPane);
		
		
		
		table = 
				
				
				
				
				new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "T\u00EAn ngu\u1ED3n thu", "T\u1ED5ng thu", "Ng\u00E0y th\u00E1ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(39);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(table);
			
			txtngay = new JTextField();
			txtngay.setBounds(180, 217, 114, 29);
			contentPane.add(txtngay);
			txtngay.setColumns(10);
			
			txtid = new JTextField();
			txtid.setBounds(180, 54, 114, 29);
			contentPane.add(txtid);
			txtid.setColumns(10);
			
			JLabel lblNewLabel_1_2 = new JLabel("ID");
			lblNewLabel_1_2.setBounds(10, 40, 120, 51);
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPane.add(lblNewLabel_1_2);
			
			JLabel ngaythu_2 = new JLabel("Ngày thu");
			ngaythu_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
			ngaythu_2.setBounds(10, 213, 120, 31);
			contentPane.add(ngaythu_2);
		showData(Ketnoithu.findAll());
		//hiện giá trị jtable lên text
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		           
		            int id = (int) table.getValueAt(selectedRow, 0);
		            String name = table.getValueAt(selectedRow, 1).toString();
		            float total = Float.parseFloat(table.getValueAt(selectedRow, 2).toString());
		            String ngay = table.getValueAt(selectedRow, 3).toString();
		            
		           //gọi các giá trị vào text
		            txtid.setText(String.valueOf(id));
		            txtthu.setText(name);
		            txttotal.setText(String.valueOf(total));
		        
		            txtngay.setText(ngay);
		            
		        }
		    }
		});
	}
	
	public void showData(List<Nguonthu> nguonthuList) {
	    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	    // Xóa dữ liệu cũ trong bảng trước khi thêm dữ liệu mới
	    tableModel.setRowCount(0);

	    for (Nguonthu nt : nguonthuList) {
	        Object[] rowData = { nt.getId(), nt.getName(), nt.getTotal(),nt.getNgaythang()};
	        tableModel.addRow(rowData);}
	        
	       
	    
	}
}
	

