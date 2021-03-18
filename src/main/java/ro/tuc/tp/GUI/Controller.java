package ro.tuc.tp.GUI;

import ro.tuc.tp.Model.Monom;
import ro.tuc.tp.Model.Operatii;
import ro.tuc.tp.Model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private View view;
    private Operatii logic;

    public Controller(View v) {
        this.view = v;

        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addMultiplyListener(new MultListener());
        view.addDivisionListener(new DivListener());
        view.addDerivListener(new DerivListener());
        view.addIntegListener(new IntegListener());
        view.addClearListener(new ClearListener());
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String in1 = view.getUserInput1();
            String in2 = view.getUserInput2();
            view.setResult(logic.adunare(convertToPolinom(in1),convertToPolinom(in2)));
        }
    }

    class SubListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String in1 = view.getUserInput1();
            String in2 = view.getUserInput2();
            view.setResult(logic.scadere(convertToPolinom(in1),convertToPolinom(in2)));
            logic.scadere(convertToPolinom(in1),convertToPolinom(in2)).toString();
        }
    }

    class MultListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String in1 = view.getUserInput1();
            String in2 = view.getUserInput2();
            view.setResult(logic.produs(convertToPolinom(in1),convertToPolinom(in2)));
        }
    }

    class DivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String in1 = view.getUserInput1();
            String in2 = view.getUserInput2();
            //view.setResult(logic.impartire(convertToPolinom(in1),convertToPolinom(in2)));
        }
    }

    class DerivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String in1 = view.getUserInput1();
            view.setResult(logic.derivare(convertToPolinom(in1)));
        }
    }

    class IntegListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String in1 = view.getUserInput1();
            view.setResult(logic.integrare(convertToPolinom(in1)));
        }
    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.clear();
        }
    }

    public Polinom convertToPolinom(String s) {
        Polinom pol = new Polinom();
        Monom mon;
        Pattern pattern = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            pol.adauga(new Monom(Integer.parseInt(m.group(1)),Integer.parseInt(m.group(2))));
        }
        return pol;
    }

}
