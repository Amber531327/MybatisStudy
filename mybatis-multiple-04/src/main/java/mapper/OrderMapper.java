package mapper;

import lombok.Data;
import pojo.Order;


public interface OrderMapper {
  Order selectOrderWithCustomer(Integer orderId);
}