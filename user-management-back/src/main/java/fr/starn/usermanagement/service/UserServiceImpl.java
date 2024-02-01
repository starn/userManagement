package fr.starn.usermanagement.service;

import fr.starn.usermanagement.dto.UserDto;
import fr.starn.usermanagement.entity.User;
import fr.starn.usermanagement.exceptions.ValidationException;
import fr.starn.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto save(UserDto user) throws ValidationException {
        List<UserDto> users = getAll();
        boolean mailIsUnique = users.stream().noneMatch((UserDto u) -> u.getEmail().equals(user.getEmail()));
        if (!mailIsUnique) {
            throw new ValidationException("E-mail already exist");
        }
        return userToUserDto(userRepository.save(userDtoToUser(user)));
    }

    @Override
    public UserDto update(UserDto user) {
        return userToUserDto(userRepository.save(userDtoToUser(user)));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAll() {
        return ((List<User>)userRepository.findAll()).stream().map(u -> userToUserDto(u)).collect(Collectors.toList());
    }

    @Override
    public UserDto get(long id) {
        return  userToUserDto(userRepository.findById(id).get());
    }

    private UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
