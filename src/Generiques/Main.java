package Generiques;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<Double> list = tweens(1.2, 2.2, 10);
        assert list.size() == 11;
        for (var elem : list) {
            System.out.println(elem);
        }

        var present = trouverElement(list.toArray(), 1.2);
        if (present.estQQChose()) {
            try {
                System.out.println(present.qQChose());
            } catch (Exception e) {
                System.exit(-1);
            }
        }
        var absent = trouverElement(list.toArray(), 20.0);

        if (absent.estRien()) {
            try {
                System.out.println(absent.getClass());
                absent.qQChose();
            } catch (Exception e) {
                System.out.println("il n'y avait pas l'objet !");
            }
        }

        var opPresent = trouverElementOptional(list.toArray(), 2.2);

        if(opPresent.isPresent()) {
            System.out.println(opPresent.get());
        }

        var opAbsent = trouverElementOptional(list.toArray(), 1.56);
        if (opAbsent.isEmpty()) {
            System.out.println("pas d'objet :/");
        }
    }

    public static <T> PeutEtre<Integer> trouverElement(T[] tableau, T element) {
        for ( int i = 0; i < tableau.length; ++i ) {
            if (tableau[i].equals(element)) {
                return new QQChose<>(i);
            }
        }

        return new Rien<>();
    }

    public static <T> Optional<Integer> trouverElementOptional(T[] a_tableau, T a_element ) {
        for (int i = 0; i < a_tableau.length; ++i) {
            if (a_tableau[i].equals(a_element)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public static ArrayList<Double> tweens(double depart, double fin, int nombreIterval) {
        ArrayList<Double> list = new ArrayList<>();
        list.add(depart);
        double aAjouter = (fin - depart) / nombreIterval;
        for (int i = 1; i <= nombreIterval; ++i) {
            list.add(depart + aAjouter * i);
        }

        return list;
    }
}