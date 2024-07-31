package com.api;

import com.core.models.Image;
import com.google.gson.Gson;
import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.lang.reflect.Type;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;

public class ImageController extends RestApiMethods{
    private static String urlApiImages="https://my-json-server.typicode.com/icedrone/json-demo-server/images";

    static String[] arr = {"reprehenderit est deserunt velit ipsam", "accusamus ea aliquid et amet sequi nemo",
            "officia delectus consequatur vero aut veniam explicabo molestias",
            "aut porro officiis laborum odit ea laudantium corporis","qui eius qui autem sed",
            "beatae et provident et ut vel"};
    public static ArrayList<String> titles = new ArrayList<>(Arrays.asList(arr));
    private static ArrayList<Image> getImages(){
        String response = get(urlApiImages);
        Gson gson = new Gson();
        Type datasetListType = new TypeToken<Collection<Collection<Image>>>() {}.getType();
        ArrayList<ArrayList<Image>> arrayList = gson.fromJson(response , datasetListType);
        ArrayList<Image> images = arrayList.get(0);
        return images;
    }
    public static ArrayList<String> getTitles(){
        ArrayList<Image> images = getImages();
        return (ArrayList<String>) images.stream().map(Image::getTitle).collect(Collectors.toList());
    }
    public static ArrayList<String> getPath(){
        ArrayList<Image> images = getImages();
        return (ArrayList<String>) images.stream().map(Image::getPath).collect(Collectors.toList());
    }
    public static ArrayList<Integer> getIds(){
        ArrayList<Image> images = getImages();
        return (ArrayList<Integer>) images.stream().map(Image::getId).collect(Collectors.toList());
    }

}
