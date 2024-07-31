package com.api;

import com.core.models.Image;
import com.core.models.Photo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class PhotoController extends RestApiMethods{
    private static String urlPhotos = "https://my-json-server.typicode.com/icedrone/json-demo-server/photos";

    static String[] arr = {"reprehenderit est deserunt velit ipsam", "officia porro iure quia iusto qui ipsa ut modi",
            "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
            "natus nisi omnis corporis facere molestiae rerum in","qui eius qui autem sed"};
    public static ArrayList<String> titles = new ArrayList<>(Arrays.asList(arr));

    private static ArrayList<Photo> getPhotos(){
        String response = get(urlPhotos);

        Gson gson = new Gson();
        Type datasetListType = new TypeToken<Collection<Collection<Photo>>>() {}.getType();
        ArrayList<ArrayList<Photo>> arrayList = gson.fromJson(response , datasetListType);
        ArrayList<Photo> photos = arrayList.get(0);
        return photos;
    }

    public static ArrayList<String> getTitles(){
        ArrayList<Photo> photos  = getPhotos();
        return (ArrayList<String>) photos.stream().map(Photo::getTitle).collect(Collectors.toList());
    }
    public static ArrayList<String> getUrl(){
        ArrayList<Photo> photos  = getPhotos();
        return (ArrayList<String>) photos.stream().map(Photo::getUrl).collect(Collectors.toList());
    }
    public static ArrayList<Integer> getIds(){
        ArrayList<Photo> photos  = getPhotos();
        return (ArrayList<Integer>) photos.stream().map(Photo::getId).collect(Collectors.toList());
    }

}
