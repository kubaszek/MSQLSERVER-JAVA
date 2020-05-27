package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "egzemplarz", schema = "dbo", catalog = "db_java")
public class EgzemplarzEntity {
    private int idEgzemplarz;
    private String stan;
    private String dostepne;
    private Integer rozmiar;
    private ProduktEntity produktByIdProdukt;
    private ZamowienieEntity zamowienieByIdZamowienie;

    public String toString(){
        return (getProduktByIdProdukt().getModel() + " " + getProduktByIdProdukt().getKolorystyka() + " " + stan + " " + dostepne + " " + rozmiar);
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_egzemplarz")
    public int getIdEgzemplarz() {
        return idEgzemplarz;
    }

    public void setIdEgzemplarz(int idEgzemplarz) {
        this.idEgzemplarz = idEgzemplarz;
    }

    @Basic
    @Column(name = "stan")
    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public void updatedost(){
        if(this.getZamowienieByIdZamowienie() == null){
            this.setDostepne("Dostepne");
        }
        else{
            this.setDostepne("Niedostepne");
        }
    }

    @Basic
    @Column(name = "dostepne")
    public String getDostepne() {
        return dostepne;
    }

    public void setDostepne(String dostepne) {
        this.dostepne = dostepne;
    }

    @Basic
    @Column(name = "rozmiar")
    public Integer getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EgzemplarzEntity that = (EgzemplarzEntity) o;
        return idEgzemplarz == that.idEgzemplarz &&
                rozmiar == that.rozmiar &&
                Objects.equals(stan, that.stan) &&
                Objects.equals(dostepne, that.dostepne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEgzemplarz, stan, dostepne, rozmiar);
    }

    @ManyToOne
    @JoinColumn(name = "id_produkt", referencedColumnName = "id_produkt", nullable = false)
    public ProduktEntity getProduktByIdProdukt() {
        return produktByIdProdukt;
    }

    public void setProduktByIdProdukt(ProduktEntity produktByIdProdukt) {
        this.produktByIdProdukt = produktByIdProdukt;
    }

    @ManyToOne
    @JoinColumn(name = "id_zamowienie", referencedColumnName = "id_zamowienie")
    public ZamowienieEntity getZamowienieByIdZamowienie() {
        return zamowienieByIdZamowienie;
    }

    public void setZamowienieByIdZamowienie(ZamowienieEntity zamowienieByIdZamowienie) {
        this.zamowienieByIdZamowienie = zamowienieByIdZamowienie;
    }
}
