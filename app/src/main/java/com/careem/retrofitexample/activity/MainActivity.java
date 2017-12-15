package com.careem.retrofitexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.careem.retrofitexample.R;
import com.careem.retrofitexample.adapter.FlowerAdapter;
import com.careem.retrofitexample.app.PracticeApplication;
import com.careem.retrofitexample.model.Flower;
import com.careem.retrofitexample.network.FlowerApiClient;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements MainContract.MainViewBehavior {

    @Inject
    FlowerApiClient flowerApiClient;

    private MainMainPresenter presenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing dagger
        ((PracticeApplication)getApplication()).getAppComponent().inject(MainActivity.this);

        // TODO: Need to Inject Dependency here
        presenter = new MainMainPresenter(this);
        //TODO: Need to use recycler view here
        listView = findViewById(R.id.listView);
        // Using our Presenter Rendering logic
        presenter.fetchFlowersDataAsync(flowerApiClient.getFlowersData());
        // Get Touch Events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // pass touch events to presenter
                presenter.handleItemTouchEvent(view,i);
            }
        });

    }

    /**
     *  Overridden methods from MainContract.MainViewBehavior
     *  setAdapter , show error message , show detail view of item
     */
    @Override
    public void setAdapter(List<Flower> flowerList) {
        listView.setAdapter(new FlowerAdapter(MainActivity.this,flowerList));
    }

    @Override
    public void showErrorMessage(Call<List<Flower>> call, Throwable t) {
        Toast.makeText(MainActivity.this,"Error Occurred",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDetailViewOfListItem(Flower flower) {
        Toast.makeText(MainActivity.this,"Flower Name is "+flower.getName(),Toast.LENGTH_SHORT).show();
    }
}
