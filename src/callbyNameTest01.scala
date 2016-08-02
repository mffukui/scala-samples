/*
 * 名前渡し サンプル
 */
import javax.swing.JOptionPane

object callbyNameTest01 {
  val japanese = true
  //val japanese = false
  
  val data = Array(1,2,3,4,5,6,7,8,9,10)
  
  def getDataCount() = {
    data.length
  }
  
  def messageBox(jp:String, en:String){
    println("------メッセージボックス(値渡し)")
    JOptionPane.showMessageDialog(null, if(japanese) jp else en, 
                                  "動作テスト", JOptionPane.INFORMATION_MESSAGE)
  }
  
  def messageBoxByName(jp: => String, en: => String){
    println("------メッセージボックス(名前渡し)")
    JOptionPane.showMessageDialog(null, if(japanese) jp else en, 
                                  "動作テスト", JOptionPane.INFORMATION_MESSAGE)
  }
  
  def test1(){
    println("==== 値渡しと名前渡し")
    messageBox( getDataCount() + "件のデータを読み込みました", 
                "Loaded " + getDataCount() + " Data." )
    messageBoxByName( getDataCount() + "件のデータを読み込みました", 
                      "Loaded " + getDataCount() + " Data." )
  }
  
  def jpn() = {
    println("---- jpn")
    getDataCount() + "件のデータを読み込みました"
  }
  
  def eng() = {
    println("---- eng")
    "Loaded" + getDataCount() + "Data."
  }
  
  def test2(){
    println("==== 値渡しと名前渡し")
    messageBox( jpn(), eng() )
    messageBoxByName( jpn(), eng() )
  }
  
  def main(args:Array[String]){
//    test1() // 動作は同じ
    test2() // 名前渡しの場合には使用されないeng()は呼ばれない
  }
}