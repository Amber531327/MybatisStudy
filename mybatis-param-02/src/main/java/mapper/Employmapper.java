package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.List;
import java.util.Map;

public interface Employmapper {
    //单个简单类型传入
    Employee queryById(Integer empId);
    //实体类类型
    int insertEmployee(Employee employee);
    //多个简单类型数据
    List<Employee> queryByNameAndSalary(@Param("a") String name, @Param("b") Double salary);
    //Map类型数据
    int insertEmployMap(Map data);
}
