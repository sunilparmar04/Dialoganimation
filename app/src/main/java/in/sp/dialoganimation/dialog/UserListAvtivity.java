package in.sp.dialoganimation.dialog;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.sp.dialoganimation.R;

public class UserListAvtivity extends AppCompatActivity {

    private RecyclerView userListRecyclerView;
    LinearLayoutManager mLayoutManager;
    ArrayList<String> userList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userListRecyclerView = findViewById(R.id.userListRecyclerView);
        userListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        userList();

        ChatUsersAdapter adapter = new ChatUsersAdapter();
        userListRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    private void userList() {
        for (int i = 0; i < 20; i++) {
            userList.add("Sunil_" + i);

        }
    }

    class ChatUsersAdapter extends RecyclerView.Adapter<ChatUsersAdapter.MyViewHolder> {

        private final String TAG = ChatUsersAdapter.class.getName();

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public ImageView userProfileImageView;
            public TextView nameTextView;
            public View dummyView;

            public MyViewHolder(View view) {
                super(view);

                userProfileImageView = view.findViewById(R.id.userProfileImageView);
                dummyView = view.findViewById(R.id.dummyView);
                nameTextView = view.findViewById(R.id.nameTextView);

            }
        }


        public ChatUsersAdapter() {

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_user, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            try {
                String name = userList.get(position);
                Log.v("data_user", "" + name);

                holder.nameTextView.setText(name);
                holder.userProfileImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(UserListAvtivity.this, DialogActivity.class);
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(UserListAvtivity.this, holder.dummyView, getString(R.string.transition_dialog));
                        startActivityForResult(intent, 123, options.toBundle());
                    }
                });

            } catch (Exception e) {

            }
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }
    }

}
