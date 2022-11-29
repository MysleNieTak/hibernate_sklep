package model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class Main_wyswietlListeProduktow {
    public static void main(String[] args) {
        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){

            TypedQuery<Produkt> zapytanie = session.createQuery("FROM Produkt", Produkt.class);
            List<Produkt> lista = zapytanie.getResultList();
            lista.forEach(System.out::println);

        } catch (Exception e){
            System.err.println("Błąd bazy: "+e);
        }
    }
}
