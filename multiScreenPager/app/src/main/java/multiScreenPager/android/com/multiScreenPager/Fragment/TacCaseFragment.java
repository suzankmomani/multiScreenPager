package multiScreenPager.android.com.multiScreenPager.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Content;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Issue;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Status;
import multiScreenPager.android.com.multiScreenPager.Mangers.ImageManager;
import multiScreenPager.android.com.multiScreenPager.R;

public class TacCaseFragment extends Fragment {
    private Content mContent;
    private static final String CONTENT ="CONTENT";

    public TacCaseFragment() {

    }

    public static TacCaseFragment newInstance(Content content) {
        TacCaseFragment fragment = new TacCaseFragment();
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

        View view = inflater.inflate(R.layout.fragment_tac_case, container, false);
        initializeView(view);
        return view;
    }

    private void initializeView(View view) {

        LinearLayout tableView = (LinearLayout) view.findViewById(R.id.parentViewCurrent);
        LinearLayout tableViewOlder = (LinearLayout) view.findViewById(R.id.parentViewOlder);

        for (Issue issue:
        mContent.getIssues()){


            View rowView =  LayoutInflater.from(tableView.getContext()).inflate(R.layout.issue_row_view, null);


            TextView titleTxt = (TextView) rowView.findViewById(R.id.titleTxt);
            TextView serialNoTxt = (TextView) rowView.findViewById(R.id.serialNoTxt);
            TextView modelNoTxt = (TextView) rowView.findViewById(R.id.modelNoTxt);
            TextView tacContractTxt = (TextView) rowView.findViewById(R.id.tacContactTxt);
            TextView expiresTxt = (TextView) rowView.findViewById(R.id.expiresTxt);
            TextView statusTxt = (TextView) rowView.findViewById(R.id.statusTxt);
            ImageView statusImg = (ImageView) rowView.findViewById(R.id.statusImg);
            ImageView issueImg = (ImageView) rowView.findViewById(R.id.issueImg);

            titleTxt.setText(issue.getIdAddress());
            serialNoTxt.setText(issue.getSerialNum());
            modelNoTxt.setText(issue.getModel().getName());
            tacContractTxt.setText(issue.getModel().getName());
            expiresTxt.setText(convertTime(issue.getModel().getExpiryDate()));
            statusTxt.setText(issue.getStatus().getStatus().toString());

            if (issue.getStatus().getStatus().equals(Status.IssueStatus.OPEN)) {
                statusImg.setColorFilter(ContextCompat.getColor(getActivity(), R.color.blueTextColor));
                tableView.addView(rowView);
            } else {
                statusImg.setColorFilter(ContextCompat.getColor(getActivity(), R.color.green_status));
                tableViewOlder.addView(rowView);
            }

            ImageManager.loadImgCircle(getActivity(),
                    "https://upload.wikimedia.org/wikipedia/commons/e/e8/Pico-HortaFaial_%28crop%29.jpg"
                    ,issueImg);



        }
    }
    public String convertTime(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy MM dd");
        return format.format(date);
    }
}
