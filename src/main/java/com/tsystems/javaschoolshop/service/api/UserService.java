package com.tsystems.javaschoolshop.service.api;


import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.enums.UserRoleEnum;
import java.util.List;

/**
 * Interface provide us API we can use to manipulate on product size.
 */
public interface UserService {

    /**
     * Method looks for user by his email.
     * @param email of the user.
     * @return found user object.
     */
    User findUserByEmail(String email);

    /**
     * Method add new user to database.
     * @param user that must be added.
     */
    void createUser(User user, String role);

    /**
     * Every user have their own SecurityContextHolder which is connected with session.
     * So, this method allow us to get User object from this SecurityContextHolder
     * and it will always return different User objects for all users. Users always will get themselves.
     * @return User object {@link User}
     */
    User findUserFromSecurityContextHolder();

    /**
     * Method checks whether email is already occupied.
     * @param email that must be checked.
     * @return true if email is already occupied and false otherwise.
     */
    boolean isEmailFree(String email);

    /**
     * Method checks whether phone is already occupied.
     * @param phone that must be checked.
     * @return true if email is already occupied and false otherwise.
     */
    boolean isPhoneFree(String phone);

    /**
     * Method change password of user.
     * @param oldPassword - old password.
     * @param newPassword - new password.
     */
    void changePassword(String oldPassword, String newPassword);

    /**
     * Method merge user to database.
     * @param user that must be added.
     */
    void saveUser(User user);

    /**
     * Method looks for top N users. The more money the spent the higher rating they have.
     * @return list of found users.
     */
    List<User> findTopNUsers();

    /**
     * Method looks for all admins.
     * @return list of found users with admin role. See {@link UserRoleEnum}
     */
    List<User> findSimpleAdmins();

    /**
     * Method delete certain User by his ID.
     * @param id of the user that must be deleted.
     */
    void deleteUser(int id);
}
