package com.Lily.seasoningpopcornwithyourtears

import android.content.ClipData
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Lily.seasoningpopcornwithyourtears.feeling.Feeling
import com.Lily.seasoningpopcornwithyourtears.databinding.FragmentFeelingDetailBinding
import com.Lily.seasoningpopcornwithyourtears.databinding.FragmentRecipeListBinding

/**
 * A fragment representing a single Feeling detail screen.
 * This fragment is either contained in a [FeelingListFragment]
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
class FeelingDetailFragment : Fragment() {

    /**
     * The feeling content this fragment is presenting.
     */
    private var item: Feeling.FeelingInstance? = null

    private var toolbarLayout: CollapsingToolbarLayout? = null

    private var _binding: FragmentFeelingDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val dragListener = View.OnDragListener { v, event ->
        if (event.action == DragEvent.ACTION_DROP) {
            val clipDataItem: ClipData.Item = event.clipData.getItemAt(0)
            val dragData = clipDataItem.text
            item = Feeling.ITEM_MAP[dragData]
            updateContent()
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FeelingDetailFragment", "Vettom: onCreate called");

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the feeling content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = Feeling.ITEM_MAP[it.getString(ARG_ITEM_ID)]
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFeelingDetailBinding.inflate(inflater, container, false)

        val rootView = binding.root

        toolbarLayout = binding.toolbarLayout

        updateContent()
        rootView.setOnDragListener(dragListener)

        return rootView
    }

    private fun updateContent() {
        toolbarLayout?.title = item?.content
        // TODO Set Real Recipe List
        Log.d("FeelingDetailFragment", "Vettom: updateContent called");

    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}