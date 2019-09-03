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
            slot1Btn.setOnClickListener {
                slot = 0;
                slot1Btn.setBackgroundColor(Color.GRAY)
                slot2Btn.setBackgroundResource(android.R.drawable.btn_default);
                slot3Btn.setBackgroundResource(android.R.drawable.btn_default);
                try {
                    showValue(slot);
                    setVisibleIsFalse();
                } catch (e: IndexOutOfBoundsException) {
                    setVisibleIsFalse()
                }

            }
            slot2Btn.setOnClickListener {
                slot2Btn.setBackgroundColor(Color.GRAY)
                slot1Btn.setBackgroundResource(android.R.drawable.btn_default);
                slot3Btn.setBackgroundResource(android.R.drawable.btn_default);
                slot = 1;
                try {
                    showValue(slot);
                    setVisibleIsFalse()
                } catch (e: IndexOutOfBoundsException) {
                    setVisibleIsFalse()
                }
            }
            slot3Btn.setOnClickListener {
                slot3Btn.setBackgroundColor(Color.GRAY)
                slot1Btn.setBackgroundResource(android.R.drawable.btn_default);
                slot2Btn.setBackgroundResource(android.R.drawable.btn_default);
                slot = 2;
                try {
                    showValue(slot);
                    setVisibleIsFalse()
                } catch (e: IndexOutOfBoundsException) {
                    setVisibleIsFalse()
                }

            }
            submitBtn.setOnClickListener {
                setValueBooking(it)
            }
            cancelBtn.setOnClickListener {
                setVisibleIsTrue()
            }
        }
        return binding.root
    }

    private fun setVisibleIsTrue() {
        binding.apply {
            registrationnumber_text?.visibility = View.GONE
            brand_text?.visibility = View.GONE
            name_text?.visibility = View.GONE
            submit_btn?.visibility = View.GONE
            cancel_btn?.visibility = View.GONE
            slot1Btn.setBackgroundResource(android.R.drawable.btn_default);
            slot2Btn.setBackgroundResource(android.R.drawable.btn_default);
            slot3Btn.setBackgroundResource(android.R.drawable.btn_default);
        }
        if (slot == 0) {
            binding.slot1Btn.setText("EMPTY")
            booking.removeAt(0)
            booking.add(0,Slot("","",""));
        } else if (slot == 1) {
            binding.slot2Btn.setText("EMPTY")
            booking.removeAt(1)
            booking.add(1,Slot("","",""));
        } else if (slot == 2) {
            binding.slot3Btn.setText("EMPTY")
            booking.removeAt(2)
            booking.add(2,Slot("","",""));
        }

    }

    private fun setVisibleIsFalse() {
        binding.apply {
            registrationnumber_text?.visibility = View.VISIBLE
            brand_text?.visibility = View.VISIBLE
            name_text?.visibility = View.VISIBLE
            submit_btn?.visibility = View.VISIBLE
            cancel_btn?.visibility = View.VISIBLE
        }
    }

    private fun setValueBooking(view:View) {
        val registrationnumber = binding.registrationnumberText.text.toString()
        val brand = binding.brandText.text.toString()
        val name = binding.nameText.text.toString()
        booking.add(slot , Slot(registrationnumber, brand, name))
        if (slot == 0) {
            binding.slot1Btn.setText("FULL")
        } else if (slot == 1) {
            binding.slot2Btn.setText("FULL")
        } else {
            binding.slot3Btn.setText("FULL")
        }
        // val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        //  inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun showValue(slot: Int) {
        binding.registrationnumberText.setText(booking.get(slot).registrationNumber)
        binding.brandText.setText(booking.get(slot).brand)
        binding.nameText.setText(booking.get(slot).name)
    }
}
