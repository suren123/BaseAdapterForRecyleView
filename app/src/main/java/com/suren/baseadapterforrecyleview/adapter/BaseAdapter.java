package com.suren.baseadapterforrecyleview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by OA on 2015/6/18.
 */
public abstract class BaseAdapter<T, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    public List<T> items;

    public OnItemClickLitener mOnItemClickLitener;
    public OnItemLongClickLitener mOnItemLongClickLitener;

    public BaseAdapter(List<T> items){
        this.items = items;
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public void setOnItemLongClickLitener(OnItemLongClickLitener mOnItemLongClickLitener) {
        this.mOnItemLongClickLitener = mOnItemLongClickLitener;
    }

    @Override
    public V onCreateViewHolder(ViewGroup viewGroup, int i) {
        final V viewHolder = initViewHolder(viewGroup, i);

        //itemClickCallback
        if (mOnItemClickLitener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = viewHolder.getPosition();
                    mOnItemClickLitener.onItemClick(viewHolder.itemView, pos);
                }
            });
        }
        if (mOnItemLongClickLitener != null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = viewHolder.getPosition();
                    mOnItemLongClickLitener.onItemLongClick(viewHolder.itemView, pos);
                    return false;
                }
            });
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(V v, final int i) {
        convert(v, items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void removeItem(int position){
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void addItem(T item, int position){
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void addItem(T item){
        items.add(item);
        notifyItemInserted(items.size());
    }

    public void moveItem(){
        Collections.swap(items, 3, 0);
        notifyItemMoved(0, 3);
    }

    public void refreshItems(List<T> newData){
        items.clear();
        items.addAll(newData);
        notifyDataSetChanged();
    }

    public abstract V initViewHolder(ViewGroup viewGroup, int i);

    public abstract void convert(V viewHolder, T item);

    public interface OnItemClickLitener{
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickLitener{
        void onItemLongClick(View view, int position);
    }
}
