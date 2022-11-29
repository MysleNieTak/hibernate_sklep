package model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main_wyswietlListeSprzedazy {

    public static void main(String[] args) {

        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            TypedQuery<Sprzedaz> zapytanie = session.createQuery("FROM Sprzedaz", Sprzedaz.class);
            List<Sprzedaz> lista = zapytanie.getResultList();
            lista.forEach(System.out::println);

        } catch (Exception e){
            System.err.println("Błąd bazy: "+ e);
        }


    }
}
