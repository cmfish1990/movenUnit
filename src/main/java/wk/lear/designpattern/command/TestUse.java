/*
 * cf
 * FileName: TestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.command;
public class TestUse {
	public static void main(String args[]) throws Exception{
		//接收者
		MakeFile makeFile = new MakeFile();
		//命令
		CommandCreate create = new CommandCreate(makeFile);
		CommandDelete delete = new CommandDelete(makeFile);
		//请求者
		Client client = new Client();
		//执行命令
		client.setCommand(create).executeCommand("d://test1.txt");
		client.setCommand(create).executeCommand("d://test2.txt");
		client.setCommand(delete).executeCommand("d://test2.txt");
	}
}