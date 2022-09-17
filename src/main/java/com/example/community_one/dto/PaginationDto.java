package com.example.community_one.dto;

import java.util.ArrayList;
import java.util.List;

//分页
public class PaginationDto {
    private List<QuestionDto> questions;
    private boolean showPrevious;//上一页
    private boolean showFirstPage;//首页
    private boolean showNext;//下一页
    private boolean showEndPage;//尾页
    private Integer page;//当前页
    private   Integer totalPage;//总页
    private List<Integer> pages=new ArrayList<>();//页面数组

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        //判断要显示的是否可以整除
        if (totalCount%size==0){
            totalPage=totalCount/size;
        }else {
            totalPage=totalCount/size+1;
        }
        //进行错误操作判断
        if (page<1){
            page=1;
        }
        if (page>totalPage){
            page=totalPage;
        }
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


    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
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
}
