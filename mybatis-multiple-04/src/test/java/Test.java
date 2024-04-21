
import mapper.CustomerMapper;
import mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pojo.Customer;
import pojo.Order;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderWithCustomer(2);
        System.out.println(order);
        System.out.println(order.getCustomer());
    }

    @org.junit.jupiter.api.Test
    public void test02(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.selectCustomerWithOrderList(1);
        for (Customer customer : customers) {
            System.out.println(customer);
            for (Order order : customer.getOrderList()) {
                System.out.println(order);
            }

        }
    }

    @AfterEach
    public void afterMethod(){
        sqlSession.commit();
        sqlSession.close();
    }
}
