package com.itacademy.service;

import com.itacademy.database.entity.User;
import com.itacademy.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl /*implements IService<User> */{


    private final UserRepository userRepository;

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public Iterable<User> getAllUser(){
        return  userRepository.findAll();
    }



//    public Long save(User user){
//        return userDao.save(user);
//    }

//    private static SessionFactory FACTORY = HibernateSessionFactoryUtil.getSessionFactory();
//
//    private final UserDao userDao = UserDao.getInstance();
//
//    @Override
//    public User findUser(int id) {
//        return null;
//    }
//
//    @Override
//    public void saveUser(User user) {
//
//    }
//
//    @Override
//    public void deleteUser(User user) {
//
//    }
//
//    @Override
//    public void updateUser(User user) {
//
//    }
//
//    @Override
//    public List<User> findAllUsers() {
//        Session session = FACTORY.openSession();
//        return userDao.findAll(session);
//    }
}
