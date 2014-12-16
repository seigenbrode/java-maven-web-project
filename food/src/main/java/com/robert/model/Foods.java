package com.robert.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.robert.dao.MysqlConnect;


public class Foods {
	
	final int PAGE_SIZE = 12;

	private Connection connection;
	private Statement statement;
	private ResultSet rs;
	private String table = "food";
	
	private String pic;
	private String dish;
	private int id;
	
	public List<Map<String, Object>> getList(int cur_page) {
		int from = (cur_page - 1) * PAGE_SIZE;
		String sql = "select * from " + table + " limit " + from + "," +   PAGE_SIZE;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			connection = MysqlConnect.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData(); // 获得结果集结构信息,元数据
			int columnCount = md.getColumnCount(); // 获得列数
			while (rs.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(rowData);

			}
			connection.close();
		} catch (SQLException e) {
			try {
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return list;
	}

	public static void main(String[] args) {
		Foods food_model = new Foods();
		List<Map<String, Object>> list = food_model.getList(1);
		for(Map<String, Object> obj: list) {
			System.out.println(obj.get("id") + obj.toString());
		}
//		System.out.println(list);
	}

	@Override
	public String toString() {
		return "Foods [pic=" + pic + ", dish=" + dish + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dish == null) ? 0 : dish.hashCode());
		result = prime * result + id;
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foods other = (Foods) obj;
		if (dish == null) {
			if (other.dish != null)
				return false;
		} else if (!dish.equals(other.dish))
			return false;
		if (id != other.id)
			return false;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		return true;
	}

}
