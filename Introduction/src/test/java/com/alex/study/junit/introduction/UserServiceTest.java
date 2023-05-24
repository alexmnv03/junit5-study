package com.alex.study.junit.introduction;

import com.alex.study.junit.introduction.service.UserService;
import com.alex.study.junit.introduction.service.dto.User;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    void trowExeptionIfUsernameOrPasswordIsNull() {
        try {
            userService.login(null, "dimmme");
            fail("login should trown exeption on null UsrName");
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }

    @Test
    void trowsExeptionIfUsernameOrPasswordIsNull() {
        assertThrows(IllegalArgumentException.class, ()-> userService.login(null, "dimmme"));
        assertThrows(IllegalArgumentException.class, ()-> userService.login("dimmme", null));
        // если так
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, ()-> userService.login(null,
                        "dimmme")),
                () -> assertThrows(IllegalArgumentException.class, ()-> userService.login("dimmme", null))
        );
    }

    @Test
    void myTrowsExeptionIfUsernameOrPasswordIsNull() {
        assertAll(
                () -> {
                    var exeption = assertThrows(IllegalArgumentException.class,
                            ()-> userService.login(null,
                            "dimmme"));
                    assertThat(exeption.getMessage()).isEqualTo("userName or password is Null");
                },
                () -> assertThrows(IllegalArgumentException.class, ()-> userService.login("dimmme", null))
        );

    }

    @Test
    void userEmptyIfNoUserAdded() {
        System.out.println("userEmptyIfNoUserAdded " + this);
        var users = userService.getAll();
        assertTrue(users.isEmpty(), ()-> "User list should empty");
        // asserj
        assertThat(users).hasSize(1);
        // hamcrest
        MatcherAssert.assertThat(users, IsEmptyCollection.empty());
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