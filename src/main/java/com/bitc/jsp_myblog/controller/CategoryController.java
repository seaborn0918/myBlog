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

@WebServlet("/view/catePage.do")
public class CategoryController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int cateNo = Integer.parseInt(req.getParameter("cateNo"));

    MyBlogDAO dao = new MyBlogDAO();
    List<MyBlogDTO> cateBoardList = dao.selectCateBoardList(cateNo); // 해당 카테고리 게시글 목록
    MyBlogDTO cateMaxPostIdxBoard = dao.selectCateMaxPostIdxBoard(cateNo); // 해당 카테고리 가장 최신글
    dao.close();

    req.setAttribute("cateBoardList", cateBoardList);
    req.setAttribute("cateMaxPostIdxBoard", cateMaxPostIdxBoard);
    req.setAttribute("cateNo", cateNo);

    req.getRequestDispatcher("/view/catePage.jsp").forward(req, resp);
  }
}
