package br.com.impacta.firstappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    private val profile = Profile(
        coverImage = Photo(
            "https://picsum.photos/600/300",
            "Cover Image"
        ),
        name = "Fabio Benigno",
        age = 28,
        location = "Manaus, AM",
        photos = MutableList (100) { index ->
            Photo(
                "https://picsum.photos/${(200..300).random()}",
                "Image ${index + 1}"
            )
        },
        curiosities = List (100) { index ->
            Curiosity(
                "Curiosity ${index + 1}",
                "Sample description"
            )
        }
    )

    private val profileInfoFragment: ProfileInfoFragment = ProfileInfoFragment(profile)
    private val profilePhotosFragment: ProfilePhotosFragment = ProfilePhotosFragment(profile)
    private val profileCuriosityFragment: ProfileCuriosityFragment = ProfileCuriosityFragment(profile)
    private val bottomNavigationMenuView : BottomNavigationView by lazy { findViewById(R.id.bottom_navigation_view_profile) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportFragmentManager.beginTransaction().replace(R.id.profile_top_fragment, profileInfoFragment)
            .commit()
        initBottomFragment()
        bottomNavigationMenuView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item_show_photo -> navigateToFragment(profilePhotosFragment)
                R.id.menu_item_show_curiosities -> navigateToFragment(profileCuriosityFragment)
                else -> false
            }
        }
        navigateToFragment(profilePhotosFragment)
    }


    private fun initBottomFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.profile_bottom_fragment, profilePhotosFragment)
            .hide(profilePhotosFragment)
            .add(R.id.profile_bottom_fragment, profileCuriosityFragment)
            .hide(profileCuriosityFragment)
            .commit()
    }

    private fun navigateToFragment(fragment: Fragment) : Boolean {
        supportFragmentManager.beginTransaction()
            .hide(profileCuriosityFragment)
            .hide(profilePhotosFragment)
            .show(fragment)
            .commit()
        return true
    }
}