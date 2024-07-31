package com.api;

import com.core.models.RegistrationResponse;
import com.core.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.api.UserController.faker;

public class UserControllerTest {
    @Test
    public void testPostCreate_positiveTest(){
        User user = User.builder().name(faker.name().firstName())
                .job(faker.job().title()).build();

        User userPost = UserController.postCreate(user);

        Assert.assertEquals(user.getName(),userPost.getName());
        Assert.assertEquals(user.getJob(),userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
    }
    @Test
    public void testPostCreate_positiveTest_nameIsBlank(){
        User user = User.builder().name(" ").job(faker.job().title()).build();

        User userPost = UserController.postCreate(user);
        System.out.println(userPost);
        Assert.assertEquals(" ",userPost.getName());
        Assert.assertEquals(user.getJob(),userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
    }
    @Test
    public void testPostCreate_positiveTest_nameIsEmpty(){
        User user = User.builder().name("").job(faker.job().title()).build();

        User userPost = UserController.postCreate(user);

        Assert.assertEquals("",userPost.getName());
        Assert.assertEquals(user.getJob(),userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
    }
    @Test
    public void testPostCreate_positiveTest_nameNull(){
        User user = User.builder().job(faker.job().title()).build();

        User userPost = UserController.postCreate(user);

        Assert.assertNull(userPost.getName());
        Assert.assertEquals(user.getJob() ,userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
        Assert.assertNotNull(userPost.getId());
    }
    @Test
    public void testPostCreate_positiveTest_jobNull(){
        User user = User.builder().name(faker.name().firstName()).build();

        User userPost = UserController.postCreate(user);

        Assert.assertEquals(user.getName() ,userPost.getName());
        Assert.assertNull(userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
        Assert.assertNotNull(userPost.getId());
    }
    @Test
    public void testPostCreate_positiveTest_nameNull_jobNull(){
        User user = User.builder().build();

        User userPost = UserController.postCreate(user);

        Assert.assertNull(userPost.getName());
        Assert.assertNull(userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
        Assert.assertNotNull(userPost.getId());
    }

    @Test
    public void testPostRegistration_positiveTest() {
        User user = User.builder().email("michael.lawson@reqres.in").  //Only defined users succeed registration
                password(faker.internet().password()).build();

        RegistrationResponse response = UserController.postRegistration(user);

        Assert.assertNotNull(response.getToken());
    }
    @Test
    public void testPostRegistration_negativeTest_passwordIsEmpty() {
        User user = User.builder().email("michael.lawson@reqres.in").  //Only defined users succeed registration
                password("").build();

        RuntimeException exception = Assert.expectThrows(RuntimeException.class,()
                ->{UserController.postRegistration(user);});
        Assert.assertEquals(exception.getMessage(), "Missing password");
    }
}