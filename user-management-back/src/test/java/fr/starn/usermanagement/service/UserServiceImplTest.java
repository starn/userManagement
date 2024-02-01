package fr.starn.usermanagement.service;

import fr.starn.usermanagement.dto.UserDto;
import fr.starn.usermanagement.entity.User;
import fr.starn.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void get() {
        User user = new User();
        user.setId(1);
        user.setFirstname("Elon");
        user.setLastname("Musk");
        user.setEmail("em@spaceXX.com");
        Mockito.when(userRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(user));

        UserDto result = userService.get(1);
        assertEquals("em@spaceXX.com", result.getEmail());
        assertEquals("Elon", result.getFirstname());
        assertEquals("Musk", result.getLastname());
        assertEquals(1, result.getId());
    }
}