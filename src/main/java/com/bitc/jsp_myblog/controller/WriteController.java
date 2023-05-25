package com.bitc.jsp_myblog.controller;

import com.bitc.jsp_myblog.model.MyBlogDAO;
import com.bitc.jsp_myblog.model.MyBlogDTO;
import com.bitc.jsp_myblog.util.FileUtils;
import com.bitc.jsp_myblog.util.JSFunc;
import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/view/write.do")
public class WriteController extends HttpServlet {
  // 글쓰기 버튼 클릭시 get 방식으로 write.do
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int cateNo = Integer.parseInt(req.getParameter("cateNo"));
    req.setAttribute("cateNo", cateNo);
    req.getRequestDispatcher("/view/write.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = (String) session.getAttribute("userName");

    String saveDir = "C:\\upload";
    int maxSize = 10 * 10224 * 1024;
    MultipartRequest mr = FileUtils.uploadFile(req, saveDir, maxSize);
    if (mr == null){
      JSFunc.alertLocation(resp, "첨부 파일의 크기가 큽니다.", "/view/write.do");
      return;
    }

    MyBlogDTO board = new MyBlogDTO();
    board.setPostTitle(mr.getParameter("title"));
    board.setPostWriter(userName);
    board.setCateNo(Integer.parseInt(mr.getParameter("cateNo")));
    board.setPostContent(mr.getParameter("content"));
    // 파일 이름
    String fileName = mr.getFilesystemName("file");
    if(fileName != null){
      String now = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
      String ext = fileName.substring(fileName.lastIndexOf("."));
      String newFileName = now + ext;

      File oldFile = new File(saveDir + File.separator + fileName);
      File newFile = new File(saveDir + File.separator + newFileName);
      oldFile.renameTo(newFile);

      board.setPostOfile(fileName);
      board.setPostSfile(newFileName);
    }

    MyBlogDAO dao = new MyBlogDAO();

    int result = dao.insertBoard(board);
    dao.close();

    if(result == 1) {
      resp.sendRedirect("/view/catePage.do?cateNo=" + board.getCateNo());
    } else {
      resp.sendRedirect("/view/write.do?cateNo=" + board.getCateNo());
    }
  }
}
