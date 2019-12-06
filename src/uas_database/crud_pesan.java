/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class crud_pesan {

    private Connection CRUDconnection;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet result;
    private ResultSet pesan;
    private String CRUDquery;
    private String pemesan;
    private String namaHotel;
    private String tipeKamar;
    private String tglMasuk;
    private String tglKeluar;
    private String lama;
    private String perhari;
    private String totalHarga;
    private String ketersediaan;
    private String ID;
    private String IDHotel;

    public crud_pesan() {
        mariadbConnection connection = new mariadbConnection();
        CRUDconnection = connection.getConnection();
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setIDHotel(String IDHotel) {
        this.IDHotel = IDHotel;
    }

    public String getIDHotel() {
        return IDHotel;
    }

    public void setPemesan(String pemesan) {
        this.pemesan = pemesan;
    }

    public String getPemesan() {
        return pemesan;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public String getTglMasuk() {
        return tglMasuk;
    }

    public void setTglKeluar(String tglKeluar) {
        this.tglKeluar = tglKeluar;
    }

    public String getTglKeluar() {
        return tglKeluar;
    }

    public void setLama(String lama) {
        this.lama = lama;
    }

    public String getLama() {
        return lama;
    }

    public void setPerhari(String perhari) {
        this.perhari = perhari;
    }

    public String getPerhari() {
        return perhari;
    }

    public void setTotalharga(String totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setKetersediaan(String ketersediaan) {
        this.ketersediaan = ketersediaan;
    }

    public String getKetersediaan() {
        return ketersediaan;
    }

    public void saveData(String idHotel, String tipeKamar, String tglMasuk, String tglKeluar, String perhari, String totalHarga, String ketersediaan) {
        CRUDquery = "INSERT INTO `pemesanan`(`email_pemesan`, `id_hotel`, `jenis_kamar`, "
                + "`tgl_check_in`, `tgl_check_out`, `harga_permalam`, `harga_total`, `ketersediaan`) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, Session.getEmail());
            CRUDpsmt.setString(2, idHotel);
            CRUDpsmt.setString(3, tipeKamar);
            CRUDpsmt.setString(4, tglMasuk);
            CRUDpsmt.setString(5, tglKeluar);
            CRUDpsmt.setString(6, perhari);
            CRUDpsmt.setString(7, totalHarga);
            CRUDpsmt.setString(8, ketersediaan);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e, "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public ResultSet showHotel() {
        CRUDquery = "select nama_hotel from deskripsi_hotel";
        try {
            CRUDstat = CRUDconnection.createStatement();
            result = CRUDstat.executeQuery(CRUDquery);
            while (result.next()) {
                result.getString("nama_hotel");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet lihatPesanan() {
        CRUDquery = "SELECT * FROM pemesanan where email_pemesan = " + Session.getEmail();
        try {
            CRUDstat = CRUDconnection.createStatement();
            result = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
        }
        return result;
    }

}
