package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_create_portal.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CreatePortalFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        portallAdd.setOnClickListener {
            createPortal()
        }
    }

    private fun createPortal() {
        var newPortal = Portal(
                portalNameEdit.text.toString(),
                portalUrlEdit.text.toString()
        )

        val bundle = bundleOf("portal" to newPortal)

        findNavController().navigate(R.id.action_CreatePortalFragment_to_StartFragment, bundle)
    }
}