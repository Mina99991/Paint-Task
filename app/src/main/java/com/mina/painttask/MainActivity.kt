package com.mina.painttask


import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.mina.painttask.PaintView.Companion.colorList
import com.mina.painttask.PaintView.Companion.currentBrush
import com.mina.painttask.PaintView.Companion.pathList
import com.mina.painttask.databinding.ActivityMainBinding
import com.mina.painttask.functions.showHide

class MainActivity : AppCompatActivity() {
    
    companion object{
        var path=Path()
        var paintBrush =Paint()
    }


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       buttonClickHandling()


    }


    private fun buttonClickHandling(){
        binding.toggleButtonGroup.addOnButtonCheckedListener{
                toggleButtonGroup, checkedId, isChecked ->
            if (isChecked) {
                when(checkedId){
                    R.id.btnPaint->{}
                    R.id.btnArrow->{}
                    R.id.btnRectangle->{}
                    R.id.btnCircle->{}

            //*************to Change between Colors*********************
                    R.id.btnColorPallet->{
                        showHide(binding.toggleButtonColorGroup)
                        buttonClickColorHandling()
                    }

            //*************to Clean Last Paints*********************
                    R.id.btnClean-> {
                        pathList.clear()
                        colorList.clear()
                        path.reset()
                    }
                }
            }else{
                if (toggleButtonGroup.checkedButtonId== View.NO_ID){
                    Toast.makeText(this, "No alignment selected", Toast.LENGTH_LONG).show()

                }
            }
        }
    }


    private fun buttonClickColorHandling(){
        binding.toggleButtonColorGroup.addOnButtonCheckedListener{
                toggleButtonGroup, checkedId, isChecked ->
            if (isChecked) {
                when(checkedId){
                    R.id.btnColorRed->{
                        Toast.makeText(this, "Red Color selected", Toast.LENGTH_SHORT).show()
                        paintBrush.color = Color.RED
                        currentColor(paintBrush.color)
                    }
                    R.id.btnColorGreen->{
                        Toast.makeText(this, "Green Color selected", Toast.LENGTH_SHORT).show()
                        paintBrush.color = Color.GREEN
                        currentColor(paintBrush.color)
                    }
                    R.id.btnColorBlue->{
                        Toast.makeText(this, "Blue Color selected", Toast.LENGTH_SHORT).show()
                        paintBrush.color = Color.BLUE
                        currentColor(paintBrush.color)
                    }
                    R.id.btnColorBlack->{
                        Toast.makeText(this, "Black Color selected", Toast.LENGTH_SHORT).show()
                        paintBrush.color = Color.BLACK
                        currentColor(paintBrush.color)
                    }
                }
            }else{
                if (toggleButtonGroup.checkedButtonId== View.NO_ID){
                    Toast.makeText(this, "No alignment selected", Toast.LENGTH_LONG).show()

                }
            }
        }
    }



    private fun currentColor(color: Int){
        currentBrush=color
        path = Path()

    }


}