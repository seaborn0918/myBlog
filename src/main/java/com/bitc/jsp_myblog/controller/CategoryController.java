package com.bitc.jsp_myblog.controller;

import com.bitc.jsp_myblog.model.MyBlogDAO;
import com.bitc.jsp_myblog.model.MyBlogDTO;
import com.bitc.jsp_myblog.util.PagingBlock;
import com.bitc.jsp_myblog.util.PagingBoardList;

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

    // 페이징 처리
    int totalCount = dao.totalCount();
    int totalCateCount = dao.totalCateCount(cateNo); // 해당 카테고리 게시물 수
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
    MyBlogDTO cateMaxPostIdxBoard = dao.selectCateMaxPostIdxBoard(cateNo); // 해당 카테고리 가장 최신글
    dao.close();

    String pagingBlock = PagingBlock.catePagingStr(totalCateCount, pageSize, blockPage, pageNum, "/view/catePage.do?cateNo=" + cateNo);

    req.setAttribute("cateBoardList", cateBoardList);
    req.setAttribute("pagingBlock", pagingBlock);
    req.setAttribute("cateMaxPostIdxBoard", cateMaxPostIdxBoard);
    req.setAttribute("cateNo", cateNo);
    req.setAttribute("pageNum", pageNum);
    req.setAttribute("totalCount", totalCount);
    req.setAttribute("totalCateCount", totalCateCount);
    req.getRequestDispatcher("/view/catePage.jsp").forward(req, resp);
  }
}
