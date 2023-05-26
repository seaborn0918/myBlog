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

@WebServlet("/view/cateView.do")
public class CateBoardViewController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int postIdx = Integer.parseInt(req.getParameter("idx"));
    int cateNo = Integer.parseInt(req.getParameter("cateNo"));

    MyBlogDAO dao = new MyBlogDAO();

    // 페이징 처리
    int totalCount = dao.totalCateCount(cateNo); // 해당 카테고리 게시물 수
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

    List<MyBlogDTO> cateBoardList = dao.selectCateBoardList(cateNo, start, pageSize); // 페이징 처리 카테 목록
    dao.updateBoardVisits(postIdx); // 조회수 업데이트

    MyBlogDTO cateBoard = dao.selectBoardDetail(postIdx);
    dao.close();

    String pagingBlock = PagingBlock.catePagingStr(totalCount, pageSize, blockPage, pageNum, "/view/catePage.do?cateNo=" + cateNo);

    req.setAttribute("cateBoardList", cateBoardList);
    req.setAttribute("pagingBlock", pagingBlock);
    req.setAttribute("cateBoard", cateBoard);
    req.setAttribute("cateNo", cateNo);
    req.getRequestDispatcher("/view/catePage.jsp").forward(req, resp);
  }
}
