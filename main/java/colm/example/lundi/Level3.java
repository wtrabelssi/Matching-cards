package colm.example.lundi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class Level3 extends AppCompatActivity {

    private boolean flipped= false;
    private ImageButton imageButton19,imageButton20,imageButton21,imageButton22,imageButton23,imageButton24,imageButton25,imageButton26,imageButton27,imageButton28,imageButton29,imageButton30,imageButton31,imageButton32,imageButton33,imageButton34,imageButton35,imageButton36,imageButton37,imageButton38;
    private ImageButton[] imageButtons =  {imageButton19,imageButton20,imageButton21,imageButton22,imageButton23,imageButton24,imageButton25,imageButton26,imageButton27,imageButton28,imageButton29,imageButton30,imageButton31,imageButton32,imageButton33,imageButton34,imageButton35,imageButton36,imageButton37,imageButton38};
    private int[] listimage = new int[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        MediaPlayer mediaPlayer1= MediaPlayer.create(this,R.raw.applause);
        MediaPlayer mediaPlayer2= MediaPlayer.create(this,R.raw.soundfail);

        imageButtons[0] = this.imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        imageButtons[1] = this.imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        imageButtons[2] = this.imageButton21 = (ImageButton) findViewById(R.id.imageButton21);
        imageButtons[3] = this.imageButton22 = (ImageButton) findViewById(R.id.imageButton22);
        imageButtons[4] = this.imageButton23 = (ImageButton) findViewById(R.id.imageButton23);
        imageButtons[5] = this.imageButton24 = (ImageButton) findViewById(R.id.imageButton24);
        imageButtons[6] = this.imageButton25 = (ImageButton) findViewById(R.id.imageButton25);
        imageButtons[7] = this.imageButton26 = (ImageButton) findViewById(R.id.imageButton26);
        imageButtons[8] = this.imageButton27 = (ImageButton) findViewById(R.id.imageButton27);
        imageButtons[9] = this.imageButton28 = (ImageButton) findViewById(R.id.imageButton28);
        imageButtons[10] = this.imageButton29 = (ImageButton) findViewById(R.id.imageButton29);
        imageButtons[11] = this.imageButton30 = (ImageButton) findViewById(R.id.imageButton30);
        imageButtons[12] = this.imageButton31 = (ImageButton) findViewById(R.id.imageButton31);
        imageButtons[13] = this.imageButton32 = (ImageButton) findViewById(R.id.imageButton32);
        imageButtons[14] = this.imageButton33 = (ImageButton) findViewById(R.id.imageButton33);
        imageButtons[15] = this.imageButton34 = (ImageButton) findViewById(R.id.imageButton34);
        imageButtons[16] = this.imageButton35 = (ImageButton) findViewById(R.id.imageButton35);
        imageButtons[17] = this.imageButton36 = (ImageButton) findViewById(R.id.imageButton36);
        imageButtons[18] = this.imageButton37 = (ImageButton) findViewById(R.id.imageButton37);
        imageButtons[19] = this.imageButton38 = (ImageButton) findViewById(R.id.imageButton38);


        int  imgback = R.drawable.img03;

        final int[] clicked = {0};
        final boolean[] twoTurned = {false};
        final int[] lastClicked = {-1};
        boolean[] isback = new boolean[20];


        listimage[0] = R.drawable.img31;
        listimage[1] = R.drawable.img32;
        listimage[2] = R.drawable.img33;
        listimage[3] = R.drawable.img34;
        listimage[4] = R.drawable.img35;
        listimage[5] = R.drawable.img36;
        listimage[6] = R.drawable.img37;
        listimage[7] = R.drawable.img38;
        listimage[8] = R.drawable.img39;
        listimage[9] = R.drawable.img40;
        listimage[10] = R.drawable.img31;
        listimage[11] = R.drawable.img32;
        listimage[12] = R.drawable.img33;
        listimage[13] = R.drawable.img34;
        listimage[14] = R.drawable.img35;
        listimage[15] = R.drawable.img36;
        listimage[16] = R.drawable.img37;
        listimage[17] = R.drawable.img38;
        listimage[18] = R.drawable.img39;
        listimage[19] = R.drawable.img40;

        Random rand = new Random();

        for (int i = 0; i < listimage.length; i++) {
            int randomIndexToSwap = rand.nextInt(listimage.length);
            int temp = listimage[randomIndexToSwap];
            listimage[randomIndexToSwap] = listimage[i];
            listimage[i] = temp;
        }


        for(int i =0 ; i<20;i++){
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