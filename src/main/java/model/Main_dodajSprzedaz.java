package model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main_dodajSprzedaz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ID produktu: ");
        Long id = Long.parseLong(scanner.nextLine());

        System.out.println("Podaj cenę produktu: ");
        double cena = Double.parseDouble(scanner.nextLine());

        System.out.println("Podaj liczbę zakupionych produktów");
        double liczba = Double.parseDouble(scanner.nextLine());

        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            Produkt szukanyProdukt = session.get(Produkt.class, id);

            if(szukanyProdukt!=null){

                Sprzedaz nowaSprzedaz = Sprzedaz.builder()
                        .liczba(liczba)
                        .cena(cena)
                        .build();

                session.persist(nowaSprzedaz);
            }else {
                System.out.println("Nie ma takiego produktu.");
            }

            transaction.commit();
        } catch (Exception ioe){
            System.err.println("Błąd bazy: "+ ioe);
        }

    }
}
