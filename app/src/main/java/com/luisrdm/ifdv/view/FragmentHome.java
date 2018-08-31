package com.luisrdm.ifdv.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisrdm.Util.ResultListener;
import com.luisrdm.ifdv.R;
import com.luisrdm.ifdv.controller.Controller;
import com.luisrdm.ifdv.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_fragmentHome);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final AdapterUser adapterUser = new AdapterUser(new ArrayList<User>());
        recyclerView.setAdapter(adapterUser);

        Controller controller = new Controller(getActivity());
        controller.obtainRandomUsers(new ResultListener<List<User>>() {
            @Override
            public void finish(List<User> result) {
                adapterUser.updateDataset(result);
            }
        });

        return view;
    }

}
