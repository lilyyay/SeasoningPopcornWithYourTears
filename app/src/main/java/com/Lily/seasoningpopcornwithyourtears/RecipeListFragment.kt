package com.Lily.seasoningpopcornwithyourtears

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.Lily.seasoningpopcornwithyourtears.databinding.FragmentRecipeListBinding
import com.Lily.seasoningpopcornwithyourtears.databinding.RecipeListContentBinding
import com.Lily.seasoningpopcornwithyourtears.feeling.Feeling
import com.Lily.seasoningpopcornwithyourtears.recipe.Recipe

class RecipeListFragment : Fragment() {

    companion object{
        public val ARG_RECIPE_ID: String = "recipe_id"
    }

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
        val parentFrag: FeelingDetailFragment = this@RecipeListFragment.getParentFragment() as FeelingDetailFragment

        // Leaving this not using view binding as it relies on if the view is visible the current
        // layout configuration (layout, layout-sw600dp)
        val itemDetailFragmentContainer: View? =
            view.findViewById(R.id.feeling_detail_nav_container)

        setupRecyclerView(recyclerView, parentFrag.item, itemDetailFragmentContainer)
        // TODO: Add itemDetailFragmentContainer for Tablets
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, feeling: Feeling.FeelingInstance?, itemDetailFragmentContainer: View?){
        if(feeling != null){
            recyclerView.adapter = SimpleItemRecyclerViewAdapter(Recipe.getRecipesByIds(feeling.recipeIds), itemDetailFragmentContainer)
        }else{
            recyclerView.adapter = SimpleItemRecyclerViewAdapter(Recipe.ITEMS, itemDetailFragmentContainer)
        }
    }

    class SimpleItemRecyclerViewAdapter(private val values: List<Recipe.RecipeInstance>,
                                        private val itemDetailFragmentContainer: View?):
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
            holder.idView.text = item.name

            with(holder.itemView) {
                tag = item
                setOnClickListener{ itemView ->
                    val item = itemView.tag as Recipe.RecipeInstance
                    val bundle = Bundle()
                    bundle.putString(RecipeListFragment.ARG_RECIPE_ID,
                        item.id
                    )
                    itemView.findNavController().navigate(R.id.show_recipe_detail, bundle)

                }
            }

            // TODO add click listeners
        }


    }
}