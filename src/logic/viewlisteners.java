package logic;

import gui.workspace;
import main.Main;
import models.*;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class viewlisteners  implements ActionListener {



    @Override
    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();
        String buttonText;
        Session session = Main.getSession();
        List<ProjektantEntity> projektanci = session.createQuery("from ProjektantEntity ").list();
        List<AdresEntity> adresy = session.createQuery("from AdresEntity ").list();
        List<EgzemplarzEntity> egzemplarze = session.createQuery("from EgzemplarzEntity ").list();
        List<KlientEntity> klienci = session.createQuery("from KlientEntity ").list();
        List<PracownikEntity> pracownicy = session.createQuery("from PracownikEntity ").list();
        List<ProduktEntity> produkty = session.createQuery("from ProduktEntity ").list();
        List<ZamowienieEntity> zamowienia = session.createQuery("from ZamowienieEntity ").list();
        List<ProducentEntity> producenci = session.createQuery("from ProducentEntity ").list();

        if (source != null) {
            buttonText = source.getText();

            for (ZamowienieEntity a : zamowienia) {
                a.updateCena();
            }
            for (EgzemplarzEntity a : egzemplarze){
                a.updatedost();
            }

            if(buttonText.equals("Load Data")){

                String value = Objects.requireNonNull(workspace.comboBoxSelect.getSelectedItem()).toString();


                if(value.equals("PROJEKTANCI")){


                    int i=0;
                    String[][] array =new String[projektanci.size()][50];
                    for (ProjektantEntity a : projektanci) {
                        array[i][0]=a.getImie();
                        array[i][1]=a.getNazwisko();
                        array[i][2]=a.getKrajPochodzenia();
                        array[i][3]=a.getSkrot();
                        i++;
                    }

                    String[] columns={"Imię","Nazwisko","Kraj pochodzenia", "Marka"};
                    JTable jt1=new JTable(array,columns);
                   workspace.scrollPane.setViewportView(jt1);

                    workspace.comboBoxName.removeAllItems();

                    for (ProjektantEntity a : projektanci) {
                        workspace.comboBoxName.addItem(a);
                    }

                }

                if(value.equals("ADRESY")){

                    int i=0;
                    int empty=0;
                    for(AdresEntity a :adresy){
                        if(a.getPracowniksByIdAdres().isEmpty() && a.getKlientsByIdAdres().isEmpty()){
                            empty++;
                        }
                    }
                    String[][] array =new String[pracownicy.size()+klienci.size()+empty][50];
                    for (AdresEntity a : adresy) {
                        Collection<KlientEntity> klients = a.getKlientsByIdAdres();
                        Collection<PracownikEntity> workers = a.getPracowniksByIdAdres();
                        for (KlientEntity b : klients) {
                            array[i][0] = b.getImie();
                            array[i][1] = b.getNazwisko();
                            array[i][2] = a.getMiasto();
                            array[i][3] = a.getKodPocztowy();
                            array[i][4] = a.getDzielnica();
                            array[i][5] = a.getUlica();
                            array[i][6] = a.getNrDomu().toString();
                            array[i][7] = a.getNrLokalu().toString();
                            i++;
                        }
                        for (PracownikEntity c : workers){
                            array[i][0] = c.getImie();
                            array[i][1] = c.getNazwisko();
                            array[i][2] = a.getMiasto();
                            array[i][3] = a.getKodPocztowy();
                            array[i][4] = a.getDzielnica();
                            array[i][5] = a.getUlica();
                            array[i][6] = a.getNrDomu().toString();
                            array[i][7] = a.getNrLokalu().toString();
                            i++;
                        }
                        if(klients.isEmpty() && workers.isEmpty()){
                            array[i][0] = "";
                            array[i][1] = "";
                            array[i][2] = a.getMiasto();
                            array[i][3] = a.getKodPocztowy();
                            array[i][4] = a.getDzielnica();
                            array[i][5] = a.getUlica();
                            array[i][6] = a.getNrDomu().toString();
                            if(a.getNrLokalu() == null){
                             array[i][7] = "";
                            }else {
                                array[i][7] = a.getNrLokalu().toString();
                            }
                            i++;
                        }

                    }

                    String[] columns={"Imie", "Nazwisko","Miasto","Kod Pocztowy","Dzielnica", "Ulica", "Nr Domu", "Nr Lokalu" };
                    JTable jt1=new JTable(array,columns);
                    workspace.scrollPane.setViewportView(jt1);

                    workspace.comboBoxName.removeAllItems();

                    for (AdresEntity a : adresy) {
                        workspace.comboBoxName.addItem(a);
                    }

                }

                if(value.equals("EGZEMPLARZE")){
                    int i=0;
                    String[][] array =new String[egzemplarze.size()][50];
                    for (EgzemplarzEntity a : egzemplarze) {
                        array[i][0]=a.getProduktByIdProdukt().getProducentByIdProducent().getNazwa();
                        array[i][1]=a.getProduktByIdProdukt().getModel();
                        array[i][2]=a.getProduktByIdProdukt().getProjektantByIdProjektant().getSkrot();
                        array[i][3]=a.getProduktByIdProdukt().getKolorystyka();
                        array[i][4]=a.getRozmiar().toString();
                        array[i][5]=a.getStan();
                        array[i][6]=a.getDostepne();
                        i++;
                    }

                    String[] columns={"Firma","Model","Kolaboracja","Kolorystyka","Rozmiar", "Stan", "Dostępność"};
                    JTable jt1=new JTable(array,columns);
                    workspace.scrollPane.setViewportView(jt1);

                    workspace.comboBoxName.removeAllItems();

                    for (EgzemplarzEntity a : egzemplarze) {
                        workspace.comboBoxName.addItem(a);
                    }

                }

                if(value.equals("KLIENCI")){
                    int i=0;
                    String[][] array =new String[klienci.size()][50];
                    for (KlientEntity a : klienci) {
                        array[i][0]=a.getImie();
                        array[i][1]=a.getNazwisko();
                        array[i][2]=a.getNrTel();
                        array[i][3]=a.getAdresByIdAdres().getMiasto();
                        array[i][4]=a.getAdresByIdAdres().getKodPocztowy();
                        array[i][5]=a.getAdresByIdAdres().getUlica();
                        array[i][6]=a.getAdresByIdAdres().getNrDomu().toString();
                        array[i][7]=a.getAdresByIdAdres().getNrLokalu().toString();
                        i++;
                    }

                    String[] columns={"Imię","Nazwisko","Nr telefonu", "Miasto", "Kod Pocztowy", "Ulica", "Nr Domu", "Nr Lokalu"};
                    JTable jt1=new JTable(array,columns);
                    workspace.scrollPane.setViewportView(jt1);

                    workspace.comboBoxName.removeAllItems();

                    for (KlientEntity a : klienci) {
                        workspace.comboBoxName.addItem(a);
                    }

                }

                if(value.equals("PRACOWNICY")){
                    int i=0;
                    String[][] array =new String[pracownicy.size()][50];
                    for (PracownikEntity a : pracownicy) {
                        array[i][0]=a.getImie();
                        array[i][1]=a.getNazwisko();
                        array[i][2]=a.getKodLog();
                        array[i][3]=a.getAdresByIdAdres().getMiasto();
                        array[i][4]=a.getAdresByIdAdres().getKodPocztowy();
                        array[i][5]=a.getAdresByIdAdres().getUlica();
                        array[i][6]=a.getAdresByIdAdres().getNrDomu().toString();
                        array[i][7]=a.getAdresByIdAdres().getNrLokalu().toString();
                        i++;
                    }

                    String[] columns={"Imię","Nazwisko","Kod logowania", "Miasto", "Kod Pocztowy", "Ulica", "Nr Domu", "Nr Lokalu"};
                    JTable jt1=new JTable(array,columns);
                    workspace.scrollPane.setViewportView(jt1);

                    workspace.comboBoxName.removeAllItems();

                    for (PracownikEntity a : pracownicy) {
                        workspace.comboBoxName.addItem(a);
                    }

                }

                if(value.equals("PRODUCENCI")){
                    int i=0;
                    String[][] array =new String[producenci.size()][50];
                    for (ProducentEntity a : producenci) {
                        array[i][0]=a.getNazwa();
                        array[i][1]=a.getKategoria();
                        array[i][2]=a.getNip();
                        array[i][3]=a.getKraj();
                        i++;
                    }

                    String[] columns={"Nazwa","Kategoria","NIP", "Kraj"};
                    JTable jt1=new JTable(array,columns);
                    workspace.scrollPane.setViewportView(jt1);

                    workspace.comboBoxName.removeAllItems();

                    for (ProducentEntity a : producenci) {
                        workspace.comboBoxName.addItem(a);
                    }

                }

                if(value.equals("PRODUKTY")){
                    int i=0;
                    String[][] array =new String[produkty.size()][50];
                    for (ProduktEntity a : produkty) {
                        array[i][0]=a.getProducentByIdProducent().getNazwa();
                        array[i][1]=a.getModel();
                        array[i][2]=a.getProjektantByIdProjektant().getSkrot();
                        array[i][3]=a.getKolorystyka();
                        array[i][4]=a.getCenaNetto()+"";
                        array[i][5]=a.getCenaBrutto()+"";
                        array[i][6]=a.getDataPremiery().toString();
                        i++;
                    }

                    String[] columns={"Producent","Model","Kolaboracja", "Kolorystyka", "Cena Netto", "Cena Brutto", "Data premiery"};
                    JTable jt1=new JTable(array,columns);
                    workspace.scrollPane.setViewportView(jt1);

                    workspace.comboBoxName.removeAllItems();

                    for (ProduktEntity a : produkty) {
                        workspace.comboBoxName.addItem(a);
                    }

                }

                if(value.equals("ZAMÓWIENIA")){
                    int i=0;
                    int x=0;
                    for (ZamowienieEntity a : zamowienia) {
                        Collection<EgzemplarzEntity> pary = a.getEgzemplarzsByIdZamowienie();
                        x=x+pary.size();
                    }


                    String[][] array =new String[x][50];
                    for (ZamowienieEntity a : zamowienia) {
                        Collection<EgzemplarzEntity> pary = a.getEgzemplarzsByIdZamowienie();
                        if( singleton.instance.uzytkownik == null || a.getKlientByIdKlient().getIdKlient() == singleton.instance.uzytkownik.getIdKlient()) {
                            for (EgzemplarzEntity b : pary) {
                                array[i][0] = a.getKlientByIdKlient().getImie();
                                array[i][1] = a.getKlientByIdKlient().getNazwisko();
                                array[i][2] = a.getPracownikByIdPracownik().getImie();
                                array[i][3] = a.getPracownikByIdPracownik().getNazwisko();
                                array[i][4] = a.getCenaNetto() + "";
                                array[i][5] = a.getCenaBrutto() + "";
                                array[i][6] = a.getDataZamowienia().toString();
                                array[i][7] = a.getDataWysylki().toString();
                                array[i][8] = b.getProduktByIdProdukt().getProducentByIdProducent().getNazwa();
                                array[i][9] = b.getProduktByIdProdukt().getModel();
                                array[i][10] = b.getProduktByIdProdukt().getProjektantByIdProjektant().getSkrot();
                                array[i][11] = b.getProduktByIdProdukt().getKolorystyka();
                                array[i][12] = b.getRozmiar().toString();
                                i++;

                            }
                        }

                    }

                    String[] columns={"Imię zamawiajacego","Nazwisko zamawiajacego","Imie sprzedawcy", "Nazwisko sprzedawcy", "Cena Netto", "Cena Brutto", "Data Zamówienia", "Data Wysyłki",
                    "Producent", "Model", "Kolaboracja", "Kolorystyka", "Rozmiar"};
                    JTable jt1=new JTable(array,columns);
                    workspace.scrollPane.setViewportView(jt1);

                    workspace.comboBoxName.removeAllItems();


                    for (ZamowienieEntity a : zamowienia) {
                            workspace.comboBoxName.addItem(a);
                        }


                }


            }


            session.close();
        }
    }
}
