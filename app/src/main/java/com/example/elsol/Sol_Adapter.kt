package com.example.elsol

import android.view.*
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class Sol_Adapter(var items: ArrayList<Sol>) :
    RecyclerView.Adapter<Sol_Adapter.SolTarjViewHolder>() {

    lateinit var onClick: (View) -> Unit

    class SolTarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imagen: ImageView
        var toolbar: Toolbar

        init {
            imagen = itemView.findViewById(R.id.imgaenPrincipal)
            toolbar = itemView.findViewById(R.id.card_toolbar)
        }


        fun bindTarjeta(t: Sol, onClick: (View) -> Unit) = with(itemView) {
            toolbar.setTitle(t.nom)
            imagen.setImageResource(t.imagen)
            toolbar.inflateMenu(R.menu.menu_sol)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SolTarjViewHolder {
        val itemView =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_sol, viewGroup, false)
        return SolTarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: SolTarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
        viewHolder.toolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(p0: MenuItem?): Boolean {
                when (p0!!.itemId) {
                    (R.id.copiar) -> {
                        items.add(viewHolder.adapterPosition, Sol(item.imagen,item.nom))
                        notifyItemInserted(viewHolder.adapterPosition)
                    }
                    (R.id.eliminar) -> {
                        items.removeAt(viewHolder.adapterPosition)
                        notifyItemRemoved(viewHolder.adapterPosition)
                    }
                }
                return true
            }
        })

    }

    override fun getItemCount(): Int {
        return items.size
    }
}



