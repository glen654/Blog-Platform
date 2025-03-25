package lk.ijse.userservice.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.userservice.dao.UserDao;
import lk.ijse.userservice.dto.impl.UserDTO;
import lk.ijse.userservice.entity.impl.UserEntity;
import lk.ijse.userservice.exception.DataPersistException;
import lk.ijse.userservice.service.UserService;
import lk.ijse.userservice.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity saveUser = userDao.save(mapping.toUserEntity(userDTO));
        if(saveUser == null) {
            throw new DataPersistException("User not saved");
        }
    }
}
