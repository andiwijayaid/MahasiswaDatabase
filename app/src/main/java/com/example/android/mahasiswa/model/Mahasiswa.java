package com.example.android.mahasiswa.model;

/**
 * Created by Asus on 30/04/2018.
 */

public class Mahasiswa {

    private long id;
    private String namaMahasiswa;
    private String nimMahasiswa;
    private String prodiMahasiswa;
    private String emailMahasiswa;

    public Mahasiswa(){

    }

    public Mahasiswa(String nimMahasiswa) {
        this.nimMahasiswa   = nimMahasiswa;
    }

    public Mahasiswa(String namaMahasiswa, String nimMahasiswa, String prodiMahasiswa, String emailMahasiswa) {
        this.namaMahasiswa  = namaMahasiswa;
        this.nimMahasiswa   = nimMahasiswa;
        this.prodiMahasiswa = prodiMahasiswa;
        this.emailMahasiswa = emailMahasiswa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getNimMahasiswa() {
        return nimMahasiswa;
    }

    public void setNimMahasiswa(String nimMahasiswa) {
        this.nimMahasiswa = nimMahasiswa;
    }

    public String getProdiMahasiswa() {
        return prodiMahasiswa;
    }

    public void setProdiMahasiswa(String prodiMahasiswa) {
        this.prodiMahasiswa = prodiMahasiswa;
    }

    public String getEmailMahasiswa() {
        return emailMahasiswa;
    }

    public void setEmailMahasiswa(String emailMahasiswa) {
        this.emailMahasiswa = emailMahasiswa;
    }
}
