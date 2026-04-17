package com.example.lab7.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab7.R;
import com.example.lab7.adapter.StarAdapter;
import com.example.lab7.service.StarService;

/**
 * Activité qui affiche la liste des personnages Hero 108 - Personnalisée par Mouad
 */
public class ListActivity extends AppCompatActivity {

    private StarAdapter adapter_mouad;
    private RecyclerView recyclerView_mouad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Set up the Toolbar
        Toolbar toolbar_mouad = findViewById(R.id.toolbar_mouad);
        if (toolbar_mouad != null) {
            setSupportActionBar(toolbar_mouad);
        }

        // Initialisation du RecyclerView avec IDs personnalisés
        recyclerView_mouad = findViewById(R.id.recycle_view_mouad);
        adapter_mouad = new StarAdapter(this, StarService.getInstance().findAll());

        recyclerView_mouad.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_mouad.setAdapter(adapter_mouad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu_mouad) {
        getMenuInflater().inflate(R.menu.menu, menu_mouad);
        MenuItem item_search_mouad = menu_mouad.findItem(R.id.app_bar_search);
        if (item_search_mouad == null) return true;

        android.view.View action_view_mouad = item_search_mouad.getActionView();
        if (!(action_view_mouad instanceof SearchView)) return true;
        SearchView search_view_mouad = (SearchView) action_view_mouad;

        search_view_mouad.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String new_text_mouad) {
                if (adapter_mouad != null) {
                    adapter_mouad.getFilter().filter(new_text_mouad);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item_mouad) {
        if (item_mouad.getItemId() == R.id.share) {
            String message_mouad = "Regardez ces personnages de Hero 108 ! App réalisé par Mouad.";
            ShareCompat.IntentBuilder.from(this)
                    .setType("text/plain")
                    .setChooserTitle("Partager Hero 108")
                    .setText(message_mouad)
                    .startChooser();
        }
        return super.onOptionsItemSelected(item_mouad);
    }
}
