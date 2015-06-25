package com.suren.baseadapterforrecyleview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.suren.baseadapter.BaseAdapter;
import com.suren.baseadapterforrecyleview.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by OA on 2015/6/18.
 */
public class StringAdapter extends BaseAdapter<String, StringAdapter.ViewHolder> {

    public final static String TAG = StringAdapter.class.getSimpleName();

    public StringAdapter(List<String> mData) {
        super(mData);
    }

    @Override
    public ViewHolder initViewHolder(ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void convert(ViewHolder viewHolder, final String item) {
        viewHolder.tv_name.setText(item);
        viewHolder.tv_description.setText(item);

        final int position = viewHolder.getPosition();
        viewHolder.iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, item + "position: " + items.indexOf(item));
            }
        });

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @InjectView(R.id.iv_head)
        ImageView iv_head;
        @InjectView(R.id.tv_name)
        TextView tv_name;
        @InjectView(R.id.tv_description)
        TextView tv_description;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
