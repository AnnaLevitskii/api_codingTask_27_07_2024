package com.api;

import com.core.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.api.UserController.faker;
import static org.testng.Assert.*;

public class UserControllerTest {
    @Test
    public void testPostCreate_posetiveTest(){
        String name = faker.name().firstName();
        String job = faker.job().title();
        User user = User.builder().name(name).job(job).build();

        User userPost = UserController.postCreate(user);

        Assert.assertEquals(user.getName(),userPost.getName());
        Assert.assertEquals(user.getJob(),userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
    }
    @Test
    public void testPostCreate_posetiveTest_nameisBlank(){
        String name = " ";
        String job = faker.job().title();
        User user = User.builder().name(name).job(job).build();

        User userPost = UserController.postCreate(user);
        System.out.println(userPost);
        Assert.assertEquals(" ",userPost.getName());
        Assert.assertEquals(user.getJob(),userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
    }
    @Test
    public void testPostCreate_posetiveTest_nameisEmpty(){
        String name = "";
        String job = faker.job().title();
        User user = User.builder().name(name).job(job).build();

        User userPost = UserController.postCreate(user);
        System.out.println(userPost);
        Assert.assertEquals("",userPost.getName());
        Assert.assertEquals(user.getJob(),userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
    }
    @Test
    public void testPostCreate_posetiveTest_nameNull(){
        String job = faker.job().title();
        User user = User.builder().job(job).build();

        User userPost = UserController.postCreate(user);

        Assert.assertNull(userPost.getName());
        Assert.assertEquals(user.getJob() ,userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
        Assert.assertNotNull(userPost.getId());
    }
    @Test
    public void testPostCreate_posetiveTest_jobNull(){
        String name = faker.name().firstName();
        User user = User.builder().name(name).build();

        User userPost = UserController.postCreate(user);

        Assert.assertEquals(user.getName() ,userPost.getName());
        Assert.assertNull(userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
        Assert.assertNotNull(userPost.getId());
    }
    @Test
    public void testPostCreate_posetiveTest_nameNull_jobNull(){
        User user = User.builder().build();

        User userPost = UserController.postCreate(user);

        Assert.assertNull(userPost.getName());
        Assert.assertNull(userPost.getJob());
        Assert.assertNotNull(userPost.getCreatedAt());
        Assert.assertNotNull(userPost.getId());
    }

}