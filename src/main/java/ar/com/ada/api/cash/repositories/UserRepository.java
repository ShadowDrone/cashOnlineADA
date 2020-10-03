
package ar.com.ada.api.cash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.ada.api.cash.entities.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
}
