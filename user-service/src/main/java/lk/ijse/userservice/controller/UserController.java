package lk.ijse.userservice.controller;

import lk.ijse.userservice.dto.impl.UserDTO;
import lk.ijse.userservice.exception.DataPersistException;
import lk.ijse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    public ResponseEntity<Void> saveUser(@RequestBody UserDTO userDTO) {
        try{
            userService.saveUser(userDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
