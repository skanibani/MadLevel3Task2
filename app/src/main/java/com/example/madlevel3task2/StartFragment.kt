package com.example.madlevel3task2

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_start.*
import androidx.browser.customtabs.*

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

        // Configure recyclerView
        portalRecycler.layoutManager =
                GridLayoutManager(context, 2)
        portalRecycler.adapter = portalAdapter

        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_StartFragment_to_CreatePortalFragment)
        }
    }

    // Fetch data from create portal fragment
    private fun observeNewPortals() {
        var newPortal = arguments?.getParcelable<Portal>("portal")
        if (newPortal != null) {

            // Add to the list
            portals.add(newPortal)
            portalAdapter.notifyDataSetChanged()
        }

    }

    // Launches a Chrome tab with given URL.
    private fun launchChromeTab(url: String) {
        var customTabsIntent = CustomTabsIntent.Builder().build()
        context?.let { customTabsIntent.launchUrl(it, Uri.parse(url)) }
    }
}