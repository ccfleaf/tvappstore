package com.wanchaopai.tvappstore;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wanchaopai.tvappstore.bean.AppBean;

import java.util.ArrayList;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private AppBean.AppItem mItem;

    RecyclerView mRecyclerView;
    HomeAdapter homeAdapter;
    private GridLayoutManager manager;
    private ArrayList<String> mList = new ArrayList<>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = AppBean.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        // Show the dummy content as text in a TextView.

//        String ttt = "e-learing for vpn child,lavaza，e-learing for vpn child,";
//        for (int i = 0; i < 40; i++) {
//            mList.add(ttt.substring(i)+String.valueOf(i));
//        }
        mList.add(mItem.content);
        mRecyclerView = view.findViewById (R.id.rv_content);
        homeAdapter = new HomeAdapter (view.getContext(),mList);
        mRecyclerView.setItemAnimator (new DefaultItemAnimator());
        mRecyclerView.setAdapter (homeAdapter);
        mRecyclerView.setLayoutManager (new GridLayoutManager (view.getContext(), 5));


        return view;
    }

    public class HomeAdapter extends RecyclerView.Adapter <HomeAdapter.MyHolder>{
        Context context;
        private ArrayList<String> list;

        public HomeAdapter(Context context, ArrayList<String> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_view_layout,parent,false);
            MyHolder holder = new MyHolder (view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            String item = list.get (position);
            holder.tvInfo.setText (item);

        }

        @Override
        public int getItemCount() {
            return list.size ();
        }

        class MyHolder extends RecyclerView.ViewHolder {

            TextView tvInfo;
            public MyHolder(View itemView) {
                super (itemView);
                tvInfo = itemView.findViewById (R.id.tv_item);

            }
        }
    }

}
