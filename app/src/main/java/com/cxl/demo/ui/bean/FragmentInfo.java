package com.cxl.demo.ui.bean;

/**
 * Created by Administrator on 2018/2/28.
 */

public class FragmentInfo {

    public String title;
    public Class  fragmet;

    public FragmentInfo(String title, Class fragmet) {
        this.title = title;
        this.fragmet = fragmet;
    }

    public Class getFragmet() {

        return fragmet;
    }

    public void setFragmet(Class fragmet) {
        this.fragmet = fragmet;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
