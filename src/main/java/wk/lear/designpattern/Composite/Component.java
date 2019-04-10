/*
 * cf
 * FileName: Component.java
 * Author:   BM
 * Date:     2019-03-11 17:01:49
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:49> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.Composite;
import java.util.Iterator;
import java.util.List;

//抽象组件
public interface Component {
	void addFile(Component file);
	Component addFolder(Component folder);
	void removeFile(Component file);
	void removeFolder(Component folder);
	List<Component> getFiles();
	List<Component> getFolders();
	List<Component> getAll();
	Iterator<Component> iterator();
	void display();
}