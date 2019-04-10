/*
 * cf
 * FileName: TestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:47> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.Composite;
import java.util.Iterator;

public class TestUse {
	public static void main(String args[]){
		Component root = new Folder("root");//根目录
		Component folder1 = new Folder("java");
		Component folder2 = new Folder("c++");
		Component folder3 = new Folder("c#");
		Component file1 = new File("info.txt");
		root.addFolder(folder1).addFolder(folder2).addFolder(folder3).addFile(file1);//添加一级目录
		folder1.addFile(new File("info.java"));
		Iterator<Component> iterator = root.iterator();
		while(iterator.hasNext()){
			Component component = iterator.next();
			if(component instanceof Folder)
				System.out.print("folder：");
			else
				System.out.print("file：");
			component.display();
		}
	}
}