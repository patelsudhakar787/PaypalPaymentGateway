package empdetails.employee.com.vedioplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by sudhakar on 10/5/17.
 */

public class VedioFragment extends Fragment {

    VideoView vv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View itemview=inflater.inflate(R.layout.layout,container,false);

        vv=(VideoView)itemview.findViewById(R.id.your_video_view);

        String url="https://www.youtube.com/watch?v=0uhsfvKEysM";
        MediaController mediaController=new MediaController(getContext());
        vv.setVideoPath(url);
        mediaController.setMediaPlayer(vv);
        vv.setMediaController(mediaController);

        vv.requestFocus();
        vv.start();


        vv.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.d("video", "setOnErrorListener ");
                return true;
            }
        });



        return itemview;
    }
}
