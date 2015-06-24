# BaseAdapterForRecyleView
A Simple Base Adapter for RecyleView on Android

------

## Usage
``` java
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
```

## In Activity 
``` java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        rv_items.setHasFixedSize(true);
        rv_items.setLayoutManager(new LinearLayoutManager(this));

        ListDividerView listDividerView = new ListDividerView(this, ListDividerView.VERTICAL_LIST);
        rv_items.addItemDecoration(listDividerView);

        mAdapter = new StringAdapter(initData());

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.addItem("test", 0);
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.removeItem(0);
            }
        });

        mAdapter.setOnItemLongClickLitener(new BaseAdapter.OnItemLongClickLitener() {
            @Override
            public void onItemLongClick(View view, int position) {
                mAdapter.removeItem(position);
            }
        });

        rv_items.setAdapter(mAdapter);
    }
```