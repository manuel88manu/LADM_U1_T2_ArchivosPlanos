package mx.tecnm.tepic.ladm_u1_t2_archivosplanos

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    val tarea= arrayListOf("Materia: LYA Descripcion: Hacer esposicion de matematicas","Materia: IA Descripcion:HAcer ejercicios")
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
      val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTarea.text=tarea[i]
        viewHolder.itemNumero.text=(i+1).toString()
    }

    override fun getItemCount(): Int {
        return tarea.size
    }

inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var itemImage: ImageView
    var itemTarea: TextView
    var itemNumero:TextView
    init{
        itemImage=itemView.findViewById(R.id.item_image)
        itemTarea=itemView.findViewById(R.id.text)
        itemNumero=itemView.findViewById(R.id.numero)
    }

}
}