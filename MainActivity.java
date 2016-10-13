import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView ivPicasso,ivRamdon;
    Handler handler;
    String[] urlImg = {
            "http://www.paisajesbonitos.org/wp-content/uploads/2015/11/paisajes-bonitos-de-oto%C3%B1o-lago.jpg"
            ,"http://vignette3.wikia.nocookie.net/naruto/images/a/aa/Naruto_primera_parte_HD.png/revision/latest?cb=20140513215903&path-prefix=es"
            ,"http://otakudesho.com/wp-content/uploads/2016/04/Naruto-Shippuden.jpg"
            ,"http://ib1.huluim.com/show_key_art/1304?size=1600x600&region=US"
            ,"http://ib3.huluim.com/show_key_art/1603?size=1600x600&region=US"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPicasso = (ImageView) findViewById(R.id.imageView);
        ivRamdon = (ImageView) findViewById(R.id.imageView2);
        Picasso.with(this)
                .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
                .into(ivPicasso);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            private long time = 0;
            @Override
            public void run() {
                time+=5000;
                Toast.makeText(getApplicationContext(),"ejecutando..."+time,Toast.LENGTH_SHORT).show();
                Random  random = new Random();
                int itemRandom = random.nextInt(urlImg.length-0)+0;
                Picasso.with(getApplicationContext())
                        .load(urlImg[itemRandom])
                        .error(R.color.colorAccent)
                        .into(ivRamdon);
                handler.postDelayed(this, 10000);
            }
        },10000);
    }

    @Override
    public void onStop(){
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }
}
