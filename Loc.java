package quanlithu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Loc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loc frame = new Loc();
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
	public Loc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Tuần");
		btnNewButton.setBounds(110, 11, 89, 37);
		contentPane.add(btnNewButton);
		
		JButton btnThng = new JButton("Tháng");
		btnThng.setBounds(209, 11, 89, 37);
		contentPane.add(btnThng);
		
		JButton btnHmNay = new JButton("Hôm nay");
		btnHmNay.setBounds(11, 11, 89, 37);
		contentPane.add(btnHmNay);
		
		textField = new JTextField();
		textField.setBounds(128, 74, 156, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 133, 156, 37);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Xác nhận");
		btnNewButton_1.setBounds(272, 203, 97, 47);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Bắt đầu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 74, 90, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblKtThc = new JLabel("Kết thúc");
		lblKtThc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKtThc.setBounds(11, 137, 90, 25);
		contentPane.add(lblKtThc);
	}

}
