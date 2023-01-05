package pl.sdacademy.dao;

import pl.sdacademy.HibernateUtil;
import pl.sdacademy.entity.Book;
import pl.sdacademy.entity.Publisher;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class BookRepositoryImpl implements Repository<Book, Integer> {




    EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
    Scanner scanner = new Scanner(System.in);
    @Override
    public Book findById( ) {
        System.out.println("Type ID of the boook: ");

        int lookingId = scanner.nextInt();
        entityManager.getTransaction().begin();
        Book result = entityManager.find(Book.class, lookingId);
        entityManager.close();
        System.out.println(result);
        return result;

    }

    @Override
    public List<Book> findAll() {
        entityManager.getTransaction().begin();
        List<Book> result = entityManager.createQuery("from Book", Book.class).getResultList();
        entityManager.close();
        for (Book book : result) {
            System.out.println(book);
        }
        return result;

    }

    @Override
    public void persist() {
        System.out.println("Type book title:");
        Scanner scanner = new Scanner(System.in);
        String book_title = scanner.nextLine();

        System.out.println("Type book ISBN:");
        String book_ISBN = scanner.nextLine();

        System.out.println("Type pubisher");
        String book_publisher = scanner.nextLine();
        Publisher publisher = new Publisher(book_publisher);

        Book book = new Book(book_title,book_ISBN,publisher);
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);

        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void delete( ) {
        System.out.println("Type title of the boook: ");

        String titleToDelete = scanner.nextLine();
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE from Book b where b.title= :t")
                .setParameter("t", titleToDelete).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
