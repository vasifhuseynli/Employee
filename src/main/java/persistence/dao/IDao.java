package persistence.dao;

import model.EmployeeModel;

import java.util.List;

public interface IDao {
    List<EmployeeModel> getAllEmployee();
    void add(EmployeeModel employee);
    void update(EmployeeModel employee);
    void delete(Integer id);
}
