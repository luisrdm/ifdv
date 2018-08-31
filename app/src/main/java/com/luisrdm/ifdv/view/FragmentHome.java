package com.luisrdm.ifdv.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luisrdm.Util.ResultListener;
import com.luisrdm.ifdv.R;
import com.luisrdm.ifdv.controller.Controller;
import com.luisrdm.ifdv.model.User;

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
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        Controller controller = new Controller();
        controller.obtainRandomUsers(new ResultListener<List<User>>() {
            @Override
            public void finish(List<User> result) {
                Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

}
