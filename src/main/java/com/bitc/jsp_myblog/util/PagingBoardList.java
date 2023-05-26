package com.bitc.jsp_myblog.util;

public class PagingBoardList {
  public static int pagingRange(int pageSize, int pageNum, String paramPageNum) {
    String pageTemp = paramPageNum;

    if (pageTemp != null && !pageTemp.equals("")) {
      pageNum = Integer.parseInt(pageTemp);
    }

    int start = (pageNum - 1) * pageSize;
    int end = pageNum * pageSize;
    return start;
  }
}
