package com.iamzexy.SpringTestTask.repositories;

import com.iamzexy.SpringTestTask.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Demin Artem
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByLogin(String login);

    Optional<User> findUserByEmail(String email);
}
