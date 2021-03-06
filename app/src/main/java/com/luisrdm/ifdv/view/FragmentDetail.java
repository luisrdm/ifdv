package com.luisrdm.ifdv.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luisrdm.ifdv.R;
import com.luisrdm.ifdv.model.User;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetail extends Fragment {


    public static final String USERKEY = "userKey";

    public FragmentDetail() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle bundle = getArguments();
        User user = (User) bundle.getSerializable(USERKEY);

        CircleImageView imageViewPhoto = view.findViewById(R.id.imageView_fragmentDetail_photo);
        TextView textViewTitle = view.findViewById(R.id.textView_fragmentDetail_title);
        TextView textViewName = view.findViewById(R.id.textView_fragmentDetail_name);
        TextView textViewSurname = view.findViewById(R.id.textView_fragmentDetail_surname);
        TextView textViewEmail = view.findViewById(R.id.textView_fragmentDetail_email);

        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.no_image).error(R.drawable.no_image).dontAnimate();
        Glide.with(getContext()).load(user.getPicture().getLarge()).apply(requestOptions).into(imageViewPhoto);

        textViewTitle.setText(user.getName().getTitle());
        textViewName.setText(user.getName().getFirst());
        textViewSurname.setText(user.getName().getLast());
        textViewEmail.setText(user.getEmail());

        return view;
    }

}
