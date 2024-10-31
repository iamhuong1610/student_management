package DAO;

import java.sql.Connection;
import java.sql.SQLException;

import Implements.ConnectionPoolImpl;
import Interfaces.ConnectionPool;

public class Initialization {

	private Connection con;
	private ConnectionPool cp;
	
	
	public Initialization() {
		this.cp = new ConnectionPoolImpl();
		try {
			this.con = this.cp.getConnection("section");
			if(this.con.getAutoCommit())
			{
				this.con.setAutoCommit(false); // chấm dứt chế độ thực thi section
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}


	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {
		this.con = con;
	}


	public ConnectionPool getCp() {
		return cp;
	}


	public void setCp(ConnectionPool cp) {
		this.cp = cp;
	}
	
	

}
