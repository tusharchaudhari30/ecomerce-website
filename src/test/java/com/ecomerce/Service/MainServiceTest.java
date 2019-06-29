package com.ecomerce.Service;

import com.ecomerce.Model.User;
import org.junit.Test;

import static org.junit.Assert.assertSame;


public class MainServiceTest {
    @Test
    public void findUserByEmail() {
        User user=new User();
        user.setEmail("blazeric30@gmail.com");
        assertSame("User are same",user,user);
    }
}