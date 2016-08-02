/*
 * グラフィック サンプル
 */
import javax.swing._
import java.awt._

object graphicTest01 extends JFrame {
  // グラフデータ
  val data = Array(500, 450, 200, 280, 80, 400, 480, 500, 100, 120)
  // 色
  val color1 = new Color(150, 180, 230)
  val color2 = new Color(120, 150, 200)
  val color3 = new Color(20, 120, 50)
  val solid1 = new BasicStroke(1.0f)
  val solid2 = new BasicStroke(2.0f)
  val dash = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, Array(1.0f), 0.0f)
  
  
  def loopGrid(start: Int, end: Int, d:Int)(bodyFunc: (Int) => Unit ){
    var i = start
    var pos = 0
    while(i <= end){
      bodyFunc(pos)
      i += 1
      pos += d
    }
  }
  
  def loopPlot(length: Int, d: Int)(lineFunc: (Int,Int,Int,Int) => Unit)(plotFunc: (Int,Int) => Unit){
    var i = 1
    var lastX = d
    var lastData = data(0)
    
    while(i < length){
      val nextX = lastX + d
      val nextData = data(i)
      lineFunc(lastX, nextX, lastData, nextData)
      plotFunc(lastX, lastData)
      i += 1
      lastX = nextX
      lastData = nextData
    }
    plotFunc(lastX, lastData)
    
  }
  
  
  def grid(g: Graphics2D, w: Int, h: Int, d: Int, color: Color, stroke: BasicStroke){
    g.setColor(color)
    g.setStroke(stroke)
    loopGrid(0, h/d, d){
      y => g.drawLine(0,y,w,y)
    }
    loopGrid(0, h/d, d){
      x => g.drawLine(x,0,x,h)
    }
   
  }
  
  def plot(g: Graphics2D, data: Array[Int], d: Int, color: Color, stroke: BasicStroke){
    g.setColor(color)
    g.setStroke(stroke)
    loopPlot(data.length, d){
      (x1,x2,y1,y2) => g.drawLine(x1,y1, x2,y2)
    }{
      (x1,y1) => g.fillRect(x1-4, y1-4, 9,9)  // マーカー
    }
  }
  
  def main(args: Array[String]){
    // ウィンドウ生成
    setBounds(100,100, 600,600)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setVisible(true)
    
    add(new JPanel {
      override def paintComponent(g:Graphics){
        super.paintComponent(g)
        val g2 = g.asInstanceOf[Graphics2D]
        val w = getWidth()
        val h = getHeight()
        
        grid(g2, w, h, 10, color1, dash) // 補助目盛り
        grid(g2, w, h, 50, color2, solid1) // 目盛り
        plot(g2, data, 50, color3, solid2) // 折れ線
      }
    })
    
  }
}