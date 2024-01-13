package quanlithu;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;


public class Billview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;
	private int id;
	private String name;
	private float total1;
	private float total12;
	private float total123;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billview frame = new Billview();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Billview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hóa đơn của bạn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(52, -1, 214, 52);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 43, 243, 281);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"T\u00EAn m\u00F3n", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel total = new JLabel("Tổng tiền của bạn là : "+String.valueOf(Ketnoibill.tongbill()));
		total.setFont(new Font("Tahoma", Font.PLAIN, 18));
		total.setBounds(0, 329, 266, 52);
		contentPane.add(total);
		
		JButton thanhtoan = new JButton("Thanh toán");
		thanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
			            // Kết nối tới cơ sở dữ liệu
			            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banhangmysql", "root", "");

			            // Câu lệnh SQL để chuyển dữ liệu từ bills sang nguonthu
			            String sqlTransfer = "INSERT INTO thu (name, total, ngay) SELECT tenmon, total1, CURDATE() FROM bill";
			            

			            // Tạo PreparedStatement và thực hiện câu lệnh SQL
			            try (PreparedStatement pstmt = connection.prepareStatement(sqlTransfer)) {
			                pstmt.executeUpdate();
			            }
			          Ketnoibill.xoa();

			          JOptionPane.showMessageDialog(null, "Bạn đã thanh toán thành công ");
			          dispose();
			        } catch (SQLException c) {
			            c.printStackTrace();
			            System.err.println("Lỗi khi thực hiện chuyển dữ liệu: " + c.getMessage());
			        }
				
				
				
				
				
				
				
				
			}
			
		});
		thanhtoan.setBounds(188, 392, 122, 52);
		contentPane.add(thanhtoan);
		
		JLabel ngayvagio = new JLabel("New label");
		ngayvagio.setBounds(10, 411, 132, 33);
		contentPane.add(ngayvagio);
		showData(Ketnoibill.findAll());
		
	}
	public static void showData(List<Bill> billList) {
	    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	    // Xóa dữ liệu cũ trong bảng trước khi thêm dữ liệu mới
	    tableModel.setRowCount(0);

	    for (Bill nt : billList) {
	        Object[] rowData = { nt.getTenmon2(), nt.getSoluong(),nt.getTotal1() };
	        tableModel.addRow(rowData);}
	        
	       
	    
	}

}
