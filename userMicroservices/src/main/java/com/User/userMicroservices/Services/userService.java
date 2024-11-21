package com.User.userMicroservices.Services;

import com.User.userMicroservices.Entities.User;

import javax.swing.text.StyledEditorKit;
import java.util.List;

public interface userService {

    public User saveUser(User user);

    public List<User> getAllUser();

    public User getUser(Integer userId);

    public User updateUser(User user);

    public Boolean deleteUser(Integer UserId);
}
