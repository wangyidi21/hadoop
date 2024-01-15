

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCountDriver extends Configured implements Tool {
    /**
     * 将自己的 map  Reduce 代码添加到框架中
     */
    @Override
    public int run(String[] strings) throws Exception {
        //1.实例一个 Job
        Job job = Job.getInstance(new Configuration(), "wordCount12");

        //2.设置读取数据的class
        job.setInputFormatClass(TextInputFormat.class);
        //  设置读取数据的路径
        TextInputFormat.addInputPath(job,new Path("E:\\study\\hadoop\\wc\\words.txt"));

        //3.设置map
        job.setMapperClass(WordCountMap.class);
        //  设置map输出的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        //4.设置reduce
        job.setReducerClass(WordCountReduce.class);
        //  设置reduce的输出的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        //5.设置输出数据的class
        job.setOutputFormatClass(TextOutputFormat.class);
        //  设置输出数据的路径
        TextOutputFormat.setOutputPath(job,new Path("E:\\study\\hadoop\\wc\\output"));
        //6.等待代码执行（返回状态码）

        return job.waitForCompletion(true)?0:1;
    }

    public static void main(String[] args) throws Exception {
        //调用执行
        int run = ToolRunner.run(new WordCountDriver(), args);
    }
}

