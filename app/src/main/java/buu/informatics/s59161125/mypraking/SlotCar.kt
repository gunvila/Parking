package buu.informatics.s59161125.mypraking


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log

class SlotCar : AppCompatActivity() {
    private val myParking: ArrayList<Slot> = ArrayList<Slot>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..2) {
            myParking.add(i, Slot("", "", ""))
        }
        findViewById<Button>(R.id.slot_one).setOnClickListener {
            clickOne()

        }
        findViewById<Button>(R.id.slot_two).setOnClickListener {
            clickTwo()

        }
        findViewById<Button>(R.id.slot_two).setOnClickListener {
            clickThree()

        }

    }

    fun clickOne() {

        val bttnone = findViewById<Button>(R.id.slot_one)

        val placenumber = findViewById<EditText>(R.id.place_number)
        val bard = findViewById<EditText>(R.id.brand)
        val user = findViewById<EditText>(R.id.user)



        findViewById<EditText>(R.id.place_number).setText(myParking.get(0).placenamber).toString()
        findViewById<EditText>(R.id.brand).setText(myParking.get(0).brand).toString()
        findViewById<EditText>(R.id.user).setText(myParking.get(0).user).toString()

        var number = placenumber.text
        var logo = bard.text
        var name = user.text

        findViewById<Button>(R.id.update).setOnClickListener {
            myParking.add(0, Slot(number.toString(), logo.toString(), name.toString()))
            bttnone.setText(myParking.get(0).placenamber).toString()


            findViewById<EditText>(R.id.place_number).setText("")
            findViewById<EditText>(R.id.brand).setText("")
            findViewById<EditText>(R.id.user).setText("")
        }


    }

    fun clickTwo() {

        val bttntwo = findViewById<Button>(R.id.slot_two)

        val placenumber = findViewById<EditText>(R.id.place_number)
        val bard = findViewById<EditText>(R.id.brand)
        val user = findViewById<EditText>(R.id.user)



        findViewById<EditText>(R.id.place_number).setText(myParking.get(1).placenamber).toString()
        findViewById<EditText>(R.id.brand).setText(myParking.get(1).brand).toString()
        findViewById<EditText>(R.id.user).setText(myParking.get(1).user).toString()

        var number = placenumber.text
        var logo = bard.text
        var name = user.text

        findViewById<Button>(R.id.update).setOnClickListener {
            myParking.add(0, Slot(number.toString(), logo.toString(), name.toString()))
            bttntwo.setText(myParking.get(0).placenamber).toString()


            findViewById<EditText>(R.id.place_number).setText("")
            findViewById<EditText>(R.id.brand).setText("")
            findViewById<EditText>(R.id.user).setText("")
        }

    }
    fun clickThree() {

        val bttnthree = findViewById<Button>(R.id.slot_three)

        val placenumber = findViewById<EditText>(R.id.place_number)
        val bard = findViewById<EditText>(R.id.brand)
        val user = findViewById<EditText>(R.id.user)



        findViewById<EditText>(R.id.place_number).setText(myParking.get(2).placenamber).toString()
        findViewById<EditText>(R.id.brand).setText(myParking.get(2).brand).toString()
        findViewById<EditText>(R.id.user).setText(myParking.get(2).user).toString()

        var number = placenumber.text
        var logo = bard.text
        var name = user.text

        findViewById<Button>(R.id.update).setOnClickListener {
            myParking.add(0, Slot(number.toString(), logo.toString(), name.toString()))
            bttnthree.setText(myParking.get(0).placenamber).toString()


            findViewById<EditText>(R.id.place_number).setText("")
            findViewById<EditText>(R.id.brand).setText("")
            findViewById<EditText>(R.id.user).setText("")
        }
    }
}
