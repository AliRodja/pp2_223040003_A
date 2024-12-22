/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package model;

public class User {
    private int id;
    private String name;
    private String email;
    private String tanggalLahir;
    private String alamat;

    public User(int id, String name, String email, String tanggalLahir, String alamat) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "', tanggalLahir='" + tanggalLahir + "', alamat='" + alamat + "'}";
    }
}
