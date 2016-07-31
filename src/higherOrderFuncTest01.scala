/*
 * 高階関数 サンプル
 */

object higherOrderFuncTest01 {
  def sankaku(a: Int, b:Int, c:Int, fun:(Int, Int, Int) => Boolean){
    if( fun(a,b,c) ){
      println("yes")
    } else {
      println("no")
    }
  }
  
  def main(args: Array[String]){
    println("正三角形")
    sankaku( 3,3,4, (a,b,c) => a == b && b == c )
    sankaku( 3,3,3, (a,b,c) => a == b && b == c )
    
    println("二等辺三角形")
    sankaku( 3,3,4, (a,b,c) => a == b || b == c || c == a )
    sankaku( 3,3,3, (a,b,c) => a == b || b == c || c == a )
  }
}