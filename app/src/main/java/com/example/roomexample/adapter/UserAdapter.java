package com.example.roomexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomexample.R;
import com.example.roomexample.db.User;

import java.util.List;

/**
 * Created by piyush on 25/12/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.rv_item,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.tvFname.setText(userList.get(position).getFirstName());
        holder.tvLname.setText(userList.get(position).getLastName());
        holder.tvAge.setText(""+userList.get(position).getAge());
    }

    public void setUserList(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        public TextView tvFname,tvLname,tvAge;
        public UserViewHolder(View itemView) {
            super(itemView);
            tvFname = (TextView) itemView.findViewById(R.id.tv_fname);
            tvLname = (TextView) itemView.findViewById(R.id.tv_lname);
            tvAge = (TextView) itemView.findViewById(R.id.tv_age);
        }
    }
}
