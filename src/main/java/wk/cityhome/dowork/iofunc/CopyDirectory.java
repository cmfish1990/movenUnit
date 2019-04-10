

package wk.cityhome.dowork.iofunc;

import java.io.*;

public class CopyDirectory {

    public static void copy(String src, String des) {
        File file1=new File(src);
        File[] fs=file1.listFiles();
        File file2=new File(des);
        if(!file2.exists()){
            file2.mkdirs();
        }
        for (File f : fs) {
            if(f.isFile()){
                fileCopy(f.getPath(),des+"\\"+f.getName()); //调用文件拷贝的方法
            }else if(f.isDirectory()){
                copy(f.getPath(),des+"\\"+f.getName());
            }
        }

    }

    /**
     * 文件拷贝的方法
     */
    private static void fileCopy(String src, String des) {

        File srcFile = new File(src);
        File targetFile = new File(des);
        try {
            InputStream in = new FileInputStream(srcFile);
            OutputStream out = new FileOutputStream(targetFile);
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len=in.read(bytes))!=-1)
            {
                out.write(bytes, 0, len);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

