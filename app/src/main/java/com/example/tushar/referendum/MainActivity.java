package com.example.tushar.referendum;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        render();
        File file = new File("/storage/TusharMann.pdf");
        PDFView pdfView=(PDFView)findViewById(R.id.pdfView);
        pdfView.fromFile(file)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .load();





    }


    private void render(){
        try {
            image = (ImageView) findViewById(R.id.image);
            int Req_Wid = image.getWidth();
            int Req_Hei = image.getHeight();

            Bitmap bitmap = Bitmap.createBitmap(Req_Wid, Req_Hei, Bitmap.Config.ARGB_4444);
            File file = new File("/OConnor--Spaths FEX.pdf");

//            PdfRenderer renderer = new PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));
//            Matrix m = image.getImageMatrix();
//            Rect rect = new Rect(0, 0, Req_Wid, Req_Hei);
//            renderer.openPage(1).render(bitmap, rect, m, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
//            image.setImageMatrix(m);
//            image.setImageBitmap(bitmap);
//            image.invalidate();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
