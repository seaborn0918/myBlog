package com.bitc.jsp_myblog.util;

import com.oreilly.servlet.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileUtils {
  public static MultipartRequest uploadFile(HttpServletRequest req, String saveDire, int maxSize) {
    try {
      return new MultipartRequest(req, saveDire, maxSize, "UTF-8");
    } catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }


  public static void download(HttpServletRequest req, HttpServletResponse resp, String saveDir, String sfileName, String ofileName) {
    try {
      File file = new File(saveDir, sfileName);
      InputStream iStream = new FileInputStream(file);
      String client = req.getHeader("User-Agent");
      if (client.indexOf("WOW64") == -1) {
        ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
      } else {
        ofileName = new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");
      }

      resp.reset();
      resp.setContentType("application/octet-stream");
      resp.setHeader("Content-Disposition", "attachment; filename=\"" + ofileName + "\"");
      resp.setHeader("Content-Length", "" + file.length());

      OutputStream oStream = resp.getOutputStream();

      byte[] b = new byte[(int) file.length()];
      int readBuffer = 0;
      while ((readBuffer = iStream.read(b)) > 0) {
        oStream.write(b, 0, readBuffer);
      }
      iStream.close();
      oStream.close();

    } catch (FileNotFoundException e) {
      System.out.println("***** 다운로드할 파일을 찾을 수 없습니다. *****");
    } catch (Exception e) {
      System.out.println("***** 파일 다운로드 중 오류가 발생했습니다. *****");
      e.printStackTrace();
    }
  }
}

