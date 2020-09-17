package br.com.local.appgooglemapsonclick;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Add a marker in etecia and move the camera
        LatLng etecia = new LatLng(-23.702497, -46.689288);
        //-23.702723,-46.6898242

        //Marcadores
        mMap.addMarker(new MarkerOptions()
                .position(etecia)
                .title("Etec Irmã Agostina")
                /*.icon(BitmapDescriptorFactory.defaultMarker(
                        //Definindo cores para os icones de posicionamento
                        BitmapDescriptorFactory.HUE_VIOLET
                ))*/
                //Icone costumizado
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.escola))

        );
        //Posicionamento da câmera
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(etecia, 15));

        //Evento de click no mapa - cria um marcador a cada click
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //Salvando a latitude e longitude
               double latitude, longitude;

               latitude = latLng.latitude;
               longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this,
                        "Click curto - Lat: " + latitude + "Lon: " + longitude,
                        Toast.LENGTH_SHORT).show();

                //Gerando marcador
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Clique curto!!!")
                        .snippet("Descrição do local")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.onibus_escolar))
                );
                //Posicionamento da câmera
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

            }
        });

        //Evento de click longo
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                //Salvando a latitude e longitude
                double latitute, longitude;

                latitute = latLng.latitude;
                longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this,
                        "Click Longo - Lat: " + latitute + "Lon: " + longitude,
                        Toast.LENGTH_SHORT).show();

                //Gerando marcador
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Clique longo!!!")
                        .snippet("Descrição do local")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.estudante))
                );
                //Posicionamento da câmera
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

            }
        });


    }
}