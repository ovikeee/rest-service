package ru.megafon.restservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.megafon.restservice.model.Order;
import ru.megafon.restservice.model.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class MainController {
    private final OrderRepository orderRepository;

    @Autowired
    public MainController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "/orders/getAll", method = RequestMethod.GET)
    public List<Order> get() {
        List<Order> result = new ArrayList<>();
        try{
            orderRepository.findAll();
        }catch (Throwable th){
            th.printStackTrace();
        }
        for (Order order : orderRepository.findAll()) {
            log.debug(order.toString());
            result.add(order);
        }
        return result;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public void create(@RequestBody Order order) {
        Order duplicate = orderRepository.findBySummary(order.getSummary());
        if (duplicate != null) {
            throw new RuntimeException("Found duplicate during creation");
        }
        orderRepository.save(order);
    }

    @RequestMapping(value = "/orders/{id}/{title}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id, @PathVariable String summary) {
        log.info("Safe deleting Order with id='{}' and title='{}'", id, summary);
        Order order = orderRepository.findById(id).get();
        if (order.getSummary().equals(summary)) {
            orderRepository.deleteById(id);
        } else {
            throw new RuntimeException("Input name doesn't equal to removing Order id");
        }
    }
}
