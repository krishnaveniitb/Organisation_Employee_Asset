package com.Siemens.Controller;

import com.Siemens.Model.Employee;
import com.Siemens.Model.Organization;
import com.Siemens.Service.OrganizationService;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/organization/list-all")
    public List<Organization> getAllOrganisationList(){
        List<Organization> organizationList = organizationService.getAllOrganisationList();
        return organizationList;
    }
    @PostMapping("/organization/add")
    public String addOrganization(@RequestBody Organization organization) throws SerializeException {
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        return xmlSerializer.serialize(organizationService.add(organization));
    }

    @GetMapping("/organization/list/{id}")
    public String getOrganisationById(@PathVariable(value = "id") Long id) throws SerializeException {
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        return xmlSerializer.serialize(organizationService.getOrganisationById(id));
    }

    @PutMapping("/update_org")
    public Organization updateOrganisation(@RequestBody Organization organization){
        return organizationService.updateOrganisation(organization);
    }
    @DeleteMapping("/delete_org/{id}")
    public String deleteOrganization(@PathVariable(name = "id") Long org_id){
        return organizationService.deleteOrganization(org_id);
    }
}
