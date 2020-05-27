package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "klient", schema = "dbo", catalog = "db_java")
public class KlientEntity {
    private int idKlient;
    private String imie;
    private String nazwisko;
    private String kodLog;
    private String haslo;
    private String nrTel;
    private AdresEntity adresByIdAdres;
    private RolaEntity rolaByIdRola;
    private Collection<ZamowienieEntity> zamowieniesByIdKlient;


    public String toString(){
        return (imie + " " + nazwisko + " " + "Nr tel: " + nrTel);
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_klient")
    public int getIdKlient() {
        return idKlient;
    }

    public void setIdKlient(int idKlient) {
        this.idKlient = idKlient;
    }

    @Basic
    @Column(name = "imie")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "kod_log")
    public String getKodLog() {
        return kodLog;
    }

    public void setKodLog(String kodLog) {
        this.kodLog = kodLog;
    }

    @Basic
    @Column(name = "haslo")
    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Basic
    @Column(name = "nr_tel")
    public String getNrTel() {
        return nrTel;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KlientEntity that = (KlientEntity) o;
        return idKlient == that.idKlient &&
                Objects.equals(imie, that.imie) &&
                Objects.equals(nazwisko, that.nazwisko) &&
                Objects.equals(kodLog, that.kodLog) &&
                Objects.equals(haslo, that.haslo) &&
                Objects.equals(nrTel, that.nrTel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKlient, imie, nazwisko, kodLog, haslo, nrTel);
    }

    @ManyToOne
    @JoinColumn(name = "id_adres", referencedColumnName = "id_adres", nullable = false)
    public AdresEntity getAdresByIdAdres() {
        return adresByIdAdres;
    }

    public void setAdresByIdAdres(AdresEntity adresByIdAdres) {
        this.adresByIdAdres = adresByIdAdres;
    }

    @ManyToOne
    @JoinColumn(name = "id_rola", referencedColumnName = "id_rola", nullable = false)
    public RolaEntity getRolaByIdRola() {
        return rolaByIdRola;
    }

    public void setRolaByIdRola(RolaEntity rolaByIdRola) {
        this.rolaByIdRola = rolaByIdRola;
    }

    @OneToMany(mappedBy = "klientByIdKlient")
    public Collection<ZamowienieEntity> getZamowieniesByIdKlient() {
        return zamowieniesByIdKlient;
    }

    public void setZamowieniesByIdKlient(Collection<ZamowienieEntity> zamowieniesByIdKlient) {
        this.zamowieniesByIdKlient = zamowieniesByIdKlient;
    }
}
