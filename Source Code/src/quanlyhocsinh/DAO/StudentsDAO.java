/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocsinh.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import quanlyhocsinh.Students;
import quanlyhocsinh.StudentsManaForm;

/**
 *
 * @author Gokki
 */
public class StudentsDAO {

    private static String connectionStr;// = "jdbc:sqlserver://localhost:1433;databasename=QuanLyHocSinh;integratedSecurity=true;";
    private static String username;// = "sa";
    private static String pass; // = "1234";

    private static StudentsDAO instance;

    private static void setInstance(StudentsDAO instance) {
        StudentsDAO.instance = instance;
    }

    public static StudentsDAO getInstance() {
        if (StudentsDAO.instance == null) {
            instance = new StudentsDAO();
        }
        connectionStr = StudentsManaForm.connStr;
        username = StudentsManaForm.username;
        pass = StudentsManaForm.password;
        return instance;
    }

    public StudentsDAO() {
        connectionStr = StudentsManaForm.connStr;
        username = StudentsManaForm.username;
        pass = StudentsManaForm.password;
    }

    public boolean TestConnect() {
        boolean checkConnect = false;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
            return checkConnect;
        }
        try (Connection conn = DriverManager.getConnection(connectionStr,username,pass)) {
            if (conn != null) {
                checkConnect = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return checkConnect;
        }
    }

