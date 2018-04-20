/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocsinh;

import java.util.Date;

/**
 *
 * @author Gokki
 */
public class Students {

    int MaHS;
    String TenHS;
    Date NgaySinh;
    String Ghichu;
    byte[] image;

    public void setMaHS(int MaHS) {
        this.MaHS = MaHS;
    }

    public void setTenHS(String TenHS) {
        this.TenHS = TenHS;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setGhichu(String Ghichu) {
        this.Ghichu = Ghichu;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getMaHS() {
        return MaHS;
    }

    public String getTenHS() {
        return TenHS;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getGhichu() {
        return Ghichu;
    }

    public byte[] getImage() {
        return image;
    }

    public Students() {
    }

    public Students(int MaHS, String TenHS, Date NgaySinh, String Ghichu, byte[] image) {
        this.MaHS = MaHS;
        this.TenHS = TenHS;
        this.NgaySinh = NgaySinh;
        this.Ghichu = Ghichu;
        this.image = image;
    }

}
