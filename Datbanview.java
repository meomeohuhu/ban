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
import java.awt.Frame;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class Datbanview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtten;
	private List<Thucan> list =new ArrayList<>();
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datbanview frame = new Datbanview();
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
	public Datbanview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 497);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tiện ích");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh sách bàn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(46, 4, 320, 44);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 19, 382, 348);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "T\u00EAn b\u00E0n", "T\u00ECnh tr\u1EA1ng", "V\u1ECB tr\u00ED"
			}
		));
		
	///
	
		scrollPane.setViewportView(table);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Tên bàn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(18, 143, 101, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tình trạng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(18, 218, 101, 44);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Vị trí");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(18, 297, 101, 44);
		contentPane.add(lblNewLabel_1_2);
		
		txtten = new JTextField();
		txtten.setBounds(164, 146, 115, 44);
		contentPane.add(txtten);
		txtten.setColumns(10);
		
		JComboBox tt = new JComboBox();
		tt.setBounds(164, 225, 115, 36);
		contentPane.add(tt);
		tt.addItem("Đã có khách");
		tt.addItem("Đang trống");
		
		JComboBox txtvitri = new JComboBox();
		txtvitri.setBounds(164, 307, 115, 30);
		contentPane.add(txtvitri);
		txtvitri.addItem("Tầng trệt");
		txtvitri.addItem("Tầng 1");
		
		JButton lammoi = new JButton("");
		lammoi.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\326679_refresh_reload_icon.png"));
		lammoi.setBounds(144, 361, 62, 53);
		contentPane.add(lammoi);
		
		JLabel lblNewLabel_1_3 = new JLabel("ID");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(18, 77, 101, 44);
		contentPane.add(lblNewLabel_1_3);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(164, 80, 115, 44);
		contentPane.add(txtid);
		
		JButton tim = new JButton("");
		tim.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\211817_search_strong_icon.png"));
		tim.setBounds(228, 361, 76, 53);
		contentPane.add(tim);
		
	
		
		lammoi.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       showData(Ketnoidatban.findAll());
		    }
		});
		
		
		
		
		lammoi.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       showData(Ketnoidatban.findAll());
		    }
		});
		
		
		final int[] selectedId = { -1 };
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		           
		            int id = (int) table.getValueAt(selectedRow, 0);
		            String name = table.getValueAt(selectedRow, 1).toString();
		            String trangthai = table.getValueAt(selectedRow, 2).toString();
		            String vitri = table.getValueAt(selectedRow, 3).toString();
		            
		          
		            
		            txtid.setText(String.valueOf(id));
		            txtten.setText(name);
		          tt.setSelectedItem(table.getModel().getValueAt(selectedRow, 2).toString());
		            txtvitri.setSelectedItem(table.getModel().getValueAt(selectedRow, 3).toString());
		         
		            
		        }
		    }
		});
		JButton datmon1 = new JButton("Đi tới đặt món");
		datmon1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       Frame Thucanview=new Thucanview();
		       Thucanview.setVisible(true);
		       Thucanview.setLocationRelativeTo(null);
		       dispose();
		       Ketnoidatban.updateStatusToDaCoKhach(selectedId[0]);
		       
		    }
		});
		datmon1.setBounds(588, 378, 115, 58);
		contentPane.add(datmon1);
	
		
		showData(Ketnoidatban.findAll());
		JMenuItem suaa = new JMenuItem("Sửa thông tin");
		mnNewMenu.add(suaa);
		suaa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Connection c = Ketnoidatban.getConnection();
		            int row = table.getSelectedRow();
		            
		            if (row == -1) {
		                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để cập nhật.");
		                return;
		            }
		            String vitrimoi = (String) txtvitri.getSelectedItem();
		            String tinhtrang = (String) tt.getSelectedItem();


		            int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
		            String query = "UPDATE datban SET tenban=?, tinhtrang=?, vitri=? WHERE id=?";
		            PreparedStatement pstmt = c.prepareStatement(query);

		            
		            pstmt.setString(1, txtten.getText());
		            pstmt.setString(2, tinhtrang);
		            pstmt.setString(3, vitrimoi);	            
		            pstmt.setInt(4, id);

		            pstmt.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Update thành công!");
		        } catch (Exception e2) {
		            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật dữ liệu: " + e2.getMessage());
		        }
		       showData(Ketnoidatban.findAll());
		    }
		});
	}
		
	
	public void showData(List<Datban> datbanList) {
	    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	    // Xóa dữ liệu cũ trong bảng trước khi thêm dữ liệu mới
	    tableModel.setRowCount(0);

	    for (Datban nt : datbanList) {
	        Object[] rowData = { nt.getId(), nt.getTenban(), nt.getTinhtrang(),nt.getVitri() };
	        tableModel.addRow(rowData);}
	        
	       
	    
	}
}
	


