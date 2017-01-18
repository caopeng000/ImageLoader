package imageloader.androidimageloader;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = getListView();
        listView.setAdapter(new ItemAdapter());
    }

    class ItemAdapter extends BaseAdapter {

        private String[] mUrls = {

                // Light images
                "data:image/jpeg;base64,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",
                "http://a3.twimg.com/profile_images/740897825/AndroidCast-350_normal.png", "http://a3.twimg.com/profile_images/121630227/Droid_normal.jpg",
                "http://a1.twimg.com/profile_images/957149154/twitterhalf_normal.jpg", "http://a1.twimg.com/profile_images/97470808/icon_normal.png",
                "http://a3.twimg.com/profile_images/511790713/AG.png", "http://a3.twimg.com/profile_images/956404323/androinica-avatar_normal.png",
                "http://a1.twimg.com/profile_images/909231146/Android_Biz_Man_normal.png",
                "http://a3.twimg.com/profile_images/72774055/AndroidHomme-LOGO_normal.jpg",
                "http://a1.twimg.com/profile_images/349012784/android_logo_small_normal.jpg",
                "http://a1.twimg.com/profile_images/841338368/ea-twitter-icon.png",
                "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
                "http://a3.twimg.com/profile_images/77641093/AndroidPlanet_normal.png",
                "http://a1.twimg.com/profile_images/850960042/elandroidelibre-logo_300x300_normal.jpg",
                "http://a1.twimg.com/profile_images/655119538/andbook.png", "http://a3.twimg.com/profile_images/768060227/ap4u_normal.jpg",
                "http://a1.twimg.com/profile_images/74724754/android_logo_normal.png",
                "http://a3.twimg.com/profile_images/681537837/SmallAvatarx150_normal.png",
                "http://a1.twimg.com/profile_images/63737974/2008-11-06_1637_normal.png", "http://a3.twimg.com/profile_images/548410609/icon_8_73.png",
                "http://a1.twimg.com/profile_images/612232882/nexusoneavatar_normal.jpg",
                "http://a1.twimg.com/profile_images/213722080/Bugdroid-phone_normal.png",
                "http://a1.twimg.com/profile_images/645523828/OT_icon_090918_android_normal.png",
                "http://a3.twimg.com/profile_images/77641093/AndroidPlanet.png", "http://a1.twimg.com/profile_images/655119538/andbook_normal.png",
                "http://a3.twimg.com/profile_images/511790713/AG_normal.png", "http://a3.twimg.com/profile_images/956404323/androinica-avatar.png",
                "http://a1.twimg.com/profile_images/841338368/ea-twitter-icon_normal.png",
                "http://a1.twimg.com/profile_images/850960042/elandroidelibre-logo_300x300.jpg", "http://a3.twimg.com/profile_images/121630227/Droid.jpg",
                "http://a1.twimg.com/profile_images/909231146/Android_Biz_Man.png",
                "http://a3.twimg.com/profile_images/670625317/aam-logo-v3-twitter_normal.png", "http://a1.twimg.com/profile_images/97470808/icon.png",
                "http://a1.twimg.com/profile_images/74724754/android_logo.png", "http://a3.twimg.com/profile_images/548410609/icon_8_73_normal.png",
                "http://a1.twimg.com/profile_images/645523828/OT_icon_090918_android.png", "http://a1.twimg.com/profile_images/957149154/twitterhalf.jpg",
                "http://a1.twimg.com/profile_images/349012784/android_logo_small.jpg"};

        public ImageLoader imageLoader;

        public ItemAdapter() {
            imageLoader = ImageLoader.getInstance(MainActivity.this);
        }

        public int getCount() {
            return mUrls.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public class ViewHolder {
            public TextView text;
            public ImageView image;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            final ViewHolder holder;
            if (convertView == null) {
                view = getLayoutInflater().inflate(R.layout.item, null);
                holder = new ViewHolder();
                holder.text = (TextView) view.findViewById(R.id.text);
                holder.image = (ImageView) view.findViewById(R.id.image);
                view.setTag(holder);
            } else
                holder = (ViewHolder) view.getTag();

            holder.text.setText("Item " + position);
            DisplayImageOptions options = new DisplayImageOptions.Builder().resetViewBeforeLoading().cacheImageInMemory().showStubImageWhileLoading().build();
            imageLoader.displayImage(mUrls[position], holder.image, options, new ImageLoadingListener() {
                @Override
                public void onLoadStarted() {
                    holder.text.setText("...loading...");
                }

                @Override
                public void onLoadComplete() {
                    holder.text.setText("Item " + position);
                }
            });
            return view;
        }
    }
}
