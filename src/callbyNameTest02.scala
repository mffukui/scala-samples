/*
 * 名前渡し サンプル
 */
object callbyNameTest02 {
  def loop1(body: => Unit){
    println("---- loop1")
    for(i <- 1 to 3){
      body
    }
  }
  
  def loop2(n: Int)(body: => Unit){
    println("---- loop2")
    var i = 0;
    while( i < n ){
      body
      i += 1
    }
  }
  
  def loop3(cond: => Boolean, update: => Unit)(body: => Unit){
    println("---- loop3")
    while(cond){
      body
      update
    }
  }
  
  def test1(){
    println("=====名前渡しループ(３回固定)")
    loop1 {
      println(111)
      println(222)
    }
  }
  
  def test2(){
    println("=====名前渡しループ(回数指定)")
    loop2(3){
      println(111)
      println(222)
    }
  }
  
  def test3(){
    println("=====名前渡しループ(汎用版)")
    var a = 0
    loop3( a < 3, a += 1){
      println(111)
      println(222)
    }
  }
  
  
  def main(args: Array[String]){
    test1()
    test2()
    test3()
  }
}