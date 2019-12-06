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
public class Session {

    private static String nama, idUser, password, loginStatus, nik, agama;
    private static String alamat, jenisKelamin, statusNikah, email, noHP;

    public static void setNoHP(String noHP) {
        Session.noHP = noHP;
    }

    public static String getNoHP() {
        return noHP;
    }
    
    public static void setAgama(String agama) {
        Session.agama = agama;
    }

    public static String getAgama() {
        return agama;
    }
    
    public static void setNIK(String nik) {
        Session.nik = nik;
    }

    public static String getNIK() {
        return nik;
    }
    
    public static void setNama(String nama) {
        Session.nama = nama;
    }

    public static String getNama() {
        return nama;
    }

    public static void setEmail(String email) {
        Session.email = email;
    }

    public static String getEmail() {
        return email;
    }

    public static void setIdUser(String idUser) {
        Session.idUser = idUser;
    }

    public static String setIdUser() {
        return idUser;
    }

    public static void setPassword(String password) {
        Session.password = password;
    }

    public static String getpassword() {
        return password;
    }

    public static void setLoginStatus(String loginStatus) {
        Session.loginStatus = loginStatus;
    }

    public static String getLoginStatus() {
        return loginStatus;
    }

    public static void setAlamat(String alamat) {
        Session.alamat = alamat;
    }

    public static String getAlamat() {
        return alamat;
    }

    public static void setJenisKelamin(String jenisKelamin) {
        Session.jenisKelamin = jenisKelamin;
    }

    public static String getJenisKelamin() {
        return jenisKelamin;
    }

    public static void setStatusNikah(String statusNikah) {
        Session.statusNikah = statusNikah;
    }

    public static String getStatusNikah() {
        return statusNikah;
    }
}
