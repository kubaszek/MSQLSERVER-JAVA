package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "adres", schema = "dbo", catalog = "db_java")
public class AdresEntity {
    private int idAdres;
    private String ulica;
    private Integer nrDomu;
    private Integer nrLokalu;
    private String dzielnica;
    private String miasto;
    private String kodPocztowy;
    private Collection<KlientEntity> klientsByIdAdres;
    private Collection<PracownikEntity> pracowniksByIdAdres;

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_adres")
    public int getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(int idAdres) {
        this.idAdres = idAdres;
    }

    @Basic
    @Column(name = "ulica")
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Basic
    @Column(name = "nr_domu")
    public Integer getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(Integer nrDomu) {
        this.nrDomu = nrDomu;
    }

    @Basic
    @Column(name = "nr_lokalu")
    public Integer getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(Integer nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    @Basic
    @Column(name = "dzielnica")
    public String getDzielnica() {
        return dzielnica;
    }

    public void setDzielnica(String dzielnica) {
        this.dzielnica = dzielnica;
    }

    @Basic
    @Column(name = "miasto")
    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Basic
    @Column(name = "kod_pocztowy")
    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresEntity that = (AdresEntity) o;
        return idAdres == that.idAdres &&
                nrDomu == that.nrDomu &&
                Objects.equals(ulica, that.ulica) &&
                Objects.equals(nrLokalu, that.nrLokalu) &&
                Objects.equals(dzielnica, that.dzielnica) &&
                Objects.equals(miasto, that.miasto) &&
                Objects.equals(kodPocztowy, that.kodPocztowy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdres, ulica, nrDomu, nrLokalu, dzielnica, miasto, kodPocztowy);
    }

    @OneToMany(mappedBy = "adresByIdAdres")
    public Collection<KlientEntity> getKlientsByIdAdres() {
        return klientsByIdAdres;
    }

    public void setKlientsByIdAdres(Collection<KlientEntity> klientsByIdAdres) {
        this.klientsByIdAdres = klientsByIdAdres;
    }

    @OneToMany(mappedBy = "adresByIdAdres")
    public Collection<PracownikEntity> getPracowniksByIdAdres() {
        return pracowniksByIdAdres;
    }

    public void setPracowniksByIdAdres(Collection<PracownikEntity> pracowniksByIdAdres) {
        this.pracowniksByIdAdres = pracowniksByIdAdres;
    }

    public String toString(){
    return (miasto + " " + kodPocztowy + " " + dzielnica + " " + ulica + " " + nrDomu + " " + nrLokalu);
        }
}
