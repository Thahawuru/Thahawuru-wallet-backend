package com.thahawuru_wallet.application.service;
import com.thahawuru_wallet.application.dto.response.UserResponseDTO;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.repository.UserRepository;
//import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EncryptionService encryptionService;

    public List<UserResponseDTO> allUsers(){
        return userRepository.findAll().stream()
                .map(user->new UserResponseDTO(user.getId(),user.getEmail(),user.getRole()))
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUser(UUID userid){
        User user =  userRepository.findById(userid).orElseThrow(()-> new UserNotFoundException("User Not Found!"));
        return new UserResponseDTO(user.getId(),user.getEmail(),user.getRole());
    }

//    public UserResponseDTO createUser( User user){
//        if(userRepository.findUserByEmail(user.getEmail()).isPresent()){
//            throw new IllegalStateException("email already exists!");
//        }else{
//            User newuser = new User();
//            newuser.setEmail(user.getEmail());
//            newuser.setPassword(encryptionService.encryptPassword(user.getPassword()));
//            newuser.setNic(user.getNic());
//            User newUser=userRepository.save(newuser);
//
//            return new UserResponseDTO(newUser.getId(),newUser.getEmail(),newUser.getNic());
//        }
//    }





//    public void testQuery (){
//        Query query =new Query();
//        query.addCriteria(Criteria.where("email").is(user.getEmail()));
//        List<User> users= mongoTemplate.find(query,User.class);
//
//        if(users.size()>1){
//            throw new IllegalStateException("Found too many entries!");
//        }
//        if(users.isEmpty()){
////            userRepository.save(user);
//            userRepository.insert(user);
//        }else{
//            System.out.println("user already exists!");
//        }
//    }


}
