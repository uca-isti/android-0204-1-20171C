package uca.apps.isi.volcanahualt.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uca.apps.isi.volcanahualt.R;
import uca.apps.isi.volcanahualt.models.Volcan;

/**
 * Created by isi3 on 24/4/2017.
 */

public class volcanAdapter extends RecyclerView.Adapter<volcanAdapter.ViewHolder>{

        public static class ViewHolder extends RecyclerView.ViewHolder{
            public TextView nombre;


            public ViewHolder(View itemView){
                super(itemView);
                nombre = (TextView) itemView.findViewById(R.id.volcan);
            }
        }//end static class

        private List<Volcan> VolcanModelList;
        private Context context;

    public volcanAdapter(Context context, List<Volcan> VolcanModelList) {
            this.VolcanModelList = VolcanModelList;
            this.context = context;
        }//end contructor

    public Context getContext() {
        return context;
    }//end method

    @Override
    public volcanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View volcanView = inflater.inflate(R.layout.fragment_volcanes, parent, false);
        ViewHolder viewHolder = new ViewHolder(volcanView);
        return viewHolder;
    }//end method

    @Override
    public void onBindViewHolder(volcanAdapter.ViewHolder viewHolder, int position) {
        Volcan volcan = VolcanModelList.get(position);

        TextView volcan_name = viewHolder.nombre;
        volcan_name.setText(volcan.getNombre());

    }//end method

    @Override
    public int getItemCount() {
        return VolcanModelList.size();
    }//end method
}//end class
