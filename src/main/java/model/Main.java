package model;

public class Main {
    public static void main(String[] args) {

        HibernateUtil.INSTANCE.getSessionFactory().openSession();



    }
}