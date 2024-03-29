package com.example.android.status;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Completed.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Completed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Completed extends Fragment {
    ArrayList<event_item> item;
    RecyclerView recyclerView;
    eventAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Completed() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Completed.
     */
    // TODO: Rename and change types and number of parameters
    public static Completed newInstance(String param1, String param2) {
        Completed fragment = new Completed();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

     item=new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View com=  inflater.inflate(R.layout.fragment_completed, container, false);
    recyclerView=com.findViewById(R.id.rview);
    recyclerView.setHasFixedSize(true);
    getinfo();
       return com;
    }
    private void getinfo()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://us-central1-sportsfete18v2.cloudfunctions.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        statusApi StatusApi=retrofit.create(statusApi.class);
        Call<List<obj>> call=StatusApi.getevents("completed");
        call.enqueue(new Callback<List<obj>>() {
            @Override
            public void onResponse(Call<List<obj>> call, Response<List<obj>> response) {
                if(!response.isSuccessful())
                {
                    return;
                }
                final List<obj> objs=response.body();
                if(!objs.isEmpty())
                {layoutManager=new LinearLayoutManager(getContext());
adapter=new eventAdapter(getContext(),objs);
recyclerView.setLayoutManager(layoutManager);
recyclerView.setAdapter(adapter);
adapter.setOnItemClickListener(new eventAdapter.OnItemClickListener() {
    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(getActivity(),eventDetails.class);
        intent.putExtra("Event", objs.get(position));
        startActivity(intent);
    }
});}
else
                {
                    Toast.makeText(getContext(),"No events completed yet..",Toast.LENGTH_SHORT).show();
                }
              }

            @Override
            public void onFailure(Call<List<obj>> call, Throwable t) {

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
