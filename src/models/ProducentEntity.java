package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "producent", schema = "dbo", catalog = "db_java")
public class ProducentEntity {
    private int idProducent;
    private String nazwa;
    private String kraj;
    private String nip;
    private String kategoria;
    private Collection<ProduktEntity> produktsByIdProducent;


    public String toString(){
        return (nazwa);
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_producent")
    public int getIdProducent() {
        return idProducent;
    }

    public void setIdProducent(int idProducent) {
        this.idProducent = idProducent;
    }

    @Basic
    @Column(name = "nazwa")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "kraj")
    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    @Basic
    @Column(name = "NIP")
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Basic
    @Column(name = "kategoria")
    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducentEntity that = (ProducentEntity) o;
        return idProducent == that.idProducent &&
                Objects.equals(nazwa, that.nazwa) &&
                Objects.equals(kraj, that.kraj) &&
                Objects.equals(nip, that.nip) &&
                Objects.equals(kategoria, that.kategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducent, nazwa, kraj, nip, kategoria);
    }

    @OneToMany(mappedBy = "producentByIdProducent")
    public Collection<ProduktEntity> getProduktsByIdProducent() {
        return produktsByIdProducent;
    }

    public void setProduktsByIdProducent(Collection<ProduktEntity> produktsByIdProducent) {
        this.produktsByIdProducent = produktsByIdProducent;
    }
}
