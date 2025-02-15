package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Grade;



public class GradeDAO extends Initialization implements DAO<Grade>{

	public GradeDAO()
	{
		super();
	}
	
	@Override
	public List<Grade> getALL() {
		List<Grade> li = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from tblgrade");
		try
		{
			PreparedStatement pre = this.getCon().prepareStatement(sql.toString());
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				Grade x = new Grade
				(
					rs.getInt("grade_ID"),
					rs.getInt("class_ID"),
					rs.getInt("student_ID"),
					rs.getInt("course_ID"),
					rs.getFloat("tx1"),
					rs.getFloat("tx2"),
					rs.getFloat("exam_Score"),
					rs.getString("letter_Score")
				);
				li.add(x);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public boolean add(Grade t) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into tblgrade ");
		sql.append("values(?,?,?,?,?,?,?,?) ");
		try
		{
			PreparedStatement pre = this.getCon().prepareStatement(sql.toString());
			pre.setInt(1, t.getGrade_ID());
			pre.setInt(2, t.getClass_ID());
			pre.setInt(3, t.getStudent_ID());
			pre.setInt(4, t.getCourse_ID());
			pre.setFloat(5, t.getTx1());
			pre.setFloat(6, t.getTx2());
			pre.setFloat(7, t.getExam_Score());
			pre.setString(8, t.getLetter_Score());
			if(pre.executeUpdate() == 0)
			{
				this.getCon().rollback();
				return false;
			}
			this.getCon().commit();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean update(Grade t) {
		StringBuilder sql = new StringBuilder();
		sql.append("update tblgrade ");
		sql.append("set tx1=?, tx2=?, ");
		sql.append("exam_Score=?, letter_Score=? ");
		sql.append("where grade_ID=?");
		try
		{
			PreparedStatement pre = this.getCon().prepareStatement(sql.toString());
			pre.setFloat(1, t.getTx1());
			pre.setFloat(2, t.getTx2());
			pre.setFloat(3, t.getExam_Score());
			pre.setString(4, t.getLetter_Score());
			pre.setInt(5, t.getGrade_ID());
			if(pre.executeUpdate() ==0)
			{
				this.getCon().rollback();
				return false;
			}
			this.getCon().commit();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from tblgrade where grade_ID=?");
		try
		{
			PreparedStatement pre = this.getCon().prepareStatement(sql.toString());
			pre.setInt(1, id);
			if(pre.executeUpdate() == 0)
			{
				this.getCon().rollback();
				return false;
			}
			this.getCon().commit();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}

}
