package thi.Bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase GhiChu;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> ListData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GhiChu = openOrCreateDatabase("data/data/databases/Note.db", MODE_PRIVATE, null);
        String SQLTaoBang = "CREATE TABLE GHICHU(NoiDung text PRIMARY KEY," +
                " MucDo text);\n";
        GhiChu.execSQL(SQLTaoBang);

        String SQLxoabang = "DROP TABLE IF EXISTS GHICHU;\n";
        GhiChu.execSQL(SQLxoabang);

        String SQLtext1 = "INSERT INTO GHICHU VALUES('Thi Machine learning 17/6', '1');\n";
        GhiChu.execSQL(SQLtext1);
        String SQLtext2 = "INSERT INTO GHICHU VALUES('Thi mang khong day 18/6', '1');\n";
        GhiChu.execSQL(SQLtext2);

        listView = (ListView) findViewById(R.id.lv);
        ListData = new ArrayList<String>();
        Cursor cs = GhiChu.rawQuery("SELECT * FROM GHICHU",null);
        cs.moveToFirst();
        while (true)
        {
            if (cs.isAfterLast()==true) break;
            String nd = cs.getString(0);
            String md = cs.getString(1);
            // Nối lại, để đưa vào arraylist
            String dong = nd+ " --- "+ md ;
            // đưa vào arrayList
            ListData.add(dong);
            // Sang dòng (bản ghi tiếp)
            cs.moveToNext();
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListData);
        listView.setAdapter(adapter);
    }
}