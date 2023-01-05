package pl.sdacademy;

import pl.sdacademy.dao.BookRepositoryImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Usun ksiazke");
            System.out.println("2. Dodaj ksiazke");
            System.out.println("3. Znajdz ksiazke po id");
            System.out.println("4. Wypisz wszyskie ksiazki");
            System.out.println("0. Wyjdz");
            System.out.print("Wybierz opcje: ");
            option = scanner.nextInt();
            BookRepositoryImpl bookRepositoryImpl = new BookRepositoryImpl();
            switch (option) {
                case 1:
                    bookRepositoryImpl.delete();
                    break;
                case 2:
                    bookRepositoryImpl.persist();
                    break;
                case 3:
                    bookRepositoryImpl.findById();
                    break;
                case 4:
                    bookRepositoryImpl.findAll();
                    break;
                case 0:
                    System.out.println("Koniec programu");
                    break;
                default:
                    System.out.println("Niepoprawny wybor");
            }
        } while (option != 0);
        HibernateUtil.shutdown();
    }
}
