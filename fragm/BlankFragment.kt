package com.example.fragm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view=inflater.inflate(R.layout.fragment_blank, container, false)

        val btnEnviar=view.findViewById<Button>(R.id.btnEnviar)

        val edtNombre=view.findViewById<EditText>(R.id.edtNombre)
        val edtApellido=view.findViewById<EditText>(R.id.edtApellido)
        val edtCorreo=view.findViewById<EditText>(R.id.edtCorreo)
       val edtTelefono=view.findViewById<EditText>(R.id.edtTelefono)
        val edtPassword=view.findViewById<EditText>(R.id.edtPassword)

        btnEnviar.setOnClickListener{
            val nombre=edtNombre.text.toString()
            val apellido=edtApellido.text.toString()
            val correo=edtCorreo.text.toString()
            val telefono=edtTelefono.text.toString()
            val password=edtPassword.text.toString()


            clickBtnEnviarMensaje(nombre)
            clickBtnEnviarMensaje(apellido)
            clickBtnEnviarMensaje(correo)
            clickBtnEnviarMensaje(telefono)
            clickBtnEnviarMensaje(password)

        }



        return view
    }

    companion object {
        @JvmStatic

        private lateinit var clickBtnEnviarMensaje:(String)->Unit
        @JvmStatic
        fun newInstance(clickBtnEnviarMensaje:(String)->Unit):BlankFragment{
            val blankFragment=BlankFragment()
            this.clickBtnEnviarMensaje=clickBtnEnviarMensaje
            return blankFragment
                }
            }
    }
