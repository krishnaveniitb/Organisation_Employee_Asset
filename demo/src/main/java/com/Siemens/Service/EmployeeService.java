package com.Siemens.Service;

import com.Siemens.Model.Asset;
import com.Siemens.Model.Employee;
import com.Siemens.Model.Organization;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public List<Employee> getAllEmployeeList();

    public Employee getEmployeeById(Long id);

    public List<Employee> getEmployeeListByOrgId(Long org_id);

    Employee updateEmployee(Employee employee);

    String deleteEmployee(Long asset_id);
}
