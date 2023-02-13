package model.GUI;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.stream.Collectors;

public class GUIFrame extends JFrame implements ActionListener {

    JButton toFilter = new JButton("Filtrar");
    JButton reset = new JButton("Reset");
    JButton skipFoward = new JButton(">");
    JButton skipBackward = new JButton("<");

    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();

    JPanel filter1 = new JPanel();
    JPanel generalJPanel = new JPanel();

    String filters[]={"Rodada","Clube","Atleta"};     
    JComboBox optionsBox = new JComboBox(filters);
    JTextField textToFilter = new JTextField(7);
    JLabel summation  = new JLabel("",JLabel.CENTER);

    DataConverter dc;
    Vector<Vector<Object>> vectorGols;
    int skip = 0;

    public GUIFrame(){
        dc = new DataConverter();
        vectorGols= dc.getListaGols();
        model.setDataVector(vectorGols.stream().limit(25).collect(Collectors.toCollection(Vector::new)), dc.getColumn());
        
        table.setBounds(400, 400, 400, 400);
        table.setModel(model);
        
        toFilter.addActionListener(this);
        reset.addActionListener(this);
        skipFoward.addActionListener(this);
        skipBackward.addActionListener(this);

        filter1.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
        filter1.add(reset);
        filter1.add(optionsBox);
        filter1.add(textToFilter);
        filter1.add(toFilter);

        JScrollPane sp = new JScrollPane(table);
        generalJPanel.setLayout(new BoxLayout(generalJPanel, BoxLayout.Y_AXIS));
        generalJPanel.add(sp);
        generalJPanel.add(filter1);
        this.add(skipFoward,BorderLayout.EAST);
        this.add(skipBackward,BorderLayout.WEST);
        this.add(summation,BorderLayout.SOUTH);
        this.add(generalJPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 610);
        this.setLocation(400, 0);
        this.setResizable(true);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == toFilter){
            String option = (String) optionsBox.getSelectedItem();// seleciona a opcao da caixa
            List<String> indexList = List.of("Rodada","Clube","Atleta");
            int index = indexList.indexOf(option);
            String text = textToFilter.getText();// seleciona o texto do filtro

            if(index==0){
                vectorGols = vectorGols.stream().filter(n->String.valueOf(n.get(index)).equals(text)).collect(Collectors.toCollection(Vector::new));
            } else{
                vectorGols = vectorGols.stream().filter(n->(((String) n.get(index)).toUpperCase()).contains(text.toUpperCase())).collect(Collectors.toCollection(Vector::new));
            }
            
            model.setDataVector(vectorGols.stream().limit(25).collect(Collectors.toCollection(Vector::new)), dc.getColumn());
            summation.setText(String.valueOf(vectorGols.size()));

        } else if (e.getSource() == reset){
            model.setRowCount(0);//limpa a lista
            vectorGols = dc.getListaGols();
            skip = 0;
            model.setDataVector(vectorGols.stream().limit(25).collect(Collectors.toCollection(Vector::new)), dc.getColumn());
            summation.setText("");

        } else if (e.getSource() == skipFoward){
            model.setDataVector(vectorGols.stream().skip(skip+25).limit(25).collect(Collectors.toCollection(Vector::new)), dc.getColumn());
            skip = skip+25;

        } else if (e.getSource() == skipBackward){
            if(skip>0){
                model.setDataVector(vectorGols.stream().skip(skip-25).limit(25).collect(Collectors.toCollection(Vector::new)), dc.getColumn());
                skip=skip-25;
            }
        }
        
    }

    
}
