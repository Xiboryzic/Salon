package com.vishnevsky.salon.service.order;

import com.vishnevsky.salon.model.Master;
import com.vishnevsky.salon.model.Order;
import com.vishnevsky.salon.model.ServiceType;
import com.vishnevsky.salon.model.User;

import java.util.HashSet;
import java.util.List;

public interface OrderService {
    public List<Order> findOrdersByClient(User user);

    public List<Order> findAllOrders();

    public HashSet<String> findServiceGroups();

    public List<ServiceType> findByServiceGroups(String serviceGroup);

    public List<ServiceType> findTypesByName(String serviceType);

    public List<Master> findMastersByRang(Integer currentRang);

    public List<Master> findMasterByName(String master);

    public void saveOrder(Order order);
}
