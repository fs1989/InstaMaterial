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

    public static Wilddog ref;
    public static final String WILDDOG_URL = "https://wilddog-vcii-3621.wilddogio.com";
    static CoordinatorLayout clContent;
    public static Object result;

    public Dog() {
        ref = new Wilddog(WILDDOG_URL);
    }

    public static void write(String node, Map map) {
        Wilddog postRef = ref.child(node);
        postRef.push().setValue(map, new Wilddog.CompletionListener() {
            @Override
            public void onComplete(WilddogError wilddogError, Wilddog wilddog) {
                if (wilddogError != null) {
                    Snackbar.make(clContent, "Data could not be saved. " + wilddogError.getMessage(), Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(clContent, "Data saved successfully.", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

    }

    public static Object getData(String path) {

        ref.child(path).addValueEventListener(new ValueEventListener() {

            public void onDataChange(DataSnapshot snapshot) {
                result =  snapshot.getValue();
                System.out.println("Dog类里的onDataChange方法执行了: Result为 " + snapshot.getValue()); //打印结果 "hello world!!!"
            }
            public void onCancelled(WilddogError error) {
                if (error != null) {
                    System.out.println(error.getCode());
                }
            }

        });
        return result;
    }

}
