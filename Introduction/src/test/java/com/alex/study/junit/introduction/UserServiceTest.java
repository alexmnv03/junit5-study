package com.alex.study.junit.introduction;

import com.alex.study.junit.introduction.service.UserService;
import com.alex.study.junit.introduction.service.dto.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    private UserService userService;

    @BeforeAll
    static void init(){
        System.out.println("Before all ");
    }

//    @BeforeAll
//    void init(){
//        System.out.println("Before all "  + this);
//    }


    @BeforeEach
    void prepare() {
        System.out.println("Before Each " + this);
        userService = new UserService();

    }

    @Test
    void userEmptyIfNoUserAdded() {
        System.out.println("userEmptyIfNoUserAdded " + this);
        var users = userService.getAll();
        assertTrue(users.isEmpty(), ()-> "User list should empty");
    }

    @Test
    void usersSizeIfUserAdded(){
        System.out.println("usersSizeIfUserAdded " + this);
        userService.add(new User());
        userService.add(new User());

        var users = userService.getAll();
        assertEquals(2, users.size());
    }

    @AfterEach
    void deleteDataFromDataBase(){
        System.out.println("After Each " + this);
    }

    @AfterAll
    static void closeConnectionPull(){
        System.out.println("After all ");
    }

//    @AfterAll
//    void closeConnectionPull(){
//        System.out.println("After all " + this);
//    }

}
