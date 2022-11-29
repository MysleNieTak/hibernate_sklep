package model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.table.TableRowSorter;
import java.util.Scanner;

public class Main_usunProdukt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            System.out.println("Podaj ID produktu, który chcesz usunąć:");
            Long id = Long.parseLong(scanner.nextLine());

            



        }


    }
}
