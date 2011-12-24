import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.{Group, Scene}
import javafx.scene.text.{Font, Text}

class HelloWorldJFX extends Application {

  override def start(stage: Stage) = {
    val text = new Text(25, 25, "Hello World")
    text.setFont(new Font(30))
    val scene = new Scene(new Group(text))
    stage.setTitle("Hello World")
    stage.setScene(scene)
    stage.sizeToScene
    stage.show
  }
}

object HelloWorldJFX {
  def main(args: Array[String]) = Application.launch(classOf[HelloWorldJFX], args:_*)
}
// vim: set ts=2 sw=2 et:
