import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现文件的拷贝
 */
public class CopyFile2 {

    /**
     * 复制目录
     * @param fromDir
     * @throws IOException
     */
    public static void copyDir(String fromDir) throws IOException{
        //创建目录的File对象
        File dirSouce = new File(fromDir);
        //判断源目录是不是一个目录
        if (!dirSouce.isDirectory()) {
            //如果不是目录那就不复制
            return;
        }
        //获取源目录下的File对象列表
        File[]files = dirSouce.listFiles();
        for (File file : files) {
            //拼接新的fromDir(fromFile)和toDir(toFile)的路径
            String strFrom = fromDir + File.separator + file.getName();
            //判断File对象是目录还是文件
            //判断是否是目录
            if (file.isDirectory()) {
                //递归调用复制目录的方法
                copyDir(strFrom);
            }
            //判断是否是文件
            if (file.isFile()) {
                //递归调用复制文件的方法
                copyFile(strFrom);
            }
        }
    }
    /**
     * 复制文件
     * @param fromFile
     * @throws IOException
     */
    public static void copyFile(String fromFile) throws IOException {


        Map<String, String> map = new HashMap<>();
        File file = new File(fromFile);



        if (file.getName().endsWith(".java")) {
            File tempFile  = new File(fromFile+".txt");
            if(tempFile.exists()){
                tempFile.delete();
            }
            tempFile.createNewFile();
            FileOutputStream fos=new FileOutputStream(tempFile);
            OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter  bw=new BufferedWriter(osw);

            BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
            String s = null;
            boolean isNext = false;

            String tempKey = "";

            while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
                // view bindView的id
                if (s.contains("@BindView")) {
                    String str = s.substring(s.lastIndexOf(".") + 1, s.length() - 1);
                    bw.write("//"+s+"\n");
                    tempKey = str;
                    isNext = true;
                    continue;
                }

                if (isNext) {
                    //view 本地名称
                    String str = s.substring(s.lastIndexOf(" "), s.length() - 1);

                    map.put(tempKey, str);

                    isNext = false;
                } else {
                    if (s.contains("public") && s.contains("void") && s.contains("initView()") && s.contains("{")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s);
                        sb.append("\n");
                        for (String key : map.keySet()) {
                            //btn_xx = findViewById(R.id.xx)
                            sb.append("        ");
                            sb.append(map.get(key));
                            sb.append(" = ");
                            sb.append("findViewById(R.id.");
                            sb.append(key);
                            sb.append(");");
                            sb.append("\n");
                        }
//                        System.out.println(sb.toString());
                        bw.write(sb.toString());
                    } else if (s.contains("import") && s.contains(".R2")) {
//                        import com.sskj.mine.R2;
                        bw.write("//" + s + "\n");
                    } else if (s.contains("butterknife")){
//                        import butterknife.BindView;
                        bw.write("//" + s + "\n");
                    }else{
                            bw.write(s+"\n");
                        }
                    }
            }
            br.close();
            bw.close();
            osw.close();
            fos.close();


            file.delete();
            if(tempFile.renameTo(new File(fromFile))){
                System.out.println("成功");
            }else{
                System.out.println("失败");
            }
            tempFile.delete();


        }else{
           //不是java文件不用管
            return;
        }






    }


    // 使用示例
    public static void main(String[] args) {

        String rootPath ="D:\\temp";

        boolean isFile = false;

        if(isFile){
            String resource =rootPath+"\\a.java";

            try {
                copyFile(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
//            String resource = rootPath+"\\dbex_android";
            String resource ="D:\\work\\temp\\dbex_android";

            try {
                copyDir(resource);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
