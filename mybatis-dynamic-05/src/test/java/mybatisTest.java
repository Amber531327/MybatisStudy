import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.Employmapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    private SqlSession sqlSession;
    @BeforeEach
    public void beforeMethod() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    @Test
   public void test(){
       Employmapper mapper = sqlSession.getMapper(Employmapper.class);
       List<Employee> amber = mapper.query("tom", null);
       System.out.println(amber);
   }

   @Test
   public void test02(){
       Employee employee = new Employee();
       employee.setEmpId(1);
       employee.setEmpName("bubu");
       Employmapper mapper = sqlSession.getMapper(Employmapper.class);
       int update = mapper.update(employee);
       System.out.println(update);
   }
    @Test
    public void testTeacherRelationshipToMulti() {
//
//        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
//
//        PageHelper.startPage(1,2);
//        // 查询Customer对象同时将关联的Order集合查询出来
//        List<Teacher> allTeachers = teacherMapper.findAllTeachers();
////
//        PageInfo<Teacher> pageInfo = new PageInfo<>(allTeachers);
//
//        System.out.println("pageInfo = " + pageInfo);
//        long total = pageInfo.getTotal(); // 获取总记录数
//        System.out.println("total = " + total);
//        int pages = pageInfo.getPages();  // 获取总页数
//        System.out.println("pages = " + pages);
//        int pageNum = pageInfo.getPageNum(); // 获取当前页码
//        System.out.println("pageNum = " + pageNum);
//        int pageSize = pageInfo.getPageSize(); // 获取每页显示记录数
//        System.out.println("pageSize = " + pageSize);
//        List<Teacher> teachers = pageInfo.getList(); //获取查询页的数据集合
//        System.out.println("teachers = " + teachers);
//        teachers.forEach(System.out::println);

    }
    @AfterEach
    public void afterMethod(){
        sqlSession.commit();
        sqlSession.close();
    }
}
