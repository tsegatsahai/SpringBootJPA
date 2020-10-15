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

    public BackendController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
   // public BackendController(){}
//    public void setUserRepo(UserRepository userRepo){
//        this.userRepo = userRepo;
//    }
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

    @PutMapping(path = "/updateUser/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable long id){
        return userRepo.findById(id).map(user -> {
            user.setEmail(newUser.getEmail());
            user.setBirthday(newUser.getBirthday());
            user.setName(newUser.getName());
            user.setPassword(newUser.getPassword());
            user.setGender(newUser.getGender());
            return userRepo.save(user);
        }).orElseGet(() -> {
            newUser.setId(id);
            return userRepo.save(newUser);
        });

    }

    @DeleteMapping(path = "/removeUser")
    @ResponseStatus(HttpStatus.OK)
    public User removeUser(@RequestBody User user){
        return userServices.removeUser(user);
    }


}
