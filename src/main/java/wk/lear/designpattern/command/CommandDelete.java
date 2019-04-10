/*
 * cf
 * FileName: CommandDelete.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.command;
//删文件命令
public class CommandDelete implements Command{
	MakeFile makeFile;
	public CommandDelete(MakeFile makeFile) {
		this.makeFile = makeFile;
	}
	@Override
	public void execute(String name) throws Exception {
		makeFile.deleteFile(name);
	}
}
