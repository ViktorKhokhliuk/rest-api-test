package com.rest.repository;

import com.rest.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM users WHERE id = :id FOR UPDATE")
    Optional<User> findByIdForUpdate(@Param("id") Long userId);

    @Query("SELECT * FROM users WHERE first_name = :firstName AND last_name = :lastName AND patronymic = :patronymic")
    Optional<User> findByFullName(@Param("firstName") String firstName,
                                  @Param("lastName") String lastName,
                                  @Param("patronymic") String patronymic);
}
