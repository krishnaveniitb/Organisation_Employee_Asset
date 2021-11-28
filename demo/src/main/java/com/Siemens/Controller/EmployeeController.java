package com.Siemens.Controller;

import com.Siemens.Model.Asset;
import com.Siemens.Model.Employee;
import com.Siemens.Model.Organization;
import com.Siemens.Service.EmployeeService;
import com.Siemens.Service.OrganizationService;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee/add")
    public String addEmployee(@RequestBody Employee employee) throws SerializeException {
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        return xmlSerializer.serialize(employeeService.addEmployee(employee));
    }

    @GetMapping("/emp/{id}")
    public String getEmployeeListById(@PathVariable(name = "id") Long emp_id) throws SerializeException {
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        return xmlSerializer.serialize(employeeService.getEmployeeById(emp_id));
    }

    @GetMapping("/employeeDetailsByOrgId/{id}")
    public String getEmployeeListByOrgId(@PathVariable(name = "id") Long org_id) throws SerializeException {
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        return xmlSerializer.serialize(employeeService.getEmployeeListByOrgId(org_id));
    }
    @GetMapping("/employee/list-all")
    public String getAllOrganisationList() throws SerializeException {
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        List<Employee> employeeList = employeeService.getAllEmployeeList();
        return xmlSerializer.serialize(employeeList);
    }

    @PutMapping("/update_employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/delete_employee/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long emp_id){
        return employeeService.deleteEmployee(emp_id);
    }
}
