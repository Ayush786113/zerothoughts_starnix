package in.starnix.zerothoughts.validators;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserValidator {

    public boolean validateEmail(String email){
        return Pattern.matches("\\w+(\\.\\w+)?@\\w+\\.(\\w+\\.)?\\w+", email);
    }
}
