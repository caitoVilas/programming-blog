package com.caito.blogbe.service.impl;

import com.caito.blogbe.constants.UserErrorsConstants;
import com.caito.blogbe.entity.Role;
import com.caito.blogbe.entity.User;
import com.caito.blogbe.exeption.customs.BadRequestException;
import com.caito.blogbe.mapper.UserResponseMapper;
import com.caito.blogbe.models.RoleName;
import com.caito.blogbe.models.dto.UserNew;
import com.caito.blogbe.models.dto.UserResponse;
import com.caito.blogbe.repository.RoleRepository;
import com.caito.blogbe.repository.UserRepository;
import com.caito.blogbe.service.contracts.AuthDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService implements AuthDAO {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserResponseMapper responseMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserResponse save(UserNew userNew) {

        if (userRepository.existsByEmail(userNew.getEmail()))
            throw new BadRequestException(UserErrorsConstants.USR_MAIL_EXISTS);
        if (userNew.getUsername().isEmpty() || userNew.getUsername() == null)
            throw new BadRequestException(UserErrorsConstants.USR_NAME_EMPTY);
        if (userNew.getEmail().isEmpty() || userNew.getEmail() == null)
            throw new BadRequestException(UserErrorsConstants.USR_EMAIL_EMPTY);
        if (userNew.getPassword().isEmpty() || userNew.getPassword() == null)
            throw new BadRequestException(UserErrorsConstants.USR_PASS_EMPTY);
        Set<Role> roles = new HashSet<>();
        if (userNew.getRole().contains("admin"))
            roles.add(roleRepository.findByRoleName(RoleName.ROLE_ADMIN).get());
        roles.add(roleRepository.findByRoleName(RoleName.ROLE_USER).get());
        User user = new User();
        user.setUsername(userNew.getUsername());
        user.setEmail(userNew.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        User newUser = userRepository.save(user);

        return responseMapper.userToUserResponse(newUser);
    }
}
