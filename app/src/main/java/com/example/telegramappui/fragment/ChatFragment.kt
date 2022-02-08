package com.example.telegramappui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegramappui.R
import com.example.telegramappui.adapter.ChatAdapter
import com.example.telegramappui.model.Chat

class ChatFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.white2)
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        initViews(view)
        return view
    }
    private fun initViews(view: View){
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)

        refreshAdapter(getChatsList())
    }

    private fun refreshAdapter(items: ArrayList<Chat>){
        val chatAdapter = ChatAdapter(requireContext(),items)
        recyclerView.adapter = chatAdapter
    }

    private fun getChatsList(): ArrayList<Chat>{
        val chats = ArrayList<Chat>()

        chats.add(Chat(R.drawable.im_user_1, "Sheronov Azizjon", "Azizjon have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Ismoilov Ilhom", "Ilhom have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Sheronov Muxtor", "Muxtor have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Baxodirov Mansur", "Mansur have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Sheronov Azizjon", "Azizjon have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Ismoilov Ilhom", "Ilhom have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Sheronov Muxtor", "Muxtor have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Baxodirov Mansur", "Mansur have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Sheronov Azizjon", "Azizjon have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Ismoilov Ilhom", "Ilhom have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Sheronov Muxtor", "Muxtor have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Baxodirov Mansur", "Mansur have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Sheronov Azizjon", "Azizjon have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Ismoilov Ilhom", "Ilhom have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Sheronov Muxtor", "Muxtor have sent a message"))
        chats.add(Chat(R.drawable.im_user_1, "Baxodirov Mansur", "Mansur have sent a message"))

        return chats
    }
}