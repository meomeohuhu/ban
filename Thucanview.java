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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Thucanview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;
	private int id;
	private String tenmon;
	private float giatien;
	private int id1;
	private int id2;
	private String name;
	private float total;
	private String tenmon2;
	private int soluong;
	private float total1;
	private String tenban;
	private String vitri;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thucanview frame = new Thucanview();
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
	public Thucanview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đặt thực đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(224, 0, 374, 61);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(272, 72, 270, 293);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Id", "T\u00EAn m\u00F3n \u0103n", "Gi\u00E1 ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(1).setPreferredWidth(101);
		scrollPane.setViewportView(table);
		
		JButton all = new JButton("Tất cả");
		all.setFont(new Font("Tahoma", Font.PLAIN, 17));
		all.setBounds(10, 74, 127, 61);
		contentPane.add(all);
		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thucan nt=new Thucan(id, tenmon, giatien);
				Nuoc t=new Nuoc(id1, name, total);
				shownuoc(Ketnoithucan.findnuoc());
				showData(Ketnoithucan.findAll());
				
			}
		});
		
		JButton hoadon = new JButton("Hóa đơn");
		hoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Bill=new Billview();
				Bill.setVisible(true);
				Bill.setLocationRelativeTo(null);
				 Bill.setDefaultCloseOperation(Trangchu.DISPOSE_ON_CLOSE); 
				
			}
		});
		hoadon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hoadon.setBounds(437, 397, 109, 61);
		contentPane.add(hoadon);
		
		JButton findmon = new JButton("");
		findmon.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\211817_search_strong_icon.png"));
		findmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Timthucan=new Timthucan();
				Timthucan.setVisible(true);
				Timthucan.setLocationRelativeTo(null);
				 Timthucan.setDefaultCloseOperation(Trangchu.DISPOSE_ON_CLOSE);  
				
			}
		});
		findmon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		findmon.setBounds(159, 74, 61, 38);
		contentPane.add(findmon);
		
		
		///nước
		
		
		
		
		
		JRadioButton nuoc = new JRadioButton("Nước");
		nuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nuoc.setBounds(10, 172, 127, 23);
		contentPane.add(nuoc);
		nuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nuoc nt=new Nuoc(id1, name, total);
				shownuoc(Ketnoithucan.findnuoc());
			}
		});
		JFrame frame2 = new JFrame("Label Frame");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		
		
		
		////
		
		JRadioButton f = new JRadioButton("Đồ ăn");
		f.setFont(new Font("Tahoma", Font.PLAIN, 15));
		f.setBounds(6, 230, 109, 23);
		contentPane.add(f);
		
		f.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thucan nt=new Thucan(id, tenmon, giatien);
				showData(Ketnoithucan.findAll());
			}
		});
	
	
//		showData(Ketnoithucan.findAll());
//		shownuoc(Ketnoithucan.findnuoc());
		
		
		
		JButton gio = new JButton("");
		gio.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\1814113_add_more_plus_icon.png"));
		gio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gio.setBounds(312, 399, 89, 59);
		contentPane.add(gio);
		
		
		// Đặt ActionListener của nút gio ở ngoài phương thức
		gio.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Bill nt = new Bill(id2, tenmon2, soluong,total1);
		        // Thêm vào bảng Ketnoibill
		        Ketnoibill.insert(nt);
		        // Hiển thị thông báo
		        JOptionPane.showMessageDialog(null, "Đã thêm vào");
		    }
		});

		// Trong phương thức valueChanged
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            int id23 = (int) table.getValueAt(selectedRow, 0);
		            String name = table.getValueAt(selectedRow, 1).toString();
		            float total = Float.parseFloat(table.getValueAt(selectedRow, 2).toString());
		            System.out.println(id23);
		            // Cập nhật các giá trị
		            id2 = id23;
		            tenmon2 = name;
		            total1=total;
		            soluong = 1;
		        }
		    }
		});

		
		
		
	}
	public static void showData(List<Thucan> FoodList) {
	    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	    // Xóa dữ liệu cũ trong bảng trước khi thêm dữ liệu mới
	    tableModel.setRowCount(0);

	    for (Thucan nt : FoodList) {
	        Object[] rowData = { nt.getId(), nt.getTenmon(), nt.getGiatien() };
	        tableModel.addRow(rowData);}
	        
	       
	    
	}
	public static void shownuoc(List<Nuoc> nuocList) {
	    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	    // Xóa dữ liệu cũ trong bảng trước khi thêm dữ liệu mới
	    tableModel.setRowCount(0);

	    for (Nuoc nt : nuocList) {
	        Object[] rowData = { nt.getId(), nt.getName(), nt.getTotal() };
	        tableModel.addRow(rowData);}
	 
	}
}

