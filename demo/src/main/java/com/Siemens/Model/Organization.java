package com.Siemens.Model;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long OrganizationId;
    private String OrganizationName;
    private String OrganizationType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_OrganizationId")
    private List<Employee> employeeList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_OrganizationId")
    private List<Asset> assetList;

    public List<Asset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    public Organization(Long OrganizationId,String organizationName, String organizationType) {
        OrganizationId = OrganizationId;
        OrganizationName = organizationName;
        OrganizationType = organizationType;
    }

    public Organization() {

    }

    public String getOrganizationType() {
        return OrganizationType;
    }

    public void setOrganizationType(String organizationType) {
        OrganizationType = organizationType;
    }

    public Long getOrganizationId() {
        return OrganizationId;
    }

    public void setOrganizationId(Long organizationId) {
        OrganizationId = organizationId;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        OrganizationName = organizationName;
    }
}
