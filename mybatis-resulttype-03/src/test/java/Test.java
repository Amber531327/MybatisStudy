import mapper.Employmapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;

public class Test {

    private SqlSession sqlSession;
    @BeforeEach
    public void beforeMethod() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    @org.junit.jupiter.api.Test
    public void test01() throws IOException {

        Employmapper mapper = sqlSession.getMapper(Employmapper.class);
        Employee employee = new Employee();
        //这里输出null
        System.out.println(employee.getEmpId());
        employee.setEmpName("amber");
        employee.setEmpSalary(888.0);
        int rows = mapper.insertEmp(employee);
        //这里输出插入的数量
        System.out.printf("rows="+rows);
        //回显出来主键的值
        System.out.println("id="+employee.getEmpId());
//        sqlSession.commit();
        sqlSession.close();

    }
}
