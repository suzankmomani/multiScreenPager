package multiScreenPager.android.com.multiScreenPager.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import multiScreenPager.android.com.multiScreenPager.Adapter.MenuListAdapter;
import multiScreenPager.android.com.multiScreenPager.Mangers.ImageManager;
import multiScreenPager.android.com.multiScreenPager.R;

public class MasterFragment extends Fragment {


    private OnListMainInteractionListener mListener;

    public MasterFragment() {
    }

    public static MasterFragment newInstance() {
        MasterFragment fragment = new MasterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListener = (OnListMainInteractionListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master, container);

        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {

        ImageView userImg = (ImageView) view.findViewById(R.id.userImg);

        ImageManager.loadImgCircle(getActivity(),
                "https://upload.wikimedia.org/wikipedia/commons/e/e8/Pico-HortaFaial_%28crop%29.jpg"
                ,userImg);


        ListView list = (ListView) view.findViewById(R.id.list);
        list.setAdapter(new MenuListAdapter(R.layout.row_menu_action_item, getActivity(), MenuActionItem.values()));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                menuItemClicked(i);
            }
        });

        ImageView openSliderImg = (ImageView) view.findViewById(R.id.openSliderImg);
        openSliderImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeSliderStateClicked();
            }
        });
    }

    public void changeSliderStateClicked() {
        if (mListener != null) {
            mListener.openCloseSlider();
        }
    }
    public void menuItemClicked(int position) {
        if (mListener != null) {
            mListener.onFragmentInteraction(position);
        }
    }

    public interface OnListMainInteractionListener {
        void onFragmentInteraction(int position);
        void openCloseSlider();
    }

    public enum MenuActionItem {
        ITEM1,
        ITEM2
    }
}
