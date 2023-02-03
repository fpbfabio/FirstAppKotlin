package br.com.impacta.firstappkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class ProfileInfoFragment(private val profile: Profile) : Fragment() {

    private val profilePhotosFragment: ProfilePhotosFragment = ProfilePhotosFragment(profile)
    private val profileCuriosityFragment: ProfileCuriosityFragment =
        ProfileCuriosityFragment(profile)
    private val coverImageView: ImageView by lazy { requireView().findViewById(R.id.profile_info_cover_image_view) }
    private val nameTextView: TextView by lazy { requireView().findViewById(R.id.profile_info_name_text_view) }
    private val ageTextView: TextView by lazy { requireView().findViewById(R.id.profile_info_age_text_view) }
    private val locationTextView: TextView by lazy { requireView().findViewById(R.id.profile_info_location_text_view) }
    private val showPhotosTrigger: View by lazy { requireView().findViewById(R.id.profile_info_show_photos_view) }
    private val showCuriositiesTrigger: View by lazy { requireView().findViewById(R.id.profile_info_show_curiosities_view) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(profile.coverImage.imageURL).into(coverImageView)
        parentFragmentManager.beginTransaction()
            .add(R.id.profile_bottom_fragment, profilePhotosFragment)
            .hide(profilePhotosFragment)
            .add(R.id.profile_bottom_fragment, profileCuriosityFragment)
            .hide(profileCuriosityFragment)
            .commit()
        nameTextView.text = profile.name
        ageTextView.text = profile.age.toString()
        locationTextView.text = profile.location
        showPhotosTrigger.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .hide(profileCuriosityFragment)
                .show(profilePhotosFragment)
                .commit()
        }
        showCuriositiesTrigger.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .hide(profilePhotosFragment)
                .show(profileCuriosityFragment)
                .commit()
        }
    }
}