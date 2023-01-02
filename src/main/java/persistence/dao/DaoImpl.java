package persistence.dao;

import model.EmployeeModel;
import persistence.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements IDao {
    public List<EmployeeModel> getAllEmployee() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("baza");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String sql = "select u from Employee u";

        List<Employee> employeeList = entityManager.createQuery(sql).getResultList();

        List<EmployeeModel> employeeModels = new ArrayList<EmployeeModel>();


        for (Employee employee : employeeList) {
            employeeModels.add(new EmployeeModel( employee.getId(), employee.getName(), employee.getSurname(), employee.getSalary()));
        }


        return employeeModels;
    }

    public void add(EmployeeModel employeeModel) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("baza");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee1 = new Employee();

        employee1.getEmployee(employeeModel);

        entityManager.getTransaction().begin();
        entityManager.persist(employee1);
        entityManager.getTransaction().commit();

    }

    public void update(EmployeeModel employee) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("baza");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee employee1 = entityManager.find(Employee.class, employee.getId());

        employee1.setId(employee.getId());
        employee1.setName(employee.getName());
        employee1.setSurname(employee.getSurname());
        employee1.setSalary(employee.getSalary());

        entityManager.persist(employee1);
        entityManager.getTransaction().commit();


    }

    public void delete(Integer id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("baza");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);
        entityManager.getTransaction().commit();

    }
}
