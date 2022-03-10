package ro.tuc.tp.GUI;

import ro.tuc.tp.Model.Polinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JPanel content = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    private JButton add = new JButton("Adunare");
    private JButton sub = new JButton("Scadere");
    private JButton mult = new JButton("Inmultire");
    private JButton div = new JButton("Impartire");
    private JButton deriv = new JButton("Derivare");
    private JButton integ = new JButton("Integrare");
    private JButton clear = new JButton("Clear");
    private JTextField p1 = new JTextField(20);
    private JTextField p2 = new JTextField(20);
    private JTextField result = new JTextField(40);
    private JLabel inf = new JLabel("Pentru a evita nefunctionarea, introduceti polinomul sub forma: anx^n+an-1x^n-1+...+a0x^0");
    private JLabel first = new JLabel("Primul polinom");
    private JLabel second = new JLabel("Al doilea polinom");
    private JLabel rez = new JLabel("Rezultat");

    Controller controller = new Controller(this);

    public View(String nume) {
        super(nume);

        c.gridx = 0;
        c.gridy = 0;
        content.add(first,c);

        c.gridx = 1;
        c.gridy = 0;
        content.add(p1,c);

        c.gridx = 0;
        c.gridy = 1;
        content.add(second,c);

        c.gridx = 1;
        c.gridy = 1;
        content.add(p2,c);

        c.gridx = 0;
        c.gridy = 2;
        content.add(rez,c);

        c.gridx = 1;
        c.gridy = 2;
        content.add(result,c);
        result.setEditable(false);

        c.gridx = 0;
        c.gridy = 3;
        content.add(add,c);

        c.gridx = 1;
        c.gridy = 3;
        content.add(sub,c);

        c.gridx = 2;
        c.gridy = 3;
        content.add(mult,c);

        c.gridx = 0;
        c.gridy = 4;
        content.add(div,c);

        c.gridx = 1;
        c.gridy = 4;
        content.add(deriv,c);

        c.gridx = 2;
        c.gridy = 4;
        content.add(integ,c);

        c.gridx = 1;
        c.gridy = 5;
        content.add(clear,c);

        c.gridx = 1;
        c.gridy = 6;
        content.add(inf,c);

        this.add(content);
    }

    String getUserInput1(){
        return p1.getText();
    }

    String getUserInput2(){
        return p2.getText();
    }

    void setResult(Polinom tot) {
        result.setText(tot.toString());
    }

    void clear(){
        p1.setText("");
        p2.setText("");
        result.setText("");
    }

    void addAddListener(ActionListener a) {
        add.addActionListener(a);
    }

    void addSubListener(ActionListener s) {
        sub.addActionListener(s);
    }

    void addMultiplyListener(ActionListener mul) {
        mult.addActionListener(mul);
    }

    void addDivisionListener(ActionListener divi) {
        div.addActionListener(divi);
    }

    void addDerivListener(ActionListener der) { deriv.addActionListener(der); }

    void addIntegListener(ActionListener integr) { integ.addActionListener(integr); }

    void addClearListener(ActionListener integr) { clear.addActionListener(integr); }
}
