package com.iamzexy.SpringTestTask.services;

import com.iamzexy.SpringTestTask.exceptions.UserException;
import com.iamzexy.SpringTestTask.models.User;
import com.iamzexy.SpringTestTask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Demin Artem
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByLogin(String login) {
        return userRepository.findUserByLogin(login).orElseThrow(() -> new UserException("no such client"));
    }

    public void addClient(User user) {
        if (userRepository.findUserByLogin(user.getLogin()).isPresent()) {
            throw new UserException("login is taken");
        }
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new UserException("email is taken");
        }
        userRepository.save(user);
    }

    @Transactional
    public void updateClient(User updatedUser) {
        User user = userRepository.findUserByLogin(updatedUser.getLogin())
                .orElseThrow(() -> new UserException("no such client"));
        if (!updatedUser.getFio().isEmpty() || !updatedUser.getFio().isBlank() || !user.getFio().equals(updatedUser.getFio())) {
            user.setFio(updatedUser.getFio());
        }
        if (!updatedUser.getEmail().isEmpty() || !updatedUser.getEmail().isBlank() || !user.getEmail().equals(updatedUser.getEmail())) {
            if (userRepository.findUserByEmail(updatedUser.getEmail()).isPresent()) {
                throw new UserException("email is taken");
            } else {
                user.setEmail(updatedUser.getEmail());
            }
        }
    }

    public void deleteClient(String login) {
        userRepository.delete(
                userRepository.findUserByLogin(login)
                        .orElseThrow(() -> new UserException("no such client"))
        );
    }
}
