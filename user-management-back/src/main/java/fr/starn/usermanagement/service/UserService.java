package fr.starn.usermanagement.service;

import fr.starn.usermanagement.dto.UserDto;
import fr.starn.usermanagement.entity.User;
import fr.starn.usermanagement.exceptions.ValidationException;

import java.util.List;

public interface UserService {
    UserDto save(UserDto user) throws ValidationException;
    public UserDto update(UserDto user);
    void delete(long id);

    List<UserDto> getAll();

    UserDto get(long id);
}
