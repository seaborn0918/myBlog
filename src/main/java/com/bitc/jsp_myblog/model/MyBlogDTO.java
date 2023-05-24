package com.bitc.jsp_myblog.model;

public class MyBlogDTO {
  // 유저 정보
  private String id;
  private String pass;
  private String name;
  private int grade;

  // 블로그 게시글
  private int postIdx;
  private String postTitle;
  private String postWriter;
  private String postContent;
  private String postDate;
  private int postVisits;
  private String postOfile;
  private String postSfile;
  private int postDnCount;
  private int cateNo;

  // 방명록
  private int contactIdx;
  private String contactWriter;
  private String contactEmail;
  private String contactContent;
  private String contactDate;

  // 유저 정보 getter, setter
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  // 블로그 게시물 getter, setter
  public int getPostIdx() {
    return postIdx;
  }

  public void setPostIdx(int postIdx) {
    this.postIdx = postIdx;
  }

  public String getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(String postTitle) {
    this.postTitle = postTitle;
  }

  public String getPostWriter() {
    return postWriter;
  }

  public void setPostWriter(String postWriter) {
    this.postWriter = postWriter;
  }

  public String getPostContent() {
    return postContent;
  }

  public void setPostContent(String postContent) {
    this.postContent = postContent;
  }

  public String getPostDate() {
    return postDate;
  }

  public void setPostDate(String postDate) {
    this.postDate = postDate;
  }

  public int getPostVisits() {
    return postVisits;
  }

  public void setPostVisits(int postVisits) {
    this.postVisits = postVisits;
  }

  public String getPostOfile() {
    return postOfile;
  }

  public void setPostOfile(String postOfile) {
    this.postOfile = postOfile;
  }

  public String getPostSfile() {
    return postSfile;
  }

  public void setPostSfile(String postSfile) {
    this.postSfile = postSfile;
  }

  public int getPostDnCount() {
    return postDnCount;
  }

  public void setPostDnCount(int postDnCount) {
    this.postDnCount = postDnCount;
  }

  public int getCateNo() {
    return cateNo;
  }

  public void setCateNo(int cateNo) {
    this.cateNo = cateNo;
  }

  // 방명록 getter, setter
  public int getContactIdx() {
    return contactIdx;
  }

  public void setContactIdx(int contactIdx) {
    this.contactIdx = contactIdx;
  }

  public String getContactWriter() {
    return contactWriter;
  }

  public void setContactWriter(String contactWriter) {
    this.contactWriter = contactWriter;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public String getContactContent() {
    return contactContent;
  }

  public void setContactContent(String contactContent) {
    this.contactContent = contactContent;
  }

  public String getContactDate() {
    return contactDate;
  }

  public void setContactDate(String contactDate) {
    this.contactDate = contactDate;
  }
}
