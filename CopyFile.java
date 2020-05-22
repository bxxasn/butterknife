import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * ʵ���ļ��Ŀ���
 */
public class CopyFile {

    /**
     * ����Ŀ¼
     * @param fromDir
     * @param toDir
     * @throws IOException
     */
    public static void copyDir(String fromDir,String toDir) throws IOException{
        //����Ŀ¼��File����
        File dirSouce = new File(fromDir);
        //�ж�ԴĿ¼�ǲ���һ��Ŀ¼
        if (!dirSouce.isDirectory()) {
            //�������Ŀ¼�ǾͲ�����
            return;
        }
        //����Ŀ��Ŀ¼��File����
        File destDir = new File(toDir);
        //���Ŀ��Ŀ¼������
        if(!destDir.exists()){
            //����Ŀ��Ŀ¼
            destDir.mkdir();
        }
        //��ȡԴĿ¼�µ�File�����б�
        File[]files = dirSouce.listFiles();
        for (File file : files) {
            //ƴ���µ�fromDir(fromFile)��toDir(toFile)��·��
            String strFrom = fromDir + File.separator + file.getName();
            String strTo = toDir + File.separator + file.getName();
            //�ж�File������Ŀ¼�����ļ�
            //�ж��Ƿ���Ŀ¼
            if (file.isDirectory()) {
                //�ݹ���ø���Ŀ¼�ķ���
                copyDir(strFrom,strTo);
            }
            //�ж��Ƿ����ļ�
            if (file.isFile()) {
                //�ݹ���ø����ļ��ķ���
                copyFile(strFrom,strTo);
            }
        }
    }
    /**
     * �����ļ�
     * @param fromFile
     * @param toFile
     * @throws IOException
     */
    public static void copyFile(String fromFile,String toFile) throws IOException {


        Map<String, String> map = new HashMap<>();
        File file = new File(fromFile);
        if (file.getName().endsWith(".java")) {

            FileOutputStream fos=new FileOutputStream(new File(toFile));
            OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter  bw=new BufferedWriter(osw);

            BufferedReader br = new BufferedReader(new FileReader(file));// ����һ��BufferedReader������ȡ�ļ�
            String s = null;
            boolean isNext = false;

            String tempKey = "";

            while ((s = br.readLine()) != null) {// ʹ��readLine������һ�ζ�һ��
                // view bindView��id
                if (s.contains("@BindView")) {
                    String str = s.substring(s.lastIndexOf(".") + 1, s.length() - 1);
                    bw.write("//"+s+"\n");
                    tempKey = str;
                    isNext = true;
                    continue;
                }

                if (isNext) {
                    //view ��������
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
        }else{
            //�ֽ�������������ȡ�ļ�
            FileInputStream in = new FileInputStream(fromFile);
            //�ֽ����������д���ļ�
            FileOutputStream out = new FileOutputStream(toFile);
            //�Ѷ�ȡ��������д�����ļ�
            //���ֽ��������ô�һЩ   1*1024*1024=1M
            byte[] bs = new byte[1 * 1024 * 1024];
            int count = 0;
            while ((count = in.read(bs)) != -1) {
                out.write(bs, 0, count);
            }
            //�ر���
            in.close();
            out.flush();
            out.close();
        }
    }


    // ʹ��ʾ��
    public static void main(String[] args) {

        String rootPath ="D:\\temp";

        boolean isFile = true;

        if(isFile){
            String resource =rootPath+"\\BindMobileActivity.java";
            String target = rootPath+"\\BindMobileActivity2.java";

            File targetFile =new File(target);
            if(targetFile.exists()){
                targetFile.delete();
            }else{
//            targetFile.mkdirs();
            }

            try {
                copyFile(resource,target);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            String resource = rootPath+"\\dbex_android";
            String target =rootPath+"\\dex_copy";

            File targetFile =new File(target);
            if(targetFile.exists()){
                targetFile.delete();
            }else{
                targetFile.mkdirs();
            }
            try {
                copyDir(resource, target);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}