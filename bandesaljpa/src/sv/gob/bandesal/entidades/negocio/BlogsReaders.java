/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.bandesal.entidades.negocio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jjala
 */
@Entity
@Table(name = "blogs_readers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlogsReaders.findAll", query = "SELECT b FROM BlogsReaders b")
    , @NamedQuery(name = "BlogsReaders.findByIdbr", query = "SELECT b FROM BlogsReaders b WHERE b.idbr = :idbr")})
public class BlogsReaders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbr")
    private Integer idbr;
    @JoinColumn(name = "blogs_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Blogs blogsID;
    @JoinColumn(name = "readers_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Readers readersID;

    public BlogsReaders() {
    }

    public BlogsReaders(Integer idbr) {
        this.idbr = idbr;
    }

    public Integer getIdbr() {
        return idbr;
    }

    public void setIdbr(Integer idbr) {
        this.idbr = idbr;
    }

    public Blogs getBlogsID() {
        return blogsID;
    }

    public void setBlogsID(Blogs blogsID) {
        this.blogsID = blogsID;
    }

    public Readers getReadersID() {
        return readersID;
    }

    public void setReadersID(Readers readersID) {
        this.readersID = readersID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbr != null ? idbr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BlogsReaders)) {
            return false;
        }
        BlogsReaders other = (BlogsReaders) object;
        if ((this.idbr == null && other.idbr != null) || (this.idbr != null && !this.idbr.equals(other.idbr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bandesal.BlogsReaders[ idbr=" + idbr + " ]";
    }
    
}
