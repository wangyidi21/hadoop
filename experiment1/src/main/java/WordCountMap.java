import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
public class WordCountMap extends Mapper<LongWritable, Text,Text,LongWritable> {
    //第一个参数 LongWritable 是map的输入的 key（数据类型固定，偏移量）
    //第二个参数 Text是map的输入的 value（数据类型固定，输入的文档）
    //第三个参数 Text是map的输出的 key（数据类型可变，根据需求而变）
    //第四个参数 LongWritable 是map的输出的 value（数据类型可变，根据需求而变）

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //key 是行首字母的偏移量
        //      偏移量：每个字符移动到当前文档的最前面需要移动的字符个数（空格和回车也要算）
        //value 代码中一行数据

        //1.将 Text 类型的 value 转化为 string
        String data = value.toString();
        //2.使用“ ”对数据切分
        String[] strings = data.split(" ");
        //3.遍历每个单词，进行输出（一个单词输出一次）
        for (String string : strings) {
            //输出数据
            //context 上下文对象
            //根据业务需求进行切分，逐一输出
            context.write(new Text(string),new LongWritable(1));
        }
    }
}
