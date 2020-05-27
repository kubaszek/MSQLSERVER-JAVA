package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pracownik", schema = "dbo", catalog = "db_java")
public class PracownikEntity {
    private int idPracownik;
    private String imie;
    private String nazwisko;
    private String kodLog;
    private String haslo;
    private AdresEntity adresByIdAdres;
    private RolaEntity rolaByIdRola;
    private Collection<ZamowienieEntity> zamowieniesByIdPracownik;


    public String toString(){
        return (imie + " " + nazwisko + " " + kodLog);
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_pracownik")
    public int getIdPracownik() {
        return idPracownik;
    }

    public void setIdPracownik(int idPracownik) {
        this.idPracownik = idPracownik;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracownikEntity that = (PracownikEntity) o;
        return idPracownik == that.idPracownik &&
                Objects.equals(imie, that.imie) &&
                Objects.equals(nazwisko, that.nazwisko) &&
                Objects.equals(kodLog, that.kodLog) &&
                Objects.equals(haslo, that.haslo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPracownik, imie, nazwisko, kodLog, haslo);
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

    @OneToMany(mappedBy = "pracownikByIdPracownik")
    public Collection<ZamowienieEntity> getZamowieniesByIdPracownik() {
        return zamowieniesByIdPracownik;
    }

    public void setZamowieniesByIdPracownik(Collection<ZamowienieEntity> zamowieniesByIdPracownik) {
        this.zamowieniesByIdPracownik = zamowieniesByIdPracownik;
    }
}
