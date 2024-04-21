package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;
import pojo.Employee;

import java.util.List;
import java.util.Map;


public interface Employmapper {
    //单个简单类型传入
    Employee queryById(Integer empId);

    Double getSalaryById(Integer Id);

    //返回Map类型
    Map<String,Object> selectEmpNameAndMaxSalary();

    //返回List类型
    List<Employee> selectAll();

    //自增长主键回显
    int insertEmp(Employee employee);

    Employee queryByIdmap(Integer empId);
}
