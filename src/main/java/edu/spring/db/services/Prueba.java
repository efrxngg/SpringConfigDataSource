package edu.spring.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.spring.db.dao.mysql.IUserRepository;

@Component
public class Prueba implements CommandLineRunner
{
    @Autowired 
    private IUserRepository _userRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Prueba Conexion");
        
        _userRepository.findAll().forEach(System.out::println);
        
    }
    
}
