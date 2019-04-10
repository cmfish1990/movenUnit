/*
 * cf
 * FileName: CommandCreate.java
 * Author:   BM
 * Date:     2019-03-11 17:01:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:48> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.command;
//新建文件命令
public class CommandCreate implements Command {
	MakeFile makeFile;
	public CommandCreate(MakeFile makeFile) {
		this.makeFile = makeFile;
	}
	@Override
	public void execute(String name) throws Exception {
		makeFile.createFile(name);
	}
}
