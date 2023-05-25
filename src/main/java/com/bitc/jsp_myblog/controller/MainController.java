package com.bitc.jsp_myblog.controller;

import com.bitc.jsp_myblog.model.MyBlogDAO;
import com.bitc.jsp_myblog.model.MyBlogDTO;
import com.bitc.jsp_myblog.util.BoardPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet("/view/main.do")
public class MainController extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doHandle(req, resp);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doHandle(req, resp);
  }

  private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    MyBlogDAO dao = new MyBlogDAO();

    // 페이징 처리
    int totalCount = dao.totalCount(); // 전체 게시물 수
    int pageSize = 5; // 현재 페이지에서 출력할 최대 게시물 수
    int blockPage = 5; // 블록에서 표현할 페이지 수
    int totalPage = (int) Math.ceil((double) totalCount / pageSize); // 전체 페이지 수
    int pageNum = 1; // 현재 페이지 수 기본값
    String pageTemp = req.getParameter("pageNum");

    if (pageTemp != null && !pageTemp.equals("")) {
      pageNum = Integer.parseInt(pageTemp);
    }

    int start = (pageNum - 1) * pageSize;
    int end = pageNum * pageSize;
    //

    List<MyBlogDTO> boardList = dao.selectBoardList(start, pageSize);
    MyBlogDTO maxPostIdxBoard = dao.selectMaxPostIdxBoard();
    dao.close();

    String pagingImg = BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, "/view/main.do");
    req.setAttribute("boardList", boardList);
    req.setAttribute("pagingImg", pagingImg);
    req.setAttribute("maxPostIdxBoard", maxPostIdxBoard);
    req.getRequestDispatcher("/view/main.jsp").forward(req, resp);
  }
}
