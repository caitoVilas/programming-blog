package com.caito.blogbe.service.contracts;

import com.caito.blogbe.models.dto.UserNew;
import com.caito.blogbe.models.dto.UserResponse;
import org.springframework.stereotype.Service;

public interface AuthDAO {

    UserResponse save(UserNew userNew);
}
