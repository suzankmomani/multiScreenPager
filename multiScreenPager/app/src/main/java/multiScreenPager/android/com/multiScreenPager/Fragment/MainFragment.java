package multiScreenPager.android.com.multiScreenPager.Fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Content;
import multiScreenPager.android.com.multiScreenPager.R;

public class MainFragment extends Fragment {

    private Content mContent;
    private static final String CONTENT = "CONTENT";

    public MainFragment() {

    }

    public static MainFragment newInstance(Content content) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putSerializable(CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContent = (Content) getArguments().getSerializable(CONTENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        pagerAdapter adapter = new pagerAdapter(getActivity().getSupportFragmentManager(), getResources().getStringArray(R.array.tabs), mContent);
        viewPager.setAdapter(adapter);
    }


    public static class pagerAdapter extends FragmentStatePagerAdapter {
        private Content mContent;
        private String[] mTitles = new String[7];

        public pagerAdapter(android.support.v4.app.FragmentManager fm, String[] mTitles, Content content) {
            super(fm);
            this.mContent = content;
            this.mTitles = mTitles;
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;

            switch (i) {
                case 4:
                    fragment=TacCaseFragment.newInstance(mContent);
                    break;
                default:
                    fragment=new EmptyFragment();
            }
            return fragment;
        }


        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }


}
