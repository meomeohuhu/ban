package quanlithu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Timthucan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ten;
	private JTextField gia;
	private int  id;
	private String tenmon;
	private  Float giatien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timthucan frame = new Timthucan();
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
	public Timthucan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên món");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 32, 103, 32);
		contentPane.add(lblNewLabel);
		
		ten = new JTextField();
		ten.setBounds(169, 32, 103, 32);
		contentPane.add(ten);
		ten.setColumns(10);
		
		JLabel lblGiMnn = new JLabel("Giá món ăn");
		lblGiMnn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiMnn.setBounds(10, 111, 103, 32);
		contentPane.add(lblGiMnn);
		
		gia = new JTextField();
		gia.setColumns(10);
		gia.setBounds(169, 111, 103, 32);
		contentPane.add(gia);
		
		JButton Tìm = new JButton("Tìm kiếm");
		Tìm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Tìm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thucan nt=new Thucan(WIDTH, tenmon, giatien);
				nt.setTenmon(ten.getText());
				Thucanview.showData(Ketnoithucan.find(nt));
				dispose();
			
			}
		});
		Tìm.setBounds(212, 154, 109, 43);
		contentPane.add(Tìm);
	}

}
