package com.example.madlevel3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter(private val portals: List<Portal>): RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        // Makes use of Kotlin synthetic.
        fun databind(portal: Portal) {
            itemView.portalTitle.text = portal.name
            itemView.portalURL.text = portal.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(portals[position])
    }

    override fun getItemCount(): Int {
        return portals.size
    }
}