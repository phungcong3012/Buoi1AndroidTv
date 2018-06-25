package com.example.admin.tvdemo;

import java.net.URI;
import java.net.URISyntaxException;

public class Movie {
  private long id;
  private String title;
  private String studio;
  private int image;
  private String url;

  public Movie() {
  }

  public Movie(String title, String studio) {
    this.title = title;
    this.studio = studio;
  }

  public Movie(String title, String studio, String url) {
    this.title = title;
    this.studio = studio;
    this.url = url;
  }

  public Movie(String title, String studio, int image) {
    this.title = title;
    this.studio = studio;
    this.image = image;
  }

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStudio() {
    return studio;
  }

  public void setStudio(String studio) {
    this.studio = studio;
  }

  public String getUrl() {
    return url;
  }

  public URI getImageURI() {
    try {
      return new URI(getUrl());
    } catch (URISyntaxException e) {
      return null;
    }
  }

  @Override
  public String toString() {
    return "Movie{" +
        "id=" + id +
        ", title='" + title + '\'' +
        '}';
  }

}
