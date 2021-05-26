package test.service.user;

import com.app.woofer.model.User;
import com.app.woofer.repository.UserRepository;
import com.app.woofer.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest {

    @Autowired
    public UserTest(UserService userService, UserRepository userRepository, User user){
        this.userService = userService;
        this.userRepository = userRepository;
        this.user = user;
    }

    private final User user;
    @InjectMocks
    private final UserService userService;

    @Mock
    private final UserRepository userRepository;

    @BeforeEach
    void createMock() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void testGetUserById(){

        User user = new User("ale","ale");

    }
}
