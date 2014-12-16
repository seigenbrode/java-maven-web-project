package com.robert.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MysqlConnect {
	
	private static ComboPooledDataSource cpds;
	
	static {
		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		// localtest
		
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/go");
		cpds.setUser("test");
		cpds.setPassword("test");
		
		//online
		/*
		cpds.setJdbcUrl("jdbc:mysql://10.10.10.245:3307/test");
		cpds.setUser("brave");
		cpds.setPassword("1game.brave2");
        */
		// the settings below are optional -- c3p0 can work with defaults
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
	}

	public static void main(String[] args) {
		
		Connection con;
		try {
			con = getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// The DataSource cpds is now a fully configured and usable pooled
		// DataSource
	}

	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}

}
