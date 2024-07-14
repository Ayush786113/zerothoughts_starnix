package in.starnix.zerothoughts.controllers;

import in.starnix.zerothoughts.models.User;
import in.starnix.zerothoughts.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user){
        try{
            user = userService.registerUser(user);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("user/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user){
        try {
            user = userService.loginUser(user);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
