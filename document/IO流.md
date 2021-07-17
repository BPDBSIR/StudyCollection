# IO流

#### 文件

* 概念

  **什么是文件？**

  文件是保存数据的地方 比如我们经常使用的word文档 txt文件 excel文件...都是文件。它既可以保存一张图片 也可以保存视频 音频等等。

  **文件流**

  文件在程序中是以流的形式来操作的

  Java程序(内存) ------输**出**流------> 文件(磁盘)

  Java程序(内存) <----输**入**流-------- 文件(磁盘)

* 常用操作

  **创建文件**

  常用构造方法:

  ```java
  new File(Stirng pathName);//更具路径构建一个File对象
  new File(File parent,String child);//根据目录文件——子路径构建
  new File(String parent,String child);//根据父目录+子目录构建
  ```

  **获取文件的相关信息**

  getName	获取名称

  getAbsolutePath	绝对路径

  getParent	父级目录

  length	文件大小

  exists	是否存在

  isFile	是否为文件

  isDirectory	是否为文件夹

  **目录操作**

  mkdir	创建一级目录

  mkdirs	创建多级目录

  delete	删除空目录或者文件

  

#### 节点流和处理流

#### 输入流

* InputStream
  * FileInputStream
  * BufferedInputStream
  * ObjectInputStream
* Reader
  * FileReader
  * BufferedReader
  * InputStreamReader

### 输出流

* OutputStream
  * FileOutputStream
  * BufferedOutputStream
  * ObjectOutputStream
* Writer
  * FileWriter
  * BufferedWriter
  * OutputStreamWriter

### Properties

