package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import logic.*;
import models.*;

public class creator extends JFrame {

    public static JPanel panel, buttons, container;
    public static JLabel one, two, three, four, five, six, seven, eight;
    public static JTextField jeden, dwa, trzy, cztery, piec, szesc, siedem, osiem;
    public static JButton save;
    public static JComboBox<AdresEntity> adresEntityJComboBox;
    public static JComboBox<ProduktEntity> produktEntityJComboBox;
    public static JComboBox<ZamowienieEntity> zamowienieEntityJComboBox;
    public static JComboBox<ProjektantEntity> projektantEntityJComboBox;
    public static JComboBox<PracownikEntity> pracownikEntityJComboBox;
    public static JComboBox<KlientEntity> klientEntityJComboBox;
    public static JComboBox<ProducentEntity> producentEntityJComboBox;


    public creator() {

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        panel = new JPanel(new GridLayout(2, 6));
        panel.setBorder(new EmptyBorder(1, 1, 1, 1));
        buttons = new JPanel(new GridLayout(1, 1));
        buttons.setBorder(new EmptyBorder(1, 1, 1, 1));
        one = new JLabel();
        two = new JLabel();
        three = new JLabel();
        four = new JLabel();
        five = new JLabel();
        six = new JLabel();
        seven = new JLabel();
        eight = new JLabel();
        jeden = new JTextField();
        dwa = new JTextField();
        trzy = new JTextField();
        cztery = new JTextField();
        piec = new JTextField();
        szesc = new JTextField();
        siedem = new JTextField();
        osiem = new JTextField();
        save = new JButton();
        adresEntityJComboBox = new JComboBox<AdresEntity>();
        produktEntityJComboBox = new JComboBox<ProduktEntity>();
        zamowienieEntityJComboBox = new JComboBox<ZamowienieEntity>();
        projektantEntityJComboBox = new JComboBox<ProjektantEntity>();
        pracownikEntityJComboBox = new JComboBox<PracownikEntity>();
        klientEntityJComboBox = new JComboBox<KlientEntity>();
        producentEntityJComboBox = new JComboBox<ProducentEntity>();


        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(four);
        panel.add(five);
        panel.add(six);
       // panel.add(seven);
       // panel.add(eight);
        panel.add(jeden);
        panel.add(dwa);
        panel.add(trzy);
        panel.add(cztery);
       // panel.add(piec);
       // panel.add(szesc);
       // panel.add(siedem);
       // panel.add(osiem);
        buttons.add(save);


        add(container);
        container.add(panel);
        container.add(buttons);
        save.addActionListener(new logic.createlisteners());
        setTitle("DODAWANIE REKORDU");
        setBounds(200, 600, 1500, 200);
        setVisible(true);
    }
}