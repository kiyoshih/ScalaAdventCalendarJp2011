---
layout: default
title: Scala Advent Calendar jp 2011
---

### Hello World ###

*このリポジトリはScala Advent Calendar jp 2011の24日目です。*

* ここでは事前にsbtがインストールされているものとして進めます。
* MacOS X 10.7、sbt0.11で実行しています。

#### JavaFXをインストールします。 ####

* インストーラを以下のページよりダウンロードし、インストールします。
* [JavaFX Downloads](http://javafx.com/downloads/)

#### プロジェクト用のディレクトリにbin,libディレクトリを作成し、JavaFXのランタイムをコピーします。 ####

<div class="span14">
<pre class="prettyprint">
$ cd /path/to/project
$ mkdir lib bin
$ cp /path/to/javafxinstalldir/rt/lib/jfxrt.jar ./lib
$ cp /path/to/javafsinstalldir/rt/bin/* ./bin
</pre>
</div>

* Mavenリポジトリが見つからなかったのと、ネイティブライブラリが必要だったため、アンマネージ依存ライブラリとしています。
* jfxrt.jarが../binのライブラリを参照するため、このようなディレクトリ構成としています。

#### build.sbtを作成します。 ####

<div class="span14">
<pre class="prettyprint">
name := "javafxscala"

version := "1.0"

scalaVersion := "2.9.1"

fork in run := true
</pre>
</div>

* <code>fork in run := true</code>とすることで、runしたときに新しいJVMで起動します。

#### srcディレクトリを作成します。 ####

<div class="span14">
<pre class="prettyprint">
mkdir -p src/main/scala
</pre>
</div>

#### HelloWorld.scalaを作成します。 ####

<div class="span14">
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

* JavaFX 2.0では以前のような宣言的なUIの定義が出来なくなっています。
   * JavaFX Scriptとして別のプロジェクトになっています。
   * ScalaFXを利用するか、自分でラッパーを作る事で宣言的に定義することが可能です。

#### 実行します。 ####

<div class="span14">
<pre class="prettyprint">
$ sbt run
</pre>
</div>

![実行結果](image/helloworld.png)


