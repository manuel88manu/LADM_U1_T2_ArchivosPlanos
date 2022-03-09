package mx.tecnm.tepic.ladm_u1_t2_archivosplanos

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    companion object{
        var listaCapas= arrayListOf<String>("Materia: ,Hora de Entrega: ,Tarea: ")
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
      val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val arr= listaCapas.get(i).split(",")
        viewHolder.itemMateria.text=arr[0]
        viewHolder.itemHora.text=arr[1]
        viewHolder.itemTarea.text=arr[2]
        viewHolder.itemNumero.text=(i+1).toString()
    }

    override fun getItemCount(): Int {
        return listaCapas.size
    }

inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var itemImage: ImageView
    var itemMateria: TextView
    var itemHora: TextView
    var itemTarea: TextView
    var itemNumero:TextView
    init{
        itemImage=itemView.findViewById(R.id.item_image)
        itemMateria=itemView.findViewById(R.id.textmateria)
        itemHora=itemView.findViewById(R.id.textHora)
        itemTarea=itemView.findViewById(R.id.textTarea)
        itemNumero=itemView.findViewById(R.id.numero)
    }

}

}