import mapper.Employmapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void test01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employmapper mapper = sqlSession.getMapper(Employmapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println(employee);
        sqlSession.close();
    }
}
