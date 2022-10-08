package edu.spring.db.dao.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.spring.db.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{}