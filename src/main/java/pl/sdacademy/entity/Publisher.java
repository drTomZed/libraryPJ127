package pl.sdacademy.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Integer publisherId;

    @Column(name = "name")
    private String publisherName;

    public Publisher() {
    };

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;


    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher " +
                "publisherId= " + publisherId +
                ", publisherName= '" + publisherName + '\'';
    }
}