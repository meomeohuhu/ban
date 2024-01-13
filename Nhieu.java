package quanlithu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Nhieu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nhieu frame = new Nhieu();
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
	public Nhieu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 55, 231, 314);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Ng\u00E0y b\u00E1n", "S\u1ED1 l\u01B0\u1EE3ng", "Doanh thu"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Ngày bán chạy");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(44, 11, 206, 44);
		contentPane.add(lblNewLabel);
		showData(Ketnoithu.find1());
	}
	public void showData(List<Sotop> datbanList) {
	    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	    // Xóa dữ liệu cũ trong bảng trước khi thêm dữ liệu mới
	    tableModel.setRowCount(0);

	    for (Sotop nt : datbanList) {
	        Object[] rowData = { nt.getNgay(),nt.getSoluong(),nt.getSoluong() };
	        tableModel.addRow(rowData);}
	        
	       
	    
	}


}
