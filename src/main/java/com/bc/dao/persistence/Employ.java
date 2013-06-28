package com.bc.dao.persistence;

import javax.persistence.*;
import java.util.Date;


@Table(name = "EMPLOYEE" )
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@SequenceGenerator(name = "SQ_EMPLOYEE", sequenceName = "SQ_EMPLOYEE")
public class Employ {

    private Long idEmploy;
    private String employer;
    private Date hired;
    private String charge;
    private Double salary;
    private String phoneNumber;

    public Employ() {
    }

    public Employ(Long idEmploy, String employer, Date hired, String charge, Double salary, String phoneNumber) {
        this.idEmploy = idEmploy;
        this.employer = employer;
        this.hired = hired;
        this.charge = charge;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @Column(name = "id_employ", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_EMPLOYEE")
    public Long getIdEmploy() {
        return idEmploy;
    }

    public void setIdEmploy(Long idEmploy) {
        this.idEmploy = idEmploy;
    }

    @Column(name = "employer", nullable = true)
    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    @Column(name = "hired", nullable = true)
    public Date getHired() {
        return hired;
    }

    public void setHired(Date hired) {
        this.hired = hired;
    }

    @Column(name = "charge", nullable = true)
    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    @Column(name = "phone_number", nullable = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
