//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.*;
//
//public class NBClassifier {
//    // "..."应替换为所使用的数据的本地实际目录
//    private static String trainingDataFilePath = ".../training-1000.txt";
//    private static String modelFilePath = ".../parameters-1000.model";
//    private static String testDataFilePath = ".../test-1000.txt";
//
//    public static String[] extractFeatures(String sentence) {
//        /*
//         * 这里实现给定句子中包含的词语的提取，本实验中的句子已经分词，并且词语之间用空格隔开
//         */
//        // Split the sentence into words using whitespace as the delimiter
//
//    }
//
//    public static void train() {
//        HashMap<String, Integer> parameters = new HashMap<String, Integer>();
//
//        /*
//         * 这里实现“类别-特征”对以及“类别”的计数，并以Key、Value的形式保存到Map中
//         */
//
//        saveModel(parameters);
//    }
//
//    private static void saveModel(HashMap<String, Integer> parameters) {
//        Iterator<String> keyIter = parameters.keySet().iterator();
//        BufferedWriter bw = null;
//
//        try {
//            bw = new BufferedWriter(new FileWriter(modelFilePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        while (keyIter.hasNext()) {
//            String key = keyIter.next();
//            int value = parameters.get(key);
//
//            try {
//                bw.append(key + "\t" + value + "\r\n");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            bw.flush();
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static HashMap<String, Integer> parameters = null;
//    private static Set<String> V = null;
//    private static double Nd;
//    private static double sizeOfV;
//
//    public static void loadModel() {
//        V = new HashSet<String>();
//        parameters = new HashMap<String, Integer>();
//
//        try {
//            List<String> parameterData = Files.readAllLines(Paths.get(modelFilePath));
//
//            for (int i = 0; i < parameterData.size(); i++) {
//                String parameter = parameterData.get(i);
//                String key = parameter.substring(0, parameter.indexOf("\t"));
//                Integer value = Integer.parseInt(parameter.substring(parameter.indexOf("\t") + 1));
//
//                parameters.put(key, value);
//
//                if (key.contains("-")) {
//                    String feature = key.substring(key.indexOf("-") + 1);
//
//                    V.add(feature);
//                }
//
//                if (!key.contains("-")) {
//                    Nd += value;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String predict(String sentence) {
//        String[] labels = {"好评", "差评"};
//        String[] features = extractFeatures(sentence);
//
//        double maxProb = Double.NEGATIVE_INFINITY;
//        String prediction = null;
//
//        /*
//         * 这里实现预测模型
//         */
//
//        return prediction;
//    }
//
//    public static void predictAll() {
//        double accuracy = 0.;
//        int amount = 0;
//
//        try {
//            List<String> testData = Files.readAllLines(Paths.get(testDataFilePath));
//
//            for (String instance : testData) {
//                String gold = instance.substring(0, instance.indexOf("\t"));
//                String sentence = instance.substring(instance.indexOf("\t") + 1);
//                String prediction = predict(sentence); // prediction为提交作业时需要按行输出到文件中的结果
//
//                System.out.println("Gold='" + gold + "'\tPrediction='" + prediction + "'");
//
//                if (gold.equals(prediction)) {
//                    accuracy += 1.;
//                }
//
//                amount += 1;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Accuracy = " + accuracy / amount);
//    }
//}
