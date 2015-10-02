package dcf.matcom.playalists;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        FrameLayout f1 = (FrameLayout) findViewById(R.id.frame1);
        //
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout l1 = new LinearLayout(this);
        l1.setLayoutParams(lp);
        l1.setOrientation(LinearLayout.HORIZONTAL);
        //
        TextView tv = new TextView(this);
        tv.setText("My manual textview");
        TextView tva = new TextView(this);
        tva.setText("My textview 2");
        //tva.setTextAppearance(this, R.style.fontForNotificationLandingPage);
        tv.setBackgroundColor(getResources().getColor(R.color.yellow));
        tva.setBackgroundColor(getResources().getColor(R.color.olive));
        tva.setTextColor(getResources().getColor(R.color.white));
        //tv.setLayoutParams(lp);
        l1.addView(tv);
        l1.addView(tva);
        f1.addView(l1);
        //
        //LayoutParams paramsExample = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1.0f);
        //
        // Add a fragment in code
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment f2 = new Frag2();
        ft.replace(R.id.frame2,f2);
        ft.commit();
        //
        List<String > data = new ArrayList<>();
        data.add("OGara");
        data.add("OBrian");
        data.add("Sexton");
         //
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recList);
        RecycAdapter adapter = new RecycAdapter(this, data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
