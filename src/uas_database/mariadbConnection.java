package uas_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class mariadbConnection {

    static Statement prepareStatement(PreparedStatement CRUDpsmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Connection connect;
    private String driverName = "org.mariadb.jdbc.Driver";
    private String jdbc = "jdbc:mariadb://";
    private String host = "localhost:";
    private String port = "5000/";
    private String database = "tels";
    private String url = jdbc + host + port + database;
    private String username = "?user=root";
    private String password = "&password=";
    private String connection = url + username + password;

    public Connection getConnection(){
        if (connect == null) {
            try {
                Class.forName(driverName);
                System.out.println("Class Driver Ditemukan");
                try {
                    connect = DriverManager.getConnection(connection);
                    System.out.println("Koneksi Database Sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi Database Gagal : " + se);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : " + cnfe);
                System.exit(0);
            }
        }
        return connect;
    }

    public static void main(String[] args) throws SQLException {
        mariadbConnection ob = new mariadbConnection();
        ob.getConnection();
    }
}
