package buu.informatics.s59161125.mypraking


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_loginmain.*

/**
 * A simple [Fragment] subclass.
 */
class Loginmain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_loginmain, container, false)

        binding.submit.setOnClickListener{view: View->
            binding.apply {
                var user = name.text.toString()
                var pass = pass.text.toString()
                if(user == "admin" && pass == "12345678"){
                    Log.d("true","12345")
                    view.findNavController()
                        .navigate(R.id.action_login_to_bookingCar)
                }else{
                    Toast.makeText(getActivity(), "รหัสผ่านผิดกรุณา ล็อคอินใหม่",
                        Toast.LENGTH_LONG).show();
                }
            }
        }
        return binding.root
    }


}
