package br.com.impacta.firstappkotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class ProfileInfoFragment(private val profile: Profile) : Fragment() {

    private val coverImageView: ImageView by lazy { requireView().findViewById(R.id.image_view_profile_cover) }
    private val nameTextView: TextView by lazy { requireView().findViewById(R.id.text_view_profile_name) }
    private val ageTextView: TextView by lazy { requireView().findViewById(R.id.text_view_profile_age) }
    private val locationTextView: TextView by lazy { requireView().findViewById(R.id.text_view_profile_location) }
    private val logoutCardView: View by lazy { requireView().findViewById(R.id.card_view_profile_logout) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(profile.coverImage.imageURL).into(coverImageView)
        initTextViews()
        initCardViews()
    }

    private fun initTextViews() {
        nameTextView.text = profile.name
        ageTextView.text = profile.age.toString()
        locationTextView.text = profile.location
    }

    private fun initCardViews() {
        logoutCardView.setOnClickListener {
            isSigned = false
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

}