package microservice.microserviceProject.Controller;

import microservice.microserviceProject.Services.UserService;
import microservice.microserviceProject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    //create
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //single user get
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        return  ResponseEntity.ok().body(userService.getUser(userId));
    }

    //all users get
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser=userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
