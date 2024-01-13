package quanlithu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class Nguonchiview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtchi;
	private JTextField txttotal;
	private JTable table;
	private Nguonchi nt;
	private JTextField txtngay;
	private JTextField txtid;
	private int id;
	private String name;
	private float total;
	private String ngaythang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nguonchiview frame = new Nguonchiview();
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
	public Nguonchiview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 512);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tiện ích");
		menuBar.add(mnNewMenu);
		
		JMenuItem tang = new JMenuItem("Sắp xếp tăng dần");
		
		
		
		tang.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Connection c = Ketnoichi.getConnection();
		            String query = "SELECT * FROM chi ORDER BY total ";
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
		
		///home
		
		
		
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
		
		mnNewMenu.add(tang);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		
		///giam
		
		
		JMenuItem giam = new JMenuItem("Sắp xếp giảm dần");
		mnNewMenu.add(giam);
		giam.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Connection c = Ketnoichi.getConnection();
		            String query = "SELECT * FROM chi ORDER BY total DESC";
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
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		JMenuItem tong = new JMenuItem("Tổng chi của bạn");
		mnNewMenu.add(tong); 
		tong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	             //tính tổng chi
	                float tongChi = Ketnoichi.tongchi();
	                JOptionPane.showMessageDialog(null, "Tổng chi của bạn là: " + tongChi, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	            }
	        });
		
		
		
		
		
		///
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loại Chi");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(27, 110, 97, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblTngChi = new JLabel("Tổng chi");
		lblTngChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTngChi.setBounds(27, 168, 97, 47);
		contentPane.add(lblTngChi);
		
		txtchi = new JTextField();
		txtchi.setBounds(157, 124, 121, 24);
		contentPane.add(txtchi);
		txtchi.setColumns(10);
		
		txttotal = new JTextField();
		txttotal.setBounds(157, 176, 121, 24);
		contentPane.add(txttotal);
		txttotal.setColumns(10);
		
		JButton txtxoa = new JButton("Xóa");
		txtxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nt=new Nguonchi(WIDTH, name, total, ngaythang);
				nt.setName(txtchi.getText());
				nt.setId(Integer.parseInt(txtid.getText()));
				nt.setNgaythang1(txtngay.getText());
				Ketnoichi.delete(nt);
				showData(Ketnoichi.findAll());
			}
			
		});
		txtxoa.setBounds(27, 369, 97, 47);
		contentPane.add(txtxoa);
		
		JButton txtthem = new JButton("Thêm");
		txtthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nt=new Nguonchi(WIDTH, name, total, ngaythang);
				nt.setName(txtchi.getText());
				nt.setTotal(Float.parseFloat(txttotal.getText()));
				nt.setNgaythang1(txtngay.getText());
			       Ketnoichi.insert(nt); 
			       JOptionPane.showMessageDialog(null, "Đã thêm thành công");
			       showData(Ketnoichi.findAll());
			}
			
		});
		txtthem.setBounds(27, 287, 97, 47);
		contentPane.add(txtthem);
		
		JButton txtfind = new JButton("Tìm kiếm");
		txtfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nt=new Nguonchi(WIDTH, name, total, ngaythang);		
				nt.setName(txtchi.getText());
				showData(Ketnoichi.find(nt));
			
			}
		});
		txtfind.setBounds(173, 369, 89, 47);
		contentPane.add(txtfind);
		
		JButton txtupdate = new JButton("Update");
		
		txtupdate.setBounds(173, 287, 89, 47);
		//table
				txtupdate.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        try {
				            Connection c = Ketnoichi.getConnection();
				            int row = table.getSelectedRow();
				            
				            if (row == -1) {
				                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để cập nhật.");
				                return;
				            }

				            int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				            String query = "UPDATE chi SET name=?, total=?, ngay=? WHERE id=?";
				            PreparedStatement pstmt = c.prepareStatement(query);

				            pstmt.setString(1, txtchi.getText());
				            pstmt.setFloat(2, Float.parseFloat(txttotal.getText()));
				            pstmt.setString(3, txtngay.getText());
				            pstmt.setInt(4, id);
				            pstmt.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Update thành công!");
				        } catch (Exception e2) {
				            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật dữ liệu: " + e2.getMessage());
				        }
				        showData(Ketnoichi.findAll());
				    }
				});
		contentPane.add(txtupdate);
		
		JButton txtlammoi = new JButton("Làm mới");
		txtlammoi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txtchi.setText("");
				txttotal.setText("");
				
				
			}
		});
		txtlammoi.setBounds(287, 369, 89, 47);
		contentPane.add(txtlammoi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(387, 255, 284, 0);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(327, 71, 381, 264);
		contentPane.add(scrollPane_1);
		
		//table
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "Lo\u1EA1i chi", "T\u1ED5ng chi", "Ng\u00E0y chi"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(84);
		table.getColumnModel().getColumn(3).setPreferredWidth(88);
		scrollPane_1.setViewportView(table);
		
		//hiện giá trị lên 
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
		            txtchi.setText(name);
		            txttotal.setText(String.valueOf(total));
		            txtngay.setText(ngay);
		        }
		    }
		});
		showData(Ketnoichi.findAll());
		
		JLabel lblNgyChi = new JLabel("Ngày chi");
		lblNgyChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgyChi.setBounds(27, 229, 97, 47);
		contentPane.add(lblNgyChi);
		
		txtngay = new JTextField();
		txtngay.setColumns(10);
		txtngay.setBounds(157, 240, 121, 24);
		contentPane.add(txtngay);
		
		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(27, 70, 72, 24);
		contentPane.add(lblNewLabel_2);
		
		txtid = new JTextField();
		txtid.setBounds(157, 73, 118, 24);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quản lí chi tiêu");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\2250033_cash_fees_money_purse_shop_icon.png"));
		lblNewLabel_1.setBackground(new Color(0, 255, 64));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(242, 11, 249, 47);
		contentPane.add(lblNewLabel_1);
		showData(Ketnoichi.findAll());
	}
	public void showData(List<Nguonchi> nguonchiList) {
	    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	    // Xóa dữ liệu cũ trong bảng trước khi thêm dữ liệu mới
	    tableModel.setRowCount(0);

	    for (Nguonchi nt : nguonchiList) {
	        Object[] rowData = { nt.getId(), nt.getName(), nt.getTotal(),nt.getNgaythang1() };
	        tableModel.addRow(rowData);}
	       
	       
	    
	}
}
