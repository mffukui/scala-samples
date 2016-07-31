/*
 * 高階関数 サンプル
 */
import java.util.Locale
import java.util.Date
import java.text.SimpleDateFormat

object higherOrderFuncTest02 {
  
  val warekiLoc = new Locale("ja", "JP", "JP" )
  val seirekiLoc = new Locale("us", "EN")
  
  def f(fmt:String, wareki:Boolean) = {
    val df = new SimpleDateFormat(fmt, if(wareki) warekiLoc
                                       else seirekiLoc )
    // 関数リテラルを返す
    (date: Date) => df.format(date)
  }
  
  
  def main(args: Array[String]){
    
    val fmtS = f("yy/M/d", false)
    val fmtWarekiS = f("GGGGyy/M/d", true)
    
    val d = new Date()
    
    println( fmtS(d) )
    println( fmtWarekiS(d) )
  }
  
  
}