/*
 * 部分適用サンプル
 */
object partiallyAppliedFuncTest01 {
  
  def org_func(a:Int, b:Int, c:Int):Int = {
    a + b + c
  }
    
  def main(args: Array[String]){
    println("org func = " + org_func(1,2,3) )
    
    val f = org_func(_:Int, _:Int, 3)
    println("new func = " + f(1,2) )
    
  }
}