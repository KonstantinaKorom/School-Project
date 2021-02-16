
package school.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "trainer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t")
    , @NamedQuery(name = "Trainer.findById", query = "SELECT t FROM Trainer t WHERE t.id = :id")
    , @NamedQuery(name = "Trainer.findByTfirstname", query = "SELECT t FROM Trainer t WHERE t.tfirstname = :tfirstname")
    , @NamedQuery(name = "Trainer.findByTlastname", query = "SELECT t FROM Trainer t WHERE t.tlastname = :tlastname")
    , @NamedQuery(name = "Trainer.findByTsubject", query = "SELECT t FROM Trainer t WHERE t.tsubject = :tsubject")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tfirstname")
    private String tfirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tlastname")
    private String tlastname;
    @Size(max = 30)
    @Column(name = "tsubject")
    private String tsubject;
    @ManyToMany(mappedBy = "trainerList")
    private List<Course> courseList;

    public Trainer() {
    }

    public Trainer(Integer id) {
        this.id = id;
    }

    public Trainer(Integer id, String tfirstname, String tlastname) {
        this.id = id;
        this.tfirstname = tfirstname;
        this.tlastname = tlastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTfirstname() {
        return tfirstname;
    }

    public void setTfirstname(String tfirstname) {
        this.tfirstname = tfirstname;
    }

    public String getTlastname() {
        return tlastname;
    }

    public void setTlastname(String tlastname) {
        this.tlastname = tlastname;
    }

    public String getTsubject() {
        return tsubject;
    }

    public void setTsubject(String tsubject) {
        this.tsubject = tsubject;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "school.entity.Trainer[ id=" + id + " ]";
    }
    
}
