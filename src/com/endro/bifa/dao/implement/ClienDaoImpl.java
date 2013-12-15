/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endro.bifa.dao.implement;

import com.endro.bifa.dao.ClienDao;
import com.endro.bifa.entity.User;
import com.endro.bifa.error.BifaExeption;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author klewoood
 */
public class ClienDaoImpl implements ClienDao {

    private Connection koneksi;

    public ClienDaoImpl(Connection koneksi) {
        this.koneksi = koneksi;
    }

    private final String insert = "insert into clien (id_clien, nama, alamat, jenis_kelamin, pengenal, id_pengenal, pekerjaan, tgl_lahir, telephone, maksud_kedatangan, id_user) values (?,?,?,?,?,?,?,?,?,?,?)";
    private final String update = "update clien set nama=?, alamat=?, jenis_kelamin=?, pengenal=?, id_pengenal=?, pekerjaan=?, tgl_lahir=?, telephone=?, maksud_kedatangan=?, id_user=? where id_clien=?";
    private final String delete = "delete from clien where id_clien=?";
    private final String fromId = "select * from clien where id_clien=?";
    private final String fromAll = "select * from clien";

    @Override
    public void insertUser(User user) throws BifaExeption {
        PreparedStatement statement = null;
        try {
            koneksi.setAutoCommit(false);
            statement = koneksi.prepareStatement(insert);

            statement.setInt(1, user.getId_clien());
            statement.setString(2, user.getNama());
            statement.setString(3, user.getAlamat());
            statement.setString(4, user.getJenis_kelamin());
            statement.setString(5, user.getPengenal());
            statement.setString(6, user.getId_pengenal());
            statement.setString(7, user.getPekerjaan());
            statement.setDate(8, new Date(user.getTgl_lahir().getTime()));
            statement.setString(9, user.getTelephone());
            statement.setString(10, user.getMaksud_kedatangan());
            statement.setInt(11, user.getId_resepsionis());

            statement.executeUpdate();
            koneksi.commit();
        } catch (SQLException ex) {
            try {
                koneksi.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ClienDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            throw new BifaExeption(ex.getMessage());
        } finally {
            try {
                koneksi.setAutoCommit(true);
            } catch (SQLException ex) {

            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    @Override
    public void updateUser(User user) throws BifaExeption {
        PreparedStatement statement = null;
        try {
            koneksi.setAutoCommit(false);
            statement = koneksi.prepareStatement(update);

            statement.setString(1, user.getNama());
            statement.setString(2, user.getAlamat());
            statement.setString(3, user.getJenis_kelamin());
            statement.setString(4, user.getPengenal());
            statement.setString(5, user.getId_pengenal());
            statement.setString(6, user.getPekerjaan());
            statement.setDate(7, new Date(user.getTgl_lahir().getTime()));
            statement.setString(8, user.getTelephone());
            statement.setString(9, user.getMaksud_kedatangan());
            statement.setInt(10, user.getId_resepsionis());
            statement.setInt(11, user.getId_clien());

            statement.executeUpdate();
            koneksi.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                koneksi.rollback();
            } catch (SQLException ex1) {
            }
            throw new BifaExeption(ex.getMessage());
        } finally {
            try {
                koneksi.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    @Override
    public void deleteUser(Integer id_clien) throws BifaExeption {
        PreparedStatement statement = null;
        try {
            koneksi.setAutoCommit(false);
            statement = koneksi.prepareStatement(delete);
            statement.setInt(1, id_clien);
            statement.executeUpdate();
            koneksi.commit();
        } catch (SQLException ex) {
            try {
                koneksi.rollback();
            } catch (SQLException ex1) {
            }
            throw new BifaExeption(ex.getMessage());
        } finally {
            try {
                koneksi.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    @Override
    public User getByIdUser(Integer id_clien) throws BifaExeption {
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            koneksi.setAutoCommit(false);
            statement = koneksi.prepareStatement(fromId);
            statement.setInt(1, id_clien);

            result = statement.executeQuery();
            User user = null;
            if (result.next()) {
                user = new User();
                user.setId_clien(result.getInt("id_clien"));
                user.setNama(result.getString("nama"));
                user.setAlamat(result.getString("alamat"));
                user.setJenis_kelamin(result.getString("jenis_kelamin"));
                user.setPengenal(result.getString("pengenal"));
                user.setId_pengenal(result.getString("id_pengenal"));
                user.setPekerjaan(result.getString("pekerjaan"));
                user.setTgl_lahir(result.getDate("tgl_lahir"));
                user.setTelephone(result.getString("telephone"));
                user.setMaksud_kedatangan(result.getString("maksud_kedatangan"));
                user.setId_resepsionis(result.getInt("id_user"));
            } else {
                throw new BifaExeption("Clien dengan id " + id_clien + " tidak ditemukan");
            }
            koneksi.commit();
            return user;
        } catch (SQLException ex) {
            try {
                koneksi.rollback();
            } catch (SQLException ex1) {
            }
            throw new BifaExeption(ex.getMessage());
        } finally {
            try {
                koneksi.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    @Override
    public List<User> getAll() throws BifaExeption {
        List<User> list = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {
            koneksi.setAutoCommit(false);
            statement = koneksi.createStatement();

            result = statement.executeQuery(fromAll);

            while (result.next()) {
                User user = new User();
                user.setId_clien(result.getInt("id_clien"));
                user.setNama(result.getString("nama"));
                user.setAlamat(result.getString("alamat"));
                user.setJenis_kelamin(result.getString("jenis_kelamin"));
                user.setPengenal(result.getString("pengenal"));
                user.setId_pengenal(result.getString("id_pengenal"));
                user.setPekerjaan(result.getString("pekerjaan"));
                user.setTgl_lahir(result.getDate("tgl_lahir"));
                user.setTelephone(result.getString("telephone"));
                user.setMaksud_kedatangan(result.getString("maksud_kedatangan"));
                user.setId_resepsionis(result.getInt("id_user"));

                list.add(user);
            }
            koneksi.commit();
            
            return list;
        } catch (SQLException ex) {
            try {
                koneksi.rollback();
            } catch (SQLException ex1) {
            }
            throw new BifaExeption(ex.getMessage());
        } finally {
            try {
                koneksi.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {

                }
            }
        }

    }

}
