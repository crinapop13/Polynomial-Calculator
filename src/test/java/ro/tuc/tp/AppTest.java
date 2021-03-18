package ro.tuc.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ro.tuc.tp.Model.Monom;
import ro.tuc.tp.Model.Operatii;
import ro.tuc.tp.Model.Polinom;

import java.util.ArrayList;


public class AppTest
{
    @Test
    public void addTest()
    {
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        
        //2x^2+3x^1+1
        p1.adauga(new Monom(2,2));
        p1.adauga(new Monom(3,1));
        p1.adauga(new Monom(1,0));

        //5x^2+2x^1
        p2.adauga(new Monom(5,2));
        p2.adauga(new Monom(2,1));
        
        //7x^2+5x^1+1
        Polinom suma = new Polinom();
        suma.adauga(new Monom(7,2));
        suma.adauga(new Monom(5,1));
        suma.adauga(new Monom(1,0));
        assertEquals(Operatii.adunare(p1,p2),suma);
    }

    @Test
    public void subTest()
    {
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        //5x^3+3x^2+2x^1
        p1.adauga(new Monom(5,3));
        p1.adauga(new Monom(3,2));
        p1.adauga(new Monom(2,1));

        //5x^2+2x^1
        p2.adauga(new Monom(5,2));
        p2.adauga(new Monom(2,1));

        //5x^3-2x^2
        Polinom dif = new Polinom();
        dif.adauga(new Monom(7,2));
        dif.adauga(new Monom(5,1));
        dif.adauga(new Monom(1,0));
        assertEquals(Operatii.scadere(p1,p2),dif);
    }

    @Test
    public void inmultireTest()
    {
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        //2x^2+x^1
        p1.adauga(new Monom(2,2));
        p1.adauga(new Monom(1,1));

        //5x^2+2x^1
        p2.adauga(new Monom(5,2));
        p2.adauga(new Monom(2,1));

        //10x^4+4x^3+5x^3+2x^2
        Polinom mul = new Polinom();
        mul.adauga(new Monom(10,4));
        mul.adauga(new Monom(4,3));
        mul.adauga(new Monom(5,3));
        mul.adauga(new Monom(2,2));
        assertEquals(Operatii.produs(p1,p2),mul);
    }

    @Test
    public void derivareTest()
    {
        Polinom p1 = new Polinom();

        //2x^4+6x^2+3x^1
        p1.adauga(new Monom(2,4));
        p1.adauga(new Monom(6,2));
        p1.adauga(new Monom(3,1));

        //8x^3+12x^1+3
        Polinom deriv = new Polinom();
        deriv.adauga(new Monom(8,3));
        deriv.adauga(new Monom(12,1));
        deriv.adauga(new Monom(3,0));
        assertEquals(Operatii.derivare(p1),deriv);
    }

    @Test
    public void integrareTest()
    {
        Polinom p1 = new Polinom();

        //2x^4+6x^2+3x^1
        p1.adauga(new Monom(2,4));
        p1.adauga(new Monom(6,2));
        p1.adauga(new Monom(3,1));

        //0.4x^5+2x^2+1.5x^1
        Polinom integ = new Polinom();
        integ.adauga(new Monom(8,3));
        integ.adauga(new Monom(12,1));
        integ.adauga(new Monom(3,0));
        assertEquals(Operatii.integrare(p1),integ);
    }

}
