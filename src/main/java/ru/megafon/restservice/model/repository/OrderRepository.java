package ru.megafon.restservice.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.megafon.restservice.model.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
    Order findBySummary(String summary);
}
