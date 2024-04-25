package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.List;
import java.util.Map;


public interface Employmapper {
    List<Employee> query(@Param("name") String name,@Param("salary") Double salary);
    int update(Employee employee);

    int updateTrim(Employee employee);
    int selectEmployeeByConditionByChoose(Employee employee);

    List<Employee> selectBatch(@Param("ids") List<Integer> ids);

    int insertBatch(@Param("list") List<Employee> employeeList);

    int updateBatch(@Param("list") List<Employee> employeeList);
}
