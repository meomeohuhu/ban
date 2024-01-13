package quanlithu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class dangki extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField taikhoan;
	private JPasswordField matkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangki frame = new dangki();
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
	public dangki() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 30, 103, 42);
		contentPane.add(lblNewLabel);
		
		taikhoan = new JTextField();
		taikhoan.setBounds(139, 30, 115, 42);
		contentPane.add(taikhoan);
		taikhoan.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMtKhu.setBounds(0, 103, 103, 42);
		contentPane.add(lblMtKhu);
		
		matkhau = new JPasswordField();
		matkhau.setBounds(139, 103, 115, 42);
		contentPane.add(matkhau);
		
		JButton btnNewButton = new JButton("Đăng kí");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(223, 156, 103, 42);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Connection c = Ketnoithu.getConnection();
		            String name = taikhoan.getText();
		            String mk = matkhau.getText();

		            // Sử dụng PreparedStatement để tránh SQL injection
		            String sql = "INSERT INTO login (name, pass) VALUES (?, ?)";
		            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
		                pstmt.setString(1, name);
		                pstmt.setString(2, mk);

		                // Sử dụng executeUpdate() cho câu lệnh INSERT
		                int rowsAffected = pstmt.executeUpdate();

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(null, "Bạn đã đăng ký thành công");
		                    JFrame Login = new Login();
		                    Login.setVisible(true);
		                    dispose();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Lỗi! Hãy đăng ký lại");
		                }
		            }

		        } catch (Exception e2) {
		            e2.printStackTrace();
		        }
		    }
		});

		contentPane.add(btnNewButton);
	}
}
