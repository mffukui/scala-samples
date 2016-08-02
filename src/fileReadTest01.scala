/*
 * ファイルリード サンプル
 */
import scala.io.Source

object fileReadTest01 {

  def fileloop(file: String)(bodyFunc: => (String) => Unit ){
    var src: Source = null
    
    try {
      src = Source.fromFile(file)
      for( line <- src.getLines ){
        bodyFunc(line)
      }
    } catch {
      case e: Exception => println("Error: " + e.getMessage())
    } finally {
      if( src != null ) src.close()
    }
  }
  
  def test(){
    fileloop("data/sample.csv"){
      line =>
      val s = line.split(",").map( x => x.toInt )
      println( s(0) + "+" + s(1) + "=" + (s(0) + s(1)) )
    }
  }
  
  
  def main(args: Array[String]){
    test()    
  }
  
}