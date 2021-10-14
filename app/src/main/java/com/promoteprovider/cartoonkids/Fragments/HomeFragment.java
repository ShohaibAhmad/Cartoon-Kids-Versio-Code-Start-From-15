package com.promoteprovider.cartoonkids.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.promoteprovider.cartoonkids.Adapters.CartoonAdapter;
import com.promoteprovider.cartoonkids.Models.CartoonModel;
import com.promoteprovider.cartoonkids.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    FirebaseFirestore database;
   CartoonAdapter adapter;
   ShimmerFrameLayout shimmerFrameLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        shimmerFrameLayout = view.findViewById(R.id.shimmer_view_container);

//        recyclerView = view.findViewById(R.id.recyclerView);

        ArrayList<CartoonModel> cartoonList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

//        layoutManager.setReverseLayout(true);
//        layoutManager.setStackFromEnd(true);

        Collections.shuffle(cartoonList);

        adapter = new CartoonAdapter(cartoonList,getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        shimmerFrameLayout.stopShimmer();






        database = FirebaseFirestore.getInstance();
        database.collection("Videos").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
              List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
              for (DocumentSnapshot d:list ){
                  CartoonModel model = d.toObject(CartoonModel.class);
                  cartoonList.add(model);
              }
              adapter.notifyDataSetChanged();
                shimmerFrameLayout.setVisibility(View.GONE);
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    public void onResume() {
        shimmerFrameLayout.startShimmer();
        super.onResume();
    }
}