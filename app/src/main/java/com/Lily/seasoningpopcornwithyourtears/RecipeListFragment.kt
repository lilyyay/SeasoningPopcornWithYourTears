package com.Lily.seasoningpopcornwithyourtears

import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.Lily.seasoningpopcornwithyourtears.databinding.FragmentRecipeListBinding
import com.Lily.seasoningpopcornwithyourtears.databinding.RecipeListContentBinding
import com.Lily.seasoningpopcornwithyourtears.feeling.Feeling

class RecipeListFragment : Fragment() {

    private var _binding: FragmentRecipeListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("RecipeListFragement", "Vettom: onViewCreated called");
        _binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("RecipeListFragement", "Vettom: onViewCreated called");

        val recyclerView: RecyclerView = binding.recipeList

         setupRecyclerView(recyclerView)
        // TODO: Add itemDetailFragmentContainer for Tablets
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView(recyclerView: RecyclerView){
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(Feeling.ITEMS)
    }

    class SimpleItemRecyclerViewAdapter(private val values: List<Feeling.FeelingInstance>):
            RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>(){

        inner class ViewHolder(binding: RecipeListContentBinding): RecyclerView.ViewHolder(binding.root){
            val idView: TextView = binding.recipeName
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolder {

            val binding = RecipeListContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return values.size
        }

        override fun onBindViewHolder(
            holder: SimpleItemRecyclerViewAdapter.ViewHolder,
            position: Int
        ) {
            val  item = values[position]
            holder.idView.text = item.id

            // TODO add click listeners
        }


    }
}