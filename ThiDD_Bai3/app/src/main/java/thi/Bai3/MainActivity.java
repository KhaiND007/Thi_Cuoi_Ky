package thi.Bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ListView ListView;
    ArrayList<String> ListData;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        ListView = (ListView) findViewById(R.id.lv);

        ListData = new ArrayList<>();
        ListData.add("Tri kỉ");
        ListData.add("Có chàng trai viết lên cây");
        ListData.add("Cưa là đổ");
        ListData.add("Mộng tàn hoa");
        ListData.add("Anh yêu vội thê");
        ListData.add("Lỡ yêu người đậm sâu");
        ListData.add("Sai người sai thời điểm");
        ListData.add("Chiếc khăn gió ấm");
        ListData.add("Mùa đông không lạnh");
        ListData.add("Yêu là cưới");

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ListData);
        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(ListData.get(i));
            }
        });
    }
}