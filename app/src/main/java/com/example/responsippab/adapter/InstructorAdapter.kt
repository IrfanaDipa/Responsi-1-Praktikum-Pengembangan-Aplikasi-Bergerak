package com.example.responsippab.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.responsippab.R
import com.example.responsippab.dataclass.InstructorProfile
import com.example.responsippab.ui.dashboard.DetailInstructorActivity

class InstructorAdapter(
    private val dataInstructor: ArrayList<InstructorProfile>
) : RecyclerView.Adapter<InstructorAdapter.ViewHolderMode>() {
    var onItemClicked : ((InstructorProfile) -> Unit)? = null

    class ViewHolderMode(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val instructorPhoto: ImageView = itemView.findViewById(R.id.grid_instructor_photo)
        val instructorName: TextView = itemView.findViewById(R.id.grid_instructor_name)
        val instructorDetail: TextView = itemView.findViewById(R.id.grid_instructor_detail)
        val instructorButton: Button = itemView.findViewById(R.id.grid_button_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMode {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_instructor_card, parent, false)
        return ViewHolderMode(view)
    }

    override fun getItemCount(): Int { return dataInstructor.size }

    override fun onBindViewHolder(holder: ViewHolderMode, position: Int) {
        val currentInstructor = dataInstructor[position]
        holder.instructorPhoto.setImageResource(currentInstructor.instructorPhoto)
        holder.instructorName.text = currentInstructor.instructorName
        holder.instructorDetail.text = currentInstructor.instructorDetail
        holder.instructorButton.setOnClickListener {
            val dataContext = holder.itemView.context
            val intent = Intent(dataContext, DetailInstructorActivity::class.java).apply {
                putExtra("image", currentInstructor.instructorPhoto)
                putExtra("name", currentInstructor.instructorName)
                putExtra("detail", currentInstructor.instructorDetail)
            }
            dataContext.startActivity(intent)
        }
    }
}