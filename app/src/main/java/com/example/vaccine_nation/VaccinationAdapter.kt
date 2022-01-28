package com.example.vaccine_nation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class HeroAdapter(var dataSet: List<Vaccination>) :
    RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewCountry: TextView
        val textViewTimeline : TextView
        val textViewDesc : TextView
        val layout : ConstraintLayout

        init {
            textViewCountry = view.findViewById(R.id.)
            textViewTimeline = view.findViewById(R.id.)
            textViewDesc = view.findViewById(R.id.)
            layout = view.findViewById(R.id.layout_vaccineItem)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_vaccination, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val vaccination = dataSet[position]
        viewHolder.textViewRanking.text = hero.ranking.toString()
        viewHolder.textViewName.text = hero.name
        viewHolder.textViewDesc.text = hero.description
        viewHolder.layout.setOnClickListener{
            val context = viewHolder.layout.context
            val heroDetailIntent = Intent(context, VaccinationDetailActivity::class.java).apply {
                putExtra(VaccinationDetailActivity.EXTRA_HERO, hero)
            }
            context.startActivity(heroDetailIntent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}