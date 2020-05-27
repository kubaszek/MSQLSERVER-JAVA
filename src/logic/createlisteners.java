package logic;

import gui.*;
import main.Main;
import models.*;
import org.hibernate.Session;

import java.sql.Date;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class createlisteners implements ActionListener {


    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();
        Session session = Main.getSession();
        String value = Objects.requireNonNull(workspace.comboBoxSelect.getSelectedItem()).toString();
        List<ProjektantEntity> projektanci = session.createQuery("from ProjektantEntity ").list();
        List<AdresEntity> adresy = session.createQuery("from AdresEntity ").list();
        List<EgzemplarzEntity> egzemplarze = session.createQuery("from EgzemplarzEntity ").list();
        List<KlientEntity> klienci = session.createQuery("from KlientEntity ").list();
        List<PracownikEntity> pracownicy = session.createQuery("from PracownikEntity ").list();
        List<ProduktEntity> produkty = session.createQuery("from ProduktEntity ").list();
        List<ZamowienieEntity> zamowienia = session.createQuery("from ZamowienieEntity ").list();
        List<ProducentEntity> producenci = session.createQuery("from ProducentEntity ").list();
        List<RolaEntity> role = session.createQuery("from RolaEntity ").list();

        if (singleton.instance.GetFunc() == "user") {

            JOptionPane.showMessageDialog(null,
                    "BRAK ODPOWIEDNICH UPRAWNIEN",
                    "Brak uprawnień",
                    JOptionPane.ERROR_MESSAGE);

        } else {

        if (source.getText() == "Create") {




                JFrame creator = new creator();

                if (value.equals("ADRESY")) {

                    gui.creator.one.setText("Miasto");
                    gui.creator.two.setText("Kod Pocztowy");
                    gui.creator.three.setText("Ulica");
                    gui.creator.four.setText("Nr Domu");
                    gui.creator.five.setText("Nr Lokalu");
                    gui.creator.six.setText("Dzielnica");
                    gui.creator.save.setText("DODAJ ADRES");
                    gui.creator.panel.add(gui.creator.piec);
                    gui.creator.panel.add(gui.creator.szesc);
                }

                if (value.equals("EGZEMPLARZE")) {

                    gui.creator.one.setText("-----");
                    gui.creator.two.setText("Stan");
                    gui.creator.three.setText("Dostępność");
                    gui.creator.four.setText("Rozmiar");
                    gui.creator.five.setText("Zamówienie");
                    gui.creator.six.setText("Produkt");
                    gui.creator.save.setText("DODAJ EGZEMPLARZ");
                    gui.creator.panel.add(gui.creator.zamowienieEntityJComboBox);
                    gui.creator.panel.add(gui.creator.produktEntityJComboBox);
                    for (ZamowienieEntity a : zamowienia) {
                        gui.creator.zamowienieEntityJComboBox.addItem(a);
                    }
                    gui.creator.zamowienieEntityJComboBox.addItem(null);
                    for (ProduktEntity a : produkty) {
                        gui.creator.produktEntityJComboBox.addItem(a);
                    }

                }

                if (value.equals("KLIENCI")) {

                    gui.creator.one.setText("Imie");
                    gui.creator.two.setText("Nazwisko");
                    gui.creator.three.setText("Kod logowania");
                    gui.creator.four.setText("Hasło");
                    gui.creator.five.setText("Nr telefonu");
                    gui.creator.six.setText("Adres");
                    gui.creator.save.setText("DODAJ KLIENTA");
                    gui.creator.panel.add(gui.creator.piec);
                    gui.creator.panel.add(gui.creator.adresEntityJComboBox);
                    for (AdresEntity a : adresy) {
                        gui.creator.adresEntityJComboBox.addItem(a);
                    }

                }


                if (value.equals("PRACOWNICY")) {


                    gui.creator.one.setText("Imie");
                    gui.creator.two.setText("Nazwisko");
                    gui.creator.three.setText("Kod logowania");
                    gui.creator.four.setText("Hasło");
                    gui.creator.five.setText("-----");
                    gui.creator.six.setText("Adres");
                    gui.creator.save.setText("DODAJ PRACOWNIKA");
                    gui.creator.panel.add(gui.creator.piec);
                    gui.creator.panel.add(gui.creator.adresEntityJComboBox);
                    for (AdresEntity a : adresy) {
                        gui.creator.adresEntityJComboBox.addItem(a);
                    }
                }


                if (value.equals("PRODUCENCI")) {


                    gui.creator.one.setText("Nazwa");
                    gui.creator.two.setText("Kraj");
                    gui.creator.three.setText("NIP");
                    gui.creator.four.setText("Kategoria");
                    gui.creator.five.setText("-----");
                    gui.creator.six.setText("-----");
                    gui.creator.save.setText("DODAJ PRODUCENTA");
                    gui.creator.panel.add(gui.creator.piec);
                    gui.creator.panel.add(gui.creator.szesc);
                }


                if (value.equals("PRODUKTY")) {


                    gui.creator.one.setText("Model");
                    gui.creator.two.setText("Kolorystyka");
                    gui.creator.three.setText("Data Premiery RRRR-MM-DD");
                    gui.creator.four.setText("Cena Netto");
                    gui.creator.five.setText("Producent");
                    gui.creator.six.setText("Projektant");
                    gui.creator.save.setText("DODAJ PRODUKT");
                    gui.creator.panel.add(gui.creator.producentEntityJComboBox);
                    gui.creator.panel.add(gui.creator.projektantEntityJComboBox);
                    for (ProducentEntity a : producenci) {
                        gui.creator.producentEntityJComboBox.addItem(a);
                    }
                    for (ProjektantEntity a : projektanci) {
                        gui.creator.projektantEntityJComboBox.addItem(a);
                    }

                }

                if (value.equals("PROJEKTANCI")) {


                    gui.creator.one.setText("Imie");
                    gui.creator.two.setText("Nazwisko");
                    gui.creator.three.setText("Kraj Pochodzenia");
                    gui.creator.four.setText("Nazwa");
                    gui.creator.five.setText("-----");
                    gui.creator.six.setText("-----");
                    gui.creator.save.setText("DODAJ PROJEKTANTA");
                    gui.creator.panel.add(gui.creator.piec);
                    gui.creator.panel.add(gui.creator.szesc);

                }

                if (value.equals("ZAMÓWIENIA")) {


                    gui.creator.one.setText("Data zamówienia RRRR-MM-DD");
                    gui.creator.two.setText("Data wysyłki RRRR-MM-DD");
                    gui.creator.three.setText("-----");
                    gui.creator.four.setText("-----");
                    gui.creator.five.setText("Pracownik");
                    gui.creator.six.setText("Klient");
                    gui.creator.save.setText("DODAJ ZAMÓWIENIE");
                    gui.creator.panel.add(gui.creator.pracownikEntityJComboBox);
                    gui.creator.panel.add(gui.creator.klientEntityJComboBox);
                    for (PracownikEntity a : pracownicy) {
                        gui.creator.pracownikEntityJComboBox.addItem(a);
                    }
                    for (KlientEntity a : klienci) {
                        gui.creator.klientEntityJComboBox.addItem(a);
                    }


                }


            }

            if (source.getText() == "DODAJ ADRES") {

                String miasto = "";
                String kod = "";
                String ulica = "";
                Integer nr_dom = null;
                Integer nr_lokal = null;
                String dzielnica = "";
                AdresEntity adres = new AdresEntity();

                try {
                    miasto = creator.jeden.getText().trim();
                    kod = creator.dwa.getText().trim();
                    ulica = creator.trzy.getText().trim();
                    nr_dom = Integer.valueOf(creator.cztery.getText().trim());
                    if (creator.piec.getText().isEmpty()) {
                    } else {
                        nr_lokal = Integer.valueOf(creator.piec.getText().trim());
                    }

                    dzielnica = creator.szesc.getText().trim();
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Wypełnij wszystkie niezbędne dane",
                            "Błąd wartości",
                            JOptionPane.ERROR_MESSAGE);

                }
                session.beginTransaction();
                try {
                    adres.setMiasto(miasto);
                    adres.setKodPocztowy(kod);
                    adres.setUlica(ulica);
                    adres.setNrDomu(nr_dom);
                    adres.setNrLokalu(nr_lokal);
                    adres.setDzielnica(dzielnica);
                    session.save(adres);
                    session.getTransaction().commit();

                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie dodany wybrany rekord",
                            "Powodzenie dodawania rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można dodać rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd dodawania rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "DODAJ PRODUCENTA") {


                String nazwa = "";
                String kraj = "";
                String nip = "";
                String kategoria = "";
                ProducentEntity producent = new ProducentEntity();

                try {
                    nazwa = creator.jeden.getText().trim();
                    kraj = creator.dwa.getText().trim();
                    nip = creator.trzy.getText().trim();
                    kategoria = creator.cztery.getText().trim();
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Wypełnij wszystkie niezbędne dane",
                            "Błąd wartości",
                            JOptionPane.ERROR_MESSAGE);

                }
                session.beginTransaction();
                try {
                    producent.setNazwa(nazwa);
                    producent.setKraj(kraj);
                    producent.setKategoria(kategoria);
                    producent.setNip(nip);
                    session.save(producent);
                    session.getTransaction().commit();

                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie dodany wybrany rekord",
                            "Powodzenie dodawania rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można dodać rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd dodawania rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "DODAJ PROJEKTANTA") {


                String imie = "";
                String nazwisko = "";
                String kraj = "";
                String nazwa = "";
                ProjektantEntity projektant = new ProjektantEntity();

                try {
                    imie = creator.jeden.getText().trim();
                    nazwisko = creator.dwa.getText().trim();
                    kraj = creator.trzy.getText().trim();
                    nazwa = creator.cztery.getText().trim();
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Wypełnij wszystkie niezbędne dane",
                            "Błąd wartości",
                            JOptionPane.ERROR_MESSAGE);

                }
                session.beginTransaction();
                try {
                    projektant.setImie(imie);
                    projektant.setNazwisko(nazwisko);
                    projektant.setKrajPochodzenia(kraj);
                    projektant.setSkrot(nazwa);
                    session.save(projektant);
                    session.getTransaction().commit();

                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie dodany wybrany rekord",
                            "Powodzenie dodawania rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można dodać rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd dodawania rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "DODAJ PRODUKT") {
                String model = "";
                String cw = "";
                String data = "";
                Double cena = null;
                ProducentEntity producent = new ProducentEntity();
                ProjektantEntity projektant = new ProjektantEntity();
                ProduktEntity produkt = new ProduktEntity();
                try {
                    model = creator.jeden.getText().trim();
                    cw = creator.dwa.getText().trim();
                    data = creator.trzy.getText().trim();
                    cena = Double.parseDouble(creator.cztery.getText().trim());
                    producent = (ProducentEntity) creator.producentEntityJComboBox.getSelectedItem();
                    projektant = (ProjektantEntity) creator.projektantEntityJComboBox.getSelectedItem();

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Wypełnij wszystkie niezbędne dane",
                            "Błąd wartości",
                            JOptionPane.ERROR_MESSAGE);

                }
                session.beginTransaction();
                try {
                    produkt.setModel(model);
                    produkt.setKolorystyka(cw);
                    produkt.setDataPremiery(Date.valueOf(data));
                    produkt.setCenaNetto(cena);
                    produkt.setCenaBrutto(cena * 1.23);
                    produkt.setProducentByIdProducent(producent);
                    produkt.setProjektantByIdProjektant(projektant);
                    session.save(produkt);
                    session.getTransaction().commit();

                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie dodany wybrany rekord",
                            "Powodzenie dodawania rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można dodać rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd dodawania rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "DODAJ PRACOWNIKA") {
                String imie = "";
                String nazwisko = "";
                String kod = "";
                String haslo = "";
                AdresEntity adres = new AdresEntity();
                PracownikEntity pracownik = new PracownikEntity();
                try {
                    imie = creator.jeden.getText().trim();
                    nazwisko = creator.dwa.getText().trim();
                    kod = creator.trzy.getText().trim();
                    haslo = creator.cztery.getText().trim();
                    adres = (AdresEntity) creator.adresEntityJComboBox.getSelectedItem();

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Wypełnij wszystkie niezbędne dane",
                            "Błąd wartości",
                            JOptionPane.ERROR_MESSAGE);

                }
                session.beginTransaction();
                try {
                    pracownik.setImie(imie);
                    pracownik.setNazwisko(nazwisko);
                    pracownik.setKodLog(kod);
                    pracownik.setHaslo(haslo);
                    pracownik.setAdresByIdAdres(adres);
                    pracownik.setRolaByIdRola(role.get(2));
                    session.save(pracownik);
                    session.getTransaction().commit();

                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie dodany wybrany rekord",
                            "Powodzenie dodawania rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można dodać rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd dodawania rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "DODAJ KLIENTA") {
                String imie = "";
                String nazwisko = "";
                String kod = "";
                String haslo = "";
                String nr = "";
                AdresEntity adres = new AdresEntity();
                KlientEntity klient = new KlientEntity();
                try {
                    imie = creator.jeden.getText().trim();
                    nazwisko = creator.dwa.getText().trim();
                    kod = creator.trzy.getText().trim();
                    haslo = creator.cztery.getText().trim();
                    nr = creator.piec.getText().trim();

                    adres = (AdresEntity) creator.adresEntityJComboBox.getSelectedItem();

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Wypełnij wszystkie niezbędne dane",
                            "Błąd wartości",
                            JOptionPane.ERROR_MESSAGE);

                }
                session.beginTransaction();
                try {
                    klient.setImie(imie);
                    klient.setNazwisko(nazwisko);
                    klient.setKodLog(kod);
                    klient.setHaslo(haslo);
                    klient.setNrTel(nr);
                    klient.setRolaByIdRola(role.get(1));
                    klient.setAdresByIdAdres(adres);
                    session.save(klient);
                    session.getTransaction().commit();

                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie dodany wybrany rekord",
                            "Powodzenie dodawania rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można dodać rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd dodawania rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "DODAJ EGZEMPLARZ") {

                String stan = "";
                String dost = "";
                Integer rozmiar = null;
                Double cena = null;
                ZamowienieEntity zamowienie = new ZamowienieEntity();
                ProduktEntity produkt = new ProduktEntity();
                EgzemplarzEntity egzemplarz = new EgzemplarzEntity();


                try {
                    stan = creator.dwa.getText().trim();
                    dost = creator.trzy.getText().trim();
                    rozmiar = Integer.valueOf(creator.cztery.getText().trim());
                    produkt = (ProduktEntity) creator.produktEntityJComboBox.getSelectedItem();
                    zamowienie = (ZamowienieEntity) creator.zamowienieEntityJComboBox.getSelectedItem();

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Wypełnij wszystkie niezbędne dane",
                            "Błąd wartości",
                            JOptionPane.ERROR_MESSAGE);

                }
                session.beginTransaction();
                try {

                    egzemplarz.setStan(stan);
                    egzemplarz.setDostepne(dost);
                    egzemplarz.setRozmiar(rozmiar);
                    egzemplarz.setProduktByIdProdukt(produkt);
                    egzemplarz.setZamowienieByIdZamowienie(zamowienie);
                    session.save(egzemplarz);
                    session.getTransaction().commit();

                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie dodany wybrany rekord",
                            "Powodzenie dodawania rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można dodać rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd dodawania rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "DODAJ ZAMÓWIENIE") {


                String datazam = "";
                String datawys = "";
                KlientEntity klient = new KlientEntity();
                PracownikEntity pracownik = new PracownikEntity();
                ZamowienieEntity zamowienie = new ZamowienieEntity();
                try {
                    datazam = creator.jeden.getText().trim();
                    datawys = creator.dwa.getText().trim();
                    pracownik = (PracownikEntity) creator.pracownikEntityJComboBox.getSelectedItem();
                    klient = (KlientEntity) creator.klientEntityJComboBox.getSelectedItem();

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Wypełnij wszystkie niezbędne dane",
                            "Błąd wartości",
                            JOptionPane.ERROR_MESSAGE);

                }
                session.beginTransaction();
                try {
                    zamowienie.setDataZamowienia(Date.valueOf(datazam));
                    zamowienie.setDataWysylki(Date.valueOf(datawys));
                    zamowienie.setPracownikByIdPracownik(pracownik);
                    zamowienie.setKlientByIdKlient(klient);
                    session.save(zamowienie);
                    session.getTransaction().commit();

                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie dodany wybrany rekord",
                            "Powodzenie dodawania rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można dodać rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd dodawania rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }
            for (ZamowienieEntity a : zamowienia) {
                a.updateCena();
            }
            for (EgzemplarzEntity a : egzemplarze){
                a.updatedost();
            }
            session.close();

        }
    }
}
