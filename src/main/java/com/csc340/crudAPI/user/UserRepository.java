package com.csc340.crudAPI.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
    Optional<User> findByEmail(String email);
    @Query(value = "SELECT COUNT(user_id) FROM User", nativeQuery = true)
    int countTotalUsers();

    Optional<User> findByName(String name);

}