    public ArrayList<Students> getListStudents() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        JOptionPane.showMessageDialog(null, "class thanh cong");
        ResultSet data = null;
        ArrayList<Students> listStu = null;
        try (Connection conn = DriverManager.getConnection(connectionStr,username,pass)) {
//            JOptionPane.showMessageDialog(null, "connect thanh cong");
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM dbo.HocSinh");
            data = pst.executeQuery();

            Students temp = null;
            while (data.next()) {
                if (listStu == null) {
                    listStu = new ArrayList<>();
                }
                temp = new Students();
                temp.setMaHS(data.getInt("MaHS"));
                temp.setTenHS(data.getString("TenHS"));
                temp.setNgaySinh(data.getDate("NgaySinh"));
                temp.setGhichu(data.getString("Ghichu"));
                temp.setImage(data.getBytes("ExtInfo"));
                listStu.add(temp);
            }
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "connect khong thanh cong");
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            return listStu;
        }
    }

    public ArrayList<Students> getListStudentsByName(String name) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ResultSet data = null;
        ArrayList<Students> listStu = null;
        try (Connection conn = DriverManager.getConnection(connectionStr, username, pass)) {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM dbo.HocSinh WHERE TenHS =  N'" + name + "'");
            data = pst.executeQuery();

            Students temp = null;
            while (data.next()) {
                if (listStu == null) {
                    listStu = new ArrayList<>();
                }
                temp = new Students();
                temp.setMaHS(data.getInt("MaHS"));
                temp.setTenHS(data.getString("TenHS"));
                temp.setNgaySinh(data.getDate("NgaySinh"));
                temp.setGhichu(data.getString("Ghichu"));
                temp.setImage(data.getBytes("ExtInfo"));
                listStu.add(temp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            return listStu;
        }
    }

    public ArrayList<Students> getListStudentsByBirth(String birth) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ResultSet data = null;
        ArrayList<Students> listStu = null;
        try (Connection conn = DriverManager.getConnection(connectionStr, username, pass)) {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM dbo.HocSinh WHERE NgaySinh =  '" + birth + "'");
            data = pst.executeQuery();

            Students temp = null;
            while (data.next()) {
                if (listStu == null) {
                    listStu = new ArrayList<>();
                }
                temp = new Students();
                temp.setMaHS(data.getInt("MaHS"));
                temp.setTenHS(data.getString("TenHS"));
                temp.setNgaySinh(data.getDate("NgaySinh"));
                temp.setGhichu(data.getString("Ghichu"));
                temp.setImage(data.getBytes("ExtInfo"));
                listStu.add(temp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            return listStu;
        }
    }

    public ArrayList<Students> getListStudentsByNotes(String notes) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ResultSet data = null;
        ArrayList<Students> listStu = null;
        try (Connection conn = DriverManager.getConnection(connectionStr, username, pass)) {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM dbo.HocSinh WHERE Ghichu =  N'" + notes + "'");
            data = pst.executeQuery();

            Students temp = null;
            while (data.next()) {
                if (listStu == null) {
                    listStu = new ArrayList<>();
                }
                temp = new Students();
                temp.setMaHS(data.getInt("MaHS"));
                temp.setTenHS(data.getString("TenHS"));
                temp.setNgaySinh(data.getDate("NgaySinh"));
                temp.setGhichu(data.getString("Ghichu"));
                temp.setImage(data.getBytes("ExtInfo"));
                listStu.add(temp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            return listStu;
        }
    }

    public byte[] GetImage(int id) throws ClassNotFoundException {
        byte[] img = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ResultSet data = null;
        try (Connection conn = DriverManager.getConnection(connectionStr, username, pass)) {
            PreparedStatement pst = conn.prepareStatement("SELECT ExtInfo FROM dbo.HocSinh WHERE MaHS = ?");
            pst.setInt(1, id);
            data = pst.executeQuery();
            String imgString = null;

            while (data.next()) {
                img = data.getBytes("ExtInfo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            return img;
        }
    }

    public int insertStudentToDatabase(int MaHS, String TenHS, String NgaySinh, String Ghichu, byte[] image) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        int kq = 0;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionStr, username, pass);
            PreparedStatement pst = conn.prepareStatement("INSERT  dbo.HocSinh (MaHS, TenHS, NgaySinh , Ghichu , ExtInfo ) VALUES  (?, ?, ?, ?, ?) ");
            pst.setInt(1, MaHS);
            pst.setString(2, TenHS);
            pst.setString(3, NgaySinh);
            pst.setString(4, Ghichu);
            pst.setBytes(5, image);

            kq = pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return kq;
        } finally {
            if (conn != null) {
                conn.close();
            }
            return kq;
        }
    }

    public Students GetStudentByID(int id) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Students temp = null;
        ResultSet data = null;

        try (Connection conn = DriverManager.getConnection(connectionStr, username, pass)) {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM dbo.HocSinh WHERE MaHS =  " + id);
            data = pst.executeQuery();

            while (data.next()) {

                temp = new Students();
                temp.setMaHS(data.getInt("MaHS"));
                temp.setTenHS(data.getString("TenHS"));
                temp.setNgaySinh(data.getDate("NgaySinh"));
                temp.setGhichu(data.getString("Ghichu"));
                temp.setImage(data.getBytes("ExtInfo"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        } finally {
            return temp;
        }
    }

    public Students GetStudentByBirth(String birth) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Students temp = null;
        ResultSet data = null;

        try (Connection conn = DriverManager.getConnection(connectionStr, username, pass)) {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM dbo.HocSinh WHERE NgaySinh =  '" + birth + "'");
            data = pst.executeQuery();

            while (data.next()) {

                temp = new Students();
                temp.setMaHS(data.getInt("MaHS"));
                temp.setTenHS(data.getString("TenHS"));
                temp.setNgaySinh(data.getDate("NgaySinh"));
                temp.setGhichu(data.getString("Ghichu"));
                temp.setImage(data.getBytes("ExtInfo"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        } finally {
            return temp;
        }
    }

    public int UpdateStuByID(int MaHS, String TenHS, String NgaySinh, String Ghichu, byte[] image) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        int kq = 0;
        try (Connection conn = DriverManager.getConnection(connectionStr, username, pass)) {
            PreparedStatement pst = conn.prepareStatement("UPDATE  dbo.HocSinh SET  TenHS = ?, NgaySinh = ?, Ghichu = ?, ExtInfo = ? WHERE  MaHS = ?");
            pst.setString(1, TenHS);
            pst.setString(2, NgaySinh);
            pst.setString(3, Ghichu);
            pst.setBytes(4, image);
            pst.setInt(5, MaHS);

            kq = pst.executeUpdate();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            return kq;
        }
    }
}
