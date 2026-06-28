package org.sushant.expensetrackerbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sushant.expensetrackerbackend.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}