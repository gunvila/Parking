package buu.informatics.s59161125.mypraking

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import buu.informatics.s59161125.mypraking.databinding.FragmentSlotCarAllBinding
import kotlinx.android.synthetic.main.fragment_slot_car_all.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SlotCarAll.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SlotCarAll.newInstance] factory method to
 * create an instance of this fragment.
 */
class SlotCarAll : Fragment() {
    private  lateinit var binding: FragmentSlotCarAllBinding
    private val booking: ArrayList<Slot> = ArrayList()
    private var slot: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_slot_car_all, container, false)
        for(x in 0..2){
            booking.add(x, Slot("","",""))
        }
        setVisibleIsTrue()
        binding.apply {
            btn1.setOnClickListener {
                slot = 0;
                btn1.setBackgroundColor(Color.GRAY)
                btn2.setBackgroundResource(android.R.drawable.btn_default);
                btn3.setBackgroundResource(android.R.drawable.btn_default);
                try {
                    showValue(slot);
                    setVisibleIsFalse();
                } catch (e: IndexOutOfBoundsException) {
                    setVisibleIsFalse()
                }

            }
            btn2.setOnClickListener {
                btn2.setBackgroundColor(Color.GRAY)
                btn1.setBackgroundResource(android.R.drawable.btn_default);
                btn3.setBackgroundResource(android.R.drawable.btn_default);
                slot = 1;
                try {
                    showValue(slot);
                    setVisibleIsFalse()
                } catch (e: IndexOutOfBoundsException) {
                    setVisibleIsFalse()
                }
            }
            btn3.setOnClickListener {
                btn3.setBackgroundColor(Color.GRAY)
                btn1.setBackgroundResource(android.R.drawable.btn_default);
                btn2.setBackgroundResource(android.R.drawable.btn_default);
                slot = 2;
                try {
                    showValue(slot);
                    setVisibleIsFalse()
                } catch (e: IndexOutOfBoundsException) {
                    setVisibleIsFalse()
                }

            }
            submitbtn.setOnClickListener {
                setValueBooking(it)
            }
            cancelbtn.setOnClickListener {
                setVisibleIsTrue()
            }
        }
        return binding.root
    }

    private fun setVisibleIsTrue() {
        binding.apply {
            carnumber?.visibility = View.GONE
            barnd?.visibility = View.GONE
            name?.visibility = View.GONE
            submitbtn?.visibility = View.GONE
            cancelbtn?.visibility = View.GONE
            btn1.setBackgroundResource(android.R.drawable.btn_default);
            btn2.setBackgroundResource(android.R.drawable.btn_default);
            btn3.setBackgroundResource(android.R.drawable.btn_default);
        }
        if (slot == 0) {
            binding.btn1.setText("SLOTONE")
            booking.removeAt(0)
            booking.add(0,Slot("","",""));
        } else if (slot == 1) {
            binding.btn2.setText("SLOTTWO")
            booking.removeAt(1)
            booking.add(1,Slot("","",""));
        } else if (slot == 2) {
            binding.btn3.setText("SLOTTHREE")
            booking.removeAt(2)
            booking.add(2,Slot("","",""));
        }

    }

    private fun setVisibleIsFalse() {
        binding.apply {
            carnumber?.visibility = View.VISIBLE
            barnd?.visibility = View.VISIBLE
            name?.visibility = View.VISIBLE
            submitbtn?.visibility = View.VISIBLE
            cancelbtn?.visibility = View.VISIBLE
        }
    }

    private fun setValueBooking(view:View) {
        val carnumber = binding.carnumber.text.toString()
        val brand = binding.barnd.text.toString()
        val name = binding.name.text.toString()
        booking.add(slot , Slot(carnumber, brand, name))
        if (slot == 0) {
            binding.btn1.setText("FULL")
        } else if (slot == 1) {
            binding.btn2.setText("FULL")
        } else {
            binding.btn3.setText("FULL")
        }
        // val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        //  inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun showValue(slot: Int) {
        binding.carnumber.setText(booking.get(slot).placenamber)
        binding.barnd.setText(booking.get(slot).brand)
        binding.name.setText(booking.get(slot).user)
    }
}
