package uca.apps.isi.volcanahualt.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import uca.apps.isi.volcanahualt.models.Volcan;

/**
 * Created by Owner on 08/04/2017.
 */

public interface ApiInterface {

    @GET("volcanes")
    Call<List<Volcan>> getVolcanes();
}
