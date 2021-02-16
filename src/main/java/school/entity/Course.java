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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Koko
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id")
    , @NamedQuery(name = "Course.findByCtitle", query = "SELECT c FROM Course c WHERE c.ctitle = :ctitle")
    , @NamedQuery(name = "Course.findByCstream", query = "SELECT c FROM Course c WHERE c.cstream = :cstream")
    , @NamedQuery(name = "Course.findByCstartdate", query = "SELECT c FROM Course c WHERE c.cstartdate = :cstartdate")
    , @NamedQuery(name = "Course.findByCenddate", query = "SELECT c FROM Course c WHERE c.cenddate = :cenddate")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "ctitle")
    private String ctitle;
    @Size(max = 30)
    @Column(name = "cstream")
    private String cstream;
    @Column(name = "cstartdate")
    @Temporal(TemporalType.DATE)
    private Date cstartdate;
    @Column(name = "cenddate")
    @Temporal(TemporalType.DATE)
    private Date cenddate;
    @JoinTable(name = "trainerpercourse", joinColumns = {
        @JoinColumn(name = "c_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "t_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Trainer> trainerList;
    @JoinTable(name = "studentpercourse", joinColumns = {
        @JoinColumn(name = "c_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "s_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Student> studentList;
    @OneToMany(mappedBy = "cId")
    private List<Assignment> assignmentList;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public String getCstream() {
        return cstream;
    }

    public void setCstream(String cstream) {
        this.cstream = cstream;
    }

    public Date getCstartdate() {
        return cstartdate;
    }

    public void setCstartdate(Date cstartdate) {
        this.cstartdate = cstartdate;
    }

    public Date getCenddate() {
        return cenddate;
    }

    public void setCenddate(Date cenddate) {
        this.cenddate = cenddate;
    }

    @XmlTransient
    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @XmlTransient
    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "school.entity.Course[ id=" + id + " ]";
    }
    
}
