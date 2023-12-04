package ru.tinkoff.fintech.qa.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.fintech.qa.controllers.models.UserEntity;


public interface UsersRepository extends JpaRepository<UserEntity, Integer> {
}
