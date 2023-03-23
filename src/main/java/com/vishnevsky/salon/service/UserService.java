package com.vishnevsky.salon.service;

import com.vishnevsky.salon.repository.ContactRepo;
import com.vishnevsky.salon.dto.UserEditRequestDto;
import com.vishnevsky.salon.model.Contact;
import com.vishnevsky.salon.model.Role;
import com.vishnevsky.salon.model.User;
import com.vishnevsky.salon.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ContactRepo contactRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public void deleteUserById(User user){
        contactRepo.deleteById(user.getId()+1);
    }

    public void saveUser(User user, UserEditRequestDto userEditRequestDto){

        user.setUsername(userEditRequestDto.getUsername());
        user.setClientName(userEditRequestDto.getClientName());
        user.setNumber(userEditRequestDto.getNumber());
        user.setMail(userEditRequestDto.getMail());
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

//        for (String key : userEditRequestDto.getForm().keySet()) {
//            if (roles.contains(key)) {
//                user.getRoles().add(Role.valueOf(key));
//            }
//        }


    }

    public void saveContact(User user, UserEditRequestDto userEditRequestDto){
        Contact contact = new Contact(userEditRequestDto.getClientName(),
                userEditRequestDto.getNumber(), userEditRequestDto.getMail(), user);
        contactRepo.save(contact);
    }


}
