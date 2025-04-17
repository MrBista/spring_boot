package org.example.model;

public class Product {
    private Long id;
    private String name;
    private String author;
    private int yearPublished;
    private String desc;

    public Product() {
    }

    public Product(Long id, String name, String author, int yearPublished, String desc) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", desc='" + desc + '\'' +
                '}';
    }
}
