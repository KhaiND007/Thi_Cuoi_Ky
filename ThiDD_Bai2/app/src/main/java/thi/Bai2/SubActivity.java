    package thi.Bai2;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.TextView;

    public class SubActivity extends AppCompatActivity {
        TextView tv;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sub);

            tv = (TextView) findViewById(R.id.tv);

            Intent i = getIntent();
            String Name = i.getStringExtra("Name");
            tv.setText("Hello "+Name);
        }
    }