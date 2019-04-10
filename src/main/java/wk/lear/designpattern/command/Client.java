/*
 * cf
 * FileName: Client.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.command;
//请求者
public class Client {
	Command command;
	public Client setCommand(Command command){
		this.command = command;
		return this;
	}
	public void executeCommand(String name) throws Exception{
		if(command==null)
			throw new Exception("命令不能为空！");
		command.execute(name);
	}
}
