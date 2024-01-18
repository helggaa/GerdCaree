package com.dicoding.gerdcaree

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UserAdapter(private val mlist: ArrayList<User>, private val context: Context) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private val database: DatabaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gerdcaree-default-rtdb.firebaseio.com/")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mlist[position]

        holder.tvFullname.text = "Full name: " + item.fullname
        holder.tvUsername.text = "Username: " + item.username
        holder.tvEmail.text = "Email: " + item.email
        holder.tvPassword.text = "Password: " + item.password

        holder.bDelete.setOnClickListener {
            item.username?.let { username ->
                val position = mlist.indexOf(item)

                // Remove item from the local list
                mlist.removeAt(position)

                // Notify adapter about the removal
                notifyItemRemoved(position)

                // Remove item from the database
                database.child(username).removeValue()
                    .addOnSuccessListener {
                        Toast.makeText(context, "Data deleted successfully", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(context, "Failed to delete data", Toast.LENGTH_SHORT).show()

                        // Add the item back to the local list if deletion fails
                        mlist.add(position, item)
                        // Notify adapter about the addition
                        notifyItemInserted(position)
                    }
            }
        }


        holder.bEdit.setOnClickListener {
            val fullname = item.fullname
            val username = item.username
            val email = item.email
            val password = item.password

            val edit = Intent(context, EditDataUser::class.java)
            edit.putExtra("fullname", fullname)
            edit.putExtra("username", username)
            edit.putExtra("email", email)
            edit.putExtra("password", password)
            context.startActivity(edit)
        }
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFullname: TextView = itemView.findViewById(R.id.tvFullname)
        val tvUsername: TextView = itemView.findViewById(R.id.tvUsername)
        val tvEmail: TextView =  itemView.findViewById(R.id.tvEmail)
        val tvPassword: TextView = itemView.findViewById(R.id.tvPassword)
        val bDelete: Button = itemView.findViewById(R.id.bDelete)
        val bEdit: Button = itemView.findViewById(R.id.bEdit)
    }
}