package com.ecom.users.repository;

import com.ecom.users.entity.User;
import com.ecom.users.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,UUID> {
        Optional<User> findByEmail(String email);
        List<User> findByRole(Role role);
}
