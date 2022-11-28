package model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main_dodajProdukt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            System.out.println("Żeby dodać produkt, podaj nazwę:");
            String nazwa = scanner.nextLine();

            String kategoria =null;
            do {
                System.out.println("Podaj kategorię produktu (żywność/napoje/inne):");
                kategoria = scanner.nextLine();
            } while (!kategoria.equalsIgnoreCase("żywność")&& !kategoria.equalsIgnoreCase("napoje")&&
                    !kategoria.equalsIgnoreCase("inne"));

                Produkt produkt = Produkt.builder()
                        .nazwa(nazwa)
                        .kategoria(kategoria)
                        .build();

                session.persist(produkt);

            transaction.commit();
        } catch (Exception ioe){
            System.err.println("Błąd bazy: "+ ioe);
        }

    }
}
