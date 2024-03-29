package yousef.joe.containersmaps;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Locale;

import yousef.joe.containersmaps.model.Container;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private Context context;

    public CustomInfoWindowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = LayoutInflater.from(context).inflate(R.layout.marker_info_view,
                null);

        // Find views
        TextView containerIdTextView = view.findViewById(R.id.tv_container_id);
        TextView sensorIdTextView = view.findViewById(R.id.tv_sensor_id);
        TextView dateTextView = view.findViewById(R.id.tv_date);
        TextView tempTextView = view.findViewById(R.id.tv_temp);
        TextView rateTextView = view.findViewById(R.id.tv_rate);


        Container container =  new Gson().fromJson(marker.getTitle(),Container.class);

        String temp = container.getContainerTemp() + "%";

        // Set values
        containerIdTextView.setText(String.valueOf(container.getContainerId()));
        sensorIdTextView.setText(String.valueOf(container.getSensorId()));
        dateTextView.setText(container.getDate());
        tempTextView.setText(temp);
        rateTextView.setText(String.valueOf(container.getOccupancyRate()));

        return view;
    }


}
