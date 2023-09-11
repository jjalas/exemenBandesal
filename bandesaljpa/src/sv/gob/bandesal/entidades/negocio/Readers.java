/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.bandesal.entidades.negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jjala
 */
@Entity
@Table(name = "readers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Readers.findAll", query = "SELECT r FROM Readers r")
    , @NamedQuery(name = "Readers.findById", query = "SELECT r FROM Readers r WHERE r.id = :id")
    , @NamedQuery(name = "Readers.findByName", query = "SELECT r FROM Readers r WHERE r.name = :name")})
public class Readers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "readersID")
    private List<BlogsReaders> blogsReadersList;

    public Readers() {
    }

    public Readers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<BlogsReaders> getBlogsReadersList() {
        return blogsReadersList;
    }

    public void setBlogsReadersList(List<BlogsReaders> blogsReadersList) {
        this.blogsReadersList = blogsReadersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Readers)) {
            return false;
        }
        Readers other = (Readers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bandesal.Readers[ id=" + id + " ]";
    }
    
}
