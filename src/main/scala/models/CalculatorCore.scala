package com.cajuncode.tipcalculator.models

object CalculatorCore {

  def getTip(bill:Double, tip_percentage:Int): Double = (bill * (tip_percentage / 100.0))

}
