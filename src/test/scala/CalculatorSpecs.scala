import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import com.cajuncode.tipcalculator.models.CalculatorCore

class CalculatorSpecs extends FunSpec with ShouldMatchers {
  describe("a Tip Calculator") {
    it("should calculate the tip of 100.00"){
      val calc = CalculatorCore
      var result = calc.getTip(100.00, 10)
      result should equal(10.00)
    }
    it("should calculate the tip of 50 dollars at 17% to equal 8.5"){
      val calc = CalculatorCore
      var result = calc.getTip(50.00, 17)
      result should equal(8.5)
    }
  }
}