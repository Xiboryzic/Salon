package com.vishnevsky.salon.service;

import com.vishnevsky.salon.model.Contact;
import com.vishnevsky.salon.model.Role;
import com.vishnevsky.salon.model.User;
import com.vishnevsky.salon.repository.ContactRepo;
import com.vishnevsky.salon.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class RegistrationService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ContactRepo contactRepo;

    public User findUserByUsername(User user){
        return userRepo.findByUsername(user.getUsername());
    }

    public void saveUser(User user){
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
    }

    public void saveContact(Contact contact){
        contactRepo.save(contact);
    }
}
