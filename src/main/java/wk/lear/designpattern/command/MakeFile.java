/*
 * cf
 * FileName: MakeFile.java
 * Author:   BM
 * Date:     2019-03-11 17:01:49
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:49> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.command;
import java.io.File;
import java.io.IOException;

//接收者
public class MakeFile {
	//新建文件
	public void createFile(String name) throws IOException{
		File file = new File(name);
		file.createNewFile();
	}
	//删除文件
	public boolean deleteFile(String name){
		File file = new File(name);
		if(file.exists()&&file.isFile()){
			file.delete();
			return true;
		}
		return false;
	}
}