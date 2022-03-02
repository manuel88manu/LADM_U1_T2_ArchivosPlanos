package mx.tecnm.tepic.ladm_u1_t2_archivosplanos.ui.slideshow

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.tecnm.tepic.ladm_u1_t2_archivosplanos.databinding.FragmentSlideshowBinding
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    public var textInser=""
    private val archivo= OutputStreamWriter(requireActivity().openFileOutput("archivo.txt",0))
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

            guardar()
            mostrar()

        }
        return root

    }

    private fun guardar() {
       try {
           val arreglo= arrayListOf<String>()
           val archi=InputStreamReader(requireActivity().openFileInput("archivo.txt"))
           var lista=archi.readLines()
               textInser = "Materia: " + binding.editMa.text.toString() + "\n" + "Hora de entrega: \n" + binding.editHo.text.toString() + "\n Tarea: " + binding.editDes.text.toString()
           Toast.makeText(requireContext(),"Es tamaño de la lista es: ${lista.size}",Toast.LENGTH_LONG).show()
           if(lista.size==0) {
               arreglo.add(textInser)
               archivo.write(textInser)
               archivo.flush()
               archivo.close()
               Toast.makeText(requireContext(),"Esta Vacio",Toast.LENGTH_LONG).show()
           }
           else{
               Toast.makeText(requireContext(),"Ya esta creado",Toast.LENGTH_LONG).show()
               val archi=InputStreamReader(requireActivity().openFileInput("archivo.txt"))
               var texto=archi.read().toString()
               if(!texto.equals("-1")) {
                   texto = texto+textInser
                   archivo.write(texto)
                   archivo.flush()
                   archivo.close()
                   Toast.makeText(requireContext(),"No es -1",Toast.LENGTH_LONG).show()
               }else{
                   texto = texto + "\n" + textInser
                   archivo.write(texto)
                   archivo.flush()
                   archivo.close()

               }
           }
       }catch (e:Exception){

       }
    }
    private fun mostrar() {
        try {
            val archi=InputStreamReader(requireActivity().openFileInput("archivo.txt"))
            var lista=archi.readLines()
            AlertDialog.Builder(requireContext()).setMessage(lista.toString()).show()
        }catch (e:Exception){

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}