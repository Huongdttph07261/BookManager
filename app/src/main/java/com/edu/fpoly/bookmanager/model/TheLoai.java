package com.edu.fpoly.bookmanager.model;

public class TheLoai {
    private String maTheLoai;
    private String tenTheLoai;
    private String viTri;
    private String moTa;

    public TheLoai(String maTheLoai, String tenTheLoai, String moTa, String viTri) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.viTri = viTri;
        this.moTa = moTa;
    }
    public TheLoai(){

    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }



    @Override
    public String toString() {
        return getMaTheLoai()+" | "+getTenTheLoai();
    }
}
