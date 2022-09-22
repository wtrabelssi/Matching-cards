package colm.example.lundi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Level1 extends AppCompatActivity {

    private boolean flipped = false;
    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6;
    private ImageButton[] imageButtons = {imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6};

    private int[] listimage = new int[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        Timer timer = new Timer();
        MediaPlayer mediaPlayer1= MediaPlayer.create(this,R.raw.applause);
        MediaPlayer mediaPlayer2= MediaPlayer.create(this,R.raw.soundfail);



        imageButtons[0] = this.imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButtons[1] = this.imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButtons[2] = this.imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButtons[3] = this.imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButtons[4] = this.imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButtons[5] = this.imageButton6 = (ImageButton) findViewById(R.id.imageButton6);


        int imgback = R.drawable.img01;

        final int[] clicked = {0};
        final boolean[] twoTurned = {false};
        final boolean noteq=false;
        final int[] lastClicked = {-1};
        boolean[] isback = new boolean[6];
        listimage[0] = R.drawable.img11;
        listimage[1] = R.drawable.img12;
        listimage[2] = R.drawable.img13;
        listimage[3] = R.drawable.img11;
        listimage[4] = R.drawable.img12;
        listimage[5] = R.drawable.img13;


        Random rand = new Random();

        for (int i = 0; i < listimage.length; i++) {
            int randomIndexToSwap = rand.nextInt(listimage.length);
            int temp = listimage[randomIndexToSwap];
            listimage[randomIndexToSwap] = listimage[i];
            listimage[i] = temp;
        }

        for (int i = 0; i < 6; i++) {
            imageButtons[i].setImageResource(imgback);
            isback[i] = true;
            int finalI = i;
            imageButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isback[finalI] == true && !twoTurned[0]) {
                        imageButtons[finalI].setImageResource(listimage[finalI]);
                        isback[finalI] = false;
                        if (clicked[0] == 0) {
                            lastClicked[0] = finalI;
                        }
                        clicked[0]++;
                       /* if (clicked[0] == 1){
                            image
                        }*/
                    } else if (isback[finalI] == false) {
                        imageButtons[finalI].setImageResource(imgback);
                        isback[finalI] = true;
                        clicked[0]--;
                    }

                  if (clicked[0] == 2) {
                              twoTurned[0] = true;
                              if (listimage[finalI] == listimage[lastClicked[0]]) {
                                  mediaPlayer1.start();
                                  imageButtons[finalI].setClickable(false);
                                  imageButtons[lastClicked[0]].setClickable(false);
                                  twoTurned[0] = false;
                                  clicked[0] = 0;
                              } else if (listimage[finalI] != listimage[lastClicked[0]]) {
                                  mediaPlayer2.start();

                                 /* try {
                                      imageButtons[finalI].setImageResource(listimage[finalI]);
                                      Thread.sleep(2000);
                                    //  imageButtons[finalI].setImageResource(imgback);
                                      imageButtons[lastClicked[0]].setImageResource(imgback);
                                  } catch (InterruptedException e) {
                                      e.printStackTrace();
                                  }*/
                                  /*timer.schedule(new TimerTask() {
                                      @Override
                                      public void run() {
                                          imageButtons[finalI].setImageResource(imgback);
                                          imageButtons[lastClicked[0]].setImageResource(imgback);
                                      }

                                  }, 2000);*/
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
                  else if (clicked[0] == 0) {
                            twoTurned[0] = false;
                        }
                }

                ;


            });


        }
        ;


    }
}
