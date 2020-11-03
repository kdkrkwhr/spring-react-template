package com.kdk.security.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {
    Optional<UserDto> findByEmail(String email);
}