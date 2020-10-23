package com.example.demo.viewmodels;

public class BaseViewModel {
    private String pageTitle;
    private String pageHeader;


    public BaseViewModel() {
        this("Default", "Default");
    }

    public BaseViewModel(String pageTitle, String pageHeader) {
        setPageHeader(pageHeader);
        setPageTitle(pageTitle);
    }


    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageHeader() {
        return pageHeader;
    }

    public void setPageHeader(String pageHeader) {
        this.pageHeader = pageHeader;
    }

}
