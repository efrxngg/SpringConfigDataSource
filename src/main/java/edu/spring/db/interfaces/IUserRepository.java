package edu.spring.db.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.spring.db.entity.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long>{}