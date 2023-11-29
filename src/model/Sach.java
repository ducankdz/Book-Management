package model;

import java.io.Serializable;

public class Sach implements Serializable,Comparable<Sach>{
	private String maSach,tenSach,tacGia,theLoai,nhaXuatBan;
	private int namXuatBan;
	private double gia;
	private boolean tinhTrang;
	
	public Sach() {
	}

	public Sach(String maSach, String tenSach, String tacGia, String theLoai, String nhaXuatBan, int namXuatBan,
			double gia, boolean tinhTrang) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.theLoai = theLoai;
		this.nhaXuatBan = nhaXuatBan;
		this.namXuatBan = namXuatBan;
		this.gia = gia;
		this.tinhTrang = tinhTrang;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", tacGia=" + tacGia + ", theLoai=" + theLoai
				+ ", nhaXuatBan=" + nhaXuatBan + ", namXuatBan=" + namXuatBan + ", gia=" + gia + ", tinhTrang="
				+ tinhTrang + "]";
	}

	@Override
	public int compareTo(Sach o) {
		// TODO Auto-generated method stub
		return this.maSach.compareTo(o.maSach);
	}

	
}
