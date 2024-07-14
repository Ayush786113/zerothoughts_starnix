package in.starnix.zerothoughts.user;

import in.starnix.zerothoughts.validators.UserValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class Email {

    private final UserValidator userValidator;

    Email(){
        userValidator = new UserValidator();
    }

    @Test
    void rightEmail(){
        assertEquals(true, userValidator.validateEmail("ayush786113@gmail.com"));
    }

    @Test
    void noAt(){
        assertEquals(false, userValidator.validateEmail("polestar.starnix.in"));
    }

    @Test
    void noDot(){
        assertEquals(false, userValidator.validateEmail("foo@barcon"));
    }

    @Test
    void emailPrefix(){
        assertEquals(true, userValidator.validateEmail("foo.bar@yahoo.com"));
    }

    @Test
    void subDomain(){
        assertEquals(true, userValidator.validateEmail("foo@bar.foo.in"));
    }
}
