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

@WebServlet("/view/view.do")
public class MainBoardViewController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    int idx = Integer.parseInt(req.getParameter("idx"));

    MyBlogDAO dao = new MyBlogDAO();

    List<MyBlogDTO> boardList = dao.selectBoardList();

    dao.updateBoardVisits(idx);

    MyBlogDTO board = dao.selectBoardDetail(idx);
    dao.close();

    req.setAttribute("boardList", boardList);
    req.setAttribute("mainBoard", board);
    req.getRequestDispatcher("/view/main.jsp").forward(req, resp);
  }
}
