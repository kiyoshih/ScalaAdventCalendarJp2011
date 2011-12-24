package sample

import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.{Group, Scene}
import javafx.scene.paint.Color
import javafx.scene.shape.{CubicCurveTo, MoveTo, Path, Rectangle}
import javafx.animation.{Animation, PathTransition}
import javafx.animation.PathTransition.OrientationType
import javafx.event.EventHandler
import javafx.util.Duration

class PathTransitionSample extends Application {

  private lazy val pathTransition = new PathTransition

  private def init(stage: Stage) : Unit = {
    val root = new Group
    stage.setResizable(false)
    stage.setScene(new Scene(root, 400, 260))

    val rect = new Rectangle(0, 0, 40, 40)
    rect.setArcHeight(10)
    rect.setArcWidth(10)
    rect.setFill(Color.ORANGE)
    
    root.getChildren().add(rect)

    val path = new Path
    path.getElements().add(new MoveTo(20, 20))
    path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120))
    path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240))
    path.setStroke(Color.DODGERBLUE)
    path.getStrokeDashArray().setAll(5d, 5d)

    root.getChildren().add(path)

    pathTransition.setDuration(Duration.seconds(4))
    pathTransition.setPath(path)
    pathTransition.setNode(rect)
    pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT)
    pathTransition.setCycleCount(Animation.INDEFINITE)
    pathTransition.setAutoReverse(true)
  }

  private def play = pathTransition play

  override def stop = pathTransition stop

  override def start(stage: Stage): Unit = {
      init(stage)
      stage.show
      play
  }
}

object PathTransitionSample {
  def main(args: Array[String]) = Application.launch(classOf[PathTransitionSample], args: _*)
}
