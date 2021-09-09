package com.evgeny.springproject3.service;

import com.evgeny.springproject3.exception.UserAlreadyExist;
import com.evgeny.springproject3.exception.UserNotFoundException;
import com.evgeny.springproject3.entity.UserEntity;
import com.evgeny.springproject3.model.Users;
import com.evgeny.springproject3.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExist {
        if (userRepository.findByUsername(user.getUsername()) != null)
            throw new UserAlreadyExist("User already is.");
        return userRepository.save(user);
    }

    public Users getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return Users.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
