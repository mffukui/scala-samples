/*
 * カリー化サンプル
 */
object curriedFuncTest01 {
  def func(a:Int)(b:Int)(c:Int) = {
    a + b + c
  }
  
  def main(args:Array[String]){
    println("curried func=" + func(1)(2)(3) )
  }
  
}