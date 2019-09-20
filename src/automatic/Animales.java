/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatic;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author juan pablo
 */
@Entity
@Table(name = "animales", catalog = "crud", schema = "")
@NamedQueries({
    @NamedQuery(name = "Animales.findAll", query = "SELECT a FROM Animales a"),
    @NamedQuery(name = "Animales.findByIdAnimales", query = "SELECT a FROM Animales a WHERE a.idAnimales = :idAnimales"),
    @NamedQuery(name = "Animales.findByNombre", query = "SELECT a FROM Animales a WHERE a.nombre = :nombre")})
public class Animales implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_animales")
    private Integer idAnimales;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    public Animales() {
    }

    public Animales(Integer idAnimales) {
        this.idAnimales = idAnimales;
    }

    public Animales(Integer idAnimales, String nombre) {
        this.idAnimales = idAnimales;
        this.nombre = nombre;
    }

    public Integer getIdAnimales() {
        return idAnimales;
    }

    public void setIdAnimales(Integer idAnimales) {
        Integer oldIdAnimales = this.idAnimales;
        this.idAnimales = idAnimales;
        changeSupport.firePropertyChange("idAnimales", oldIdAnimales, idAnimales);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnimales != null ? idAnimales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animales)) {
            return false;
        }
        Animales other = (Animales) object;
        if ((this.idAnimales == null && other.idAnimales != null) || (this.idAnimales != null && !this.idAnimales.equals(other.idAnimales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "automatic.Animales[ idAnimales=" + idAnimales + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
