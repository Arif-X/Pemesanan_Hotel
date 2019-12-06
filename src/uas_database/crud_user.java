/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_database;

/**
 *
 * @author Lenovo
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class crud_user {

    private Connection CRUDconnection;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet result;
    private ResultSet userData;
    private String CRUDquery;
    private String email;
    private String password;
    private String nama;
    private String alamat;
    private String jenisKelamin;
    private String nik;
    private String agama;
    private String noHP;
    private String massage;

    public crud_user() {
        mariadbConnection connection = new mariadbConnection();
        CRUDconnection = connection.getConnection();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAgama() {
        return agama;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getnoHP() {
        return noHP;
    }

    public void daftar(String nama, String email, String password, String jenisKelamin, String nik, String alamat, String agama, String noHP) {
        CRUDquery = "INSERT INTO `user`(`nama`, `email`, `password`, `jenis_kelamin`, `nik`, `alamat`, `agama`, `no_hp`) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, email);
            CRUDpsmt.setString(3, password);
            CRUDpsmt.setString(4, jenisKelamin);
            CRUDpsmt.setString(5, nik);
            CRUDpsmt.setString(6, alamat);
            CRUDpsmt.setString(7, agama);
            CRUDpsmt.setString(8, noHP);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String loginCheck(String email, String password) {
        CRUDquery = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, email);
            CRUDpsmt.setString(2, password);
            userData = CRUDpsmt.executeQuery();
            if (userData.next()) {
                Session.setIdUser("id_user");
                Session.setNama(userData.getString("nama"));
                Session.setLoginStatus("Active");
                Session.setEmail(userData.getString("email"));
                Session.setAlamat(userData.getString("alamat"));
                Session.setPassword(userData.getString("password"));
                Session.setJenisKelamin(userData.getString("jenis_kelamin"));
                Session.setNIK(userData.getString("nik"));
                Session.setAgama(userData.getString("agama"));
                Session.setNoHP(userData.getString("no_hp"));
            } else {
                massage = "Can't Login";
            }
        } catch (Exception e) {
            massage = "Error Query";
        }
        return massage;
    }

    public void saveData(String nama, String password, String alamat, String noHP, String email) {
        CRUDquery = "UPDATE `user` SET `nama` = ?, `password` = ?, `alamat` = ?, `no_hp` = ? where email = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, password);
            CRUDpsmt.setString(3, alamat);
            CRUDpsmt.setString(4, noHP);
            CRUDpsmt.setString(5, email);
            CRUDpsmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String namaUpdate(String email) {
        CRUDquery = "SELECT `nama` FROM user WHERE `email` = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, email);
            userData = CRUDpsmt.executeQuery();
            if (userData.next()) {
                Session.setEmail(email);
                Session.setNama(userData.getString("nama"));
            }
        } catch (Exception e) {

        }
        return massage;
    }

    public String passwordUpdate(String email) {
        CRUDquery = "SELECT `password` FROM user WHERE `email` = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, email);
            userData = CRUDpsmt.executeQuery();
            if (userData.next()) {
                Session.setEmail(email);
                Session.setPassword(userData.getString("password"));
            }
        } catch (Exception e) {

        }
        return massage;
    }
    
    public String alamatUpdate(String email) {
        CRUDquery = "SELECT `alamat` FROM user WHERE `email` = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, email);
            userData = CRUDpsmt.executeQuery();
            if (userData.next()) {
                Session.setEmail(email);
                Session.setAlamat(userData.getString("alamat"));
            }
        } catch (Exception e) {

        }
        return massage;
    }
    
    public String noHPUpdate(String email) {
        CRUDquery = "SELECT `no_hp` FROM user WHERE `email` = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, email);
            userData = CRUDpsmt.executeQuery();
            if (userData.next()) {
                Session.setEmail(email);
                Session.setNoHP(userData.getString("no_hp"));
            }
        } catch (Exception e) {

        }
        return massage;
    }
    
    public String seeData(String email) {
        CRUDquery = "SELECT * FROM user WHERE `email` = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, email);
            userData = CRUDpsmt.executeQuery();
            if (userData.next()) {
                Session.setEmail(email);
                Session.setNama(userData.getString("name"));
                Session.setEmail(userData.getString("email"));
                Session.setPassword(userData.getString("password"));
                Session.setJenisKelamin(userData.getString("jenis_kelamin"));
                Session.setNIK(userData.getString("nik"));
                Session.setAlamat(userData.getString("alamat"));
                Session.setAgama(userData.getString("agama"));
                Session.setNoHP(userData.getString("no_hp"));
            }
        } catch (Exception e) {

        }
        return massage;
    }
}
