package com.bitc.jsp_myblog.controller;

import com.bitc.jsp_myblog.model.MyBlogDAO;
import com.bitc.jsp_myblog.util.JSFunc;

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

    String cateNoStr = req.getParameter("cateNo");


    if (cateNoStr == null){
      MyBlogDAO dao = new MyBlogDAO();
      int result = dao.deleteBoard(postIdx);
      dao.close();
      if (result == 1) {
        resp.sendRedirect("/view/main.do");
      } else {
        JSFunc.alertBack("삭제 중 오류가 발생했습니다.", resp);
      }
    } else {
      int cateNo = Integer.parseInt(req.getParameter("cateNo"));

      MyBlogDAO dao = new MyBlogDAO();
      int result = dao.deleteBoard(postIdx);
      dao.close();
      if (result == 1) {
        resp.sendRedirect("/view/catePage.do?cateNo=" + cateNo);
      } else {
        JSFunc.alertBack("삭제 중 오류가 발생했습니다.", resp);
      }
    }


  }
}
