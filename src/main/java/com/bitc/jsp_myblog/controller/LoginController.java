package com.bitc.jsp_myblog.controller;

import com.bitc.jsp_myblog.model.MyBlogDAO;
import com.bitc.jsp_myblog.model.MyBlogDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/view/login.do")
public class LoginController extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userId = req.getParameter("userId");
    String userPw = req.getParameter("userPw");

    MyBlogDAO dao = new MyBlogDAO();
    int selectResult = dao.isMember(userId, userPw);
    if (selectResult == 1) {
      MyBlogDTO member = dao.selectMember(userId, userPw);
      dao.close();

      HttpSession session = req.getSession();
      session.setAttribute("userId", member.getId());
      session.setAttribute("userPw", member.getPass());

      req.getRequestDispatcher("/view/main.do").forward(req, resp);
    }
  }
}
