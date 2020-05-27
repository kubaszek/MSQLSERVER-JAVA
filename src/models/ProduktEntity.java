package models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "produkt", schema = "dbo", catalog = "db_java")
public class ProduktEntity {
    private int idProdukt;
    private String model;
    private String kolorystyka;
    private Date dataPremiery;
    private double cenaNetto;
    private double cenaBrutto;
    private Collection<EgzemplarzEntity> egzemplarzsByIdProdukt;
    private ProducentEntity producentByIdProducent;
    private ProjektantEntity projektantByIdProjektant;

    public String toString(){
        return (model + " " + kolorystyka);
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_produkt")
    public int getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(int idProdukt) {
        this.idProdukt = idProdukt;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "kolorystyka")
    public String getKolorystyka() {
        return kolorystyka;
    }

    public void setKolorystyka(String kolorystyka) {
        this.kolorystyka = kolorystyka;
    }

    @Basic
    @Column(name = "data_premiery")
    public Date getDataPremiery() {
        return dataPremiery;
    }

    public void setDataPremiery(Date dataPremiery) {
        this.dataPremiery = dataPremiery;
    }

    @Basic
    @Column(name = "cena_netto")
    public double getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(double cenaNetto) {
        this.cenaNetto = cenaNetto;
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
        ProduktEntity that = (ProduktEntity) o;
        return idProdukt == that.idProdukt &&
                Double.compare(that.cenaNetto, cenaNetto) == 0 &&
                Double.compare(that.cenaBrutto, cenaBrutto) == 0 &&
                Objects.equals(model, that.model) &&
                Objects.equals(kolorystyka, that.kolorystyka) &&
                Objects.equals(dataPremiery, that.dataPremiery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, model, kolorystyka, dataPremiery, cenaNetto, cenaBrutto);
    }

    @OneToMany(mappedBy = "produktByIdProdukt")
    public Collection<EgzemplarzEntity> getEgzemplarzsByIdProdukt() {
        return egzemplarzsByIdProdukt;
    }

    public void setEgzemplarzsByIdProdukt(Collection<EgzemplarzEntity> egzemplarzsByIdProdukt) {
        this.egzemplarzsByIdProdukt = egzemplarzsByIdProdukt;
    }

    @ManyToOne
    @JoinColumn(name = "id_producent", referencedColumnName = "id_producent", nullable = false)
    public ProducentEntity getProducentByIdProducent() {
        return producentByIdProducent;
    }

    public void setProducentByIdProducent(ProducentEntity producentByIdProducent) {
        this.producentByIdProducent = producentByIdProducent;
    }

    @ManyToOne
    @JoinColumn(name = "id_projektant", referencedColumnName = "id_projektant", nullable = false)
    public ProjektantEntity getProjektantByIdProjektant() {
        return projektantByIdProjektant;
    }

    public void setProjektantByIdProjektant(ProjektantEntity projektantByIdProjektant) {
        this.projektantByIdProjektant = projektantByIdProjektant;
    }
}
