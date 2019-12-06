/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_database;

import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Pesan extends javax.swing.JFrame {

    /**
     * Creates new form Pesan
     */
    private DefaultTableModel tabmode;
    private Connection CRUDconnection;
    private PreparedStatement CRUDpsmt;
    private String CRUDquery;
    private Statement CRUDstat;
    private ResultSet result;
    crud_pesan cc = new crud_pesan();
    crud_user dd = new crud_user();
    public String typeKamar[] = {"Pilih...", "Standart Room", "Superrior Room", "Deluxe Room",
        "Studio Room", "Suite Room", "Presidential Room"};

    private static long daysBetween(Calendar tanggalAwal, Calendar tanggalAkhir) {
        long lama = 0;
        Calendar tanggal = (Calendar) tanggalAwal.clone();
        while (tanggal.before(tanggalAkhir)) {
            tanggal.add(Calendar.DAY_OF_MONTH, 1);
            lama++;
        }
        return lama;
    }

    public Pesan() {
        if (Session.getLoginStatus() == "Active") {
            initComponents();
            setSessionName();
            tampil_combo();
        } else {
            dispose();
            Login.preview();
        }
    }

    public void tampil_combo() {
        try {
            mariadbConnection db = new mariadbConnection();
            Connection con = db.getConnection();
            Statement stt = con.createStatement();
            String sql = "select nama_hotel from hotel order by nama_hotel asc";
            ResultSet res = stt.executeQuery(sql);

            while (res.next()) {
                Object[] ob = new Object[1];
                ob[0] = res.getString(1);
                namaHotel.addItem(String.valueOf(ob[0]));
            }
            res.close();
            stt.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampil() {
        if (jenisKamar.getSelectedItem().equals("Pilih")) {

        } else if (jenisKamar.getSelectedItem() == ("Standart Room")) {
            try {
                mariadbConnection db = new mariadbConnection();
                Connection con = db.getConnection();
                Statement stt = con.createStatement();
                String sql = "select harga_standart_room from harga_kamar_hotel where id_hotel = '" + id_hotel.getText() + "'";
                String sql1 = "select standart_room from ketersediaan_kamar where id_hotel = '" + id_hotel.getText() + "'";
                String sql2 = "select id_hotel from hotel where nama_hotel = '" + namaHotel.getSelectedItem() + "'";
                ResultSet res = stt.executeQuery(sql);
                ResultSet res1 = stt.executeQuery(sql1);
                ResultSet res2 = stt.executeQuery(sql2);

                while (res2.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res2.getString("id_hotel");
                    id_hotel.setText((String) obj[0]);
                }
                while (res.next()) {
                    Object[] ob = new Object[2];
                    ob[0] = res.getString("harga_standart_room");
                    perhari.setText((String) ob[0]);
                }
                while (res1.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res1.getString("standart_room");
                    tersedia_tidak.setText((String) obj[0]);
                }
                res.close();
                stt.close();
                tersedia();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (jenisKamar.getSelectedItem() == ("Superrior Room")) {
            try {
                mariadbConnection db = new mariadbConnection();
                Connection con = db.getConnection();
                Statement stt = con.createStatement();
                String sql = "select harga_superrior_room from harga_kamar_hotel where id_hotel = '" + id_hotel.getText() + "'";
                String sql1 = "select superrior_room from ketersediaan_kamar where id_hotel = '" + id_hotel.getText() + "'";
                String sql2 = "select id_hotel from hotel where nama_hotel = '" + namaHotel.getSelectedItem() + "'";
                ResultSet res = stt.executeQuery(sql);
                ResultSet res1 = stt.executeQuery(sql1);
                ResultSet res2 = stt.executeQuery(sql2);

                while (res2.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res2.getString("id_hotel");
                    id_hotel.setText((String) obj[0]);
                }
                while (res.next()) {
                    Object[] ob = new Object[2];
                    ob[0] = res.getString("harga_superrior_room");
                    perhari.setText((String) ob[0]);
                }
                while (res1.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res1.getString("superrior_room");
                    tersedia_tidak.setText((String) obj[0]);
                }
                res.close();
                stt.close();
                tersedia();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (jenisKamar.getSelectedItem() == ("Deluxe Room")) {
            try {
                mariadbConnection db = new mariadbConnection();
                Connection con = db.getConnection();
                Statement stt = con.createStatement();
                String sql = "select harga_deluxe_room from harga_kamar_hotel where id_hotel = '" + id_hotel.getText() + "'";
                String sql1 = "select deluxe_room from ketersediaan_kamar where id_hotel = '" + id_hotel.getText() + "'";
                String sql2 = "select id_hotel from hotel where nama_hotel = '" + namaHotel.getSelectedItem() + "'";
                ResultSet res = stt.executeQuery(sql);
                ResultSet res1 = stt.executeQuery(sql1);
                ResultSet res2 = stt.executeQuery(sql2);

                while (res2.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res2.getString("id_hotel");
                    id_hotel.setText((String) obj[0]);
                }
                while (res.next()) {
                    Object[] ob = new Object[2];
                    ob[0] = res.getString("harga_deluxe_room");
                    perhari.setText((String) ob[0]);
                }
                while (res1.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res1.getString("deluxe_room");
                    tersedia_tidak.setText((String) obj[0]);
                }
                res.close();
                stt.close();
                tersedia();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (jenisKamar.getSelectedItem() == ("Studio Room")) {
            try {
                mariadbConnection db = new mariadbConnection();
                Connection con = db.getConnection();
                Statement stt = con.createStatement();
                String sql = "select harga_studio_room from harga_kamar_hotel where id_hotel = '" + id_hotel.getText() + "'";
                String sql1 = "select studio_room from ketersediaan_kamar where id_hotel = '" + id_hotel.getText() + "'";
                String sql2 = "select id_hotel from hotel where nama_hotel = '" + namaHotel.getSelectedItem() + "'";
                ResultSet res = stt.executeQuery(sql);
                ResultSet res1 = stt.executeQuery(sql1);
                ResultSet res2 = stt.executeQuery(sql2);

                while (res2.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res2.getString("id_hotel");
                    id_hotel.setText((String) obj[0]);
                }
                while (res.next()) {
                    Object[] ob = new Object[2];
                    ob[0] = res.getString("harga_studio_room");
                    perhari.setText((String) ob[0]);
                }
                while (res1.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res1.getString("studio_room");
                    tersedia_tidak.setText((String) obj[0]);
                }
                res.close();
                stt.close();
                tersedia();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (jenisKamar.getSelectedItem() == ("Suite Room")) {
            try {
                mariadbConnection db = new mariadbConnection();
                Connection con = db.getConnection();
                Statement stt = con.createStatement();
                String sql = "select harga_suite_room from harga_kamar_hotel where id_hotel = '" + id_hotel.getText() + "'";
                String sql1 = "select suite_room from ketersediaan_kamar where id_hotel = '" + id_hotel.getText() + "'";
                String sql2 = "select id_hotel from hotel where nama_hotel = '" + namaHotel.getSelectedItem() + "'";
                ResultSet res = stt.executeQuery(sql);
                ResultSet res1 = stt.executeQuery(sql1);
                ResultSet res2 = stt.executeQuery(sql2);

                while (res2.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res2.getString("id_hotel");
                    id_hotel.setText((String) obj[0]);
                }
                while (res.next()) {
                    Object[] ob = new Object[2];
                    ob[0] = res.getString("harga_suite_room");
                    perhari.setText((String) ob[0]);
                }
                while (res1.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res1.getString("suite_room");
                    tersedia_tidak.setText((String) obj[0]);
                }
                res.close();
                stt.close();
                tersedia();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (jenisKamar.getSelectedItem() == ("Presidential Room")) {
            try {
                mariadbConnection db = new mariadbConnection();
                Connection con = db.getConnection();
                Statement stt = con.createStatement();
                String sql = "select harga_presidential_room from harga_kamar_hotel where id_hotel = '" + id_hotel.getText() + "'";
                String sql1 = "select presidential_room from ketersediaan_kamar where id_hotel = '" + id_hotel.getText() + "'";
                String sql2 = "select id_hotel from hotel where nama_hotel = '" + namaHotel.getSelectedItem() + "'";
                ResultSet res = stt.executeQuery(sql);
                ResultSet res1 = stt.executeQuery(sql1);
                ResultSet res2 = stt.executeQuery(sql2);

                while (res2.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res2.getString("id_hotel");
                    id_hotel.setText((String) obj[0]);
                }
                while (res.next()) {
                    Object[] ob = new Object[2];
                    ob[0] = res.getString("harga_presidential_room");
                    perhari.setText((String) ob[0]);
                }
                while (res1.next()) {
                    Object[] obj = new Object[2];
                    obj[0] = res1.getString("presidential_room");
                    tersedia_tidak.setText((String) obj[0]);
                }
                res.close();
                stt.close();
                tersedia();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setSessionName() {
        name.setText("Welcome " + Session.getNama());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        perhari = new javax.swing.JTextField();
        pesan = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        totalHarga = new javax.swing.JTextField();
        lama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        namaHotel = new javax.swing.JComboBox<>();
        tglMasuk = new com.toedter.calendar.JDateChooser();
        tglKeluar = new com.toedter.calendar.JDateChooser();
        tglMasukTF = new javax.swing.JTextField();
        tglKeluarTF = new javax.swing.JTextField();
        hitung = new javax.swing.JButton();
        jenisKamar = new javax.swing.JComboBox<>();
        tersedia_tidak = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        id_hotel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        idPesanan = new javax.swing.JTextField();
        lihat = new javax.swing.JButton();
        profil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 610));
        getContentPane().setLayout(null);

        perhari.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                perhariPropertyChange(evt);
            }
        });
        getContentPane().add(perhari);
        perhari.setBounds(140, 400, 103, 31);

        pesan.setBackground(new java.awt.Color(255, 255, 255));
        pesan.setForeground(new java.awt.Color(255, 182, 0));
        pesan.setText("Pesan");
        pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesanActionPerformed(evt);
            }
        });
        getContentPane().add(pesan);
        pesan.setBounds(20, 490, 450, 30);

        name.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        name.setText("Hello");
        getContentPane().add(name);
        name.setBounds(170, 130, 200, 19);

        totalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalHargaActionPerformed(evt);
            }
        });
        getContentPane().add(totalHarga);
        totalHarga.setBounds(140, 440, 333, 31);
        getContentPane().add(lama);
        lama.setBounds(140, 360, 103, 29);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hotel");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 250, 70, 16);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jenis Kamar");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 210, 80, 16);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tanggal Check-in");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 280, 100, 31);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tanggal Check-out");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 320, 110, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Durasi");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 370, 50, 16);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Biaya Permalam");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 410, 93, 16);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 450, 40, 16);

        namaHotel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih...." }));
        namaHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaHotelActionPerformed(evt);
            }
        });
        getContentPane().add(namaHotel);
        namaHotel.setBounds(140, 240, 220, 30);

        tglMasuk.setDateFormatString("yyyy-MM-dd");
        tglMasuk.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglMasukPropertyChange(evt);
            }
        });
        getContentPane().add(tglMasuk);
        tglMasuk.setBounds(450, 280, 23, 31);

        tglKeluar.setDateFormatString("yyyy-MM-dd");
        tglKeluar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglKeluarPropertyChange(evt);
            }
        });
        getContentPane().add(tglKeluar);
        tglKeluar.setBounds(450, 320, 22, 30);
        getContentPane().add(tglMasukTF);
        tglMasukTF.setBounds(140, 280, 305, 31);
        getContentPane().add(tglKeluarTF);
        tglKeluarTF.setBounds(140, 320, 305, 30);

        hitung.setBackground(new java.awt.Color(255, 255, 255));
        hitung.setForeground(new java.awt.Color(255, 182, 0));
        hitung.setText("Hitung Biaya");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });
        getContentPane().add(hitung);
        hitung.setBounds(350, 360, 121, 30);

        jenisKamar.setModel(new javax.swing.DefaultComboBoxModel<>(typeKamar));
        jenisKamar.setMinimumSize(new java.awt.Dimension(31, 29));
        getContentPane().add(jenisKamar);
        jenisKamar.setBounds(140, 200, 333, 30);

        tersedia_tidak.setForeground(new java.awt.Color(255, 255, 255));
        tersedia_tidak.setText("Tersedia / Tidak Tersedia");
        getContentPane().add(tersedia_tidak);
        tersedia_tidak.setBounds(340, 410, 143, 16);

        logout.setBackground(new java.awt.Color(255, 255, 255));
        logout.setForeground(new java.awt.Color(255, 182, 0));
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(20, 530, 450, 30);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ketersediaan     : ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(250, 410, 97, 16);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Malam");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(250, 370, 70, 15);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID Hotel");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(370, 240, 60, 30);

        id_hotel.setForeground(new java.awt.Color(255, 255, 255));
        id_hotel.setText("id");
        getContentPane().add(id_hotel);
        id_hotel.setBounds(440, 240, 30, 30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Logo_Daftar.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -5, 500, 120);

        jLabel12.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("PESAN HOTEL");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 120, 140, 40);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ID Pesanan");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 170, 110, 16);

        idPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPesananActionPerformed(evt);
            }
        });
        getContentPane().add(idPesanan);
        idPesanan.setBounds(140, 159, 170, 30);

        lihat.setBackground(new java.awt.Color(255, 255, 255));
        lihat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lihat.setForeground(new java.awt.Color(255, 182, 0));
        lihat.setText("Lihat Struk");
        lihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatActionPerformed(evt);
            }
        });
        getContentPane().add(lihat);
        lihat.setBounds(320, 160, 150, 30);

        profil.setBackground(new java.awt.Color(255, 255, 255));
        profil.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        profil.setForeground(new java.awt.Color(255, 182, 0));
        profil.setText("Profil");
        profil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilActionPerformed(evt);
            }
        });
        getContentPane().add(profil);
        profil.setBounds(390, 130, 80, 26);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesanActionPerformed
        try {
            cc.setNamaHotel(id_hotel.getText());
            cc.setTipeKamar((String) jenisKamar.getSelectedItem());
            cc.setTglMasuk(tglMasukTF.getText());
            cc.setTglKeluar(tglKeluarTF.getText());
            cc.setPerhari(perhari.getText());
            cc.setTotalharga(totalHarga.getText());
            cc.setKetersediaan(tersedia_tidak.getText());
            cc.saveData(cc.getNamaHotel(), cc.getTipeKamar(), cc.getTglMasuk(), cc.getTglKeluar(), cc.getPerhari(), cc.getTotalHarga(), cc.getKetersediaan());
            JOptionPane.showMessageDialog(null, "Data Saved", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("http://localhost/struk/laporan.php"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_pesanActionPerformed

    private void totalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalHargaActionPerformed

    private void tglMasukPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglMasukPropertyChange
        if (evt.getPropertyName().equals("")) {
        } else {
            String tanggal = ((JTextField) tglMasuk.getDateEditor().getUiComponent()).getText();
            tglMasukTF.setText(tanggal);
        }
    }//GEN-LAST:event_tglMasukPropertyChange

    private void tglKeluarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglKeluarPropertyChange
        if (evt.getPropertyName().equals("")) {
        } else {
            String tanggal = ((JTextField) tglKeluar.getDateEditor().getUiComponent()).getText();
            tglKeluarTF.setText(tanggal);
        }
    }//GEN-LAST:event_tglKeluarPropertyChange

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        String stglAwal = tglMasukTF.getText();
        String stglAkhir = tglKeluarTF.getText();
        DateFormat dateAwal = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateAkhir = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date tglAwal = dateAwal.parse(stglAwal);
            Date tglAkhir = dateAkhir.parse(stglAkhir);

            Date TGLAwal = tglAwal;
            Date TGLAkhir = tglAkhir;
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(TGLAwal);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(TGLAkhir);

            String hasil = String.valueOf(daysBetween(cal1, cal2));

            lama.setText(hasil);
        } catch (ParseException e) {
        }
        int a = Integer.parseInt(lama.getText());
        int b = Integer.parseInt(perhari.getText());
        int c = a * b;
        totalHarga.setText(String.valueOf(c));
    }//GEN-LAST:event_hitungActionPerformed

    private void namaHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaHotelActionPerformed
        tampil();
    }//GEN-LAST:event_namaHotelActionPerformed

    private void perhariPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_perhariPropertyChange
        if (evt.getPropertyName().equals("0")) {
            String tidak_tersedia = "Tidak Tersedia";
            tersedia_tidak.setText(tidak_tersedia);
        } else if (evt.getPropertyName() == null) {
            String tidak_tersedia = "Tidak Tersedia";
            tersedia_tidak.setText(tidak_tersedia);
        } else {
            String tersedia = "Tersedia";
            tersedia_tidak.setText(tersedia);
        }
    }//GEN-LAST:event_perhariPropertyChange

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Mau Logout ?", "Warning", 2)
                == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void idPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPesananActionPerformed

    private void lihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("http://localhost/struk/struk.php?id-pemesanan=" + idPesanan.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_lihatActionPerformed

    private void profilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilActionPerformed
        dispose();
        Profil_User.preview();
    }//GEN-LAST:event_profilActionPerformed

    public void tersedia() {
        if (perhari.getText().equals("0")) {
            tersedia_tidak.setText("Tidak Tersedia");
        }
    }

    public static void preview() {
        Pesan form = new Pesan();
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.getContentPane().setBackground(Color.decode("#ffb600"));
        form.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            preview();
        } catch (Exception e) {

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hitung;
    private javax.swing.JTextField idPesanan;
    private javax.swing.JLabel id_hotel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jenisKamar;
    private javax.swing.JTextField lama;
    private javax.swing.JButton lihat;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> namaHotel;
    private javax.swing.JLabel name;
    private javax.swing.JTextField perhari;
    private javax.swing.JButton pesan;
    private javax.swing.JButton profil;
    private javax.swing.JLabel tersedia_tidak;
    private com.toedter.calendar.JDateChooser tglKeluar;
    private javax.swing.JTextField tglKeluarTF;
    private com.toedter.calendar.JDateChooser tglMasuk;
    private javax.swing.JTextField tglMasukTF;
    private javax.swing.JTextField totalHarga;
    // End of variables declaration//GEN-END:variables
}
