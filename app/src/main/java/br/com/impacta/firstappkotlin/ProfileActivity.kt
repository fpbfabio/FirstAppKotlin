package br.com.impacta.firstappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.random.Random

class ProfileActivity : AppCompatActivity() {

    private val profile = Profile(
        coverImage = Photo(
            "https://picsum.photos/600/300",
            "Cover Image"
        ),
        name = "Fabio Benigno",
        age = 28,
        location = "Manaus, AM",
        photos = List (100) { index ->
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

    private val fragment: ProfileInfoFragment = ProfileInfoFragment(profile)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportFragmentManager.beginTransaction().replace(R.id.profile_top_fragment, fragment)
            .commit()
    }
}