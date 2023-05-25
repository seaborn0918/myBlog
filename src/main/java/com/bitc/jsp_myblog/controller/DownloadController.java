package com.bitc.jsp_myblog.controller;

import com.bitc.jsp_myblog.model.MyBlogDAO;
import com.bitc.jsp_myblog.util.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/view/download.do")
public class DownloadController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String ofile = req.getParameter("ofile");
    String sfile = req.getParameter("sfile");
    int postIdx = Integer.parseInt(req.getParameter("idx"));

    FileUtils.download(req, resp, "C:\\upload", sfile, ofile);

    MyBlogDAO dao = new MyBlogDAO();
    dao.updateBoardDnCnt(postIdx);
    dao.close();
  }
}
