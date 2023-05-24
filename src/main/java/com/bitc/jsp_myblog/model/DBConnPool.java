package com.bitc.jsp_myblog.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnPool {
  public Connection conn;
  public PreparedStatement pstmt;
  public ResultSet rs;

  public DBConnPool() {
    try {
      Context initCtx = new InitialContext();
      Context ctx = (Context) initCtx.lookup("java:/comp/env");
      DataSource ds = (DataSource) ctx.lookup("dbcp_mysql");

      conn = ds.getConnection();
      System.out.println("DB 커넥션 풀 연결 성공");

    } catch (Exception e) {
      System.out.println("DB 커넥션 풀 연결 실패");
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      if (rs != null) rs.close();
      if (pstmt != null) pstmt.close();
      if (conn != null) conn.close();
      System.out.println("DB 커넥션 풀 연결 해제");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
