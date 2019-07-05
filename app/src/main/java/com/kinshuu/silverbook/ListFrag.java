package com.kinshuu.silverbook;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends Fragment {

    RecyclerView recyclerview;
    public RecyclerView.Adapter myadapter;
    RecyclerView.LayoutManager layoutManager;
    View view;
    ArrayList<Subject> subjects;
    Integer elegible;

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: Fragment created");
        view= inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
        recyclerview =view.findViewById(R.id.list);
        recyclerview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerview.setLayoutManager(layoutManager);
        if(subjects==null) {
            subjects= new ArrayList<>();
            Log.d(TAG, "onActivityCreated: Subjects is null");
            subjects.add(new Subject("New Subject"));
        }
        myadapter = new SubjectAdapter(this.getActivity(), subjects, elegible);
        recyclerview.setAdapter(myadapter);
    }

    //This is a bundle from main activity, it contains the local subjects ArrayList.
    public void getArgs(Bundle args){
        subjects=args.getParcelableArrayList("arraylist");
        elegible=args.getInt("elegible");
        Log.d(TAG, "getArgs: List recieved");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: In oncreat");
    }

    public void emptyfun(){}
}
