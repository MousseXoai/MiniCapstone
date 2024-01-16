/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Blog {
    private int maBlog;
    private String title;
    private String content;
    private String author;
    private Date dateBlog;
    private String image1;
    private String image2;
    private String image3;
    private int view;

    public Blog() {
    }

    public Blog(int maBlog, String title, String content, String author, Date dateBlog, String image1, String image2, String image3, int view) {
        this.maBlog = maBlog;
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateBlog = dateBlog;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.view = view;
    }

    public int getMaBlog() {
        return maBlog;
    }

    public void setMaBlog(int maBlog) {
        this.maBlog = maBlog;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateBlog() {
        return dateBlog;
    }

    public void setDateBlog(Date dateBlog) {
        this.dateBlog = dateBlog;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    
    
}
