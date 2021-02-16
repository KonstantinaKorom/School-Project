/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Koko
 */
@Entity
@Table(name = "assignment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a")
    , @NamedQuery(name = "Assignment.findById", query = "SELECT a FROM Assignment a WHERE a.id = :id")
    , @NamedQuery(name = "Assignment.findByAtitle", query = "SELECT a FROM Assignment a WHERE a.atitle = :atitle")
    , @NamedQuery(name = "Assignment.findByAdescription", query = "SELECT a FROM Assignment a WHERE a.adescription = :adescription")
    , @NamedQuery(name = "Assignment.findBySubdatetime", query = "SELECT a FROM Assignment a WHERE a.subdatetime = :subdatetime")
    , @NamedQuery(name = "Assignment.findByTotalmax", query = "SELECT a FROM Assignment a WHERE a.totalmax = :totalmax")
    , @NamedQuery(name = "Assignment.findByOralmax", query = "SELECT a FROM Assignment a WHERE a.oralmax = :oralmax")})
public class Assignment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "atitle")
    private String atitle;
    @Size(max = 30)
    @Column(name = "adescription")
    private String adescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subdatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subdatetime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalmax")
    private int totalmax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oralmax")
    private int oralmax;
    @JoinColumn(name = "c_id", referencedColumnName = "id")
    @ManyToOne
    private Course cId;
    @OneToMany(mappedBy = "aId")
    private List<Grade> gradeList;

    public Assignment() {
    }

    public Assignment(Integer id) {
        this.id = id;
    }

    public Assignment(Integer id, String atitle, Date subdatetime, int totalmax, int oralmax) {
        this.id = id;
        this.atitle = atitle;
        this.subdatetime = subdatetime;
        this.totalmax = totalmax;
        this.oralmax = oralmax;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public String getAdescription() {
        return adescription;
    }

    public void setAdescription(String adescription) {
        this.adescription = adescription;
    }

    public Date getSubdatetime() {
        return subdatetime;
    }

    public void setSubdatetime(Date subdatetime) {
        this.subdatetime = subdatetime;
    }

    public int getTotalmax() {
        return totalmax;
    }

    public void setTotalmax(int totalmax) {
        this.totalmax = totalmax;
    }

    public int getOralmax() {
        return oralmax;
    }

    public void setOralmax(int oralmax) {
        this.oralmax = oralmax;
    }

    public Course getCId() {
        return cId;
    }

    public void setCId(Course cId) {
        this.cId = cId;
    }

    @XmlTransient
    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
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
        if (!(object instanceof Assignment)) {
            return false;
        }
        Assignment other = (Assignment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "school.entity.Assignment[ id=" + id + " ]";
    }
    
}
