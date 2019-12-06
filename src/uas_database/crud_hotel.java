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

public class crud_hotel {

    private String namaHotel, alamatHotel, noTelpHotel, emailHotel, passwordHotel, pengelola;
    private String hargaStandartRoom, hargaSuperriorRoom, hargaDeluxeRoom, hargaStudioRoom, hargaSuiteRoom, hargaPresidentialRoom;
    private String stokStandartRoom, stokSuperriorRoom, stokDeluxeRoom, stokStudioRoom, stokSuiteRoom, stokPresidentialRoom;
    private Connection CRUDconnection;
    private PreparedStatement CRUDpsmt, CRUDpsmt1;
    private ResultSet userData, userData1;
    private String CRUDquery, CRUDqueryHarga, CRUDqueryStok;
    private String massage;

    public crud_hotel() {
        mariadbConnection connection = new mariadbConnection();
        CRUDconnection = connection.getConnection();
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setAlamatHotel(String alamatHotel) {
        this.alamatHotel = alamatHotel;
    }

    public String getAlamatHotel() {
        return alamatHotel;
    }

    public void setNoTelpHotel(String noTelpHotel) {
        this.noTelpHotel = noTelpHotel;
    }

    public String getNoTelpHotel() {
        return noTelpHotel;
    }

    public void setEmailHotel(String emailHotel) {
        this.emailHotel = emailHotel;
    }

    public String getEmailHotel() {
        return emailHotel;
    }

    public void setPasswordHotel(String passwordHotel) {
        this.passwordHotel = passwordHotel;
    }

    public String getPasswordHotel() {
        return passwordHotel;
    }

    public void setPengelolaHotel(String pengelola) {
        this.pengelola = pengelola;
    }

    public String getPengelola() {
        return pengelola;
    }

    public void setHargaStandartRoom(String hargaStandartRoom) {
        this.hargaStandartRoom = hargaStandartRoom;
    }

    public String getHargaStandartRoom() {
        return hargaStandartRoom;
    }

    public void setHargaSuperriorRoom(String hargaSuperriorRoom) {
        this.hargaSuperriorRoom = hargaSuperriorRoom;
    }

    public String getHargaSuperriorRoom() {
        return hargaSuperriorRoom;
    }

    public void setHargaDeluxeRoom(String hargaDeluxeRoom) {
        this.hargaDeluxeRoom = hargaDeluxeRoom;
    }

    public String getHargaDeluxeRoom() {
        return hargaDeluxeRoom;
    }

    public void setHargaStudioRoom(String hargaStudioRoom) {
        this.hargaStudioRoom = hargaStudioRoom;
    }

    public String getHargaStudioRoom() {
        return hargaStudioRoom;
    }

    public void setHargaSuiteRoom(String hargaSuiteRoom) {
        this.hargaSuiteRoom = hargaSuiteRoom;
    }

    public String getHargaSuiteRoom() {
        return hargaSuiteRoom;
    }

    public void setHargaPresidetialRoom(String hargaPresidentialRoom) {
        this.hargaPresidentialRoom = hargaPresidentialRoom;
    }

    public String getHargaPresidentialRoom() {
        return hargaPresidentialRoom;
    }

    public void setStokStandartRoom(String stokStandartRoom) {
        this.stokStandartRoom = stokStandartRoom;
    }

    public String getStokStandartRoom() {
        return stokStandartRoom;
    }

    public void setStokSuperriorRoom(String stokSuperriorRoom) {
        this.stokSuperriorRoom = stokSuperriorRoom;
    }

    public String getStokSuperriorRoom() {
        return stokSuperriorRoom;
    }

    public void setStokDeluxeRoom(String stokDeluxeRoom) {
        this.stokDeluxeRoom = stokDeluxeRoom;
    }

    public String getStokDeluxeRoom() {
        return stokDeluxeRoom;
    }

    public void setStokStudioRoom(String stokStudioRoom) {
        this.stokStudioRoom = stokStudioRoom;
    }

    public String getStokStudioRoom() {
        return stokStudioRoom;
    }

    public void setStokSuiteRoom(String stokSuiteRoom) {
        this.stokSuiteRoom = stokSuiteRoom;
    }

    public String getStokSuiteRoom() {
        return stokSuiteRoom;
    }

    public void setStokPresidetialRoom(String stokPresidentialRoom) {
        this.stokPresidentialRoom = stokPresidentialRoom;
    }

    public String getStokPresidentialRoom() {
        return stokPresidentialRoom;
    }

    public void daftarHotel(String namaHotel, String alamatHotel, String noTelpHotel, String emailHotel, String passwordHotel, String pengelola) {
        CRUDquery = "INSERT INTO `hotel`(`nama_hotel`, `alamat_hotel`, `no_telp_hotel`, `email_hotel`, `password`, `pengelola`)"
                + "VALUES (?,?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, namaHotel);
            CRUDpsmt.setString(2, alamatHotel);
            CRUDpsmt.setString(3, noTelpHotel);
            CRUDpsmt.setString(4, emailHotel);
            CRUDpsmt.setString(5, passwordHotel);
            CRUDpsmt.setString(6, pengelola);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void daftarStokKamar(String stokStandartRoom, String stokSuperriorRoom, String stokDeluxeRoom, String stokStudioRoom, String stokSuiteRoom, String stokPresidentialRoom) {
        CRUDquery = "INSERT INTO `stok_kamar`(`id_hotel`, `stok_standart_room`, `stok_superrior_room`, `stok_deluxe_room`, `stok_studio_room`, `stok_suite_room`, `stok_presidential_room`) VALUES (autoInc(),?,?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, stokStandartRoom);
            CRUDpsmt.setString(2, stokSuperriorRoom);
            CRUDpsmt.setString(3, stokDeluxeRoom);
            CRUDpsmt.setString(4, stokStudioRoom);
            CRUDpsmt.setString(5, stokSuiteRoom);
            CRUDpsmt.setString(6, stokPresidentialRoom);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void daftarHargaKamar(String hargaStandartRoom, String hargaSuperriorRoom, String hargaDeluxeRoom, String hargaStudioRoom, String hargaSuiteRoom, String hargaPresidentialRoom) {
        CRUDquery = "INSERT INTO harga_kamar_hotel(id_hotel, harga_standart_room, harga_superrior_room, harga_deluxe_room, "
                + "harga_studio_room, harga_suite_room, harga_presidential_room)"
                + "VALUES (autoInc(),?,?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, hargaStandartRoom);
            CRUDpsmt.setString(2, hargaSuperriorRoom);
            CRUDpsmt.setString(3, hargaDeluxeRoom);
            CRUDpsmt.setString(4, hargaStudioRoom);
            CRUDpsmt.setString(5, hargaSuiteRoom);
            CRUDpsmt.setString(6, hargaPresidentialRoom);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void tersedia(String a, String b, String c, String d, String e, String f) {
        CRUDquery = "INSERT INTO ketersediaan_kamar(id_hotel, standart_room, superrior_room, deluxe_room, "
                + "studio_room, suite_room, presidential_room)"
                + "VALUES (autoInc(),?,?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, a);
            CRUDpsmt.setString(2, b);
            CRUDpsmt.setString(3, c);
            CRUDpsmt.setString(4, d);
            CRUDpsmt.setString(5, e);
            CRUDpsmt.setString(6, f);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public String loginCheck(String email, String password) {
        CRUDquery = "select id_hotel, nama_hotel, alamat_hotel, no_telp_hotel, email_hotel, password, pengelola from hotel where email_hotel = ? and password = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, email);
            CRUDpsmt.setString(2, password);
            userData = CRUDpsmt.executeQuery();
            if (userData.next()) {
                Session_Hotel.setLoginStatus("Active");
                Session_Hotel.setIDHotel(userData.getString("id_hotel"));
                Session_Hotel.setNamaHotel(userData.getString("nama_hotel"));
                Session_Hotel.setAlamatHotel(userData.getString("alamat_hotel"));
                Session_Hotel.setNoTelpHotel(userData.getString("no_telp_hotel"));
                Session_Hotel.setEmailHotel(userData.getString("email_hotel"));
                Session_Hotel.setPasswordHotel(userData.getString("password"));
                Session_Hotel.setPengelolaHotel(userData.getString("pengelola"));
            } else {
                massage = "Can't Login";
            }
        } catch (Exception e) {
            massage = "Error Query";
        }
        return massage;
    }

    public void editHotel(String namaHotel, String alamatHotel, String noTelpHotel, String email, String password, String pengelola) {
        CRUDquery = "UPDATE hotel SET nama_hotel = ?, alamat_hotel = ?, no_telp_hotel = ?, email_hotel = ?, password = ?, pengelola = ? WHERE id_hotel = " + Session_Hotel.getIDHotel();
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, namaHotel);
            CRUDpsmt.setString(2, alamatHotel);
            CRUDpsmt.setString(3, noTelpHotel);
            CRUDpsmt.setString(4, email);
            CRUDpsmt.setString(5, password);
            CRUDpsmt.setString(6, pengelola);
            CRUDpsmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editStokKamar(String standart, String superrior, String deluxe, String studio, String suite, String presidential) {
        CRUDquery = "UPDATE stok_kamar SET stok_standart_room = ?, stok_superrior_room = ?, stok_deluxe_room = ?, stok_studio_room = ?, stok_suite_room = ?, stok_presidential_room = ? WHERE id_hotel = " + Session_Hotel.getIDHotel();
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, standart);
            CRUDpsmt.setString(2, superrior);
            CRUDpsmt.setString(3, deluxe);
            CRUDpsmt.setString(4, studio);
            CRUDpsmt.setString(5, suite);
            CRUDpsmt.setString(6, presidential);
            CRUDpsmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editHargaKamar(String standart, String superrior, String deluxe, String studio, String suite, String presidential) {
        CRUDquery = "UPDATE harga_kamar_hotel SET harga_standart_room = ?, harga_superrior_room = ?, harga_deluxe_room = ?, harga_studio_room = ?, harga_suite_room = ?, harga_presidential_room = ? WHERE id_hotel = " + Session_Hotel.getIDHotel();
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, standart);
            CRUDpsmt.setString(2, superrior);
            CRUDpsmt.setString(3, deluxe);
            CRUDpsmt.setString(4, studio);
            CRUDpsmt.setString(5, suite);
            CRUDpsmt.setString(6, presidential);
            CRUDpsmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
