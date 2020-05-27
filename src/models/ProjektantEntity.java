package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "projektant", schema = "dbo", catalog = "db_java")
public class ProjektantEntity {
    private int idProjektant;
    private String imie;
    private String nazwisko;
    private String krajPochodzenia;
    private String skrot;
    private Collection<ProduktEntity> produktsByIdProjektant;

    public String toString(){
        return (skrot);
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_projektant")
    public int getIdProjektant() {
        return idProjektant;
    }

    public void setIdProjektant(int idProjektant) {
        this.idProjektant = idProjektant;
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
    @Column(name = "kraj_pochodzenia")
    public String getKrajPochodzenia() {
        return krajPochodzenia;
    }

    public void setKrajPochodzenia(String krajPochodzenia) {
        this.krajPochodzenia = krajPochodzenia;
    }

    @Basic
    @Column(name = "skrot")
    public String getSkrot() {
        return skrot;
    }

    public void setSkrot(String skrot) {
        this.skrot = skrot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjektantEntity that = (ProjektantEntity) o;
        return idProjektant == that.idProjektant &&
                Objects.equals(imie, that.imie) &&
                Objects.equals(nazwisko, that.nazwisko) &&
                Objects.equals(krajPochodzenia, that.krajPochodzenia) &&
                Objects.equals(skrot, that.skrot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProjektant, imie, nazwisko, krajPochodzenia, skrot);
    }

    @OneToMany(mappedBy = "projektantByIdProjektant")
    public Collection<ProduktEntity> getProduktsByIdProjektant() {
        return produktsByIdProjektant;
    }

    public void setProduktsByIdProjektant(Collection<ProduktEntity> produktsByIdProjektant) {
        this.produktsByIdProjektant = produktsByIdProjektant;
    }
}
