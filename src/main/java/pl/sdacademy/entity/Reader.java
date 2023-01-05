package pl.sdacademy.entity;

import javax.persistence.*;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id")
    private Integer readerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    public Reader() {
    }

    ;

    public Reader(String firstName, String lastName, String identityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
    }

    @OneToOne(mappedBy = "reader",
            fetch = FetchType.EAGER)
    private BookRegistration bookRegistration;

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public BookRegistration getBookRegistration() {
        return bookRegistration;
    }

    public void setBookRegistration(BookRegistration bookRegistration) {
        this.bookRegistration = bookRegistration;
    }

    @Override
    public String toString() {
        return "Reader: " +
                "readerId= " + readerId +
                ", firstName= '" + firstName + '\'' +
                ", lastName= '" + lastName + '\'' +
                ", identityNumber= '" + identityNumber + '\'';
    }
}