package com.berfinilik.haritakullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berfinilik.haritakullanimi.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(),OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mMap:GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment=supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.buttonKonumaGit.setOnClickListener {
            //41.0370175,28.974792 TAKSİM
            val konum=LatLng(41.0370175,28.974792)
            mMap.addMarker(MarkerOptions().position(konum).title("Taksim"))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum,15f))
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE

        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap=googleMap
        //39.7655118,30.4958871 ESKİŞEHİRİN ENLEM VE BOYLAMI
        val konum=LatLng(39.7655118,30.4958871)
        mMap.addMarker(MarkerOptions().position(konum).title("Eskişehir"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(konum))

    }
}