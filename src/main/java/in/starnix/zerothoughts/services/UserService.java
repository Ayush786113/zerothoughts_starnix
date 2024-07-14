package in.starnix.zerothoughts.services;

import in.starnix.zerothoughts.models.User;
import in.starnix.zerothoughts.repositories.UserRepository;
import in.starnix.zerothoughts.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserValidator userValidator;

    public User registerUser(User user) throws Exception{
        if(user.getPassword() == null)
            throw new Exception("Please provide a password!");
        if(user.getEmail() == null)
            throw new Exception("Please provide an email address!");
        if(!userValidator.validateEmail(user.getEmail()))
            throw new Exception("Invalid Email Format!");
        if(userRepository.findByEmail(user.getEmail()) != null)
            throw new Exception("Email ID unavailable!");
        user.setUserId(UUID.randomUUID().toString());
        user = userRepository.save(user);
        user.setPassword(null);
        return user;
    }

    public User loginUser(User user) throws Exception {
        if(user.getPassword() == null)
            throw new Exception("Please provide a password!");
        if(user.getEmail() == null)
            throw new Exception("Please provide an email address!");
        if(!userValidator.validateEmail(user.getEmail()))
            throw new Exception("Invalid Email Format!");
        user = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(user == null)
            throw new Exception("Wrong Username or Password!");
        user.setPassword(null);
        user.setEmail(null);
        return user;
    }
}
