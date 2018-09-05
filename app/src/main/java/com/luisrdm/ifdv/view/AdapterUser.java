package com.luisrdm.ifdv.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luisrdm.ifdv.R;
import com.luisrdm.ifdv.model.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
public class AdapterUser extends RecyclerView.Adapter {

    private Context context;
    private List<User> listOfUsers;
    private InterfaceNotifierFromAdapterHome interfaceNotifierFromAdapterHome;

    public AdapterUser(ArrayList<User> users, Context context, InterfaceNotifierFromAdapterHome interfaceNotifierFromAdapterHome) {
        listOfUsers = users;
        this.context = context;
        this.interfaceNotifierFromAdapterHome = interfaceNotifierFromAdapterHome;
    }

    public void updateDataset(List<User> listOfUsers, RecyclerView recyclerView){
        this.listOfUsers = listOfUsers;
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

        recyclerView.setLayoutAnimation(controller);
        notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cellView = inflater.inflate(R.layout.recycler_view_user_cell,parent,false);

        UserHolder userHolder = new UserHolder(cellView);

        return userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = listOfUsers.get(position);
        UserHolder userHolder = (UserHolder) holder;
        userHolder.bindUser(user);
    }

    @Override
    public int getItemCount() {
        return listOfUsers.size();
    }

    private class UserHolder extends RecyclerView.ViewHolder {
        private TextView textViewFullName;
        private CircleImageView imageViewPhoto;

        public UserHolder(View itemView) {
            super(itemView);
            textViewFullName = itemView.findViewById(R.id.textView_recyclerViewDetail_fullName);
            imageViewPhoto = itemView.findViewById(R.id.imageView_recyvlerViewDetail_photo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interfaceNotifierFromAdapterHome.notifyFromUserAdapter(listOfUsers.get(getAdapterPosition()));
                }
            });
        }

        public void bindUser(User user){
            textViewFullName.setText(user.getName().getTitle() + " " + user.getName().getFirst() + " " + user.getName().getLast());
            RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.no_image).error(R.drawable.no_image).dontAnimate();
            Glide.with(context).load(user.getPicture().getMedium()).apply(requestOptions).into(imageViewPhoto);
        }
    }

    public interface InterfaceNotifierFromAdapterHome {
        void notifyFromUserAdapter(User user);
    }

}
