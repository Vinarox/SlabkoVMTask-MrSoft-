package by.bsu.slabko.vladislav.slabkovmtask.MVP.Views.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import by.bsu.slabko.vladislav.slabkovmtask.App;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseContainer;
import by.bsu.slabko.vladislav.slabkovmtask.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private Context mContext;
    private LayoutInflater ltInflater;
    private DatabaseContainer databaseContainer;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView cityName;
        public TextView language;
        public TextView population;
        public TextView salary;
        public ImageView capitalChecker;
        public MyViewHolder(View v) {
            super(v);
            view = v;
            cityName = v.findViewById(R.id.cityName);
            language = v.findViewById(R.id.language);
            population = v.findViewById(R.id.population);
            salary = v.findViewById(R.id.averageSalary);
            capitalChecker = v.findViewById(R.id.capitalChecker);
        }
    }

    public ListAdapter(Context c, LayoutInflater ltInflater) {
        this.mContext = c;
        this.ltInflater = ltInflater;
        this.databaseContainer = App.getModelComponents().getDatabaseContainer();
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = ltInflater.inflate(R.layout.list_line, null, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.cityName.setText(databaseContainer.getItems().get(position).getCityName());
        holder.language.setText(databaseContainer.getItems().get(position).getSpokenLanguage());
        holder.population.setText(String.valueOf(databaseContainer.getItems().get(position).getPopulation()));
        String salaryStr = databaseContainer.getItems().get(position).getAverageSalaryLevel() + "$";
        holder.salary.setText(salaryStr);
        int color;
        holder.capitalChecker = holder.view.findViewById(R.id.capitalChecker);
        if(databaseContainer.getItems().get(position).isCapital()) {
            color = R.color.green;
        }
        else {
            color = R.color.grey;
        }
        DrawableCompat.setTint(holder.capitalChecker.getDrawable(),
                mContext.getApplicationContext().getResources().getColor(color));
    }


    @Override
    public int getItemCount() {
        return databaseContainer.getItems().size();
    }

    public void deleteItem(int position) {
        databaseContainer.deleteItem(position);
    }
}
