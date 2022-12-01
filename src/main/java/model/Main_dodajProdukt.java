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

            String kategoriaProduktu =null;
            do {
                System.out.println("Podaj kategorię produktu wielkimi literami (żywność/napoje/inne):");
                kategoriaProduktu = scanner.nextLine();
            } while (!kategoriaProduktu.equalsIgnoreCase("żywność")&& !kategoriaProduktu.equalsIgnoreCase("napoje")&&
                    !kategoriaProduktu.equalsIgnoreCase("inne"));

            Kategoria kategoria = Kategoria.valueOf(kategoriaProduktu);

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
