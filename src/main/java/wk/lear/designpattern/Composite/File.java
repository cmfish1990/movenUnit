/*
 * cf
 * FileName: File.java
 * Author:   BM
 * Date:     2019-03-11 17:01:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:48> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.Composite;

import java.util.Iterator;
import java.util.List;

//Leaf节点
public class File implements Component{
	private String name;
	public File(String name){
		this.name = name;
	}
	@Override
	public void addFile(Component file) {}
	@Override
	public Component addFolder(Component folder) { return null; }
	@Override
	public void removeFile(Component file) {}
	@Override
	public void removeFolder(Component folder) {}
	@Override
	public List<Component> getFiles() { return null; }
	@Override
	public List<Component> getFolders() { return null; }
	@Override
	public List<Component> getAll() { return null; }
	@Override
	public Iterator<Component> iterator() { return null; }
	@Override
	public void display() {
		System.out.println(name);
	}
}
