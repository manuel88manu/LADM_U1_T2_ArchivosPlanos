package mx.tecnm.tepic.ladm_u1_t2_archivosplanos.ui.gallery

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.tecnm.tepic.ladm_u1_t2_archivosplanos.CustomAdapter
import mx.tecnm.tepic.ladm_u1_t2_archivosplanos.R
import mx.tecnm.tepic.ladm_u1_t2_archivosplanos.databinding.FragmentGalleryBinding
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private var  textInser = ""

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView=root.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter= CustomAdapter()
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        recyclerView.adapter=adapter
        /*
            val archi = InputStreamReader(requireActivity().openFileInput("datos.txt"))
            val lista = archi.readLines()
            CustomAdapter.listaCapas = lista as ArrayList<String>
            */
            //METODO ELIMINAR====================
        binding.actualizar.setOnClickListener {
            try {
               /* textInser = "Materia: " + binding.editMateria.text.toString() + "," + "Hora de entrega:" + binding.editFecha.text.toString() + ", Tarea: " + binding.editTarea.text.toString()
                val Lis = CustomAdapter.listaCapas
                val posi = binding.edit.text.toString().toInt()
                Lis[posi-1] = textInser+"\n"
                AlertDialog.Builder(requireContext()).setMessage(Lis.toString()).show()
                borrar("",requireContext())
                guardar(Lis.toString(),requireContext())
                mostrar()*/
            }catch (e:Exception){
                AlertDialog.Builder(requireContext()).setMessage("Dato invalido").show()

            }

        }

        return root

    }
    fun guardar(data:String,context: Context) {
        try {
            val outputStreamWriter =
                OutputStreamWriter(context.openFileOutput("datos.txt", Context.MODE_APPEND))
            outputStreamWriter.write(data)
            outputStreamWriter.flush()
            outputStreamWriter.close()
        } catch (e: IOException) {

        }
    }
    fun borrar(data:String,context: Context){
        try{
            val outputStreamWriter=OutputStreamWriter(context.openFileOutput("datos.txt",0))
            outputStreamWriter.write("")
            outputStreamWriter.flush()
            outputStreamWriter.close()
        }catch (e:IOException){

        }
    }
    private fun mostrar() {
        try {
            val archi=InputStreamReader(requireActivity().openFileInput("datos.txt"))
            val lista=archi.readLines()
            CustomAdapter.listaCapas = lista as ArrayList<String>
        }catch (e: java.lang.Exception){

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}