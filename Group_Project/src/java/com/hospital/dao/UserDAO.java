package com.hospital.dao;
import com.hospital.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDAO {
    Optional<User> findByUsernameAndPassword(String username, String passwordHash);
    void save(User user);
    List<User> findAll();
    void deleteById(int userId);
    void updatePassword(int userId, String newPassword);

    public User validateUser(String email, String password);
}
