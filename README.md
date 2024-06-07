# stcjava
本项目是对the-super-tiny-compiler项目的Java实现。

原项目地址：https://github.com/the-super-tiny-compiler/stc

项目实现了lisp到js的简单编译器，项目十分迷你，代码量不多，适合学习编译原理。

讲解博客：https://www.cnblogs.com/xueweihan/p/16283249.html

感谢the-super-tiny-compiler项目和博客作者。

## 运行
项目jdk版本为21，请确保安装了jdk21及以上版本。


```
git clone https://github.com/xueweihan/stcjava.git
cd stcjava
cd out
java -jar stcjava.jar <input-file> 
```
参数说明：
- input-file：输入文件路径，可以是lisp代码文件（“.lisp”）。
注意：编译后的js文件会输出到和输入文件同一目录下，文件名与输入文件名相同，后缀名为“.js”。


