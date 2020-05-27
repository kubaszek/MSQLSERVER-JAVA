package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "rola", schema = "dbo", catalog = "db_java")
public class RolaEntity {
    private int idRola;
    private String rola;
    private Collection<KlientEntity> klientsByIdRola;
    private Collection<PracownikEntity> pracowniksByIdRola;

    @Id
    @Column(name = "id_rola")
    public int getIdRola() {
        return idRola;
    }

    public void setIdRola(int idRola) {
        this.idRola = idRola;
    }

    @Basic
    @Column(name = "rola")
    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolaEntity that = (RolaEntity) o;
        return idRola == that.idRola &&
                Objects.equals(rola, that.rola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRola, rola);
    }

    @OneToMany(mappedBy = "rolaByIdRola")
    public Collection<KlientEntity> getKlientsByIdRola() {
        return klientsByIdRola;
    }

    public void setKlientsByIdRola(Collection<KlientEntity> klientsByIdRola) {
        this.klientsByIdRola = klientsByIdRola;
    }

    @OneToMany(mappedBy = "rolaByIdRola")
    public Collection<PracownikEntity> getPracowniksByIdRola() {
        return pracowniksByIdRola;
    }

    public void setPracowniksByIdRola(Collection<PracownikEntity> pracowniksByIdRola) {
        this.pracowniksByIdRola = pracowniksByIdRola;
    }
}
