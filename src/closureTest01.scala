/*
 * クロージャ サンプル
 */
import java.util.Locale
import java.text.SimpleDateFormat


object closureTest01 {
  
  val plan = List("2017/08/01", "2017/08/02", "2017/08/03" )
  
  def disp(fmt: String) = {
    val inFmt = new SimpleDateFormat("yyyy/MM/dd")
    val outFmt = new SimpleDateFormat(fmt, Locale.ENGLISH)
    
    var count = 0
    
    // クロージャを返す
    (s: String) => {
      println("--------クロージャの呼び出し")
      count += 1
      println(count + " " + outFmt.format(inFmt.parse(s)))
    }
  }
  
  val disp_plan1 = disp("yyy.M.d(E)")
  val disp_plan2 = disp("yyy/M/d")
  
  def test1() {
    println("予定の表示1")
    plan.map( s => disp_plan1(s) )
  }

  def test2() {
    println("予定の表示2")
    plan.map( s => disp_plan2(s) )
  }

  def main(args: Array[String]){
    test1()
    test2()
  }
}