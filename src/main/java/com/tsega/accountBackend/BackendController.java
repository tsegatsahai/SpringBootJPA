package com.tsega.accountBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BackendController {
    @Autowired
    UserDAO userServices = new UserDAO();

    private final UserRepository userRepo;
   // public BackendController(){}
    public BackendController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping(method= RequestMethod.GET, path = "/hello/{name}")
    public String getInfo(@PathVariable String name){
        return "Hello there " + name;
    }

    @GetMapping(path = "/printAllUsers")
    public List<User> printAllUsers(){
        //return userServices.displayAllUsers();
        return userRepo.findAll();
    }

    @PostMapping(path = "/addUser")
    @ResponseStatus(HttpStatus.OK)
    public User addUser(@RequestBody User user){
        //return userServices.addUser(user);
        return userRepo.save(user);
    }

    @DeleteMapping(path = "/removeUser")
    @ResponseStatus(HttpStatus.OK)
    public User removeUser(@RequestBody User user){
        return userServices.removeUser(user);
    }


}
