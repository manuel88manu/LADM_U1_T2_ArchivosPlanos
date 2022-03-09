package mx.tecnm.tepic.ladm_u1_t2_archivosplanos.ui.slideshow

import android.app.Activity
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
import mx.tecnm.tepic.ladm_u1_t2_archivosplanos.CustomAdapter
import mx.tecnm.tepic.ladm_u1_t2_archivosplanos.CustomAdapter.Companion.listaCapas
import mx.tecnm.tepic.ladm_u1_t2_archivosplanos.databinding.FragmentSlideshowBinding
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    public var textInser=""
    public val arreglo= arrayListOf<String>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.insertar.setOnClickListener {
            textInser = "Materia: " + binding.editMa.text.toString() + "," + "Hora de entrega:" + binding.editHo.text.toString() + ", Tarea: " + binding.editDes.text.toString()
            guardar(textInser,requireContext())
            mostrar()
        }
        binding.Borrar.setOnClickListener {
            borrar("",requireContext())
            mostrar()
            AlertDialog.Builder(requireContext()).setMessage("SE ELIMINARON TODAS LAS TAREAS").show()
        }
        return root

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
    //===========================================================================================
    fun guardar(data:String,context: Context){
     try{
         val outputStreamWriter=OutputStreamWriter(context.openFileOutput("datos.txt",Context.MODE_APPEND))
         outputStreamWriter.write(data+"\n")
         outputStreamWriter.flush()
         outputStreamWriter.close()
         AlertDialog.Builder(requireContext()).setMessage("SE AGREGO NUEVA TAREA").show()

     }catch (e:IOException){

     }

    }
    private fun mostrar() {
        try {
            val archi=InputStreamReader(requireActivity().openFileInput("datos.txt"))
            val lista=archi.readLines()
            listaCapas= lista as ArrayList<String>
        }catch (e:Exception){

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}