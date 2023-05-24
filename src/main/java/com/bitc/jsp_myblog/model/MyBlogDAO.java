package com.bitc.jsp_myblog.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyBlogDAO extends DBConnPool {
  // ****************************************//
  // ********** 사용자 정보(로그인) **********//
  // ****************************************//
  // 사용자 존재여부 확인
  public int isMember(String userId, String userPw) {
    int result = 0;
    String sql = "SELECT count(id) AS cnt FROM blog_member ";
    sql += "WHERE id = ? ";
    sql += "AND pass = ? ";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, userId);
      pstmt.setString(2, userPw);
      rs = pstmt.executeQuery();

      while (rs.next()){
        result = rs.getInt("cnt");
      }

    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다.*****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return result;
  }

  // 사용자 정보 가져오기
  public MyBlogDTO selectMember(String userId, String userPw){
    MyBlogDTO member = new MyBlogDTO();
    String sql = "SELECT id, pass, name FROM blog_member ";
    sql += "WHERE id = ? ";
    sql += "AND pass = ? ";

    try{
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, userId);
      pstmt.setString(2, userPw);
      rs = pstmt.executeQuery();

      while (rs.next()){
        member.setId(rs.getString("id"));
        member.setPass(rs.getString("pass"));
        member.setName(rs.getString("name"));
      }
    } catch (SQLException e){
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다.*****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return member;
  }


  // ****************************************//
  // ********** 블로그 게시글 CRUD **********//
  // ****************************************//
  // 블로그 전체 게시물 목록 가져오기
  public List<MyBlogDTO> selectBoardList() {
    List<MyBlogDTO> boardList = new ArrayList<>();
    String sql = "SELECT post_idx, post_title, post_writer, post_content, post_date, post_ofile, post_sfile, post_dn_count, cate_no ";
    sql += "FROM blog_board ";
    sql += "ORDER BY post_idx DESC;";
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        MyBlogDTO board = new MyBlogDTO();
        board.setPostIdx(rs.getInt("post_idx"));
        board.setPostTitle(rs.getString("post_title"));
        board.setPostWriter(rs.getString("post_writer"));
        board.setPostContent(rs.getString("post_content"));
        board.setPostDate(rs.getString("post_date"));
        board.setPostOfile(rs.getString("post_ofile"));
        board.setPostSfile(rs.getString("post_sfile"));
        boardList.add(board);
      }

    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다.*****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return boardList;
  }

  // 제목 클릭한 게시물 상세 정보 가져오기(글읽기)
  public MyBlogDTO selectBoardDetail(int Idx) {
    MyBlogDTO board = new MyBlogDTO();
    String sql = "SELECT post_idx, post_title, post_writer, post_content, post_date, post_visits, post_ofile, post_sfile, post_dn_count, cate_no ";
    sql += "FROM blog_board ";
    sql += "WHERE post_idx = ? ";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, Idx);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        board.setPostIdx(rs.getInt("post_idx"));
        board.setPostTitle(rs.getString("post_title"));
        board.setPostWriter(rs.getString("post_writer"));
        board.setPostContent(rs.getString("post_content"));
        board.setPostDate(rs.getString("post_date"));
        board.setPostVisits(rs.getInt("post_visits"));
        board.setPostOfile(rs.getString("post_ofile"));
        board.setPostSfile(rs.getString("post_sfile"));
        board.setPostDnCount(rs.getInt("post_dn_count"));
        board.setCateNo(rs.getInt("cate_no"));
      }
    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return board;
  }

  // 전체 게시물 중 가장 최근 게시글
  public MyBlogDTO selectMaxPostIdxBoard() {
    MyBlogDTO board = new MyBlogDTO();
    String sql = "SELECT post_idx, post_title, post_writer, post_content, post_date, post_visits, post_ofile, post_sfile, post_dn_count, cate_no ";
    sql += "FROM blog_board ";
    sql += "WHERE post_idx = (SELECT MAX(post_idx) FROM blog_board) ";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        board.setPostIdx(rs.getInt("post_idx"));
        board.setPostTitle(rs.getString("post_title"));
        board.setPostWriter(rs.getString("post_writer"));
        board.setPostContent(rs.getString("post_content"));
        board.setPostDate(rs.getString("post_date"));
        board.setPostVisits(rs.getInt("post_visits"));
        board.setPostOfile(rs.getString("post_ofile"));
        board.setPostSfile(rs.getString("post_sfile"));
        board.setPostDnCount(rs.getInt("post_dn_count"));
        board.setCateNo(rs.getInt("cate_no"));
      }
    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return board;
  }

  // 데이터 베이스에 글등록하기
  // 게시물 삭제
  // 게시글 수정
  // 조회수 업데이트
  // 파일 다운로드 수 업데이트
  // 패스워드 확인
}
