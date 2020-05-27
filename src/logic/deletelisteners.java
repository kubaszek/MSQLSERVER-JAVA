package logic;

import gui.workspace;
import main.Main;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class deletelisteners implements ActionListener {

    Session session = Main.getSession();

    public void actionPerformed(ActionEvent e) {


        {
            if (singleton.instance.GetFunc().equals("user")) {

                JOptionPane.showMessageDialog(null,
                        "BRAK ODPOWIEDNICH UPRAWNIEN",
                        "Brak uprawnień",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                session.clear();
                session.getTransaction().begin();
                try {
                    session.delete(workspace.comboBoxName.getSelectedItem());
                    session.getTransaction().commit();
                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie usunięto wybrany rekord",
                            "Powodzenie usuwania",
                            JOptionPane.ERROR_MESSAGE);


                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można usunąć rekordu, istnieją powiązane z nim inne rekordy",
                            "Błąd usuwania",
                            JOptionPane.ERROR_MESSAGE);


                }


            }
        }
    }
}