package com.example.telegramappui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.telegramappui.R
import com.example.telegramappui.model.Contact
import com.google.android.material.imageview.ShapeableImageView

class ContactAdapter(val context: Context, var contacts: ArrayList<Contact>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private final val TYPE_HEADERS = 0
    private final val TYPE_CONTACTS = 1

    override fun getItemViewType(position: Int): Int {
        if (position == 0 || position == 1) return TYPE_HEADERS
        return TYPE_CONTACTS
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_HEADERS){
            return HeadersViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_contact_headers, parent, false))
        }
        return ContactsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_contact_view, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact = contacts[position]

        if (holder is ContactsViewHolder){
            holder.iv_profile.setImageResource(contact.profile)
            holder.tv_contact_name.text = contact.fullname
            holder.tv_online.text = contact.online
        }

        if (holder is HeadersViewHolder){
            holder.iv_contact_header.setImageResource(contact.profile)
            holder.tv_contact_header.text = contact.fullname
        }
    }

    override fun getItemCount() = contacts.size

    class ContactsViewHolder(view: View): RecyclerView.ViewHolder(view){
        val iv_profile = view.findViewById<ShapeableImageView>(R.id.iv_contact_profile)
        val tv_contact_name = view.findViewById<TextView>(R.id.tv_contact_name)
        val tv_online = view.findViewById<TextView>(R.id.tv_online)
    }

    class HeadersViewHolder(view: View): RecyclerView.ViewHolder(view){
        val iv_contact_header = view.findViewById<ImageView>(R.id.iv_contact_header)
        val tv_contact_header = view.findViewById<TextView>(R.id.tv_contact_header)
    }
}