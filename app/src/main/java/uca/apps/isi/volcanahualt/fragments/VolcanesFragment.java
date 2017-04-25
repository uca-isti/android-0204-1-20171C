package uca.apps.isi.volcanahualt.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
import android.support.v7.widget.RecyclerView;
=======
>>>>>>> 68582831379cadec2d240557728a236e942b2025
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<< HEAD
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uca.apps.isi.volcanahualt.MainActivity;
import java.util.ArrayList;
import java.util.List;

import uca.apps.isi.volcanahualt.R;
import uca.apps.isi.volcanahualt.api.Api;
import uca.apps.isi.volcanahualt.ui.volcanAdapter;
=======
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uca.apps.isi.volcanahualt.R;
import uca.apps.isi.volcanahualt.api.Api;
>>>>>>> 68582831379cadec2d240557728a236e942b2025
import uca.apps.isi.volcanahualt.models.Volcan;

/**
 * A simple {@link Fragment} subclass.
 */
public class VolcanesFragment extends Fragment {
<<<<<<< HEAD
  private static final String TAG = "VolcanesFragment";
  public RecyclerView Volcanes;
  public volcanAdapter volcanAdapter;
  public ArrayList<Volcan> VolcanModelArrayList;
=======

  private static final String TAG = "VolcanesFragment";


>>>>>>> 68582831379cadec2d240557728a236e942b2025
  public VolcanesFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
<<<<<<< HEAD
    View rootView = inflater.inflate(R.layout.fragment_volcanes, container, false);
    Volcanes = (RecyclerView) rootView.findViewById(R.id.volcan);
    VolcanModelArrayList= new ArrayList<>();
    getData();



    // Inflate the layout for this fragment
    return rootView;
=======

    getData();

>>>>>>> 68582831379cadec2d240557728a236e942b2025
    // Inflate the layout for this fragment
    //return inflater.inflate(R.layout.fragment_volcanes, container, false);
  }
  private void getData() {
    Call<List<Volcan>> call = Api.instance().getVolcanes();
    call.enqueue(new Callback<List<Volcan>>() {
      @Override
      public void onResponse(Call<List<Volcan>> call, Response<List<Volcan>> response) {
        if (response != null) {
          for(Volcan volcan : response.body()) {
            Log.i(TAG, volcan.getNombre());

          }
        }
        else {
          Log.i(TAG, "La respuesta es incorrecta");
        }
      }

<<<<<<< HEAD
=======
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

>>>>>>> 68582831379cadec2d240557728a236e942b2025
      @Override
      public void onFailure(Call<List<Volcan>> call, Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
      }
    });

  }
<<<<<<< HEAD
=======

>>>>>>> 68582831379cadec2d240557728a236e942b2025
}
