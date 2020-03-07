package ru.megafon.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.megafon.restservice.model.Order;
import ru.megafon.restservice.model.User;
import ru.megafon.restservice.model.repository.OrderRepository;
import ru.megafon.restservice.model.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class InitTestData {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final DataSource dataSource;

    @Autowired
    public InitTestData(UserRepository userRepository, OrderRepository orderRepository, DataSource dataSource) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void initTestData(){
        Long firstReporterUserId = userRepository.save(new User( "KimChinIn", User.Role.CUSTOMER)).getId();
        Long firstAssigneeUserId = userRepository.save(new User( "SeiFeiHun", User.Role.SUPPORT)).getId();

        orderRepository.save(new Order("Make a Rocket", "Big Nuclear Rocket", firstReporterUserId, firstAssigneeUserId));
    }
}
