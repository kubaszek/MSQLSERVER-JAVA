package logic;

import gui.updater;
import gui.workspace;
import main.Main;
import models.*;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class updatelisteners implements ActionListener {


    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();
        Session session = Main.getSession();
        List<ProjektantEntity> projektanci = session.createQuery("from ProjektantEntity ").list();
        List<AdresEntity> adresy = session.createQuery("from AdresEntity ").list();
        List<EgzemplarzEntity> egzemplarze = session.createQuery("from EgzemplarzEntity ").list();
        List<KlientEntity> klienci = session.createQuery("from KlientEntity ").list();
        List<PracownikEntity> pracownicy = session.createQuery("from PracownikEntity ").list();
        List<ProduktEntity> produkty = session.createQuery("from ProduktEntity ").list();
        List<ZamowienieEntity> zamowienia = session.createQuery("from ZamowienieEntity ").list();
        List<ProducentEntity> producenci = session.createQuery("from ProducentEntity ").list();
        List<RolaEntity> role = session.createQuery("from RolaEntity ").list();
        Object template = new Object();
        AdresEntity adresEntity;
        EgzemplarzEntity egzemplarzEntity;
        KlientEntity klientEntity;
        PracownikEntity pracownikEntity;
        ProduktEntity produktEntity;
        ProjektantEntity projektantEntity;
        ZamowienieEntity zamowienieEntity;
        ProducentEntity producentEntity;

        if (singleton.instance.GetFunc() == "user") {

            JOptionPane.showMessageDialog(null,
                    "BRAK ODPOWIEDNICH UPRAWNIEN",
                    "Brak uprawnień",
                    JOptionPane.ERROR_MESSAGE);

        } else {


            if (source.getText() == "Update") {


                template = workspace.comboBoxName.getSelectedItem();

                JFrame updater = new updater();

                if (template.getClass() == AdresEntity.class) {

                    adresEntity = (AdresEntity) template;
                    gui.updater.one.setText("Miasto");
                    gui.updater.two.setText("Kod Pocztowy");
                    gui.updater.three.setText("Ulica");
                    gui.updater.four.setText("Nr Domu");
                    gui.updater.five.setText("Nr Lokalu");
                    gui.updater.six.setText("Dzielnica");
                    gui.updater.save.setText("ZAKTUALIZUJ ADRES");
                    gui.updater.panel.add(gui.updater.piec);
                    gui.updater.panel.add(gui.updater.szesc);
                    gui.updater.jeden.setText(adresEntity.getMiasto());
                    gui.updater.dwa.setText(adresEntity.getKodPocztowy());
                    gui.updater.trzy.setText(adresEntity.getUlica());
                    gui.updater.cztery.setText(adresEntity.getNrDomu().toString());
                    gui.updater.piec.setText(adresEntity.getNrLokalu().toString());
                    gui.updater.szesc.setText(adresEntity.getDzielnica());


                }

                if (template.getClass() == EgzemplarzEntity.class) {

                    egzemplarzEntity = (EgzemplarzEntity) template;
                    gui.updater.one.setText("-----");
                    gui.updater.two.setText("Stan");
                    gui.updater.three.setText("Dostępność");
                    gui.updater.four.setText("Rozmiar");
                    gui.updater.five.setText("Zamówienie");
                    gui.updater.six.setText("Produkt");
                    gui.updater.save.setText("ZAKTUALIZUJ EGZEMPLARZ");
                    gui.updater.panel.add(gui.updater.zamowienieEntityJComboBox);
                    gui.updater.panel.add(gui.updater.produktEntityJComboBox);
                    for (ZamowienieEntity a : zamowienia) {
                        gui.updater.zamowienieEntityJComboBox.addItem(a);
                    }
                    gui.updater.zamowienieEntityJComboBox.addItem(null);
                    for (ProduktEntity a : produkty) {
                        gui.updater.produktEntityJComboBox.addItem(a);
                    }
                    gui.updater.dwa.setText(egzemplarzEntity.getStan());
                    gui.updater.trzy.setText(egzemplarzEntity.getDostepne());
                    gui.updater.cztery.setText(egzemplarzEntity.getRozmiar().toString());
                    gui.updater.zamowienieEntityJComboBox.setSelectedItem(egzemplarzEntity.getZamowienieByIdZamowienie());
                    gui.updater.produktEntityJComboBox.setSelectedItem(egzemplarzEntity.getProduktByIdProdukt());

                }

                if (template.getClass() == KlientEntity.class) {

                    klientEntity = (KlientEntity) template;
                    gui.updater.one.setText("Imie");
                    gui.updater.two.setText("Nazwisko");
                    gui.updater.three.setText("Kod logowania");
                    gui.updater.four.setText("Hasło");
                    gui.updater.five.setText("Nr telefonu");
                    gui.updater.six.setText("Adres");
                    gui.updater.save.setText("ZAKTUALIZUJ KLIENTA");
                    gui.updater.panel.add(gui.updater.piec);
                    gui.updater.panel.add(gui.updater.adresEntityJComboBox);
                    for (AdresEntity a : adresy) {
                        gui.updater.adresEntityJComboBox.addItem(a);
                    }
                    gui.updater.jeden.setText(klientEntity.getImie());
                    gui.updater.dwa.setText(klientEntity.getNazwisko());
                    gui.updater.trzy.setText(klientEntity.getKodLog());
                    gui.updater.cztery.setText(klientEntity.getHaslo());
                    gui.updater.piec.setText(klientEntity.getNrTel());
                    gui.updater.adresEntityJComboBox.setSelectedItem(klientEntity.getAdresByIdAdres());
                }

                if (template.getClass() == PracownikEntity.class) {

                    pracownikEntity = (PracownikEntity) template;
                    gui.updater.one.setText("Imie");
                    gui.updater.two.setText("Nazwisko");
                    gui.updater.three.setText("Kod logowania");
                    gui.updater.four.setText("Hasło");
                    gui.updater.five.setText("-----");
                    gui.updater.six.setText("Adres");
                    gui.updater.save.setText("ZAKTUALIZUJ PRACOWNIKA");
                    gui.updater.panel.add(gui.updater.piec);
                    gui.updater.panel.add(gui.updater.adresEntityJComboBox);
                    for (AdresEntity a : adresy) {
                        gui.updater.adresEntityJComboBox.addItem(a);
                    }
                    gui.updater.jeden.setText(pracownikEntity.getImie());
                    gui.updater.dwa.setText(pracownikEntity.getNazwisko());
                    gui.updater.trzy.setText(pracownikEntity.getKodLog());
                    gui.updater.cztery.setText(pracownikEntity.getHaslo());
                    gui.updater.adresEntityJComboBox.setSelectedItem(pracownikEntity.getAdresByIdAdres());

                }

                if (template.getClass() == ProducentEntity.class) {

                    producentEntity = (ProducentEntity) template;
                    gui.updater.one.setText("Nazwa");
                    gui.updater.two.setText("Kraj");
                    gui.updater.three.setText("NIP");
                    gui.updater.four.setText("Kategoria");
                    gui.updater.five.setText("-----");
                    gui.updater.six.setText("-----");
                    gui.updater.save.setText("ZAKTUALIZUJ PRODUCENTA");
                    gui.updater.panel.add(gui.updater.piec);
                    gui.updater.panel.add(gui.updater.szesc);
                    gui.updater.jeden.setText(producentEntity.getNazwa());
                    gui.updater.dwa.setText(producentEntity.getKraj());
                    gui.updater.trzy.setText(producentEntity.getNip());
                    gui.updater.cztery.setText(producentEntity.getKategoria());
                }

                if (template.getClass() == ProduktEntity.class) {

                    produktEntity = (ProduktEntity) template;
                    gui.updater.one.setText("Model");
                    gui.updater.two.setText("Kolorystyka");
                    gui.updater.three.setText("Data Premiery RRRR-MM-DD");
                    gui.updater.four.setText("Cena Netto");
                    gui.updater.five.setText("Producent");
                    gui.updater.six.setText("Projektant");
                    gui.updater.save.setText("ZAKTUALIZUJ PRODUKT");
                    gui.updater.panel.add(gui.updater.producentEntityJComboBox);
                    gui.updater.panel.add(gui.updater.projektantEntityJComboBox);
                    for (ProducentEntity a : producenci) {
                        gui.updater.producentEntityJComboBox.addItem(a);
                    }
                    for (ProjektantEntity a : projektanci) {
                        gui.updater.projektantEntityJComboBox.addItem(a);
                    }
                    gui.updater.jeden.setText(produktEntity.getModel());
                    gui.updater.dwa.setText(produktEntity.getKolorystyka());
                    gui.updater.trzy.setText(produktEntity.getDataPremiery().toString());
                    gui.updater.cztery.setText(String.valueOf(produktEntity.getCenaNetto()));
                    gui.updater.producentEntityJComboBox.setSelectedItem(produktEntity.getProducentByIdProducent());
                    gui.updater.projektantEntityJComboBox.setSelectedItem(produktEntity.getProjektantByIdProjektant());

                }

                if (template.getClass() == ProjektantEntity.class) {

                    projektantEntity = (ProjektantEntity) template;
                    gui.updater.one.setText("Imie");
                    gui.updater.two.setText("Nazwisko");
                    gui.updater.three.setText("Kraj Pochodzenia");
                    gui.updater.four.setText("Nazwa");
                    gui.updater.five.setText("-----");
                    gui.updater.six.setText("-----");
                    gui.updater.save.setText("ZAKTUALIZUJ PROJEKTANTA");
                    gui.updater.panel.add(gui.updater.piec);
                    gui.updater.panel.add(gui.updater.szesc);
                    gui.updater.jeden.setText(projektantEntity.getImie());
                    gui.updater.dwa.setText(projektantEntity.getNazwisko());
                    gui.updater.trzy.setText(projektantEntity.getKrajPochodzenia());
                    gui.updater.cztery.setText(projektantEntity.getSkrot());
                }

                if (template.getClass() == ZamowienieEntity.class) {

                    zamowienieEntity = (ZamowienieEntity) template;
                    gui.updater.one.setText("Data zamówienia RRRR-MM-DD");
                    gui.updater.two.setText("Data wysyłki RRRR-MM-DD");
                    gui.updater.three.setText("-----");
                    gui.updater.four.setText("-----");
                    gui.updater.five.setText("Pracownik");
                    gui.updater.six.setText("Klient");
                    gui.updater.save.setText("ZAKTUALIZUJ ZAMÓWIENIE");
                    gui.updater.panel.add(gui.updater.pracownikEntityJComboBox);
                    gui.updater.panel.add(gui.updater.klientEntityJComboBox);
                    for (PracownikEntity a : pracownicy) {
                        gui.updater.pracownikEntityJComboBox.addItem(a);
                    }
                    for (KlientEntity a : klienci) {
                        gui.updater.klientEntityJComboBox.addItem(a);
                    }
                    gui.updater.jeden.setText(zamowienieEntity.getDataZamowienia().toString());
                    gui.updater.dwa.setText(zamowienieEntity.getDataWysylki().toString());
                    gui.updater.pracownikEntityJComboBox.setSelectedItem(zamowienieEntity.getPracownikByIdPracownik());
                    gui.updater.klientEntityJComboBox.setSelectedItem(zamowienieEntity.getKlientByIdKlient());

                }


            }

            if (source.getText() == "ZAKTUALIZUJ ADRES") {

                AdresEntity adresEntity1 = (AdresEntity) workspace.comboBoxName.getSelectedItem();
                AdresEntity adres = (AdresEntity) session.get(AdresEntity.class, adresEntity1.getIdAdres());
                String miasto = "";
                String kod = "";
                String ulica = "";
                Integer nr_dom = null;
                Integer nr_lokal = null;
                String dzielnica = "";


                try {
                    miasto = gui.updater.jeden.getText().trim();
                    kod = gui.updater.dwa.getText().trim();
                    ulica = gui.updater.trzy.getText().trim();
                    nr_dom = Integer.valueOf(gui.updater.cztery.getText().trim());
                    if (gui.updater.piec.getText().trim().isEmpty()) {
                    } else {
                        nr_lokal = Integer.valueOf(gui.updater.piec.getText().trim());
                    }

                    dzielnica = gui.updater.szesc.getText().trim();
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
                            "Pomyślnie zaktualizowano wybrany rekord",
                            "Powodzenie aktualizacji rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można zaktualizować rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd aktualizacji rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "ZAKTUALIZUJ PRODUCENTA") {

                ProducentEntity producentEntity1 = (ProducentEntity) workspace.comboBoxName.getSelectedItem();
                ProducentEntity producent = (ProducentEntity) session.get(ProducentEntity.class, producentEntity1.getIdProducent());

                String nazwa = "";
                String kraj = "";
                String nip = "";
                String kategoria = "";

                try {
                    nazwa = gui.updater.jeden.getText().trim();
                    kraj = gui.updater.dwa.getText().trim();
                    nip = gui.updater.trzy.getText().trim();
                    kategoria = gui.updater.cztery.getText().trim();
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
                            "Pomyślnie zaktualizowano wybrany rekord",
                            "Powodzenie aktualizacji rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można zaktualizować rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd aktualizacji rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "ZAKTUALIZUJ PROJEKTANTA") {

                ProjektantEntity projektantEntity1 = (ProjektantEntity) workspace.comboBoxName.getSelectedItem();
                ProjektantEntity projektant = (ProjektantEntity) session.get(ProjektantEntity.class, projektantEntity1.getIdProjektant());


                String imie = "";
                String nazwisko = "";
                String kraj = "";
                String nazwa = "";


                try {
                    imie = gui.updater.jeden.getText().trim();
                    nazwisko = gui.updater.dwa.getText().trim();
                    kraj = gui.updater.trzy.getText().trim();
                    nazwa = gui.updater.cztery.getText().trim();
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
                            "Pomyślnie zaktualizowano wybrany rekord",
                            "Powodzenie aktualizacji rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można zaktualizować rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd aktualizacji rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "ZAKTUALIZUJ PRODUKT") {

                ProduktEntity produktEntity1 = (ProduktEntity) workspace.comboBoxName.getSelectedItem();
                ProduktEntity produkt = (ProduktEntity) session.get(ProduktEntity.class, produktEntity1.getIdProdukt());

                String model = "";
                String cw = "";
                String data = "";
                Double cena = null;
                ProducentEntity producent = new ProducentEntity();
                ProjektantEntity projektant = new ProjektantEntity();

                try {
                    model = gui.updater.jeden.getText().trim();
                    cw = gui.updater.dwa.getText().trim();
                    data = gui.updater.trzy.getText().trim();
                    cena = Double.parseDouble(gui.updater.cztery.getText().trim());
                    producent = (ProducentEntity) gui.updater.producentEntityJComboBox.getSelectedItem();
                    projektant = (ProjektantEntity) gui.updater.projektantEntityJComboBox.getSelectedItem();

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
                            "Pomyślnie zaktualizowano wybrany rekord",
                            "Powodzenie aktualizacji rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można zaktualizować rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd aktualizacji rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "ZAKTUALIZUJ PRACOWNIKA") {

                PracownikEntity pracownikEntity1 = (PracownikEntity) workspace.comboBoxName.getSelectedItem();
                PracownikEntity pracownik = (PracownikEntity) session.get(PracownikEntity.class, pracownikEntity1.getIdPracownik());

                String imie = "";
                String nazwisko = "";
                String kod = "";
                String haslo = "";
                AdresEntity adres = new AdresEntity();

                try {
                    imie = gui.updater.jeden.getText().trim();
                    nazwisko = gui.updater.dwa.getText().trim();
                    kod = gui.updater.trzy.getText().trim();
                    haslo = gui.updater.cztery.getText().trim();
                    adres = (AdresEntity) gui.updater.adresEntityJComboBox.getSelectedItem();

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
                    pracownik.setRolaByIdRola(role.get(3));
                    session.save(pracownik);
                    session.getTransaction().commit();

                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie zaktualizowano wybrany rekord",
                            "Powodzenie aktualizacji rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można zaktualizować rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd aktualizacji rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "ZAKTUALIZUJ KLIENTA") {

                KlientEntity klientEntity1 = (KlientEntity) workspace.comboBoxName.getSelectedItem();
                KlientEntity klient = (KlientEntity) session.get(KlientEntity.class, klientEntity1.getIdKlient());

                String imie = "";
                String nazwisko = "";
                String kod = "";
                String haslo = "";
                String nr = "";
                AdresEntity adres = new AdresEntity();

                try {
                    imie = gui.updater.jeden.getText().trim();
                    nazwisko = gui.updater.dwa.getText().trim();
                    kod = gui.updater.trzy.getText().trim();
                    haslo = gui.updater.cztery.getText().trim();
                    nr = gui.updater.piec.getText().trim();

                    adres = (AdresEntity) gui.updater.adresEntityJComboBox.getSelectedItem();

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
                    klient.setRolaByIdRola(role.get(2));
                    klient.setAdresByIdAdres(adres);
                    session.save(klient);
                    session.getTransaction().commit();

                    JOptionPane.showMessageDialog(null,
                            "Pomyślnie zaktualizowano wybrany rekord",
                            "Powodzenie aktualizacji rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można zaktualizować rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd aktualizacji rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "ZAKTUALIZUJ EGZEMPLARZ") {

                EgzemplarzEntity egzemplarzEntity1 = (EgzemplarzEntity) workspace.comboBoxName.getSelectedItem();
                EgzemplarzEntity egzemplarz = (EgzemplarzEntity) session.get(EgzemplarzEntity.class, egzemplarzEntity1.getIdEgzemplarz());


                String stan = "";
                String dost = "";
                Integer rozmiar = null;
                Double cena = null;
                ZamowienieEntity zamowienie = new ZamowienieEntity();
                ProduktEntity produkt = new ProduktEntity();


                try {
                    stan = gui.updater.dwa.getText().trim();
                    dost = gui.updater.trzy.getText().trim();
                    rozmiar = Integer.valueOf(gui.updater.cztery.getText().trim());
                    produkt = (ProduktEntity) gui.updater.produktEntityJComboBox.getSelectedItem();
                    zamowienie = (ZamowienieEntity) gui.updater.zamowienieEntityJComboBox.getSelectedItem();

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
                            "Pomyślnie zaktualizowano wybrany rekord",
                            "Powodzenie aktualizacji rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można zaktualizować rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd aktualizacji rekordu",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            if (source.getText() == "ZAKTUALIZUJ ZAMÓWIENIE") {


                ZamowienieEntity zamowienieEntity1 = (ZamowienieEntity) workspace.comboBoxName.getSelectedItem();
                ZamowienieEntity zamowienie = (ZamowienieEntity) session.get(ZamowienieEntity.class, zamowienieEntity1.getIdZamowienie());

                String datazam = "";
                String datawys = "";
                KlientEntity klient = new KlientEntity();
                PracownikEntity pracownik = new PracownikEntity();

                try {
                    datazam = gui.updater.jeden.getText().trim();
                    datawys = gui.updater.dwa.getText().trim();
                    pracownik = (PracownikEntity) gui.updater.pracownikEntityJComboBox.getSelectedItem();
                    klient = (KlientEntity) gui.updater.klientEntityJComboBox.getSelectedItem();

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
                            "Pomyślnie zaktualizowano wybrany rekord",
                            "Powodzenie aktualizacji rekordu",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "Nie można zaktualizować rekordu, sprawdź poprawność danych i spróbuj ponownie",
                            "Błąd aktualizacji rekordu",
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