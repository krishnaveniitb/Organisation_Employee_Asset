package com.Siemens.Service.impl;

import com.Siemens.Exception.NoValueFoundException;
import com.Siemens.Model.Asset;
import com.Siemens.Model.Employee;
import com.Siemens.Model.Organization;
import com.Siemens.Repo.AssetRepo;
import com.Siemens.Repo.EmployeeRepo;
import com.Siemens.Repo.OrganizationRepo;
import com.Siemens.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private OrganizationRepo organizationRepo;

    @Autowired
    private AssetRepo assetRepo;

    @Override
    public List<Employee> getAllEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeRepo.findAll().forEach(employeeList::add);
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else {
            throw new NoValueFoundException("No Employee found for this id! Try again with some other Id");
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        List<Asset> assetList = employee.getAssetList();
        if(assetList!=null){
            assetRepo.saveAll(assetList);
        }
        return employeeRepo.save(employee);
    }
    @Override
    public List<Employee> getEmployeeListByOrgId(Long org_id) {
        Organization org = organizationRepo.findById(org_id).get();
        if(org==null){
            throw new NoValueFoundException("No Employee found for this id! Try again with some other Id");
        }
        return  org.getEmployeeList();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public String deleteEmployee(Long emp_id) {
        employeeRepo.deleteById(emp_id);
        return "Deleted successfully";
    }
}
