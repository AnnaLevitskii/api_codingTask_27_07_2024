package com.api;

import com.core.models.Image;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class ImageControllerTest {

    @BeforeSuite
    public void bt(){
    }

    @Test
    public void testGetImages_posetiveTest() {
          ArrayList<String> titlesGet = ImageController.getTitles();
          Assert.assertEquals(titlesGet, ImageController.titles);

          ArrayList<String> pathGet = ImageController.getPath();
          for(String path : pathGet){
            Assert.assertTrue(path.contains("https://via.placeholder.com/"));
          }

          ArrayList<Integer> idGet = ImageController.getIds();
          int i = 0;
          for (int id : idGet){
              Assert.assertEquals(id, i);
              i++;
          }
    }
}