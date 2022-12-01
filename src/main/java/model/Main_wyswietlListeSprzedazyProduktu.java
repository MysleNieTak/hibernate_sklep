package model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main_wyswietlListeSprzedazyProduktu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){

            System.out.println("Podaj ID produktu, żeby poznać sprzedaż:");
            String id = scanner.nextLine();
            TypedQuery<Sprzedaz> zapytanie = session.createQuery("FROM Sprzedaz WHERE i ", Sprzedaz.class);




        }
    }

}
