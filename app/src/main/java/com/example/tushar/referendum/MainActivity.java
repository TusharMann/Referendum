package com.example.tushar.referendum;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        render();

    }

    private void render(){
        try {
            image = (ImageView) findViewById(R.id.image);
            int Req_Wid = image.getWidth();
            int Req_Hei = image.getHeight();

            Bitmap bitmap = Bitmap.createBitmap(Req_Wid, Req_Hei, Bitmap.Config.ARGB_4444);
            File file = new File("/OConnor--Spaths FEX.pdf");

            PdfRenderer renderer = new PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));
            Matrix m = image.getImageMatrix();
            Rect rect = new Rect(0, 0, Req_Wid, Req_Hei);
            renderer.openPage(1).render(bitmap, rect, m, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
            image.setImageMatrix(m);
            image.setImageBitmap(bitmap);
            image.invalidate();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
