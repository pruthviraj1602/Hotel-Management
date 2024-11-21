package com.User.userMicroservices.Repositories;

import com.User.userMicroservices.Entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Integer> {

    public User getUserByUserId(Integer userId);

    @Transactional
    public Integer deleteUserByUserId(Integer userId);
}
