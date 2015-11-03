package io.github.froger.instamaterial.ui.utils;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.Toast;

import com.wilddog.client.DataSnapshot;
import com.wilddog.client.ValueEventListener;
import com.wilddog.client.Wilddog;
import com.wilddog.client.WilddogError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import butterknife.Optional;
import io.github.froger.instamaterial.ui.activity.MainActivity;

/**
 * Created by Dan on 2015-10-28.
 */
public class Dog {

    public static final String WILDDOG_DATA_URL = "https://wilddog-vcii-3621.wilddogio.com/data";
    public List<Map<String, Object>> feedList;
    public int listNumber = 1;

    private void initData() {
        Wilddog ref = new Wilddog(WILDDOG_DATA_URL);
        feedList = new ArrayList<Map<String, Object>>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                feedList = new ArrayList();
                feedList = (List) dataSnapshot.getValue();
                listNumber = feedList.size();
                System.out.println(listNumber);
                System.out.println(feedList);
            }

            @Override
            public void onCancelled(WilddogError wilddogError) {
            }
        });

    }

}
