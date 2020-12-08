package de.hsos.minesweeper;

import de.hsos.minesweeper.logik.Game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;

    private Game game;
    private int breite = 800, hoehe = 800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }
  /*  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bitmap = Bitmap.createBitmap(this.breite, this.hoehe, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(this);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();
        this.setContentView(imageView);
        this.paint.setColor(Color.BLACK);
        drawBall(100);
        for (int i = 0; i < 1000; i++) {
            drawBall(i);
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {

            }

        }
    }

    public void drawBall(int i) {
        this.canvas.drawCircle(i, i, 100, this.paint);
    }

    public void initialize() {
        this.bitmap = this.initBitmap();
        this.imageView = this.initImageview();
        this.canvas = new Canvas(this.bitmap);
        this.paint = new Paint();
    }

    private Bitmap initBitmap() {
        Display display = this.getWindowManager().getDefaultDisplay();
        Point ext = new Point();
        display.getSize(ext);

        return Bitmap.createBitmap(ext.x, ext.y, Bitmap.Config.ARGB_8888);
    }

    private ImageView initImageview() {
        ImageView imageView = new ImageView(this);
        imageView.setOnTouchListener((view, motionEvent)) ->{
            Log.d(tag, "touch-Event from view listener started");
            if (motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN) {
                this.drawFilledRect(motionEvent.getX(), motionEvent.getY());
            }
        }
        ;
    }*/
}