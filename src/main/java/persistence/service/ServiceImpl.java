package persistence.service;

import model.EmployeeModel;
import persistence.dao.IDao;
import persistence.dao.DaoImpl;

import java.util.List;

public class ServiceImpl implements IService {

    private IDao IDao = new DaoImpl();

    public List<EmployeeModel> getAllEmployee() {
        return IDao.getAllEmployee();
    }

    public void add(EmployeeModel employee) {
        IDao.add(employee);
    }

    public void update(EmployeeModel employee) {
        IDao.update(employee);
    }

    public void delete(Integer id) {
        IDao.delete(id);
    }
}
