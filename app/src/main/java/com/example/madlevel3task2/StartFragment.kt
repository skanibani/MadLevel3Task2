package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_start.*

// Outside of fragment so that the list exists outside the fragment
val portals = arrayListOf<Portal>()

class StartFragment : Fragment() {
    private val portalAdapter = PortalAdapter(portals)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        observeNewPortals()
    }

    private fun initViews() {
        portalRecycler.layoutManager =
                GridLayoutManager(context, 2)
        portalRecycler.adapter = portalAdapter
        // TODO perhaps add a divider

        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_StartFragment_to_CreatePortalFragment)
        }
    }

    private fun observeNewPortals() {
        var newPortal = arguments?.getParcelable<Portal>("portal")
        if (newPortal != null) {
            portals.add(newPortal)
            portalAdapter.notifyDataSetChanged()
        }

    }
}