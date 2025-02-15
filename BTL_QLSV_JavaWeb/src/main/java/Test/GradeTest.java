package Test;

import java.util.List;

import DAO.GradeDAO;
import Model.Grade;

public class GradeTest {
	
	static GradeDAO x = new GradeDAO();
	
	public static void main(String[] args) {
//		display();
//		add();
//		update();
		delete();
		
	}
	
	public static void display()
	{
		List<Grade> li = x.getALL();
		li.forEach(g -> System.out.println(g));
	}
	
	public static void add()
	{
		Grade moi = new Grade(101,22,10,34,8,8,8,"B+");
		if(x.add(moi))
		{
			System.out.println("Them thanh cong");
			display();
		}
		else System.out.println("Them that bai");
	}
	
	public static void update()
	{
		Grade moi = new Grade(101,22,10,34,9,9,9,"A");
		if(x.update(moi))
		{
			System.out.println("cap nha thanh cong");
			display();
		}
		else System.out.println("cap nhat that bai");
	}
	
	public static void delete()
	{
		int id = 101;
		if(x.delete(id))
		{
			System.out.println("xoa thanh cong");
			display();
		}
		else System.out.println("xoa that bai");
	}
}
