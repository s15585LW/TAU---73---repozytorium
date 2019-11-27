package WalenskiCorp;

import java.util.Objects;

public class Kajet {
    private Long id;
    private Integer pages;
    private String type_of_pages;
    private String color;
    private long addTime;
    private long updateTime;
    private long readTime;


    public Kajet() {
    }

    public Kajet(Long id, Integer pages, String type_of_pages, String color) {
        this.id = id;
        this.pages = pages;
        this.type_of_pages = type_of_pages;
        this.color = color;
    }

    public Kajet(Long id, Integer pages, String type_of_pages, String color, long addTime, long updateTime, long readTime) {
        this.id = id;
        this.pages = pages;
        this.type_of_pages = type_of_pages;
        this.color = color;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.readTime = readTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getType_of_pages() {
        return type_of_pages;
    }

    public void setType_of_pages(String type_of_pages) {
        this.type_of_pages = type_of_pages;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getReadTime() {
        return readTime;
    }

    public void setReadTime(long readTime) {
        this.readTime = readTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kajet)) return false;
        Kajet kajet = (Kajet) o;
        return getId().equals(kajet.getId()) &&
                getPages().equals(kajet.getPages()) &&
                getType_of_pages().equals(kajet.getType_of_pages()) &&
                getColor().equals(kajet.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPages(), getType_of_pages(), getColor());
    }
}