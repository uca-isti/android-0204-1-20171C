package uca.apps.isi.volcanahualt.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uca.apps.isi.volcanahualt.R;
import uca.apps.isi.volcanahualt.api.Api;
import uca.apps.isi.volcanahualt.models.Volcan;

/**
 * A simple {@link Fragment} subclass.
 */
public class VolcanesFragment extends Fragment {

  private static final String TAG = "VolcanesFragment";


  public VolcanesFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    getData();

    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_volcanes, container, false);
  }

  private void getData() {
    Log.i(TAG, "Cargo la app");
    Call<List<Volcan>> call = Api.instance().getVolcanes();
    call.enqueue(new Callback<List<Volcan>>() {
      @Override
      public void onResponse(Call<List<Volcan>> call, Response<List<Volcan>> response) {
        Log.i(TAG, "llegue");
        if (response != null && response.body() !=null) {
          for(Volcan volcan : response.body()) {
            Log.i(TAG, response.body().toString());
           Log.i(TAG, volcan.getNombre());
          }
        }
        else {
          Log.i(TAG, "La respuesta es incorrecta");
        }
      }

      @Override
      public void onFailure(Call<List<Volcan>> call, Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
      }
    });

  }

}
