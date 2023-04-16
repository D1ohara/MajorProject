package com.example.final_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FacultyStaffAdapter(
    private val staffMembers: List<FacultyStaffMember>,
    private var listener: OnItemClickListener
) : RecyclerView.Adapter<FacultyStaffAdapter.ViewHolder>() {

    private lateinit var context: Context


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val titleTextView: TextView = itemView.findViewById(R.id.positionTextView)
        private val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        private val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        init {
            itemView.setOnClickListener(this)
            emailTextView.setOnClickListener(this)
        }


        fun bind(staffMember: FacultyStaffMember) {
            nameTextView.text = staffMember.name
            titleTextView.text = staffMember.title
            phoneTextView.text = staffMember.phoneNumber
            emailTextView.text = staffMember.email
            imageView.setImageResource(staffMember.imageResId)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val staffMember = staffMembers[position]
                when (v?.id) {
                    R.id.emailTextView -> {
                        listener.onEmailClick(staffMember)
                    }
                    else -> {
                        listener.onItemClick(staffMember)
                    }
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(staffMember: FacultyStaffMember)
        fun onEmailClick(staffMember: FacultyStaffMember)
        fun onPhoneClick(phoneNumber: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item_faculty_staff, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val staffMember = staffMembers[position]
        holder.bind(staffMember)
    }

    override fun getItemCount(): Int {
        return staffMembers.size
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}
