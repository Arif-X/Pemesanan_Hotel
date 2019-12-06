/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class crud_daftar {

    private Connection CRUDconnection;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet result;
    private ResultSet pesan;
    private String CRUDquery;

    private String nama;
    private String email;
    private String password;
    private String alamat;
    private String jenisKelamin;
    private String statusNikah;

    public crud_daftar() {
        mariadbConnection connection = new mariadbConnection();
        CRUDconnection = connection.getConnection();
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
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

    public void setStatusNikah(String statusNikah) {
        this.statusNikah = statusNikah;
    }

    public String getSatusNikah() {
        return statusNikah;
    }

    public void daftar(String email, String password, String nama, String alamat, String jenisKelamin) {
        CRUDquery = "insert into user (email, password, nama, alamat, jenis_kelamin) values (?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, email);
            CRUDpsmt.setString(2, password);
            CRUDpsmt.setString(3, nama);
            CRUDpsmt.setString(4, alamat);
            CRUDpsmt.setString(5, jenisKelamin);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {

        }
    }
}
