package com.bitc.jsp_myblog.controller;

import com.bitc.jsp_myblog.model.MyBlogDAO;
import com.bitc.jsp_myblog.model.MyBlogDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    List<MyBlogDTO> boardList = dao.selectBoardList();
    MyBlogDTO maxPostIdxBoard = dao.selectMaxPostIdxBoard();
    dao.close();

    req.setAttribute("boardList", boardList);
    req.setAttribute("maxPostIdxBoard", maxPostIdxBoard);
    req.getRequestDispatcher("/view/main.jsp").forward(req, resp);
  }
}
