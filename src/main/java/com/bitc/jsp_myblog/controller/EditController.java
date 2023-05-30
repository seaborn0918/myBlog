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
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/view/edit.do")
public class EditController extends HttpServlet {
  // 글읽기 페이지에서 수정 버튼 클릭 시
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int postIdx = Integer.parseInt(req.getParameter("idx"));
    // int cateNo = Integer.parseInt(req.getParameter("cateNo"));

    MyBlogDAO dao = new MyBlogDAO();
    MyBlogDTO board = dao.selectBoardDetail(postIdx);
    List<MyBlogDTO> cateList = dao.getCategory();
    dao.close();

    req.setAttribute("cateBoard", board);
    req.setAttribute("category", cateList);
    req.getRequestDispatcher("/view/edit.jsp").forward(req, resp);
  }

  // 수정페이지에서 글 등록 버튼 클릭 시
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String saveDir = "C:\\upload";
    int maxSize = 10 * 10224 * 1024;
    MultipartRequest mr = FileUtils.uploadFile(req, saveDir, maxSize);
    if (mr == null){
      JSFunc.alertLocation(resp, "첨부 파일의 크기가 큽니다.", "/view/edit.do");
      return;
    }

    MyBlogDTO board = new MyBlogDTO();
    board.setCateNo(Integer.parseInt(mr.getParameter("cateBox")));
    board.setPostTitle(mr.getParameter("title"));
    board.setPostContent(mr.getParameter("content"));
    board.setPostIdx(Integer.parseInt(mr.getParameter("idx")));
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
    int result = dao.updateBoard(board);
    dao.close();
    if (result == 1) {
      JSFunc.alertLocation(resp, "수정되었습니다.", "/view/cateView.do?idx=" + board.getPostIdx() +"&cateNo=" + board.getCateNo());
    } else {
      JSFunc.alertBack("잘못된 입력입니다.", resp);
    }
  }
}
