package quanlithu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class Themban extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ten;
	private int id;
	private String tenban;
	private String tinhtrang;
	private String vitri;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Themban frame = new Themban();
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
	public Themban() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên bàn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(22, 11, 78, 41);
		contentPane.add(lblNewLabel);
		
		ten = new JTextField();
		ten.setBounds(147, 11, 114, 41);
		contentPane.add(ten);
		ten.setColumns(10);
		
		JComboBox tt = new JComboBox();
		tt.addItem("Đã có khách");
		tt.addItem("Đang trống");
		tt.setBounds(147, 86, 114, 34);
		contentPane.add(tt);
		
		JLabel lblVTr = new JLabel("Vị trí");
		lblVTr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVTr.setBounds(22, 147, 78, 41);
		contentPane.add(lblVTr);
		
		JLabel lblTnhTrng = new JLabel("Tình trạng");
		lblTnhTrng.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTnhTrng.setBounds(22, 86, 78, 41);
		contentPane.add(lblTnhTrng);
		
		JComboBox vi = new JComboBox();
		vi.addItem("Tầng trệt");
		vi.addItem("Tầng 1");
		vi.setBounds(147, 154, 114, 34);
		contentPane.add(vi);
		
		JButton them1 = new JButton("Xác nhận");
		them1.setBounds(294, 204, 107, 39);
		JButton them = new JButton("Xác nhận");
	

		them1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String selectedStatus = (String) tt.getSelectedItem();
		        String selectedLocation = (String) vi.getSelectedItem();
		        String tableName = ten.getText(); // Lưu ý: bạn phải đảm bảo có một JTextField với tên là "ten"

		        Datban nt = new Datban(id, tenban, tinhtrang, vitri);
		        nt.setTenban(tableName);

		        if ("Đã có khách".equals(selectedStatus) && ("Tầng trệt".equals(selectedLocation) || "Tầng 1".equals(selectedLocation))) {
		            // Xử lý khi tình trạng là "Đã có khách" và vị trí là "Tầng trệt" hoặc "Tầng 1"
		            nt.setTinhtrang(selectedStatus);
		            nt.setVitri(selectedLocation);
		            Ketnoidatban.insert(nt);
		        } else if ("Đã có khách".equals(selectedStatus) && "Đang trống".equals(selectedLocation)) {
		            // Xử lý khi tình trạng là "Đã có khách" và vị trí là "Đang trống"
		            nt.setTinhtrang(selectedStatus);
		            Ketnoidatban.insert(nt);
		        } else if ("Đang trống".equals(selectedStatus) && ("Tầng trệt".equals(selectedLocation) || "Tầng 1".equals(selectedLocation))) {
		            // Xử lý khi tình trạng là "Đang trống" và vị trí là "Tầng trệt" hoặc "Tầng 1"
		            nt.setTinhtrang(selectedStatus);
		            nt.setVitri(selectedLocation);
		            Ketnoidatban.insert(nt);
		        } else {
		            // Xử lý trường hợp không xác định
		            System.out.println("Tình trạng hoặc vị trí không hợp lệ");
		        }
		        dispose();
		      
		    }
		}
		
		);

		contentPane.add(them1);

	}
	
}
