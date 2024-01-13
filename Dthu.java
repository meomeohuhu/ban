package quanlithu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class Dthu extends JFrame {

    private DefaultTableModel model;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Dthu frame = new Dthu();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Dthu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 248, 326);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 222, 276);
        contentPane.add(scrollPane);

        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Tháng", "Doanh thu"}
        );

        table = new JTable(model);
        scrollPane.setViewportView(table);

        updateTableData();
    }

    private void updateTableData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banhangmysql", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MONTH(ngay) AS Thang, SUM(total) AS TongDoanhThu FROM thu GROUP BY MONTH(ngay)");

            // Xóa dữ liệu cũ
            model.setRowCount(0);

            // Thêm dữ liệu mới từ ResultSet
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("Thang"));
                row.add(resultSet.getFloat("TongDoanhThu"));
                model.addRow(row);
            }

            // Đóng kết nối
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

