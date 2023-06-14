package com.example.laba6serega;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

import model.Sight;

public class MapActivity extends AppCompatActivity {

    private MapView mapview;
    Sight sight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map);

        mapview = (MapView)findViewById(R.id.mapview);

        Bundle extras = getIntent().getExtras();
        sight = new Sight(new Point(extras.getDouble("sight_x"), extras.getDouble("sight_y")),
                extras.getString("sight_name"), extras.getString("sight_text"), "", extras.getString("sight_times"));

        mapview.getMap().move(new CameraPosition(sight.getPoint(), 15.f,0,0));
        mapview.getMap().getMapObjects().addPlacemark(sight.getPoint());
        updateTexts();
    }

    @Override
    protected void onStop() {
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapview.onStart();
    }

    private void updateTexts()
    {
        ((TextView)findViewById(R.id.sightText)).setText(sight.getName()+"\n\n"+sight.getDescription() + "\n\n" + (sight.getDates().isEmpty()?"":("Время работы: "+ sight.getDates())));
    }
}