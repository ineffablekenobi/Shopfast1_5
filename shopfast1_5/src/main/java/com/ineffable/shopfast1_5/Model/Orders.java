package com.ineffable.shopfast1_5.Model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(hidden = true)
    private Long oid;

    private String status;

    private Date createdDate;
    private Date lastUpdated;

    @OneToMany(targetEntity = SubOrder.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_fk", referencedColumnName = "oid")
    private List<SubOrder> subOrderList;

    public Orders() {
        createdDate = new Date();
        subOrderList = new ArrayList<>();
    }

    public Orders(Long oid, String status, Date createdDate, Date lastUpdated) {
        this.oid = oid;
        this.status = status;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<SubOrder> getSubOrderList() {
        return subOrderList;
    }

    public void setSubOrderList(List<SubOrder> subOrderList) {
        this.subOrderList = subOrderList;
    }
}
