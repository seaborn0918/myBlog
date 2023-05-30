package com.bitc.jsp_myblog.controller;

import com.bitc.jsp_myblog.model.MyBlogDAO;
import com.bitc.jsp_myblog.model.MyBlogDTO;
import com.bitc.jsp_myblog.util.PagingBlock;

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

    // 페이징 처리
    int totalCount = dao.totalCount(); // 해당 카테고리 게시물 수
    int pageSize = 5; // 현재 페이지에서 출력할 최대 게시물 수
    int blockPage = 5; // 블록에서 표현할 페이지 수
    int pageNum = 1; // 현재 페이지 수 기본값
    String pageTemp = req.getParameter("pageNum");

    if (pageTemp != null && !pageTemp.equals("")) {
      pageNum = Integer.parseInt(pageTemp);
    }

    int start = (pageNum - 1) * pageSize;
    int end = pageNum * pageSize;
    //

    List<MyBlogDTO> boardList = dao.selectBoardList(start, pageSize); // 페이징 처리 카테 목록
    dao.updateBoardVisits(idx); // 조회수 업데이트

    MyBlogDTO board = dao.selectBoardDetail(idx);
    dao.close();

    String pagingBlock = PagingBlock.pagingStr(totalCount, pageSize, blockPage, pageNum, "/view/main.do");

    req.setAttribute("boardList", boardList);
    req.setAttribute("pagingBlock", pagingBlock);
    req.setAttribute("mainBoard", board);
    req.setAttribute("totalCount", totalCount);
    req.setAttribute("pageNum", pageNum);
    req.getRequestDispatcher("/view/main.jsp").forward(req, resp);
  }
}
