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
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 437);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tài khoản");
		lblNewLabel.setBackground(new Color(0, 255, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(410, 218, 107, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMtKhu.setBounds(410, 282, 107, 32);
		contentPane.add(lblMtKhu);
		
		taikhoan = new JTextField();
		taikhoan.setBounds(549, 221, 130, 32);
		contentPane.add(taikhoan);
		
		taikhoan.setColumns(10);
		
		JButton login = new JButton("Đăng nhập");
		login.setBounds(610, 350, 114, 46);
		login.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Connection c = Ketnoithu.getConnection();
		            String name = taikhoan.getText();
		            String mk = matkhau.getText();

		            // Use PreparedStatement to avoid SQL injection
		            String sql = "SELECT * FROM login WHERE name = ? AND pass = ?";
		            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
		                pstmt.setString(1, name);
		                pstmt.setString(2, mk);

		                ResultSet rs = pstmt.executeQuery();

		                if (rs.next()) {
		                    dispose();
		                    JFrame Trangchu = new Trangchu();
		                    Trangchu.setVisible(true);
		                    Trangchu.setLocationRelativeTo(null);
		                    System.out.println("kk");
		                } else {
		                    JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
		                }
		            }

		        } catch (Exception e2) {
		            e2.printStackTrace();
		        }
		    }
		});

		contentPane.add(login);
		
		JLabel lblNewLabel_1 = new JLabel("Phần mềm quản lí bán hàng ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(243, 0, 381, 82);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\1936907_eco_environment_green_leaves_nature_icon.png"));
		lblNewLabel_2.setBounds(0, 0, 277, 285);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\4171319_baked_cake_cup_day_love_icon.png"));
		lblNewLabel_3.setBounds(0, 288, 163, 108);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\BT\\Downloads\\6030234_beverage_boba_drink_milk tea_pearl_icon.png"));
		lblNewLabel_4.setBounds(549, 0, 130, 114);
		contentPane.add(lblNewLabel_4);
		
		matkhau = new JPasswordField();
		matkhau.setBounds(549, 282, 130, 32);
		contentPane.add(matkhau);
		
		JButton dangki = new JButton("Đăng kí");
		dangki.setBounds(453, 325, 87, 17);
		contentPane.add(dangki);
	}
}
