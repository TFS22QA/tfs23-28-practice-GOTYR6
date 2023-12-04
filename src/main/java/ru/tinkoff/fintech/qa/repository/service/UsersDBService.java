package ru.tinkoff.fintech.qa.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tinkoff.fintech.qa.controllers.models.UserEntity;
import ru.tinkoff.fintech.qa.exceptions.UsersDBException;

@Service
public class UsersDBService {
    @Autowired
    UsersRepository usersRepository;

    public void add(UserEntity user) {
        try {
            usersRepository.save(user);
        } catch (Exception e) {
            throw new UsersDBException("Error by add user : " + e.getMessage());
        }
    }

    public void update(UserEntity user) {
        try {
            usersRepository.save(user);
        } catch (Exception e) {
            throw new UsersDBException("Error by update user : " + e.getMessage());
        }
    }

    public void delete(Integer id) {
        try {
            UserEntity user = usersRepository.getById(id);
            usersRepository.delete(user);
        } catch (Exception e) {
            throw new UsersDBException("Error by delete user : " + e.getMessage());
        }
    }

    public UserEntity get(Integer id) {
        try {
            return usersRepository.findById(id).get();
        } catch (Exception e) {
            throw new UsersDBException("Error by get user : " + e.getMessage());
        }
    }
}
