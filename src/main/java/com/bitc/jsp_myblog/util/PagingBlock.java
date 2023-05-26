package com.bitc.jsp_myblog.util;

public class PagingBlock {
  public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
    String pagingStr = "";
    int totalPages = (int) (Math.ceil((double) totalCount / pageSize));

    int pageTemp = (((pageNum -1) /blockPage) * blockPage) +1;
    if (pageTemp != 1){
      pagingStr += "<a href='" + reqUrl + "?pageNum=" + (pageNum-1) +"'>이전</a>";
    }
    int blockCount = 1;
    while (blockCount <= blockPage && pageTemp <= totalPages){
      if (pageTemp == pageNum){
        pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
      } else {
        pagingStr += "&nbsp;<a href ='"+ reqUrl +"?pageNum=" + pageTemp + "' class=' text-decoration-none pagingNum'>"+ pageTemp +"</a>&nbsp;";
      }
      pageTemp++;
      blockCount++;
    }
    if (pageTemp <= totalPages){
      pagingStr += "<a href='" + reqUrl + "?pageNum=" + pageTemp +"'>다음</a>";
    }
    return pagingStr;
  }

  // cateNo 값을 받아야하기 때문에 추가 생성
  public static String catePagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
    String pagingStr = "";
    int totalPages = (int) (Math.ceil((double) totalCount / pageSize));

    int pageTemp = (((pageNum -1) /blockPage) * blockPage) +1;
    if (pageTemp != 1){
      pagingStr += "<a href='" + reqUrl + "&pageNum=" + (pageNum-1) +"'>이전</a>";
    }
    int blockCount = 1;
    while (blockCount <= blockPage && pageTemp <= totalPages){
      if (pageTemp == pageNum){
        pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
      } else {
        pagingStr += "&nbsp;<a href ='"+ reqUrl +"&pageNum=" + pageTemp + "' class=' text-decoration-none pagingNum'>"+ pageTemp +"</a>&nbsp;";
      }
      pageTemp++;
      blockCount++;
    }
    if (pageTemp <= totalPages){
      pagingStr += "<a href='" + reqUrl + "&pageNum=" + pageTemp +"'>다음</a>";
    }
    return pagingStr;
  }
}
