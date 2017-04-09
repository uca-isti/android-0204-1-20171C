package uca.apps.isi.volcanahualt.api;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Owner on 06/04/2017.
 */

public class Api {

    private final static String URL = "https://api-0204-1.herokuapp.com/api";

    public static String getBase() {return URL + "/";}

    public static ApiInterface instance(){
        Retrofit retrofit = new Retrofit
                 .Builder()
                 .baseUrl(Api.getBase())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
        return retrofit.create(ApiInterface.class);
    }

}
