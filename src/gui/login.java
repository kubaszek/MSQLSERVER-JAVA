package gui;

import main.Main;
import models.KlientEntity;
import models.PracownikEntity;
import org.hibernate.Session;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.*;
import logic.*;

public class login extends JFrame implements ActionListener {


    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;
    Session session = Main.getSession();

    List<PracownikEntity> pracownicy = session.createQuery("from PracownikEntity ").list();
    List<KlientEntity> klienci = session.createQuery("from KlientEntity ").list();

    public login() {

        // User Label
        user_label = new JLabel();
        user_label.setText("Login :");
        userName_text = new JTextField();

        // Password

        password_label = new JLabel();
        password_label.setText("Hasło :");
        password_text = new JPasswordField();

        // Submit

        submit = new JButton("LOGOWANIE");

        panel = new JPanel(new GridLayout(3, 1));
        setLocation(800, 400);

        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Zaloguj się na swoje konto");
        setSize(300, 100);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String login = userName_text.getText();
        String haslo = password_text.getText();

        for (PracownikEntity a : pracownicy) {
            if (login.equals(a.getKodLog()) && haslo.equals(a.getHaslo())) {
                singleton.instance.staff = a;
                dispose();
                JOptionPane.showMessageDialog(null,
                        "Witaj pracowniku!");
                dispose();
                singleton.instance.SetFunc(a.getRolaByIdRola().getRola());
                JFrame workspace = new workspace();
                return;
            } else {
                for (KlientEntity b : klienci) {
                    if (login.equals(b.getKodLog()) && haslo.equals(b.getHaslo())) {
                        singleton.instance.uzytkownik = b;
                        dispose();
                        JOptionPane.showMessageDialog(null,
                                "Witaj kliencie!");
                        dispose();
                        singleton.instance.SetFunc("user");
                        JFrame workspace = new workspace();
                        return;
                    }
                    else {
                        message.setText(" Błędne dane logowania ");
                    }
                }
            }

        }

    }
}