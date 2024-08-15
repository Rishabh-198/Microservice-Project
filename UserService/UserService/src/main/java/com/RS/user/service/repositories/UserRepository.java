package com.RS.user.service.repositories;

import com.RS.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>

{


}
