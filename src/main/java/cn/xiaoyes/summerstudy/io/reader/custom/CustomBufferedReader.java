package cn.xiaoyes.summerstudy.io.reader.custom;

/**
 * 处理流(包装流)
 */
public class CustomBufferedReader extends CustomReader{

    private CustomReader reader;

    public CustomBufferedReader(CustomReader reader) {
        this.reader = reader;
    }

    /**
     * 扩展功能
     * @param num
     */
    public void readFile(int num) {
        for (int i = 0; i < num; i++) {
            reader.readFile();
        }
    }


    public void readString(int num){
        for (int i = 0; i < num; i++) {
            reader.readString();
        }
    }
}
