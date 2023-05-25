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

@WebServlet("/view/cateView.do")
public class CateBoardViewController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int idx = Integer.parseInt(req.getParameter("idx"));
    int cateNo = Integer.parseInt(req.getParameter("cateNo"));

    MyBlogDAO dao = new MyBlogDAO();
    List<MyBlogDTO> cateBoardList = dao.selectCateBoardList(cateNo);

    dao.updateBoardVisits(idx);

    MyBlogDTO cateBoard = dao.selectBoardDetail(idx);
    dao.close();

    req.setAttribute("cateBoardList", cateBoardList);
    req.setAttribute("cateBoard", cateBoard);
    req.setAttribute("cateNo", cateNo);
    req.getRequestDispatcher("/view/catePage.jsp").forward(req, resp);
  }
}
