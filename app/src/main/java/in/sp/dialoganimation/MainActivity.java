package in.sp.dialoganimation;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new GridViewAdapter(this));
    }
}
