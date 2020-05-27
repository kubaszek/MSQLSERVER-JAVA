package models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "zamowienie", schema = "dbo", catalog = "db_java")
public class ZamowienieEntity {
    private int idZamowienie;
    private Date dataZamowienia;
    private Date dataWysylki;
    private double cenaNetto ;
    private double cenaBrutto;
    private Collection<EgzemplarzEntity> egzemplarzsByIdZamowienie;
    private PracownikEntity pracownikByIdPracownik;
    private KlientEntity klientByIdKlient;

    public String toString(){
        return ("Data zamówienia: " + dataZamowienia + " " + klientByIdKlient.getImie() + " " + klientByIdKlient.getNazwisko());
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_zamowienie")
    public int getIdZamowienie() {
        return idZamowienie;
    }

    public void setIdZamowienie(int idZamowienie) {
        this.idZamowienie = idZamowienie;
    }

    @Basic
    @Column(name = "data_zamowienia")
    public Date getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(Date dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    @Basic
    @Column(name = "data_wysylki")
    public Date getDataWysylki() {
        return dataWysylki;
    }

    public void setDataWysylki(Date dataWysylki) {
        this.dataWysylki = dataWysylki;
    }

    @Basic
    @Column(name = "cena_netto")
    public double getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(double cenaNetto) {
        this.cenaNetto = cenaNetto;
    }

    public void updateCena(){

        double cenan = 0;
        for ( EgzemplarzEntity a : this.getEgzemplarzsByIdZamowienie()){
            cenan = cenan + a.getProduktByIdProdukt().getCenaNetto();

        }
        this.cenaNetto = cenan;
        this.cenaBrutto = cenan*1.23;
    }

    @Basic
    @Column(name = "cena_brutto")
    public double getCenaBrutto() {
        return cenaBrutto;
    }

    public void setCenaBrutto(double cenaBrutto) {
        this.cenaBrutto = cenaBrutto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZamowienieEntity that = (ZamowienieEntity) o;
        return idZamowienie == that.idZamowienie &&
                Double.compare(that.cenaNetto, cenaNetto) == 0 &&
                Double.compare(that.cenaBrutto, cenaBrutto) == 0 &&
                Objects.equals(dataZamowienia, that.dataZamowienia) &&
                Objects.equals(dataWysylki, that.dataWysylki);
    }



    @Override
    public int hashCode() {
        return Objects.hash(idZamowienie, dataZamowienia, dataWysylki, cenaNetto, cenaBrutto);
    }

    @OneToMany(mappedBy = "zamowienieByIdZamowienie")
    public Collection<EgzemplarzEntity> getEgzemplarzsByIdZamowienie() {
        return egzemplarzsByIdZamowienie;
    }

    public void setEgzemplarzsByIdZamowienie(Collection<EgzemplarzEntity> egzemplarzsByIdZamowienie) {
        this.egzemplarzsByIdZamowienie = egzemplarzsByIdZamowienie;
    }

    @ManyToOne
    @JoinColumn(name = "id_pracownik", referencedColumnName = "id_pracownik", nullable = false)
    public PracownikEntity getPracownikByIdPracownik() {
        return pracownikByIdPracownik;
    }

    public void setPracownikByIdPracownik(PracownikEntity pracownikByIdPracownik) {
        this.pracownikByIdPracownik = pracownikByIdPracownik;
    }

    @ManyToOne
    @JoinColumn(name = "id_klient", referencedColumnName = "id_klient", nullable = false)
    public KlientEntity getKlientByIdKlient() {
        return klientByIdKlient;
    }

    public void setKlientByIdKlient(KlientEntity klientByIdKlient) {
        this.klientByIdKlient = klientByIdKlient;
    }
}
