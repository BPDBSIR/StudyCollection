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

  

#### 什么是IO？

* I/O是Input/Output的缩写，I/O技术是非常实用的技术，用于处理数据传输 如读/写文件 网路通讯等。
* Java程序中，对与数据的输入/输出操作以”流(Stream)“的方式进行。
* java.io包下提供了各种"流"类和接口，用于获取不同种类的数据，并同各种方法输入或者输出数据。

#### 流的分类

* 按操作数据单位不同分为: 字节流(8 bit) 字符流(按字符)
* 按数据流的流向不同分为: 输入流 输出流
* 按流的角色的不同分为: 节点流 处理流/包装流

| 抽象基类 | 字节流       | 字符流 |
| -------- | ------------ | ------ |
| 输入流   | InputStream  | Reader |
| 输出流   | OutputStream | Writer |

* Java的IO流共涉及40多个类 实际上非常规则 都是从如上4个抽象基类派生的
* 由这四个类派生出来的子类名车都是以其父类名作为子类名的后缀

#### 输入流(InputStream Reader)

读取外部数据(磁盘/光盘等储存设备的数据)到程序(内存中)

* InputStream

  ![](images/io_input.png)

  * FileInputStream

    **常用构造**

    ```java
    public FileInputStream(String name);// 文件路径
    public FileInputStream(File file);// 文件对象
    ```

    **常用方法**

    ```java
    int read();// 读取一个字节 返回结果如果为-1则表示读取完毕
    int read(byte b[]);// 读取多个字节并将读取到的数据写入到传入的字节数组内 返回结果为-1表示读取完毕否则为实际读取到的字节数
    int read(byte b[], int off, int len);
    
    void close(); //关闭流
    ```

    

  * BufferedInputStream

  * ObjectInputStream

* Reader

  * FileReader
  * BufferedReader
  * InputStreamReader

#### 输出流(Outputstream Wtiter)

将程序(内存)数据输出到磁盘或者光盘等储存设备中

* OutputStream

  ![](images/io_output.png)

  * FileOutputStream

    **常用构造**

    ```java
    public FileOutputStream(String name);// 文件路径
    public FileOutputStream(String name,boolean append);// 文件路径 为true追加内容
    public FileOutputStream(File file);// 文件对象
    public FileOutputStream(File file,boolean append);// 文件对象 是否追加
    ```

    **常用方法**

    ```java
    void write(int b);// 写出的字节
    void write(byte b[]);// 写出的字节数组
    void write(byte b[], int off, int len);// 字节数组,开始索引,结束索引
    
    void close(); //关闭流
    ```

    

  * BufferedOutputStream

  * ObjectOutputStream

* Writer

  * FileWriter
  * BufferedWriter
  * OutputStreamWriter

### Properties

