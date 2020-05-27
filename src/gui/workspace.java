package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import logic.*;

public class workspace extends JFrame {

    JPanel contentPane;
    JTable table;
    public static JComboBox<Object> comboBoxName;
    public static JComboBox<String> comboBoxSelect;
    JLabel lblNewLabel;
    JLabel lblDesignedByMr = new JLabel("MARCIN KUBACH");
    JButton btnSave;
    JButton btnUpdate;
    JButton btnDelete;
    public static JScrollPane scrollPane;

    JTextField textFieldSearch;


    public workspace() {
        setBounds(200, 100, 1500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("BAZA DANYCYH SKLEPU Z BUTAMI");

        JButton btnLoadTable = new JButton("Load Data");
        btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnLoadTable.setForeground(new Color(30, 144, 255));
        btnLoadTable.addActionListener(new logic.viewlisteners());

        textFieldSearch = new JTextField();

        comboBoxSelect = new JComboBox<String>();
        comboBoxSelect.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        if (singleton.instance.GetFunc().equals("admin")){
            comboBoxSelect.setModel(new DefaultComboBoxModel<>(new String[]{"ADRESY", "EGZEMPLARZE", "KLIENCI", "PRACOWNICY", "PRODUCENCI", "PRODUKTY", "PROJEKTANCI", "ZAMÓWIENIA"}));
        }
        else if (singleton.instance.GetFunc().equals("staff")){
            comboBoxSelect.setModel(new DefaultComboBoxModel<>(new String[]{"ADRESY", "EGZEMPLARZE", "KLIENCI", "PRODUCENCI", "PRODUKTY", "PROJEKTANCI", "ZAMÓWIENIA"}));
        }
        else {
            comboBoxSelect.setModel(new DefaultComboBoxModel<>(new String[]{"EGZEMPLARZE", "PRODUCENCI", "PRODUKTY", "PROJEKTANCI", "ZAMÓWIENIA"}));
        }
        comboBoxSelect.setBounds(320, 84, 200, 24);
        contentPane.add(comboBoxSelect);

        btnLoadTable.setBounds(164, 84, 136, 24);
        contentPane.add(btnLoadTable);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(164, 117, 1200, 192);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);


        lblNewLabel = new JLabel("BAZA DANYCH SKLEPU Z BUTAMI");
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(339, 25, 800, 38);
        contentPane.add(lblNewLabel);
        lblDesignedByMr.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
        lblDesignedByMr.setHorizontalAlignment(SwingConstants.CENTER);
        lblDesignedByMr.setBounds(580, 420, 233, 22);
        contentPane.add(lblDesignedByMr);

        btnSave = new JButton("Create");
        btnSave.setBackground(Color.YELLOW);
        btnSave.addActionListener(new logic.createlisteners());

        btnSave.setFont(new Font("Arial", Font.BOLD, 18));
        btnSave.setBounds(164, 320, 122, 31);
        contentPane.add(btnSave);

        btnUpdate = new JButton("Update");
        btnUpdate.setForeground(Color.BLUE);
        btnUpdate.setBackground(Color.GREEN);

        btnUpdate.setFont(new Font("Arial", Font.BOLD, 18));
        btnUpdate.setBounds(448, 320, 122, 31);
        contentPane.add(btnUpdate);
        btnUpdate.addActionListener(new logic.updatelisteners());

        btnDelete = new JButton("Delete");
        btnDelete.setBackground(Color.RED);
        btnDelete.setForeground(Color.DARK_GRAY);

        btnDelete.setFont(new Font("Arial", Font.BOLD, 18));
        btnDelete.setBounds(306, 320, 122, 31);
        contentPane.add(btnDelete);
        btnDelete.addActionListener(new logic.deletelisteners());

        comboBoxName = new JComboBox<Object>();
        comboBoxName.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        comboBoxName.setBounds(590, 320, 600, 31);
        contentPane.add(comboBoxName);

        JButton btnReset = new JButton("New");
        btnReset.setForeground(Color.WHITE);
        btnReset.setBackground(Color.BLUE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

