package fr.arolla.atelier.legacy;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FactUtils.testDistance();
        Model.Fact[] bs = new Model.Fact[2000];
        showList(bs) ;
    }



    public static void showList(Model.Fact[] data){

        final JLabel fact=new JLabel();
        final JLabel related=new JLabel();
        final JLabel factLabel=new JLabel();
        final JLabel relatedLabel=new JLabel();

        factLabel.setText("Fait marquant");
        relatedLabel.setText("Fait en rapport");



        final JTextField f=new JTextField();
        f.setMaximumSize(new Dimension(200,75));

        f.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Manager manager = new Manager();
                    Model.Fact factFinded = manager.get(((JTextField) e.getSource()).getText());
                    fact.setText(factFinded.toString());
                    related.setText(manager.related(factFinded).toString());
                }catch(Exception ex){
                    ex.printStackTrace();
                    System.exit(0);
                }
            }
        });

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        JFrame frame = new JFrame();
        p.add(factLabel,0);
        p.add(fact,1);
        p.add(relatedLabel,2);
        p.add(related,3);
        p.add(f, 4);
        frame.add(p);
        frame.setSize(400, 300);
        frame.setVisible(true);

    }



}
