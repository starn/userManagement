package fr.starn.usermanagement.repository;

import fr.starn.usermanagement.entity.User;
import jakarta.persistence.Table;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
