package com.example.gopal.nfa;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Event>>{
    CustomAdapter mArrayAdapter;
    TextView textView;
    String mUrl;


    public MasterFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_master, container, false);
        ListView list = rootView.findViewById(R.id.list);
       mUrl = "https://content.guardianapis.com/search?q=tech&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail";
      //  if (getArguments() != null) {
      //  // mUrl = getArguments().getString("key");}

        mArrayAdapter = new CustomAdapter(getActivity(),new ArrayList<Event>());
        list.setAdapter(mArrayAdapter);
        ConnectivityManager cm = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nif = cm.getActiveNetworkInfo();
        if(nif!=null && nif.isConnected()) {
            getLoaderManager().initLoader(0, null, this).forceLoad();
        }
        else{
            // textView = findViewById(R.id.no_network);
            // textView.setText("Oops! No network");
            }
            return rootView;
    }
    @NonNull
    @Override
    public Loader<List<Event>> onCreateLoader(int i, Bundle bundle) {
        return new CustomLoader(getContext(),mUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<Event>> loader, List<Event> events) {
        mArrayAdapter.addAll(events);
    }

    @Override
    public void onLoaderReset(Loader<List<Event>> loader) {
        mArrayAdapter.clear();
    }

//    String getUrl(int position){
//        String[] urlArray ={"https://content.guardianapis.com/search?q=tech&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail",
//                "https://content.guardianapis.com/search?q=tech&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail",
//                "https://content.guardianapis.com/search?q=tech&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail"};
//        return urlArray[position];
//    }

//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mUrl = getArguments().getString("key");
//        }
//    }
}
