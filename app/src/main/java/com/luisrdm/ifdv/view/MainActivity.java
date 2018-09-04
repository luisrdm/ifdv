package com.luisrdm.ifdv.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.luisrdm.ifdv.R;
import com.luisrdm.ifdv.model.User;

public class MainActivity extends AppCompatActivity implements FragmentHome.InterfaceNotifierFromFragmentHome {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_MainActivity_root, new FragmentHome(), null);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void notifyFromFragmentHome(User user) {
        Toast.makeText(this, "Main activity: " + user.toString(), Toast.LENGTH_SHORT).show();

        FragmentDetail fragmentDetail = new FragmentDetail();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentDetail.USERKEY, user);
        fragmentDetail.setArguments(bundle);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_MainActivity_root, fragmentDetail, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
