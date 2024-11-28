package com.ticket.ticket.repositorie;

import com.ticket.ticket.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
}
