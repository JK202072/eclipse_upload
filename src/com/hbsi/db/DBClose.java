package com.hbsi.db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClose {
	private static void close(ResultSet rs) {
		if (rs!=null) {
			try {
			rs.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	}
  private static void close(Statement stat) {
	if (stat!=null) {
		try {
		stat.close();
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
  }

  private static void close(Connection con) {
	if (con!=null) {
		try {
		con.close();
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
  }

  public static void close(Statement stat,Connection con) {
	close(stat);
	close(con);
}
  public static void close(ResultSet rs,Statement stat,Connection con) {
	close(rs);
	close(stat);
	close(con);
}
}
