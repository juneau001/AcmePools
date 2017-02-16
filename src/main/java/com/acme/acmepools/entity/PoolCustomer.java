/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acme.acmepools.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author Juneau
 */
@Data
@Entity
@Table(name = "POOL_CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoolCustomer.findAll", query = "SELECT p FROM PoolCustomer p"),
    @NamedQuery(name = "PoolCustomer.findById", query = "SELECT p FROM PoolCustomer p WHERE p.id = :id")})
public class PoolCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "POOL_ID", referencedColumnName = "ID")
    @ManyToOne
    private Pool poolId;
    @OneToMany(mappedBy = "customerId")
    private Collection<Job> jobCollection;

    public PoolCustomer() {
    }

    public PoolCustomer(Integer id) {
        this.id = id;
    }

    
    @XmlTransient
    public Collection<Job> getJobCollection() {
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection) {
        this.jobCollection = jobCollection;
    }

   
}
