package quanlithu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;

public class Themthucan extends JFrame {

	private static final long serialVersionUID = 1L;
	private List<Thucan> list =new ArrayList<>();
	private JPanel contentPane;
	private JTextField txtmon;
	private JTextField txtgia;
	private int id;
	private String tenmon;
	public float giatien;
	private int id1;
	private String name;
	private float total;
	private JTextField txtid;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Themthucan frame = new Themthucan();
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
	public Themthucan() {
		
		JLabel anh = new JLabel("New label");
		getContentPane().add(anh, BorderLayout.WEST);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ten = new JLabel("Tên món ăn");
		ten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ten.setBounds(10, 85, 111, 43);
		contentPane.add(ten);
		
		JLabel gia = new JLabel("Giá tiền");
		gia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gia.setBounds(10, 139, 111, 43);
		contentPane.add(gia);
		
		txtmon = new JTextField();
		txtmon.setBounds(157, 88, 180, 43);
		contentPane.add(txtmon);
		txtmon.setColumns(10);
		
		txtgia = new JTextField();
		txtgia.setColumns(10);
		txtgia.setBounds(157, 142, 180, 43);
		contentPane.add(txtgia);
		
		JComboBox chon = new JComboBox();
		chon.addItem("Đồ ăn");
		chon.addItem("Nước uống");
		chon.setBounds(157, 204, 180, 35);
		contentPane.add(chon);
		
		JButton them = new JButton("Xác nhận");
		
			  them.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                String selectedOption = (String) chon.getSelectedItem();

		               try {
		            	   if ("Đồ ăn".equals(selectedOption)) {
			                	Thucan nt=new Thucan(id, tenmon, giatien);
			                	nt.setId(Integer.parseInt(txtid.getText()));
			                	nt.setTenmon(txtmon.getText());
			                	nt.setGiatien(Float.parseFloat(txtgia.getText()));
			                	Ketnoithucan.insert(nt);
			                	 JOptionPane.showMessageDialog(null, "Đã thêm thành công");
			                	
			    			
			                } else if ("Nước uống".equals(selectedOption)) {
			                	Nuoc t=new Nuoc(id1, name, total);
			                	t.setId(Integer.parseInt(txtid.getText()));
			                	t.setName(txtmon.getText());
			                	t.setTotal(Float.parseFloat(txtgia.getText()));
			                	Ketnoithucan.insert1(t);
			                	 JOptionPane.showMessageDialog(null, "Đã thêm thành công");
			                	
			                }
			               
			                

			            
		               }
						
					catch (Exception e2) {
					
						
					}
		            }
		        });
		them.setFont(new Font("Tahoma", Font.PLAIN, 17));
		them.setBounds(299, 268, 119, 51);
		contentPane.add(them);
//		JLabel ima = new JLabel("New label");
//		ima.setBounds(329, 25, 46, 14);
//		contentPane.add(ima);
		
	
		
		JLabel lblLoi = new JLabel("Loại đồ");
		lblLoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoi.setBounds(10, 204, 111, 43);
		contentPane.add(lblLoi);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(157, 21, 180, 43);
		contentPane.add(txtid);
		
		JLabel id32 = new JLabel("ID");
		id32.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id32.setBounds(10, 21, 111, 43);
		contentPane.add(id32);
//		
//		JButton anh1 = new JButton("Thêm Ảnh ");
//		anh1.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		anh1.setBounds(20, 258, 119, 35);
//		contentPane.add(anh1);
//		
//		anh1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//           JFileChooser fileChooser=new JFileChooser();
//           fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//           int returnValue=fileChooser.showOpenDialog(this);
//           
//           if(returnValue==JFileChooser.APPROVE_OPTION) {
//        	   File file=fileChooser.getSelectedFile();
//        	   String pathFile=file.getAbsolutePath();
//        	   BufferedImage b;
//        	   try {
//				b=ImageIO.read(file);
//				ima.setIcon(new ImageIcon(b));
//						
//						} 
//        	   catch (Exception e2) {
//				// TODO: handle exception
//			}
//           }
//           
//
//            }
//        });
//	
		
		
	}
}
