package pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

//如果不想使用批量的别名，可以用注解给名字，这个注解必须配合批量使用
@Alias("bieming")
@Data
public class Employee {
    private Integer empId;

    private String empName;

    private Double empSalary;


}
