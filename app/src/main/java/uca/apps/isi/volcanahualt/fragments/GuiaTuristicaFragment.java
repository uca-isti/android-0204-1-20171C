package uca.apps.isi.volcanahualt.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uca.apps.isi.volcanahualt.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuiaTuristicaFragment extends Fragment {


  public GuiaTuristicaFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_guia_turistica, container, false);
  }

}
