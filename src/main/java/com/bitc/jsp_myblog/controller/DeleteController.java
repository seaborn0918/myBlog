package com.bitc.jsp_myblog.controller;

import com.bitc.jsp_myblog.model.MyBlogDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/view/delete.do")
public class DeleteController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int postIdx = Integer.parseInt(req.getParameter("idx"));
    int cateNo = Integer.parseInt(req.getParameter("cateNo"));

    MyBlogDAO dao = new MyBlogDAO();
    int result = dao.deleteBoard(postIdx);
    dao.close();
    if (result == 1) {
      resp.sendRedirect("/view/catePage.do?cateNo=" + cateNo);
    }
  }
}
