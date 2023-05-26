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

      while (rs.next()) {
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
  public MyBlogDTO selectMember(String userId, String userPw) {
    MyBlogDTO member = new MyBlogDTO();
    String sql = "SELECT id, pass, name FROM blog_member ";
    sql += "WHERE id = ? ";
    sql += "AND pass = ? ";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, userId);
      pstmt.setString(2, userPw);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        member.setId(rs.getString("id"));
        member.setPass(rs.getString("pass"));
        member.setName(rs.getString("name"));
      }
    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다.*****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return member;
  }


  // ****************************************//
  // ********** 블로그 게시글 CRUD **********//
  // ****************************************//

  // **************메인 페이지**************//
  // 블로그 전체 게시물 목록 가져오기
  public List<MyBlogDTO> selectBoardList() {
    List<MyBlogDTO> boardList = new ArrayList<>();
    String sql = "SELECT post_idx, post_title, post_writer, post_content, post_date, post_visits, post_ofile, post_sfile, post_dn_count, cate_no ";
    sql += "FROM blog_board ";
    sql += "ORDER BY post_idx DESC ";
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
        board.setPostVisits(rs.getInt("post_visits"));
        board.setPostOfile(rs.getString("post_ofile"));
        board.setPostSfile(rs.getString("post_sfile"));
        board.setPostDnCount(rs.getInt("post_dn_count"));
        board.setCateNo(rs.getInt("cate_no"));
        boardList.add(board);
      }

    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다.*****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return boardList;
  }

  // 페이징 처리 블로그 전체 게시물 목록 가져오기
  public List<MyBlogDTO> selectBoardList(int startNum, int postSize) {
    List<MyBlogDTO> boardList = new ArrayList<>();
    String sql = "SELECT post_idx, post_title, post_writer, post_content, post_date, post_visits, post_ofile, post_sfile, post_dn_count, cate_no ";
    sql += "FROM blog_board ";
    sql += "ORDER BY post_idx DESC ";
    sql += "LIMIT ?, ?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, startNum);
      pstmt.setInt(2, postSize);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        MyBlogDTO board = new MyBlogDTO();
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
//    String sql = "SELECT post_idx, post_title, post_writer, post_content, post_date, post_visits, post_ofile, post_sfile, post_dn_count, cate_no ";
//    sql += "FROM blog_board ";
//    sql += "WHERE post_idx = ? ";

    String sql = "SELECT post_idx, post_title, post_writer, post_content, post_date, post_visits, post_ofile, post_sfile, post_dn_count, board.cate_no, cate.post_cate ";
    sql += "FROM blog_board as board LEFT OUTER JOIN blog_category as cate ";
    sql += "ON board.cate_no = cate.cate_no ";
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
        board.setPostCate(rs.getString("post_cate"));
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
  // ***************************************//

  // **************카테 페이지**************//

  // 카테 글 목록
  public List<MyBlogDTO> selectCateBoardList(int cateNo) {
    List<MyBlogDTO> boardList = new ArrayList<>();
    String sql = "SELECT post_idx, post_title, post_writer, post_content, post_date, post_visits, post_ofile, post_sfile, post_dn_count, board.cate_no, cate.post_cate ";
    sql += "FROM blog_board as board LEFT OUTER JOIN blog_category as cate ";
    sql += "ON board.cate_no = cate.cate_no ";
    sql += "WHERE cate.cate_no = ? ";
    sql += "ORDER BY post_idx DESC ";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cateNo);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        MyBlogDTO board = new MyBlogDTO();
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
        board.setPostCate(rs.getString("post_cate"));
        boardList.add(board);
      }

    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다.*****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return boardList;
  }
  // 페이징 처리 카테 글 목록
  public List<MyBlogDTO> selectCateBoardList(int cateNo, int startNum, int postSize) {
    List<MyBlogDTO> boardList = new ArrayList<>();
    String sql = "SELECT post_idx, post_title, post_writer, post_content, post_date, post_visits, post_ofile, post_sfile, post_dn_count, board.cate_no, cate.post_cate ";
    sql += "FROM blog_board as board LEFT OUTER JOIN blog_category as cate ";
    sql += "ON board.cate_no = cate.cate_no ";
    sql += "WHERE cate.cate_no = ? ";
    sql += "ORDER BY post_idx DESC ";
    sql += "LIMIT ?, ? ";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cateNo);
      pstmt.setInt(2, startNum);
      pstmt.setInt(3, postSize);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        MyBlogDTO board = new MyBlogDTO();
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
        board.setPostCate(rs.getString("post_cate"));
        boardList.add(board);
      }

    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다.*****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return boardList;
  }


  // 해당 카테 최근 글
  public MyBlogDTO selectCateMaxPostIdxBoard(int cateNo) {
    MyBlogDTO board = new MyBlogDTO();

    String sql = "SELECT post_idx, post_title, post_writer, post_content, post_date, post_visits, post_ofile, post_sfile, post_dn_count, board.cate_no, cate.post_cate ";
    sql += "FROM blog_board as board LEFT OUTER JOIN blog_category as cate ";
    sql += "ON board.cate_no = cate.cate_no ";
    sql += "WHERE post_idx = (SELECT MAX(post_idx) FROM blog_board WHERE cate_no = ?) ";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cateNo);
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
        board.setPostCate(rs.getString("post_cate"));
      }
    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return board;
  }

  // 카테 글 읽기 : selectCateBoardList()에서 카테고리별로 분류했기 때문에 selectBoardDetail(idx) 수정없이 사용
  // ***************************************//


  // 데이터 베이스에 글등록하기(글쓰기)
  public int insertBoard(MyBlogDTO board) {
    int result = 0;

    String sql = "INSERT INTO blog_board (post_title, post_writer, post_content, post_date, post_ofile, post_sfile, cate_no) ";
    sql += "VALUES (?, ?, ?, NOW(), ?, ?, ?) ";

    try {
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, board.getPostTitle());
      pstmt.setString(2, board.getPostWriter());
      pstmt.setString(3, board.getPostContent());
      pstmt.setString(4, board.getPostOfile());
      pstmt.setString(5, board.getPostSfile());
      pstmt.setInt(6, board.getCateNo());

      result = pstmt.executeUpdate();

    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에 INSERT 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + " *****");
      e.printStackTrace();
    }
    return result;
  }

  // 게시물 삭제
  public int deleteBoard(int postIdx) {
    int result = 0;
    String sql = "DELETE FROM blog_board WHERE post_idx = ?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, postIdx);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 DELETE 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + "*****");
      e.printStackTrace();
    }
    return result;
  }

  // 게시글 수정
  public int updateBoard(MyBlogDTO board) {
    int result = 0;
    String sql = "UPDATE blog_board ";
    sql += "SET post_title = ?, post_content = ?, cate_no = ?, ";
    sql += "post_ofile = ?, post_sfile = ? ";
    sql += "WHERE post_idx = ? ";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, board.getPostTitle());
      pstmt.setString(2, board.getPostContent());
      pstmt.setInt(3, board.getCateNo());
      pstmt.setString(4, board.getPostOfile());
      pstmt.setString(5, board.getPostSfile());
      pstmt.setInt(6, board.getPostIdx());

      result = pstmt.executeUpdate();

    } catch (SQLException e){
      System.out.println("***** 데이터 베이스에서 UPDATE 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + "*****");
      e.printStackTrace();
    }
    return result;
  }

  // 조회수 업데이트
  public void updateBoardVisits(int postIdx) {
    String sql = "UPDATE blog_board SET post_visits = post_visits + 1 WHERE post_idx = ? ";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, postIdx);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 UPDATE 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + "*****");
      e.printStackTrace();
    }
  }

  // 파일 다운로드 수 업데이트
  public void updateBoardDnCnt(int postIdx) {
    String sql = "UPDATE blog_board SET post_dn_count = post_dn_count + 1 WHERE post_idx = ? ";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, postIdx);
      pstmt.executeUpdate();

    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 UPDATE 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + "*****");
      e.printStackTrace();
    }
  }

  // 페이징 처리 - 전체 게시물 수
  public int totalCount() {
    int result = 0;
    String sql = "SELECT count(*) AS cnt FROM blog_board ";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        result = rs.getInt("cnt");
      }
    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + "*****");
    }
    return result;
  }

  // 페이징 처리 - 카테고리당 게시물 수
  public int totalCateCount(int cateNo) {
    int result = 0;
    String sql = "SELECT count(*) AS cnt FROM blog_board WHERE cate_no = ?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cateNo);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        result = rs.getInt("cnt");
      }
    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + "*****");
    }
    return result;
  }

  // 카테고리 정보
  public List<MyBlogDTO> getCategory() {
    List<MyBlogDTO> cateList = new ArrayList<>();
    String sql = "SELECT cate_no, post_cate FROM blog_category ";
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        MyBlogDTO cate = new MyBlogDTO();
        cate.setCateNo(rs.getInt("cate_no"));
        cate.setPostCate(rs.getString("post_cate"));
        cateList.add(cate);
      }
    } catch (SQLException e) {
      System.out.println("***** 데이터 베이스에서 SELECT 중 오류가 발생했습니다. *****");
      System.out.println("***** Error : " + e.getMessage() + "*****");
      e.printStackTrace();
    }
    return cateList;
  }
}
