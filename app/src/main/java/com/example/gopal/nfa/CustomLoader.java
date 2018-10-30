package com.example.gopal.nfa;

import android.content.AsyncTaskLoader;
import android.content.Context;



import java.util.List;

/**
 * Created by Gopal on 10/28/2018.
 */

public class CustomLoader extends android.support.v4.content.AsyncTaskLoader {
    private String mUrl;
    public CustomLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
    }

    @Override
    public List<Event> loadInBackground() {
        List<Event> arrayList = Helper.fetchEarthquakeData(mUrl);
        return arrayList;
    }
}
