package cn.book.domain;

public class Book {
    private String bid;
    private String bname;
    private Double price;
    private int category;



    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
