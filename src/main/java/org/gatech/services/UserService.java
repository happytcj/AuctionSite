package org.gatech.services;

import org.gatech.models.AdminUser;
import org.gatech.models.User;
import org.gatech.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Steph on 2/24/2018.
 */
@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User checkLogin(String userName, String password) {
        User user = userRepository.findUserByUserNamePassword(userName, password);
        if (user.getUserName() != null) { // successful login
            if (userRepository.isAdminUser(user)) {
                user = userRepository.fetchAdminUser(user);
            }
        }
        return user;
    }

    public boolean createUser(String firstName, String lastName, String userName, String password) {
        return userRepository.createUser(firstName, lastName, userName, password);
    }

    public boolean savePosition(User user, String position) {
        boolean success = false;
        if (user instanceof AdminUser) {
            user.setPosition(position);
            success = userRepository.savePosition(user);
        }
        return success;
    }
}
