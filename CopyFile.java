package remove_butterknife;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *在新的文件目录下，去掉Buterknife的R2和BindView
 */
public class CopyFile {

    /**
     * 复制目录
     * @param fromDir
     * @param toDir
     * @throws IOException
     */
    public static void copyDir(String fromDir,String toDir) throws IOException{
        //创建目录的File对象
        File dirSouce = new File(fromDir);
        //判断源目录是不是一个目录
        if (!dirSouce.isDirectory()) {
            //如果不是目录那就不复制
            return;
        }
        //创建目标目录的File对象
        File destDir = new File(toDir);
        //如果目的目录不存在
        if(!destDir.exists()){
            //创建目的目录
            destDir.mkdir();
        }
        //获取源目录下的File对象列表
        File[]files = dirSouce.listFiles();
        for (File file : files) {
            //拼接新的fromDir(fromFile)和toDir(toFile)的路径
            String strFrom = fromDir + File.separator + file.getName();
            String strTo = toDir + File.separator + file.getName();
            //判断File对象是目录还是文件
            //判断是否是目录
            if (file.isDirectory()) {
                //递归调用复制目录的方法
                copyDir(strFrom,strTo);
            }
            //判断是否是文件
            if (file.isFile()) {
                //递归调用复制文件的方法
                copyFile(strFrom,strTo);
            }
        }
    }
    /**
     * 复制文件
     * @param fromFile
     * @param toFile
     * @throws IOException
     */
    public static void copyFile(String fromFile,String toFile) throws IOException {
        
        
            boolean isFragment = false;


        Map<String, String> map = new HashMap<>();
        File file = new File(fromFile);
        if (file.getName().endsWith(".java")) {

            FileOutputStream fos=new FileOutputStream(new File(toFile));
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
                    
//                    System.out.println(str);
                    tempKey = str;
                    isNext = true;
                    continue;
                }

                if (isNext) {
                    //view 本地名称

                    s = s.trim();   
                    String []strs = s.split(" ");
                    System.out.println(strs[0]);
                    System.out.println(strs[1]);
                    System.out.println("-----"+s+"-------");
                     
                    map.put(tempKey, strs[1].substring(0,strs[1].length()-1));
                    //                        bw.write("        ");
                    StringBuilder sb = new StringBuilder();
                    sb.append("        ");
                    sb.append(strs[0]);
                    sb.append(" ");
                    sb.append(strs[1]);
                    sb.append("\n");
                    bw.write(sb.toString());
                          
                    isNext = false;
                } else {
                        if(s.trim().startsWith("public class")) {
                            if(s.contains("fragment") || s.contains("Fragment")) {
                                isFragment = true;
                            }
                             bw.write(s+"\n");
                        }else if (s.contains("public") && s.contains("void") && s.contains("initView()") && s.contains("{")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s);
                        sb.append("\n");
                        for (String key : map.keySet()) {
                            //btn_xx = findViewById(R.id.xx)
                            sb.append("        ");
                            sb.append(map.get(key));
                            sb.append(" = ");
                            if(isFragment) {
                                    sb.append("getView().");
                            }
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
        }else{
            //字节输入流——读取文件
            FileInputStream in = new FileInputStream(fromFile);
            //字节输出流——写入文件
            FileOutputStream out = new FileOutputStream(toFile);
            //把读取到的内容写入新文件
            //把字节数组设置大一些   1*1024*1024=1M
            byte[] bs = new byte[1 * 1024 * 1024];
            int count = 0;
            while ((count = in.read(bs)) != -1) {
                out.write(bs, 0, count);
            }
            //关闭流
            in.close();
            out.flush();
            out.close();
        }
    }


    // 使用示例
//    public static void main(String[] args) {
//
//        String rootPath ="D:\\temp";
//
//        boolean isFile = true;
//
//        if(isFile){
//            String resource =rootPath+"\\BindMobileActivity.java";
//            String target = rootPath+"\\BindMobileActivity2.java";
//
//            File targetFile =new File(target);
//            if(targetFile.exists()){
//                targetFile.delete();
//            }else{
////            targetFile.mkdirs();
//            }
//
//            try {
//                copyFile(resource,target);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }else{
//            String resource = rootPath+"\\dbex_android";
//            String target =rootPath+"\\dex_copy";
//
//            File targetFile =new File(target);
//            if(targetFile.exists()){
//                targetFile.delete();
//            }else{
//                targetFile.mkdirs();
//            }
//            try {
//                copyDir(resource, target);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

}