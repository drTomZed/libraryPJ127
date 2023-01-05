package pl.sdacademy.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="book_registration")
public class BookRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_record_id")
    private Integer bookRecordId;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column
    private LocalDate borrowDate;

    public BookRegistration(String registrationNumber, LocalDate borrowDate, Book book, Reader reader) {
        this.registrationNumber = registrationNumber;
        this.borrowDate = borrowDate;
        this.book = book;
        this.reader = reader;
    }
    public BookRegistration(){};


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Integer getBookRecordId() {
        return bookRecordId;
    }

    public void setBookRecordId(Integer bookRecordId) {
        this.bookRecordId = bookRecordId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "BookRegistration: " +
                "bookRecordId= " + bookRecordId +
                ", registrationNumber= '" + registrationNumber + '\'' +
                ", borrowDate= " + borrowDate +
                ", book= " + book +
                ", reader= " + reader;
    }
}