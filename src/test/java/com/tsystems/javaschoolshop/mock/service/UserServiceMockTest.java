package com.tsystems.javaschoolshop.mock.service;

import static org.mockito.Mockito.verifyZeroInteractions;
import com.tsystems.javaschoolshop.dao.impl.UserDaoImpl;
import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.enums.UserRoleEnum;
import com.tsystems.javaschoolshop.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceMockTest {

    private User user = new User();
    private Address userAddress = new Address();

    @Mock
    UserDaoImpl userDao;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserServiceImpl userService;

    @Before
    public void setup() {
        userAddress.setId(1);
        userAddress.setApartment("271");
        userAddress.setHouse("15");
        userAddress.setStreet("Torzhkovskaya");
        userAddress.setCity("Saint-Petersburg");
        userAddress.setPostcode("197343");
        userAddress.setCountry("Russia");
        userAddress.setUser(user);

        user.setBirthday(new Date());
        user.setNameUser("Test");
        user.setLastNameUser("Test");
        user.setPhone("+77777777777");
        user.setPassword("123456");
        user.setEmail("vk@gmail.com");
        user.setRole("ROLE_ADMIN");
        user.setId(1);
    }

    @Test
    public void findUserByEmailMockTest1() {
        //prepare
        when(userDao.findUserByEmail(user.getEmail())).thenReturn(user);
        //do
        userService.findUserByEmail(user.getEmail());
        //check
        verify(userDao).findUserByEmail(user.getEmail());
    }

    @Test
    public void findUserByEmailMockTest2() {
        //do
        User result = userService.findUserByEmail(null);
        //check
        assertNull(result);
    }

    @Test
    public void findUserByEmailMockTest3() {
        //do
        User result = userService.findUserByEmail("");
        //check
        assertNull(result);
    }

    @Test
    public void saveNewUserMockTest1() {
        //do
        userService.saveUser(user);
        //check
        verify(userDao).saveUser(user);
    }

    @Test
    public void findSimpleAdminMockTest1() {
        List<User> users = new ArrayList<>();
        //prepare
        when(userDao.findSimpleAdmins()).thenReturn(users);
        //do
        userService.findSimpleAdmins();
        //check
        verify(userDao).findSimpleAdmins();
    }


    @Test
    public void isEmailFreeMockTest1() {
        //prepare
        when(userDao.findUserByEmail("vk@gmail.com")).thenReturn(user);
        //do
        boolean result = userService.isEmailFree("vk@gmail.com");
        //check
        verify(userDao).findUserByEmail("vk@gmail.com");
        assertFalse(result);
    }

    @Test
    public void isEmailFreeMockTest2() {
        //prepare
        when(userDao.findUserByEmail("vk@gmail.com")).thenReturn(null);
        //do
        boolean result = userService.isEmailFree("vk@gmail.com");
        //check
        verify(userDao).findUserByEmail("vk@gmail.com");
        assertTrue(result);
    }

    @Test
    public void isEmailFreeMockTest3() {
        //do
        boolean result = userService.isEmailFree("");
        //check
        verifyZeroInteractions(userDao);
        assertFalse(result);
    }

    @Test
    public void isEmailFreeMockTest4() {
        //do
        boolean result = userService.isEmailFree(null);
        //check
        verifyZeroInteractions(userDao);
        assertFalse(result);
    }

    @Test
    public void isPhoneFreeMockTest1() {
        //prepare
        when(userDao.findUserByPhone("+77777777777")).thenReturn(user);
        //do
        boolean result = userService.isEmailFree("+77777777777");
        //check
        verify(userDao).findUserByEmail("+77777777777");
        assertTrue(result);
    }

    @Test
    public void isPhoneFreeMockTest2() {
        //prepare
        when(userDao.findUserByEmail("+77777777777")).thenReturn(null);
        //do
        boolean result = userService.isEmailFree("+77777777777");
        //check
        verify(userDao).findUserByEmail("+77777777777");
        assertTrue(result);
    }

    @Test
    public void isEmailPhoneMockTest4() {
        //do
        boolean result = userService.isPhoneFree(null);
        //check
        verifyZeroInteractions(userDao);
        assertFalse(result);
    }
    @Test
    public void deleteUserMockTest1() {
        //do
        userService.deleteUser(1);
        //check
        verify(userDao).deleteUser(1);
    }

    @Test
    public void findTop10UsersMockTest1() {
        List<User> users = new ArrayList<>();
        //prepare
        when(userDao.findTopNUsers(5)).thenReturn(users);
        //do
        userService.findTopNUsers();
        //check
        verify(userDao).findTopNUsers(5);
    }

    @Test
    public void  changeUserMockTest1() {
        User user = new User();
        user.setNameUser("dgdh");
        user.setLastNameUser("gdfhdfhd");
        user.setPassword("rgdrhd");
        user.setBirthday(new Date());
        user.setPhone("");
        user.setEmail("dgsdg");
        when(passwordEncoder.encode("rgdrhd")).thenReturn("rgdrhd");
        //do
        userService.createUser(user, UserRoleEnum.ROLE_USER.toString());
        //check
        verify(userDao).saveUser(user);
    }

}
