package com.example.verify.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.verify.R;
import com.example.verify.components.ApartmentProfile;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends BaseFragment {


    private SearchFragmentListener mSearchFragmentListener;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View button = view.findViewById(R.id.main_search_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSearchFragmentListener != null){
                    mSearchFragmentListener.onSearchButtonClick();
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof DummySearchFragment.DummySearchFragmentListener){
            mSearchFragmentListener = (SearchFragmentListener) context;
        }
        else{
            throw new RuntimeException(context.toString() + " must imlement DummySearchFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSearchFragmentListener = null;
    }

    public ApartmentProfile collectApartmentProfile(){
        return new ApartmentProfile(
                ((EditText)Objects.requireNonNull(getView()).findViewById(R.id.city_field)).getText().toString(),
                ((EditText)Objects.requireNonNull(getView()).findViewById(R.id.street_field)).getText().toString(),
                Integer.parseInt(((EditText)Objects.requireNonNull(getView()).findViewById(R.id.building_field)).getText().toString()),
                Integer.parseInt((((EditText)Objects.requireNonNull(getView()).findViewById(R.id.floor_field)).getText().toString())),
                Integer.parseInt(((EditText)Objects.requireNonNull(getView()).findViewById(R.id.apartment_field)).getText().toString())
        );
    }

    public interface SearchFragmentListener{
        void onSearchButtonClick();
    }
}