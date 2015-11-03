package io.github.froger.instamaterial.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.github.froger.instamaterial.R;
import io.github.froger.instamaterial.ui.view.SendingProgressView;


/**
 * Created by Dan on 2015-11-02.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private List<Map<String, Object>> feedList;
    private int itemsCount;
    private boolean animateItems = false;
    private final Map<Integer, Integer> likesCount = new HashMap<>();

//    public void updateItems(boolean animated) {
//        itemsCount = feedList.size();
//        animateItems = animated;
//        fillLikesWithRandomValues();
//        notifyDataSetChanged();
//    }

//    private void fillLikesWithRandomValues() {
//        for (int i = 0; i < getItemCount(); i++) {
//            likesCount.put(i, new Random().nextInt(100));
//        }
//    }

//    private void updateLikesCounter(FeedAdapter.CellFeedViewHolder holder, boolean animated) {
//        int currentLikesCount = likesCount.get(holder.getPosition()) + 1;
//        String likesCountText = context.getResources().getQuantityString(
//                R.plurals.likes_count, currentLikesCount, currentLikesCount
//        );
//
//        if (animated) {
//            holder.tsLikesCounter.setText(likesCountText);
//        } else {
//            holder.tsLikesCounter.setCurrentText(likesCountText);
//        }
//        likesCount.put(holder.getPosition(), currentLikesCount);
//    }

    public MyAdapter(Context context, List<Map<String, Object>> feedList) {
        this.context = context;
        this.feedList = feedList;
        layoutInflater = layoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_feed, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);

        String imageUrl = feedList.get(position).get("picbig").toString();
        String userUrl = feedList.get(position).get("userpic").toString();

        imageLoader.displayImage(imageUrl, holder.ivFeedCenter);
        imageLoader.displayImage(userUrl, holder.ivUserProfile);

    }

    @Override
    public int getItemCount() {
        int count = 1;
        if (feedList.size() > 1) {
            count = feedList.size();
        }
        return count;
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.ivFeedCenter)
    ImageView ivFeedCenter;
    @InjectView(R.id.ivFeedBottom)
    ImageView ivFeedBottom;
    @InjectView(R.id.btnComments)
    ImageButton btnComments;
    @InjectView(R.id.btnLike)
    ImageButton btnLike;
    @InjectView(R.id.btnMore)
    ImageButton btnMore;
    @InjectView(R.id.vBgLike)
    View vBgLike;
    @InjectView(R.id.ivLike)
    ImageView ivLike;
    @InjectView(R.id.tsLikesCounter)
    TextSwitcher tsLikesCounter;
    @InjectView(R.id.ivUserProfile)
    ImageView ivUserProfile;
    @InjectView(R.id.vImageRoot)
    FrameLayout vImageRoot;

    public MyViewHolder(View view) {
        super(view);
        ButterKnife.inject(this, view);
        SendingProgressView vSendingProgress;
        View vProgressBg;
    }
}