package ru.megafon.restservice.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.megafon.restservice.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
