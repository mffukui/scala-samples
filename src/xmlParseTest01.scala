/*
 * XMLパース サンプル
 */
import javax.xml.parsers.DocumentBuilderFactory

object xmlParseTest01 {
  
  def loop(cond: => Boolean, update: => Unit)(body: => Unit){
    while(cond){
      body
      update
    }
  }
  
  def test(){
    val builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    val doc = builder.parse("data/data.xml")
    val users = doc.getElementsByTagName("user")
    var i = 0
    
    // userタグループ
    loop( i < users.getLength(), i += 1 ){
      var user = users.item(i)
      var node = user.getFirstChild()
      
      loop( node != null, node = node.getNextSibling){
        // nameがあれば表示
        if( node.getNodeName() == "name" ){
          println("名前=" + node.getTextContent().replaceAll("\\s", ""))
        }
      }
    }
    
  }
  
  def main(args: Array[String]){
    test()
  }
}