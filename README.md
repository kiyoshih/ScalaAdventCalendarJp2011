## Scala Advent Calendar jp 2012 24日目 ##

このリポジトリはScala Advent Calendar jp 2012の24日目です。

### 準備 ###

ここでは事前にsbtがインストールされているものとして進めます。

1. JavaFXをインストールします。
    * インストーラを以下のページよりダウンロードし、インストールします。
    * [JavaFX Downloads](http://javafx.com/downloads/)
1. プロジェクト用のディレクトリにbin,libディレクトリを作成し、JavaFXのランタイムをコピーします。
<pre>
$ cd /path/to/project
$ mkdir lib bin
$ cp /path/to/javafxinstalldir/rt/lib/jfxrt.jar ./lib
$ cp /path/to/javafsinstalldir/rt/bin/* ./bin
</pre>
1. build.sbtを作成します。
<pre>
name := "javafxscala"

version := "1.0"

scalaVersion := "2.9.1"

fork in run := true
</pre>
1. srcディレクトリを作成します。
<pre>
mkdir -p src/main/scala
</pre>
1. HelloWorld.scalaを作成します。
<pre>
mport javafx.application.Application
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
</pre>
1. 実行します。
<pre>
$ sbt run
</pre>

