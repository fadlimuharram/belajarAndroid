package com.example.fadli.viewpager;

/**
 * Created by fadli on 3/7/18.
 */

public class News {
    private String id;
    private String slug;
    private String title;
    private String author_name;
    private String description;
    private String date;
    private String link;
    private String thumbnail;
    private String total_view;

    public News(String id, String slug, String title, String author_name, String description, String date, String link, String thumbnail, String total_view) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.author_name = author_name;
        this.description = description;
        this.date = date;
        this.link = link;
        this.thumbnail = thumbnail;
        this.total_view = total_view;
    }

    public News() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desctiprion) {
        this.description = desctiprion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTotal_view() {
        return total_view;
    }

    public void setTotal_view(String total_view) {
        this.total_view = total_view;
    }


}
