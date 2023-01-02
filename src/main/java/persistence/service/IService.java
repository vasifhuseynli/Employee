package persistence.service;

import model.EmployeeModel;

import java.util.List;

public interface IService {

    List<EmployeeModel> getAllEmployee();
    void add(EmployeeModel employee);
    void update(EmployeeModel employee);
    void delete(Integer id);
}
