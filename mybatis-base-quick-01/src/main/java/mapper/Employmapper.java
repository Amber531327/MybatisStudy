package mapper;

import pojo.Employee;

public interface Employmapper {
    //单个简单类型传入
    Employee queryById(Integer empId);
    //实体类类型
    int insertEmployee(Employee employee);
}
