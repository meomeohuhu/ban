package quanlithu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Trangchu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTable table;

	

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                Trangchu frame = new Trangchu();
	                frame.setLocationRelativeTo(null);
	                frame.setVisible(true);
	            }
	        });
	    }
	


	/**
	 * Create the frame.
	 */
	public Trangchu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lí cửa hàng");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\5027823_calculator_coin_dollar_money_icon (1).png"));
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setBackground(new Color(0, 128, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(139, 11, 315, 57);
		contentPane.add(lblNewLabel);
		
		JButton datban = new JButton("Đặt bàn");
		datban.setBackground(new Color(255, 128, 64));
		datban.setFont(new Font("Tahoma", Font.PLAIN, 16));
		datban.setBounds(226, 398, 111, 57);
		contentPane.add(datban);
		datban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Datban=new Datbanview();
				Datban.setVisible(true);
				Datban.setLocationRelativeTo(null);
				 Datban.setDefaultCloseOperation(Trangchu.DISPOSE_ON_CLOSE);  
			}
		});
		JButton menu = new JButton("");
		menu.setBackground(new Color(255, 255, 255));
		menu.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\134216_menu_lines_hamburger_icon.png"));
		menu.setBounds(10, 0, 65, 38);
		contentPane.add(menu);
		
		JPanel menua = new JPanel();
		menua.setBounds(10, 40, 0, 437);
		contentPane.add(menua);
		menua.setLayout(null);
		menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int dai=172;
            	int rong=800;
            	for(int i=0;i<dai;i++) {
            		menua.setSize(i, rong);
            	}
            	
    
               
            }
        });
		JButton x = new JButton("");
		x.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\1564505_close_delete_exit_remove_icon.png"));
		x.setBounds(141, 0, 31, 26);
		menua.add(x);
		x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int dai=190;
            	int rong=800;
            	for(int i=dai;i>0;i--) {
            		menua.setSize(i, rong);
            	}
            	
    
               
            }
        });
		
		//thongke
		
		JButton thongke = new JButton("Thống kê");
		thongke.setBounds(10, 37, 144, 41);
		menua.add(thongke);
		thongke.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\5027860_analytics_graph_laptop_statistics_icon.png"));
		thongke.setBackground(new Color(0, 128, 128));
		thongke.setFont(new Font("Tahoma", Font.PLAIN, 16));
		thongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Thongke=new Thongke();
				Thongke.setVisible(true);
				Thongke.setLocationRelativeTo(null);
				
				 Thongke.setDefaultCloseOperation(Trangchu.DISPOSE_ON_CLOSE);  
			}
		});
		
		
		
		//quanlithu
		JButton thu = new JButton("Quản lí thu");
		thu.setBounds(10, 110, 144, 41);
		menua.add(thu);
		thu.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\532625_cash_coins_hand_income_investment_icon (1).png"));
		thu.setBackground(new Color(0, 255, 255));
		thu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//quản lí chi
		JButton chi = new JButton("Quản lí chi");
		chi.setBounds(10, 179, 144, 41);
		menua.add(chi);
		chi.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\2250033_cash_fees_money_purse_shop_icon.png"));
		chi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi nút "Quản lí thu" được nhấn, tạo JFrame mới và đóng JFrame hiện tại
                JFrame Nguonchiview= new Nguonchiview();
                Nguonchiview.setVisible(true);
                Nguonchiview.setLocationRelativeTo(null);
                Nguonchiview.setDefaultCloseOperation(Trangchu.DISPOSE_ON_CLOSE);  
            }
        });
		chi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnThmMnn = new JButton("Thêm món ăn");
		btnThmMnn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThmMnn.setBounds(10, 252, 144, 41);
		btnThmMnn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi nút "Quản lí thu" được nhấn, tạo JFrame mới và đóng JFrame hiện tại
                JFrame Themthucan = new Themthucan();
                Themthucan.setVisible(true);
                Themthucan.setLocationRelativeTo(null);
                Themthucan.setDefaultCloseOperation(Trangchu.DISPOSE_ON_CLOSE);                // Đóng JFrame hiện tại
            }
        });
		
		
		menua.add(btnThmMnn);
		
		JButton btnThmBn = new JButton("Thêm bàn");
		btnThmBn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThmBn.setBounds(10, 329, 144, 41);
		btnThmBn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi nút "Quản lí thu" được nhấn, tạo JFrame mới và đóng JFrame hiện tại
                JFrame Themban = new Themban();
                Themban.setVisible(true);
                Themban.setLocationRelativeTo(null);
                Themban.setDefaultCloseOperation(Trangchu.DISPOSE_ON_CLOSE);  
            }
        });
		
		menua.add(btnThmBn);
		
		
		
			
			
			
			
			
			thu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi nút "Quản lí thu" được nhấn, tạo JFrame mới và đóng JFrame hiện tại
                JFrame Nguonthuview = new Nguonthuview();
                Nguonthuview.setVisible(true);
                Nguonthuview.setLocationRelativeTo(null);
                Nguonthuview.setDefaultCloseOperation(Trangchu.DISPOSE_ON_CLOSE);  
            }
        });
		
		
		
		JButton goimon = new JButton("Gọi món");
		goimon.setBackground(new Color(255, 128, 64));
		goimon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		goimon.setBounds(145, 329, 111, 57);
		contentPane.add(goimon);	
	    goimon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame goimon=new Thucanview();
				goimon.setVisible(true);
				goimon.setLocationRelativeTo(null);
				 goimon.setDefaultCloseOperation(Trangchu.DISPOSE_ON_CLOSE);  
			}
		});
	    
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(475, 110, 232, 350);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"T\u00EAn m\u00F3n", "Gi\u00E1 b\u00E1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Top doanh thu của quán");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\5243645_burn_fire_flame_hot_icon.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(405, 61, 329, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\115799_shop_icon (2).png"));
		lblNewLabel_2.setForeground(new Color(0, 0, 160));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBackground(new Color(0, 128, 64));
		lblNewLabel_2.setBounds(0, 303, 266, 174);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\3558120_corn_food_shop_street_vegetable_icon.png"));
		lblNewLabel_2_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2_1.setBackground(new Color(0, 128, 64));
		lblNewLabel_2_1.setBounds(339, 303, 266, 174);
		contentPane.add(lblNewLabel_2_1);
		
		showData(Ketnoithu.find());
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public void showData(List<Top> top) {
	    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	    // Xóa dữ liệu cũ trong bảng trước khi thêm dữ liệu mới
	    tableModel.setRowCount(0);

	    for (Top nt : top) {
	        Object[] rowData = { nt.getName1(), nt.getTotal1() };
	        tableModel.addRow(rowData);}
	        
	       
	    
	}
}
