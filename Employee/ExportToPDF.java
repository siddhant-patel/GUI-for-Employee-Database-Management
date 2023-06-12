package Employee;

import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;

public class ExportToPDF
{
    ExportToPDF(String s){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/siddhantpatel", "root", "Siddhant01*");
            Statement stmt = conn.createStatement();
            ResultSet query_set = stmt.executeQuery("select * from employee where emp_id = '"+s+"'");
            ResultSetMetaData rsmd = query_set.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            Document my_pdf_report = new Document();
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Employee'"+s+"' Record PDF.pdf"));
            my_pdf_report.open();
            PdfPTable my_report_table = new PdfPTable(11);
            PdfPCell table_cell;
            for (int i = 1; i <= columnsNumber; i++) {
                String name = rsmd.getColumnName(i);
                table_cell = new PdfPCell(new Phrase(name));
                my_report_table.addCell(table_cell);
            }

            while (query_set.next()) {
                System.out.println();
                String name = query_set.getString("name");
                table_cell = new PdfPCell(new Phrase(name));
                my_report_table.addCell(table_cell);

                String fname = query_set.getString("fname");
                table_cell = new PdfPCell(new Phrase(fname));
                my_report_table.addCell(table_cell);

                String age = query_set.getString("age");
                table_cell = new PdfPCell(new Phrase(age));
                my_report_table.addCell(table_cell);

                String dob = query_set.getString("dob");
                table_cell = new PdfPCell(new Phrase(dob));
                my_report_table.addCell(table_cell);

                String address = query_set.getString("address");
                table_cell = new PdfPCell(new Phrase(address));
                my_report_table.addCell(table_cell);

                String phone = query_set.getString("phone");
                table_cell = new PdfPCell(new Phrase(phone));
                my_report_table.addCell(table_cell);

                String email = query_set.getString("email");
                table_cell = new PdfPCell(new Phrase(email));
                my_report_table.addCell(table_cell);

                String education = query_set.getString("education");
                table_cell = new PdfPCell(new Phrase(education));
                my_report_table.addCell(table_cell);

                String post = query_set.getString("post");
                table_cell = new PdfPCell(new Phrase(post));
                my_report_table.addCell(table_cell);

                String aadhar = query_set.getString("aadhar");
                table_cell = new PdfPCell(new Phrase(aadhar));
                my_report_table.addCell(table_cell);

                String emp_id = query_set.getString("emp_id");
                table_cell = new PdfPCell(new Phrase(emp_id));
                my_report_table.addCell(table_cell);
            }
            /* Attach report table to PDF */
            my_pdf_report.add(my_report_table);
            my_pdf_report.close();

            /* Close all DB related objects */
            query_set.close();
            stmt.close();
            conn.close();
            JOptionPane.showMessageDialog(null,"PDF File is created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ExportToPDF(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/siddhantpatel", "root", "Siddhant01*");
            Statement stmt = conn.createStatement();
            ResultSet query_set = stmt.executeQuery("select * from employee;");
            ResultSetMetaData rsmd = query_set.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            Document my_pdf_report = new Document();
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Employee Records PDF.pdf"));
            my_pdf_report.open();
            PdfPTable my_report_table = new PdfPTable(11);
            PdfPCell table_cell;
            for (int i = 1; i <= columnsNumber; i++) {
                String name = rsmd.getColumnName(i);
                table_cell = new PdfPCell(new Phrase(name));
                my_report_table.addCell(table_cell);
            }

            while (query_set.next()) {
                System.out.println();
                String name = query_set.getString("name");
                table_cell = new PdfPCell(new Phrase(name));
                my_report_table.addCell(table_cell);

                String fname = query_set.getString("fname");
                table_cell = new PdfPCell(new Phrase(fname));
                my_report_table.addCell(table_cell);

                String age = query_set.getString("age");
                table_cell = new PdfPCell(new Phrase(age));
                my_report_table.addCell(table_cell);

                String dob = query_set.getString("dob");
                table_cell = new PdfPCell(new Phrase(dob));
                my_report_table.addCell(table_cell);

                String address = query_set.getString("address");
                table_cell = new PdfPCell(new Phrase(address));
                my_report_table.addCell(table_cell);

                String phone = query_set.getString("phone");
                table_cell = new PdfPCell(new Phrase(phone));
                my_report_table.addCell(table_cell);

                String email = query_set.getString("email");
                table_cell = new PdfPCell(new Phrase(email));
                my_report_table.addCell(table_cell);

                String education = query_set.getString("education");
                table_cell = new PdfPCell(new Phrase(education));
                my_report_table.addCell(table_cell);

                String post = query_set.getString("post");
                table_cell = new PdfPCell(new Phrase(post));
                my_report_table.addCell(table_cell);

                String aadhar = query_set.getString("aadhar");
                table_cell = new PdfPCell(new Phrase(aadhar));
                my_report_table.addCell(table_cell);

                String emp_id = query_set.getString("emp_id");
                table_cell = new PdfPCell(new Phrase(emp_id));
                my_report_table.addCell(table_cell);
            }
            /* Attach report table to PDF */
            my_pdf_report.add(my_report_table);
            my_pdf_report.close();

            /* Close all DB related objects */
            query_set.close();
            stmt.close();
            conn.close();
            JOptionPane.showMessageDialog(null,"PDF File is created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] arg) throws Exception { new ExportToPDF();
    }
}
