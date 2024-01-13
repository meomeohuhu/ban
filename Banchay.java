package quanlithu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Banchay extends JFrame {

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
					Banchay frame = new Banchay();
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
	public Banchay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 267, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 58, 214, 309);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"T\u00EAn m\u00F3n \u0103n", "Gi\u00E1 b\u00E1n", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Top doanh thu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(17, 11, 207, 36);
		contentPane.add(lblNewLabel);
		showData(Ketnoithu.find());
	}
	public void showData(List<Top> top) {
	    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	    // Xóa dữ liệu cũ trong bảng trước khi thêm dữ liệu mới
	    tableModel.setRowCount(0);

	    for (Top nt : top) {
	        Object[] rowData = { nt.getName1(), nt.getTotal1(),nt.getSoluong() };
	        tableModel.addRow(rowData);}
	        
	       
	    
	}
}
