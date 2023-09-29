package microservice.microserviceProject.Services;

import microservice.microserviceProject.entity.User;

import java.util.List;

public interface UserService {
    //user operations
    //create user saveUser(User user);
    //get all user

    //save user
    User saveUser(User user);


    List<User> getAllUser();

    //get a single user of given UserId
    User getUser(String userId);

    //delete or update

 }
