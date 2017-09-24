package multiScreenPager.android.com.multiScreenPager.Mangers;

import android.content.Context;
import android.widget.ImageView;

import multiScreenPager.android.com.multiScreenPager.Utils.CircleTransform;

import com.squareup.picasso.Picasso;

public class ImageManager {


    public static void loadImgCircle(Context context, String url, ImageView imgView) {

        Picasso.with(context)
                .load(url)
                .transform(new CircleTransform())
                .into(imgView);

    }

}
