package model;

import java.util.ArrayList;
import java.util.Collections;

import dao.SachDAO;

public class QLSModel {
	private ArrayList<Sach> dsSach;
	private String tenFile;

	public QLSModel() {
		this.dsSach = SachDAO.getInstance().selectAll();
		Collections.sort(dsSach);
		this.tenFile = "";
	}

	public QLSModel(ArrayList<Sach> dsSach,String tenFile) {
		this.dsSach = dsSach;
		Collections.sort(dsSach);
		this.tenFile = tenFile;
	}
	
	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	
	public void insert(Sach s) {
		this.dsSach.add(s);
	}
	
	public void delete(Sach s) {
		try {
			for(Sach i : this.dsSach) {
				if(i.getMaSach().equals(s.getMaSach())) {
					this.dsSach.remove(i);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Sach s) {
		for(Sach i : this.getDsSach()) {
			if(i.getMaSach().equals(s.getMaSach())) {
				i.setTenSach(s.getTenSach());
				i.setTacGia(s.getTacGia());
				i.setTheLoai(s.getTheLoai());
				i.setNhaXuatBan(s.getNhaXuatBan());
				i.setNamXuatBan(s.getNamXuatBan());
				i.setGia(s.getGia());
				i.setTinhTrang(s.isTinhTrang());
			}
		}
	}

	public boolean kiemTraTonTai(Sach sach) {
		// TODO Auto-generated method stub
		for(Sach i : dsSach) {
			if(i.getMaSach().equals(sach.getMaSach())) {
				return true;
			}
		}
		return false;
	}
	
}
