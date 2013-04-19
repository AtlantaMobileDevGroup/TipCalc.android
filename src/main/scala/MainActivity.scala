package com.cajuncode.tipcalculator

import _root_.android.app.Activity
import _root_.android.os.Bundle
import android.widget.{TextView, SeekBar, EditText}
import android.text.{Editable, TextWatcher}
import android.widget.SeekBar.OnSeekBarChangeListener
import com.cajuncode.tipcalculator.models.CalculatorCore

class MainActivity extends Activity with TypedActivity {

  private lazy val bill:EditText = findView(TR.billAmount)
  private lazy val percentage:SeekBar = findView(TR.percent)
  private lazy val percentText:TextView = findView(TR.txtPercent)
  private lazy val tipAmount:TextView = findView(TR.tipAmount)
  private lazy val totalAmount:TextView = findView(TR.totalAmount)
  private val tag:String = "TipCalcMainActivity"

  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)

    bill.addTextChangedListener( new TextWatcher {
      def beforeTextChanged(value: CharSequence, start: Int, count: Int, after: Int) {}

      def onTextChanged(value: CharSequence, start: Int, before: Int, count: Int) {}

      def afterTextChanged(value: Editable) {
        //bill.setText(value)
        updateTip()
      }
    } )
    percentage.setOnSeekBarChangeListener(new OnSeekBarChangeListener {
      def onProgressChanged(seekbar: SeekBar, progress: Int, fromUser: Boolean) {
        updateTip()
        percentText.setText(progress.toString + "%")
      }

      def onStopTrackingTouch(seekbar: SeekBar) {}

      def onStartTrackingTouch(seekbar: SeekBar) {}
    })
    //findView(TR.textview).setText("hello, world!")
  }
  def updateTip(){
    val billText:String = bill.getText().toString
    val amount = convert(billText)

    val tip = CalculatorCore.getTip(amount, percentage.getProgress)
    tipAmount.setText(formatDecimal(tip))
    totalAmount.setText(formatDecimal(amount + tip))
  }
  def convert(value:String):Double = if(value.isEmpty) 00 else value.toDouble
  def formatDecimal(value:Double):String = "%1.2f" format value
}
