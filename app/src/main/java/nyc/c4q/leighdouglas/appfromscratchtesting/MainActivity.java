package nyc.c4q.leighdouglas.appfromscratchtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import nyc.c4q.leighdouglas.appfromscratchtesting.backend.ContactInfo;
import nyc.c4q.leighdouglas.appfromscratchtesting.backend.GetJsonObject;
import nyc.c4q.leighdouglas.appfromscratchtesting.backend.Listener;
import nyc.c4q.leighdouglas.appfromscratchtesting.recyclerview.ContactAdapter;

public class MainActivity extends AppCompatActivity implements Listener {
    private RecyclerView rv;
    private ContactAdapter contactAdapter;
    private static String URL = "http://api.androidhive.info/contacts/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        contactAdapter = new ContactAdapter();
        rv.setAdapter(contactAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new GetJsonObject(URL, this).execute();
    }

    @Override
    public void updateList(ArrayList<ContactInfo> list) {
        contactAdapter.setList(list);
    }
}
