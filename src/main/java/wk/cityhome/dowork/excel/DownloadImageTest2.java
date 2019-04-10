/*
 * Copyright (C),2015-2019.
 * FileName: DownloadImageTest2.java
 * Author:   BM
 * Date:     2019-03-28 10:27:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-28 10:27:13> <version> <desc> <source>
 *
 */

package wk.cityhome.dowork.excel;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class DownloadImageTest2 {

    public static void main(String[] args) throws Exception {
        char dirName = 'A';
        int dirSize = 300;
        List<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(new File("e:/民宿图片.txt"));
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        scanner.close();

        Iterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (dirSize > 0) {
                File file = new File("e:/imgs/" + dirName);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            String urlStr = iterator.next();
            String imageName = urlStr.substring(urlStr.lastIndexOf("/") + 1);
            URL url = new URL(urlStr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            InputStream inputStream = urlConnection.getInputStream();
//            BufferedInputStream bis = new BufferedInputStream(inputStream);
            FileOutputStream imageOutputStream = new FileOutputStream("e:/imgs/" + dirName + "/" + imageName);
//            BufferedOutputStream bos = new BufferedOutputStream(imageOutputStream);
            int r = -1;
            while ((r = inputStream.read()) != -1) {
                imageOutputStream.write(r);
            }
//            bos.flush();
//            bos.close();
//            bis.close();
            imageOutputStream.flush();
            imageOutputStream.close();
            inputStream.close();
            System.out.println("downloading " + urlStr + " --> " + dirName + "/" + imageName);
            iterator.remove();
            writeToFile(list);
            if (dirSize == 0) {
                dirName += 1;
                dirSize = 300;
                continue;
            }
        }
    }

    public static void writeToFile(List<String> list) throws Exception {
        FileWriter writer = new FileWriter(new File("e:/剩余的地址.txt"));
        for (String url : list) {
            writer.append(url).append("\n");
        }
        writer.flush();
        writer.close();
    }

}
