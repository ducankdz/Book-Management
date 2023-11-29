package test;

import java.util.ArrayList;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
	public static void main(String[] args) {
		Sach s1 = new Sach("S01","Truyện Kiều","Nguyễn Du","Văn học","Kim Đồng",1950,35000,true);
		Sach s2 = new Sach("S02","Làng","Kim Lân","Văn học","Kim Đồng",1900,25000,true);
//		ArrayList<Sach> lst = SachDAO.getInstance().selectAll();
//		for(Sach i : lst) System.out.println(i);
		Sach s = SachDAO.getInstance().selectByID("s04");
		System.out.println(s);
	}
}
