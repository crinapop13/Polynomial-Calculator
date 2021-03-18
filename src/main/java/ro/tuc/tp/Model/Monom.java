package ro.tuc.tp.Model;

public class Monom {
    private Number coeficient;
    private int grad;

    public Monom(Number c, int grad) {
        coeficient = c;
        this.grad = grad;
    }

    public Number getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(Number coef) {
        coeficient = coef;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public Monom div(Monom m1) {
        int coef = (int)this.getCoeficient() - (int)m1.getCoeficient();
        int putere = this.getGrad() - m1.getGrad();
        return new Monom(coef,putere);
    }


    public String toString() {
        /*if((int)coeficient == 1)
            return "+x^" + grad else */
        if(coeficient instanceof Integer) {
            if ((int) coeficient == 0)
                return "";
            else if (grad == 0)
                return ((int) coeficient > 0) ? "+" + coeficient : "" + coeficient;
            else
                return ((int) coeficient > 0) ? "+" + coeficient + "x^" + grad : coeficient + "x^" + grad;
        } else {
            if ((double) coeficient == 0)
                return "";
            else if (grad == 0)
                return ((double) coeficient > 0) ? "+" + coeficient : "" + coeficient;
            else
                return ((double) coeficient > 0) ? "+" + coeficient + "x^" + grad : coeficient + "x^" + grad;
        }
    }
}