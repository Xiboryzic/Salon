package com.vishnevsky.salon.service.order;

import com.vishnevsky.salon.model.Master;
import com.vishnevsky.salon.model.Order;

import java.util.List;

public interface OrderAdminService {

    public List<Order> findAllOrders();

    public List<Master> orderAdminEditForm(Order order);

    public void deleteOrder(Order order);

    public void orderAdminSubmit(Order order, String master);

}
