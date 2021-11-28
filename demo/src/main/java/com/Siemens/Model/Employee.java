package com.Siemens.Model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String employeeName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_employeeId")
    private List<Asset> assetList;

//    public Organization getOrganization() {
//        return organization;
//    }
//
//    public void setOrganization(Organization organization) {
//        this.organization = organization;
//    }
//
//    @ManyToOne
//    private Organization organization;

    public List<Asset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<Asset> asset) {
        this.assetList = asset;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
