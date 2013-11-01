package fr.arolla.atelier.legacy;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringDistance.testDistance();
        Model.Book[] bs = new Model.Book[2000];
        new BookManager().maj("").toArray(bs);
        showList(bs) ;
    }



    public static void showList(Model.Book[] data){

        final JList list = new JList(data);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);

        final JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        final JTextField f=new JTextField();
        f.setMaximumSize(new Dimension(200,75));
        f.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                List<Model.Book> bs = new BookManager().maj(f.getText());
                list.setListData(bs.toArray());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                List<Model.Book> bs = new BookManager().maj(f.getText());
                list.setListData(bs.toArray());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                List<Model.Book> bs = new BookManager().maj(f.getText());
                list.setListData(bs.toArray());
            }
        }) ;
                f.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List<Model.Book> bs = new BookManager().maj(((JTextField) e.getSource()).getText());
                        list.setListData(bs.toArray());
                    }
                });
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        JFrame frame = new JFrame();
        p.add(listScroller,0);
        p.add(f, 1);
        frame.add(p);
        frame.setSize(400, 300);
        frame.setVisible(true);

    }



}
