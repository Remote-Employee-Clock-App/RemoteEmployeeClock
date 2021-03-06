package com.example.remoteemployeeclock.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.remoteemployeeclock.Post;
import com.example.remoteemployeeclock.PostAdapter;
import com.example.remoteemployeeclock.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class InboxFragment extends Fragment {

    public static final String TAG = "InboxFragment";
    private RecyclerView rvMessages;
    private PostAdapter adpater;
    private List<Post> allMessages;

    public InboxFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inbox, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMessages = view.findViewById(R.id.rvMessages);

        allMessages = new ArrayList<>();
        adpater = new PostAdapter(getContext(), allMessages);

        rvMessages.setAdapter(adpater);
        rvMessages.setLayoutManager(new LinearLayoutManager(getContext()));
        queryPosts();
    }

    protected void queryPosts(){
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_NAME);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with getting messages", e);
                    return;
                }
                for (Post post : posts){
                    Log.i(TAG, "Message: " + post.getMessage() + ", Name: " + post.getName());
                }
                allMessages.addAll(posts);
                adpater.notifyDataSetChanged();
            }
        });
    }
}