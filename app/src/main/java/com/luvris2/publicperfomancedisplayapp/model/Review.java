package com.luvris2.publicperfomancedisplayapp.model;

import java.io.Serializable;
import java.util.List;

public class Review implements Serializable{
    // 공연 ID, 작성자, 리뷰 내용
    private String mt20id, userName, title, content, imgUrl;

    private int userId; // 작성자 식별 ID
    private String nickname, nickName; // 작성자 닉네임
    private String prfName; // 통신을 줄이기 위한 공연 제목 저장 변수
    private int verified; // 실제 관람 인증 여부
    private double rating; // 평점
    private String result; // API 결과 저장 변수
    private List<Review> resultList; // API 결과 저장 배열


    public Review() { }
    public Review(List<Review> resultList) {
        this.resultList = resultList;
    }
    public Review(String result) {
        this.result = result;
    }
    public Review(String title, String content, String imgUrl, String prfName, int verified, double rating) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.prfName = prfName;
        this.verified = verified;
        this.rating = rating;
    }

    public String getPrfName() {
        return prfName;
    }

    public void setPrfName(String prfName) {
        this.prfName = prfName;
    }

    public String getMt20id() {
        return mt20id;
    }

    public void setMt20id(String mt20id) {
        this.mt20id = mt20id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Review> getResultList() {
        return resultList;
    }

    public void setResultList(List<Review> resultList) {
        this.resultList = resultList;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
