package by.bsu.slabko.vladislav.slabkovmtask.MVP.Views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Views.MainActivity;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Views.adapters.ListAdapter;
import by.bsu.slabko.vladislav.slabkovmtask.R;


public class StartFragment extends Fragment
        implements MainActivity.OnActivityInteractionListener {
    //@Inject
    private ListAdapter mAdapter;

    public StartFragment() {}


    public static StartFragment newInstance() {
        StartFragment fragment = new StartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_start, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.my_view);
        registerForContextMenu(recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getActivity()));
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ListAdapter((getActivity()), inflater);
        recyclerView.setAdapter(mAdapter);
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter = null;
    }

    @Override
    public void onStringSelected(String str) {
        if(str.equals("updateList")){
            mAdapter.notifyDataSetChanged();
        }
    }
}
