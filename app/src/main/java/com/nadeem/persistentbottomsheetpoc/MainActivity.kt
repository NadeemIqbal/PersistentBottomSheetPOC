package com.nadeem.persistentbottomsheetpoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.nadeem.persistentbottomsheetpoc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize map
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Initialize bottom sheet
        val bottomSheetLayout = binding.root.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.bottomSheetBehavior)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        setupBottomSheet()
    }

    private fun setupBottomSheet() {
        // Set up bottom sheet behavior
        val displayMetrics = resources.displayMetrics
        val screenHeight = displayMetrics.heightPixels
        val peekHeight = (screenHeight * 0.25).toInt()
        val maxHeight = (screenHeight * 0.5).toInt()

        val bottomSheetLayout = binding.root.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.bottomSheetBehavior)
        val layoutParams = bottomSheetLayout.layoutParams
        layoutParams.height = maxHeight
        bottomSheetLayout.layoutParams = layoutParams

        bottomSheetBehavior.apply {
            state = BottomSheetBehavior.STATE_COLLAPSED
            isDraggable = true
            isHideable = false
            this.peekHeight = peekHeight

            // Add callback to handle state changes
            addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: android.view.View, newState: Int) {
                    // Handle state changes if needed
                }

                override fun onSlide(bottomSheet: android.view.View, slideOffset: Float) {
                    // Handle slide events if needed
                }
            })
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        // Configure map settings
        map.uiSettings.apply {
            isZoomControlsEnabled = true
            isMyLocationButtonEnabled = true
            isMapToolbarEnabled = true
        }
    }
}