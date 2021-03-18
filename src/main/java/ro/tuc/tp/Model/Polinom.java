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

    public boolean equals(Object p) {
        if(!(p instanceof Polinom))
            return false;
        Polinom p1 = (Polinom) p;
        ArrayList<Monom> m1 =  this.getPolinom();
        ArrayList<Monom> m2 =  p1.getPolinom();
        int gr1,gr2;
        Number coef1,coef2;
        int i = 0;
        if(m1.size() != m2.size()) {
            return false;
        } else {
            while (i < m1.size() && i < m2.size()) {
                gr1 = m1.get(i).getGrad();
                coef1 = m1.get(i).getCoeficient();
                gr2 = m1.get(i).getGrad();
                coef2 = m2.get(i).getCoeficient();
                if (gr1 != gr2 && coef1 != coef2) {
                    return false;
                }
                i++;
            }
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
