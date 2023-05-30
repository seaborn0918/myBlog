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
import java.util.List;

@WebServlet("/view/write.do")
public class WriteController extends HttpServlet {
  // 글쓰기 버튼 클릭시 get 방식으로 write.do
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 카테고리 출력 위한 db 연결
    MyBlogDAO dao = new MyBlogDAO();
    List<MyBlogDTO> cateList = dao.getCategory();
    dao.close();
    req.setAttribute("category", cateList);
    req.getRequestDispatcher("/view/write.jsp").forward(req, resp);
  }

  // 글 등록 버튼 클릭 시
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = (String) session.getAttribute("userName");

    String saveDir = "C:\\upload";
    int maxSize = 10 * 10224 * 1024;
    MultipartRequest mr = FileUtils.uploadFile(req, saveDir, maxSize);
    if (mr == null) {
      JSFunc.alertLocation(resp, "첨부 파일의 크기가 큽니다.", "/view/write.do");
      return;
    }

    MyBlogDTO board = new MyBlogDTO();
    board.setCateNo(Integer.parseInt(mr.getParameter("cateBox")));
    board.setPostTitle(mr.getParameter("title"));
    board.setPostWriter(userName);
    board.setPostContent(mr.getParameter("content"));
    // 파일 이름
    String fileName = mr.getFilesystemName("file");
    if (fileName != null) {
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

    if (result == 1) {
      JSFunc.alertLocation(resp, "글이 등록되었습니다.", "/view/catePage.do?cateNo=" + board.getCateNo());
    } else {
      JSFunc.alertBack("잘못된 입력입니다.", resp);
    }
  }
}
