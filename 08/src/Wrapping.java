// 第８講 ファイルの入出力 ラッピング
// https://ksuap.github.io/2022autumn/lesson08/stream/#ラッピングwrapping
// Inner.java
class Inner {
  void method1() {
    // some operation...
  }
}

// Outer.java
class Outer {
  Inner inner;

  void method2() {
    inner.method1();
  }
}

// Main.java
public class Wrapping {
  void run() {
    Inner inner = new Inner();
    Outer outer = this.wrap(inner);
    outer.method2();
  }

  Outer wrap(Inner inner) {
    Outer outer = new Outer();
    outer.inner = inner;
    return outer;
  }
}
