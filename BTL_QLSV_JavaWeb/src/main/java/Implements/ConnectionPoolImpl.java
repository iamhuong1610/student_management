package Implements;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import Interfaces.ConnectionPool;

public class ConnectionPoolImpl implements ConnectionPool {
	private String driver;
	private String username;
	private String password;
	private String url;
	
	private Stack<Connection> pool;
	
	public ConnectionPoolImpl() {
		//Xác định trình điều khiển
		this.driver = "com.mysql.cj.jdbc.Driver";
		
		//Nạp trình điều khiển
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Xác định tài khoản làm việc
		this.username = "root";
		this.password = "root";
		
		//Xác định đường dẫn thực thi
		this.url = "jdbc:mysql://localhost:3306/db_java_web_fix1";
		
		//Cấp phát bộ nhớ cho pool
		this.pool = new Stack<>();
	}
	@Override
	public Connection getConnection(String objectName) throws SQLException {
		// TODO Auto-generated method stub
		
		if(this.pool.isEmpty()) {
			System.out.println(objectName+" đã khởi tạo 1 kết nối mới");
			return DriverManager.getConnection(this.url,this.username,this.password);
		} else {
			System.out.println(objectName+" đã lấy ra một kết nối");
			return this.pool.pop();
		}
	}

	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(objectName+"đã thu hồi một kết nối");
		this.pool.push(con);
	}
	
	protected void finalize() throws Throwable{
		this.pool.clear();
		this.pool = null;
		
		System.out.println("Cpool đã kết thúc để CPoll mới ra đời");
	}

}
