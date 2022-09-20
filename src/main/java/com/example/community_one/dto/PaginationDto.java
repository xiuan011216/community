package com.example.community_one.dto;

import java.util.ArrayList;
import java.util.List;

//分页
public class PaginationDto {
    private List<QuestionDTO> questionDtoList;
    private boolean showPrevious;//上一页
    private boolean showFirstPage;//首页
    private boolean showNext;//下一页
    private boolean showEndPage;//尾页
    private Integer page;//当前页
    private   Integer totalPage;//总页
    private List<Integer> pages=new ArrayList<>();//页面数组
    private Integer totalCount;

    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage=totalPage;
        this.page=page;

        //判断当前页是那一页
        pages.add(page);
        for (int i=1;i<=3;i++){
            //头
            if (page-i>0){
                pages.add(0,page-i);
            }
            //尾
            if (page+i<=totalPage){
                pages.add(page+i);
            }
        }

        //判断是否显示前一页
        if (page==1){
            showPrevious=false;
        }else {
            showPrevious=true;
        }
        //判断是否显示后一页
        if (page==totalPage){
            showNext=false;
        }else {
            showNext=true;
        }
        //判断是否显示首页
        if (pages.contains(1)){
            showFirstPage=false;
        }else {
            showFirstPage=true;
        }
        //判断是否显示尾页
        if (pages.contains(totalCount)){
            showEndPage=false;
        }else {
            showEndPage=true;
        }
    }

    public List<QuestionDTO> getQuestionDtoList() {
        return questionDtoList;
    }

    public void setQuestionDtoList(List<QuestionDTO> questionDtoList) {
        this.questionDtoList = questionDtoList;
    }

    public boolean isShowPrevious() {
        return showPrevious;
    }

    public void setShowPrevious(boolean showPrevious) {
        this.showPrevious = showPrevious;
    }

    public boolean isShowFirstPage() {
        return showFirstPage;
    }

    public void setShowFirstPage(boolean showFirstPage) {
        this.showFirstPage = showFirstPage;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowEndPage() {
        return showEndPage;
    }

    public void setShowEndPage(boolean showEndPage) {
        this.showEndPage = showEndPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }
    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}