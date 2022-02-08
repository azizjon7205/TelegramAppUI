package com.example.telegramappui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.telegramappui.R
import com.example.telegramappui.model.Chat
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(val context: Context, var items: ArrayList<Chat>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_view, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]

        if (holder is MessageViewHolder){
            holder.iv_profile.setImageResource(chat.profile)
            holder.tv_fullname.text = chat.fullname
            holder.tv_message.text = chat.message


        }
    }

    override fun getItemCount() = items.size

    inner class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val iv_profile = itemView.findViewById<ShapeableImageView>(R.id.iv_profile)
        val tv_fullname = itemView.findViewById<TextView>(R.id.tv_fullname)
        val tv_message = itemView.findViewById<TextView>(R.id.tv_message)
    }
}