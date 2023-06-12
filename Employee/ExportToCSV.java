package Employee;

import javax.swing.*;
import java.io.FileWriter;
import java.sql.*;

public class ExportToCSV {
    ExportToCSV() {
        String filename ="C:\\Users\\Sid\\IdeaProjects\\Employee Management\\Employee_Records.csv";
        try {
            FileWriter fw = new FileWriter(filename);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/siddhantpatel", "root", "Siddhant01*");
            String query = "select * from employee";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            for (int i = 1; i <= columnsNumber; i++)
            {
                fw.append(rsmd.getColumnName(i));
                fw.append(',');
            }
            fw.append("\n");
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append(',');
                fw.append(rs.getString(5));
                fw.append(',');
                fw.append(rs.getString(6));
                fw.append(',');
                fw.append(rs.getString(7));
                fw.append(',');
                fw.append(rs.getString(8));
                fw.append(',');
                fw.append(rs.getString(9));
                fw.append(',');
                fw.append(rs.getString(10));
                fw.append(',');
                fw.append(rs.getString(11));
                fw.append('\n');
            }
            fw.flush();
            fw.close();
            conn.close();
            JOptionPane.showMessageDialog(null,"CSV File is created successfully!");
            System.out.println("CSV File is created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){ new ExportToCSV();
    }
}