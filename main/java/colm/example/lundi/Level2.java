package colm.example.lundi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class Level2 extends AppCompatActivity {
    private boolean flipped= false;
    private ImageButton imageButton7,imageButton8,imageButton9,imageButton10,imageButton11,imageButton12,imageButton13,imageButton14,imageButton15,imageButton16,imageButton17,imageButton18;
    private ImageButton[] imageButtons =  {imageButton7,imageButton8,imageButton9,imageButton10,imageButton11,imageButton12,imageButton13,imageButton14,imageButton15,imageButton16,imageButton17,imageButton18};
    private int[] listimage = new int[12];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        MediaPlayer mediaPlayer1= MediaPlayer.create(this,R.raw.applause);
        MediaPlayer mediaPlayer2= MediaPlayer.create(this,R.raw.soundfail);

        imageButtons[0] = this.imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButtons[1] = this.imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButtons[2] = this.imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButtons[3] = this.imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButtons[4] = this.imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButtons[5] = this.imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButtons[6] = this.imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButtons[7] = this.imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButtons[8] = this.imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButtons[9] = this.imageButton16 = (ImageButton) findViewById(R.id.imageButton16);
        imageButtons[10] = this.imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButtons[11] = this.imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        int  imgback = R.drawable.img02;
        final int[] clicked = {0};
        final boolean[] twoTurned = {false};
        final int[] lastClicked = {-1};
        boolean[] isback = new boolean[12];
        listimage[0] = R.drawable.img21;
        listimage[1] = R.drawable.img22;
        listimage[2] = R.drawable.img23;
        listimage[3] = R.drawable.img24;
        listimage[4] = R.drawable.img25;
        listimage[5] = R.drawable.img26;
        listimage[6] = R.drawable.img21;
        listimage[7] = R.drawable.img22;
        listimage[8] = R.drawable.img23;
        listimage[9] = R.drawable.img24;
        listimage[10] = R.drawable.img25;
        listimage[11] = R.drawable.img26;


        Random rand = new Random();

        for (int i = 0; i < listimage.length; i++) {
            int randomIndexToSwap = rand.nextInt(listimage.length);
            int temp = listimage[randomIndexToSwap];
            listimage[randomIndexToSwap] = listimage[i];
            listimage[i] = temp;
        }

        for(int i =0 ; i<12;i++){
            imageButtons[i].setImageResource(imgback);
            isback[i]=true;
            int finalI = i;
            imageButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isback[finalI]==true && !twoTurned[0]){
                        imageButtons[finalI].setImageResource(listimage[finalI]);
                        isback[finalI]=false;
                        if (clicked[0] ==0){
                            lastClicked[0] = finalI;}
                        clicked[0]++;
                    }
                    else if (isback[finalI]==false) {
                        imageButtons[finalI].setImageResource(imgback);
                        isback[finalI]=true;
                        clicked[0]--;
                    }
                    if(clicked[0] ==2){
                        twoTurned[0] =true;
                        if (listimage[finalI]==listimage[lastClicked[0]]){

                            mediaPlayer1.start();
                            imageButtons[finalI].setClickable(false) ;
                            imageButtons[lastClicked[0]].setClickable(false) ;
                            twoTurned[0] = false;
                            clicked[0] = 0;
                        }
                        else if (listimage[finalI] != listimage[lastClicked[0]]) {

                            mediaPlayer2.start();
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    imageButtons[finalI].setImageResource(imgback);
                                    imageButtons[lastClicked[0]].setImageResource(imgback);
                                }}, 2000);
                            isback[finalI] = true;
                            isback[lastClicked[0]] = true;

                            twoTurned[0] = false;
                            clicked[0] = 0;

                        }
                    }
                    else if (clicked[0] ==0){
                        twoTurned[0] =false;
                    }
                }
            });







        };

    }
}