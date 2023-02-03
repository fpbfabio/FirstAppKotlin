package br.com.impacta.firstappkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfilePhotosFragment(private val profile: Profile) : Fragment() {
    private val recyclerView: RecyclerView by lazy { requireView().findViewById(R.id.recycler_view_photo) }
    private val floatingActionButton : FloatingActionButton by lazy { requireView().findViewById(R.id.floating_action_button_photos) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager =
            GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
        recyclerView.adapter = PhotoAdapter(profile.photos)
        floatingActionButton.setOnClickListener {
            profile.photos.add(0, Photo(
                "https://picsum.photos/${(200..300).random()}",
                "New Image"
            ))
            recyclerView.adapter?.notifyItemInserted(0)
            recyclerView.scrollToPosition(0)
        }
    }
}