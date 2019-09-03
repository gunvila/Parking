package buu.informatics.s59161125.mypraking


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import s591125.informatics.buu.bookingcar.databinding.FragmentLoginBinding
import kotlin.math.log


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        binding.submit.setOnClickListener{view: View->
            binding.apply {
                var user = username.text.toString()
                var pass = password.text.toString()
                if(user == "admin" && pass == "12345678"){
                    Log.d("true","12345")
                    view.findNavController()
                        .navigate(R.id.action_login_to_bookingCar)
                }else{
                    Toast.makeText(getActivity(), "Username or Password Invalid",
                        Toast.LENGTH_LONG).show();
                }
            }
        }
        return binding.root
    }


}