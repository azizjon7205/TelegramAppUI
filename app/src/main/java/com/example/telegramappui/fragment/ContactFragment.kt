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
import com.example.telegramappui.adapter.ContactAdapter
import com.example.telegramappui.model.Contact

class ContactFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.black2)
        val view = inflater.inflate(R.layout.fragment_contacts, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.rv_contacts)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)

        refreshAdapter(getContacts())
    }

    private fun refreshAdapter(contacts: ArrayList<Contact>){
        val contactAdapter = ContactAdapter(requireContext(), contacts)
        recyclerView.adapter = contactAdapter
    }

    private fun getContacts(): ArrayList<Contact>{
        val contacts = ArrayList<Contact>()

        contacts.add(Contact(R.drawable.icons_location, "Find Nearby People", null))
        contacts.add(Contact(R.drawable.ic_add_user, "Invite People", null))
        contacts.add(Contact(R.drawable.im_user_1, "Sheronov Azizjon", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Jurabekov Sherzod", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Mardiev Abbos", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Pulatov Bobur", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Sheronov Muxtor", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Tursunbayev Chingiz", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Ergashev Jasur", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Mardiev Abbos", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Pulatov Bobur", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Sheronov Muxtor", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Tursunbayev Chingiz", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Ergashev Jasur", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Mardiev Abbos", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Pulatov Bobur", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Sheronov Muxtor", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Tursunbayev Chingiz", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Ergashev Jasur", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Mardiev Abbos", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Pulatov Bobur", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Sheronov Muxtor", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Tursunbayev Chingiz", "last seen recently"))
        contacts.add(Contact(R.drawable.im_user_1, "Ergashev Jasur", "last seen recently"))


        return contacts
    }
}