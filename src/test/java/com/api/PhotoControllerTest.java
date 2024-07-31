package com.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class PhotoControllerTest {
    @Test
    public void testGetPhotos_posetiveTest() {
        ArrayList<String> titlesGet = PhotoController.getTitles();
        Assert.assertEquals(titlesGet, PhotoController.titles);

        ArrayList<String> urlGet = PhotoController.getUrl();
        for(String url : urlGet){
            Assert.assertTrue(url.contains("https://via.placeholder.com/"));
        }

        ArrayList<Integer> idGet = PhotoController.getIds();
        int i = 0;
        for (int id : idGet){
            Assert.assertEquals(id, i);
            i++;
        }
    }

}