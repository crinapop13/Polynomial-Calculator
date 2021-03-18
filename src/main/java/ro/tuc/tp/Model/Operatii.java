package ro.tuc.tp.Model;

import java.util.ArrayList;

public class Operatii {
    public static Polinom adunare(Polinom p1, Polinom p2) {
        Polinom suma = new Polinom();
        int gr1,gr2;
        int i = 0;
        int j = 0;
        ArrayList<Monom> m1 = p1.getPolinom();
        ArrayList<Monom> m2 = p2.getPolinom();
        while (i < m1.size() && j < m2.size()) {
            gr1 = m1.get(i).getGrad();
            gr2 = m2.get(j).getGrad();
            if(gr1 < gr2) {
                suma.adauga(m2.get(j));
                j++;
            } else if (gr1 == gr2) {
                int c1 = (int) m1.get(i).getCoeficient();
                int c2 = (int) m2.get(j).getCoeficient();
                suma.adauga(new Monom(c1 + c2, gr1));
                i++;
                j++;
            } else {
                suma.adauga(m1.get(i));
                i++;
            }
        }
        for(int k = i; k < m1.size(); k++) {
            suma.adauga(m1.get(k));
        }
        for(int k = j; k < m2.size(); k++) {
            suma.adauga(m2.get(k));
        }
        return suma;
    }

    public static Polinom scadere(Polinom p1, Polinom p2) {
        Polinom dif = new Polinom();

        for(Monom mon2: p2.getPolinom()) {
            int coef = (int) mon2.getCoeficient();
            coef = coef * -1;
            mon2.setCoeficient(coef);
        }

        dif = adunare(p1,p2);

        for(Monom mon2: p2.getPolinom()) {
            int coef = (int) mon2.getCoeficient();
            coef = coef * -1;
            mon2.setCoeficient(coef);
        }

        return dif;
    }

    public static Polinom produs(Polinom p1,Polinom p2) {
        Polinom prod = new Polinom();
        ArrayList<Monom> m1 = p1.getPolinom();
        ArrayList<Monom> m2 = p2.getPolinom();
        int gr1,gr2, c1,c2;
        for(Monom mon1: m1) {
            for(Monom mon2: m2) {
                gr1 = mon1.getGrad();
                gr2 = mon2.getGrad();
                c1= (int) mon1.getCoeficient();
                c2 = (int) mon2.getCoeficient();
                prod.adauga(new Monom(c1 * c2, gr1 + gr2));
            }
        }
        return prod;
    }

    public static Polinom impartire(Polinom p1,Polinom p2) {
        Polinom div = new Polinom();
        Polinom cat = new Polinom();
        Polinom rest = p1;
        //int i = 0;
        //int j = 0;
        int gr1 = rest.getPolinom().get(0).getGrad();
        int gr2 = p2.getPolinom().get(0).getGrad();

        if(gr1 < gr2) {
            System.out.println("Nu se pot imparti polinoamele!");
        } else {
            while(gr1 >= gr2) {
                Monom d = rest.getFirst().div(p2.getFirst());
                Polinom p = new Polinom();
                p.adauga(d);
                cat.adauga(d);
                rest = scadere(rest,produs(p,p2));
                gr1 = rest.getPolinom().get(0).getGrad();
                gr2 = p2.getPolinom().get(0).getGrad();
            }
            for(Monom m: cat.getPolinom())
                div.adauga(m);
            div.adauga(new Monom(0,0));
            for(Monom m: rest.getPolinom())
                div.adauga(m);
        }
        return div;
    }

    public static Polinom derivare(Polinom p) {
        Polinom deriv = new Polinom();
        ArrayList<Monom> m1 = p.getPolinom();
        for(int i=0; i < m1.size(); i++) {
            int gr = m1.get(i).getGrad();
            int coef = (int)m1.get(i).getCoeficient() * gr;
            deriv.adauga(new Monom(coef,gr - 1));
        }
        return deriv;
    }

    public static Polinom integrare(Polinom p) {
        Polinom integ = new Polinom();
        ArrayList<Monom> m1 = p.getPolinom();
        double coef;
        for(int i=0; i < m1.size(); i++) {
            int grad = m1.get(i).getGrad();
            coef = (int) m1.get(i).getCoeficient();
            if(grad != 0) {
                integ.adauga(new Monom(coef*1.0 / (grad + 1),grad + 1));
            } else {
                integ.adauga(new Monom(coef, grad + 1));
            }
        }
        return integ;
    }
}
