package com.tsystems.javaschoolshop.dao.api;


import com.tsystems.javaschoolshop.model.User;
import java.util.List;

/**
 * This interface provide us API through which we will communicate with database.
 */
public interface UserDao {

    /**
     * Method should find user by his email.
     * @param email unique email of the user.
     * @return reference to an found User object.
     */
    User findUserByEmail(String email);

    /**
     * Method should find user by his phone.
     * @param phone unique phone of the user.
     * @return reference to an found User object.
     */
    User findUserByPhone(String phone);

    /**
     * Method should saves users.
     * @param user - reference to an User object we need to save.
     */
    void saveUser(User user);

    /**
     * Method should find user by his ID.
     * @param id of the user.
     * @return reference to an found User object.
     */
    User findUserById(int id);

    /**
     * Method should find top N users.
     * @param n is input parameter.
     * @return List of found users.
     */
    List<User> findTopNUsers(int n);

    /**
     * Method finds simple admins.
     * @return list of found simple admins.
     */
    List<User> findSimpleAdmins();

    /**
     * Method should delete user form the database by his ID.
     * @param id of the user.
     */
    void deleteUser(int id);
}
