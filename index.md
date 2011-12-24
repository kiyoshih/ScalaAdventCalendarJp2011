---
layout: default
title: Scala Advent Calendar jp 2011
---

*このリポジトリはScala Advent Calendar jp 2011の24日目です。*

ここでは事前にsbtがインストールされているものとして進めます。

#### JavaFXをインストールします。 ####

* インストーラを以下のページよりダウンロードし、インストールします。
* [JavaFX Downloads](http://javafx.com/downloads/)

#### プロジェクト用のディレクトリにbin,libディレクトリを作成し、JavaFXのランタイムをコピーします。 ####

<div class="span9">
<pre class="prettyprint">
$ cd /path/to/project
$ mkdir lib bin
$ cp /path/to/javafxinstalldir/rt/lib/jfxrt.jar ./lib
$ cp /path/to/javafsinstalldir/rt/bin/* ./bin
</pre>
</div>

#### build.sbtを作成します。 ####

<div class="span9">
<pre class="prettyprint">
name := "javafxscala"

version := "1.0"

scalaVersion := "2.9.1"

fork in run := true
</pre>
</div>

#### srcディレクトリを作成します。 ####

<div class="span9">
<pre class="prettyprint">
mkdir -p src/main/scala
</pre>
</div>

#### HelloWorld.scalaを作成します。 ####

<div class="span9">
<pre class="prettyprint lang-scala">
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
</pre>
</div>

#### 実行します。 ####

<div class="span9">
<pre class="prettyprint">
$ sbt run
</pre>
</div>

