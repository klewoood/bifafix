package com.endro.bifa.entity;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author klewoood
 */
public class User {
    
    private Integer id_clien;
    private String nama;
    private String alamat;
    private String jenis_kelamin;
    private String pengenal;
    private String id_pengenal;
    private String pekerjaan;
    private Date tgl_lahir;
    private String telephone;
    private String maksud_kedatangan;
    private Integer id_user;

    public User() {
    }

    public Integer getId_clien() {
        return id_clien;
    }

    public void setId_clien(Integer id_clien) {
        this.id_clien = id_clien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getPengenal() {
        return pengenal;
    }

    public void setPengenal(String pengenal) {
        this.pengenal = pengenal;
    }

    public String getId_pengenal() {
        return id_pengenal;
    }

    public void setId_pengenal(String id_pengenal) {
        this.id_pengenal = id_pengenal;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMaksud_kedatangan() {
        return maksud_kedatangan;
    }

    public void setMaksud_kedatangan(String maksud_kedatangan) {
        this.maksud_kedatangan = maksud_kedatangan;
    }

    public Integer getId_resepsionis() {
        return id_user;
    }

    public void setId_resepsionis(Integer id_resepsionis) {
        this.id_user = id_resepsionis;
    }
    
    
}
