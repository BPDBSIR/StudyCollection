package cn.xiaoyes.summerstudy.io.reader.custom;

public class CustomTest {
    public static void main(String[] args) {
        CustomBufferedReader bufferedReader = new CustomBufferedReader(new CustomFileReader());
        bufferedReader.readFile(5);

        CustomBufferedReader bufferedReader2 = new CustomBufferedReader(new CustomStringReader());
        bufferedReader2.readString(5);
    }
}
