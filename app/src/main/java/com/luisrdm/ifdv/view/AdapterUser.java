package com.luisrdm.ifdv.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luisrdm.ifdv.R;
import com.luisrdm.ifdv.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis R. Díaz Muñiz on 31/08/2018.
 * you can reach me at luisrdm@gmail.com
 */
public class AdapterUser extends RecyclerView.Adapter {

    private List<User> listOfUsers;

    public AdapterUser(ArrayList<User> users) {
        listOfUsers = users;
    }

    public void updateDataset(List<User> listOfUsers){
        this.listOfUsers = listOfUsers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cellView = inflater.inflate(R.layout.recycler_view_user_detail,parent,false);

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
        private TextView textViewTitle;
        private TextView textViewName;
        private TextView textViewSurname;

        public UserHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textView_recyclerViewDetail_title);
            textViewName = itemView.findViewById(R.id.textView_recyclerViewDetail_name);
            textViewSurname = itemView.findViewById(R.id.textView_recyclerViewDetail_surname);
        }

        public void bindUser(User user){
            textViewTitle.setText(user.getName().getTitle());
            textViewName.setText(user.getName().getFirst());
            textViewSurname.setText(user.getName().getLast());
        }


    }

}
