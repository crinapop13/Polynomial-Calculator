package ro.tuc.tp.Model;

import java.util.ArrayList;

public class Polinom {
    private ArrayList<Monom> monom;

    public Polinom() {
        monom = new ArrayList<Monom>();
    }

    public void adauga(Monom m) {
        monom.add(m);
    }

    public ArrayList<Monom> getPolinom() {
        return monom;
    }

    public Monom getFirst() {
        return this.getPolinom().get(0);
    }

    boolean equals(Polinom p1, Polinom p2) {
        ArrayList<Monom> m1 = p1.getPolinom();
        ArrayList<Monom> m2 = p2.getPolinom();
        int gr1,gr2,coef1,coef2;
        int i = 0;
        while(i < m1.size() && i < m2.size()) {
            gr1 = m1.get(i).getGrad();
            coef1 = (int) m1.get(i).getCoeficient();
            gr2 = m1.get(i).getGrad();
            coef2 = (int) m2.get(i).getCoeficient();
            if (gr1 != gr2 && coef1 != coef2) {
                return false;
            }
            i++;
        }
        return true;
    }

    public String toString(){
        String result = "";
        for(Monom mon: monom) {
            result+=mon.toString();
        }
        return result;
    }
}
