package com.ticket.ticket.repositorie;

import com.ticket.ticket.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UsersRepo extends JpaRepository<Users, Long> {
}
