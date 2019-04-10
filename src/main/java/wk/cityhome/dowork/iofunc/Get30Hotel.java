

package wk.cityhome.dowork.iofunc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Get30Hotel {
    public static void main(String args[]){

        String [] fileName = getFileName("F:\\dopicture");
        Map myMap=getRoomMNameMap();
        for(String name:fileName) {
            //
            String path="F:\\dopicture" + "\\" + name;
            String[] fileNamesub = getFileName(path);

            for (String subname : fileNamesub) {
                String subFile = path + "\\" + subname;
                File toBeRenamed = new File(subFile);
                toBeRenamed.renameTo(new File(path+"\\"+myMap.get(subname)+"_"+subname));
                System.out.println(subFile+"_"+myMap.get(subname));
            }

        }
    }


    public static void movePicture(){
        Map myMap=getMap();
        String oldpath="F:\\roommodel";
        String newpath="F:\\needroommodelpicture";
        String [] fileName = getFileName("F:\\roommodel");

        int count=0;
        for(String name:fileName)
        {

            if(myMap.get(name)!=null){
                System.out.println(name);

                CopyDirectory.copy(oldpath +"\\"+name,newpath+"\\"+myMap.get(name)+"_"+name);
                count++;
            }
        }
        System.out.println("--------------"+count+"------------------");
    }

    public static String [] getFileName(String path)
    {
        File file = new File(path);
        String [] fileName = file.list();
        return fileName;
    }
    public static void getAllFileName(String path,ArrayList<String> fileName)
    {
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
        if(names != null)
            fileName.addAll(Arrays.asList(names));
        for(File a:files)
        {
            if(a.isDirectory())
            {
                getAllFileName(a.getAbsolutePath(),fileName);
            }
        }
    }
    public static Map getMap(){
        Map myMap=new HashMap();
        myMap.put("H986","H330436");
        myMap.put("H1515","H330443");
        myMap.put("H1523","H330446");
        myMap.put("H1287","H222616");
        myMap.put("H1008","H330269");
        myMap.put("H1014","H330273");
        myMap.put("H1472","H330429");
        myMap.put("H1633","H330433");
        myMap.put("H1636","H333000");
        myMap.put("H1637","H333004");
        myMap.put("H699","H333007");
        myMap.put("H1497","H333008");
        myMap.put("H1638","H333011");
        myMap.put("H686","H333016");
        myMap.put("H306","H333017");
        myMap.put("H310","H333021");
        myMap.put("H1487","H333027");
        myMap.put("H1481","H333028");
        myMap.put("H280","H333034");
        myMap.put("H1503","H333044");
        myMap.put("H783","H333066");
        myMap.put("H776","H333073");
        myMap.put("H1522","H333075");
        myMap.put("H1111","H333076");
        myMap.put("H1141","H333081");
        myMap.put("H970","H333084");
        myMap.put("H1277","H333091");
        myMap.put("H1635","H333312");
        myMap.put("H779","H333313");
        myMap.put("H1512","H333314");



        return myMap;




    }
    public static Map getRoomMNameMap(){
        Map myMap=new HashMap();
        myMap.put("R1427","舒适大床房");
        myMap.put("R1428","豪华标准间");
        myMap.put("R1429","浪漫圆床房");
        myMap.put("R1430","日式榻榻米");
        myMap.put("R1537","家庭房");
        myMap.put("R1538","榻榻米");
        myMap.put("R1539","大床房");
        myMap.put("R1552","特价大床房");
        myMap.put("R1553","特价双床房");
        myMap.put("R1554","浪漫圆床房");
        myMap.put("R1555","舒适标准间");
        myMap.put("R3386","豪华大床房");
        myMap.put("R3387","豪华标间");
        myMap.put("R3388","桃花源");
        myMap.put("R3437","豪华大床房");
        myMap.put("R3438","豪华标准房");
        myMap.put("R3439","圆床房");
        myMap.put("R3835","淑离精致临院房");
        myMap.put("R3836","绎心精致临院房");
        myMap.put("R3837","既明精致临院房");
        myMap.put("R3838","令仪私享庭院房");
        myMap.put("R3839","徽音私享露台房");
        myMap.put("R3840","渥丹私享庭院SPA浴缸套房");
        myMap.put("R3841","管彤私享露台套房");
        myMap.put("R3851","精致阁楼榻榻米房");
        myMap.put("R3852","上下铺双人房");
        myMap.put("R3853","复式大床房");
        myMap.put("R3854","浪漫圆床房");
        myMap.put("R3867","特惠房");
        myMap.put("R3868","普通大床房");
        myMap.put("R3869","舒适标准间");
        myMap.put("R3870","欧式大床房");
        myMap.put("R3871","浪漫圆床房");
        myMap.put("R4959","轻奢体验房");
        myMap.put("R4960","轻奢园景房");
        myMap.put("R4961","好友欢享房");
        myMap.put("R4962","豪华园景房");
        myMap.put("R4963","行政房(阳台浴缸)");
        myMap.put("R5043","芰荷香房");
        myMap.put("R5044","御景阁房");
        myMap.put("R5045","满庭芳房");
        myMap.put("R5046","忆江南房");
        myMap.put("R5047","蝶恋花房");
        myMap.put("R5048","聚宝阁房");
        myMap.put("R5049","漱芳斋房");
        myMap.put("R5164","大床房");
        myMap.put("R5188","大床房");
        myMap.put("R5189","家庭房");
        myMap.put("R5675","泉吟私享花园复式房");
        myMap.put("R5676","星语私享花园复式房");
        myMap.put("R5677","素年私享花园复式房");
        myMap.put("R5678","品月私享阳台复式房");
        myMap.put("R5679","隐竹私享花园大床房");
        myMap.put("R5680","水岸私享花园大床房");
        myMap.put("R5681","寻篱私享花园大床房");
        myMap.put("R5682","风颂私享阳台复式房");
        myMap.put("R5683","云歌豪华家庭房");
        myMap.put("R5684","听雨私享花园家庭房");
        myMap.put("R5685","栖霞私享露台家庭房");
        myMap.put("R5828","朱阁精致大床房");
        myMap.put("R5829","琼木精致庭院大床房");
        myMap.put("R5830","拂风精致庭院圆床房");
        myMap.put("R5831","疏影精致大床房");
        myMap.put("R5832","帘雨精致庭院大床房");
        myMap.put("R5833","朝花私享花园复式大床房");
        myMap.put("R5834","晚云私享花园复式大床房");
        myMap.put("R5835","静水临河复式大床房");
        myMap.put("R5836","暮雪临河复式大床房");
        myMap.put("R5837","媛月奢华私享花园复式大床房");
        myMap.put("R6777","古韵紫林大床房");
        myMap.put("R6778","古韵西月复式庭院阳台房");
        myMap.put("R6779","古韵东旭复式庭院阳台房");
        myMap.put("R6780","古韵私亨别院复式庭院阳台房");
        myMap.put("R6781","古韵般若复式套房");
        myMap.put("R6833","精致阁楼榻榻米房");
        myMap.put("R6834","舒适大床房");
        myMap.put("R6835","舒适标准间");
        myMap.put("R6836","浪漫圆床房");
        myMap.put("R7928","大床房");
        myMap.put("R7929","豪华大床房");
        myMap.put("R7930","豪华精致大床房");
        myMap.put("R7931","精致大床房");
        myMap.put("R7932","豪华大床套房");
        myMap.put("R7933","庭院大床房");
        myMap.put("R7990","在一起");
        myMap.put("R7991","雕花大床房");
        myMap.put("R7992","格桑花复式-鹊桥相会");
        myMap.put("R7993","东南亚套房—妲己惑纣");
        myMap.put("R7994","地中海-鸳鸯戏水");
        myMap.put("R8022","花隐(豪华大床房)");
        myMap.put("R8023","花事(临河豪华大床房)");
        myMap.put("R8024","花语(临河复式阁楼房)");
        myMap.put("R8025","花房(临院豪华套房)");
        myMap.put("R8026","花迹(临河豪华复式套房)");
        myMap.put("R8076","月之宴(套房)");
        myMap.put("R8077","阳光雨露(套房)");
        myMap.put("R8078","花好月圆(套房)");
        myMap.put("R8079","空中竹园(独立阳台)");
        myMap.put("R8080","花前月下");
        myMap.put("R8081","夕阳夕下");
        myMap.put("R8082","月之蓝(家庭房)");
        myMap.put("R8083","春暖花开");
        myMap.put("R8084","天上人房");
        myMap.put("R8085","墨书风云(豪华标准间)");
        myMap.put("R8086","月之阁");
        myMap.put("R8087","星之阁");
        myMap.put("R8088","夕阳如丹");
        myMap.put("R8089","落日余晖(特大床)");
        myMap.put("R8090","粉色桃源(大床房)");
        myMap.put("R8091","金风玉露");
        myMap.put("R8109","后院房");
        myMap.put("R8110","西厢房");
        myMap.put("R8111","上房");
        myMap.put("R8112","东厢房");
        myMap.put("R8113","望月房");
        myMap.put("R8114","望桥房");
        myMap.put("R8115","雅舍房");
        myMap.put("R8165","澹雅（标准间）");
        myMap.put("R8166","涵畅（一楼大床）");
        myMap.put("R8167","浩初（二楼家庭房）");
        myMap.put("R8168","雅淳（阳台大床）");
        myMap.put("R8169","澄泓（一楼大床）");
        myMap.put("R8170","淑离（复式房）");
        myMap.put("R8181","水晶宫");
        myMap.put("R8182","精品大床房");
        myMap.put("R8183","百鸟岩");
        myMap.put("R8184","精品大标间");
        myMap.put("R8185","复式大床间");
        myMap.put("R8186","百魔洞");
        myMap.put("R8187","现代大床房");
        myMap.put("R8188","麻将套房");
        myMap.put("R8236","彼岸花开");
        myMap.put("R8237","浪漫满屋");
        myMap.put("R8238","花好月圆");
        myMap.put("R8239","爱在西塘");
        myMap.put("R8240","今生有约");
        myMap.put("R8241","姹紫嫣红");
        myMap.put("R8242","沁园初心豪华大床房");
        myMap.put("R8243","沁园南轩日式榻榻米豪华大床房");
        myMap.put("R8244","凤鸾私语豪华大床房");
        myMap.put("R8245","沁园印象复式套房");
        myMap.put("R8246","花开畔夏私享阳台复式大床房");
        myMap.put("R8247","御园倾城御园倾城私享阳台复式大床房");
        myMap.put("R8248","觅觅花语私享阳台独栋别院");
        myMap.put("R8249","水晶之恋");
        myMap.put("R8250","一帘");
        myMap.put("R8251","幽梦");
        myMap.put("R8252","风情");
        myMap.put("R8253","倾城之恋");
        myMap.put("R8254","初雪");
        myMap.put("R8255","流年");
        myMap.put("R8256","回忆");
        myMap.put("R8257","初见（豪华套房）");
        myMap.put("R8258","怀念（复式房）");
        myMap.put("R8259","倾心");
        myMap.put("R8664","荷塘月色房");
        myMap.put("R8665","万紫千红房");
        myMap.put("R8666","一帆风顺房");
        myMap.put("R8667","出水芙蓉房");
        myMap.put("R8668","倾国倾城房");
        myMap.put("R8669","一米阳光房");
        myMap.put("R8670","春色满园房");
        myMap.put("R8671","花开半夏大床房");
        myMap.put("R8672","陌上花开临河大床房");
        myMap.put("R8673","地中海别院房");
        myMap.put("R8674","欧式别院房");
        myMap.put("R8675","美式别院房");
        myMap.put("R8680","舒适标准间");
        myMap.put("R8681","普通大床房");
        myMap.put("R8682","豪华圆床房");
        myMap.put("R8683","阳台豪华大床房");
        myMap.put("R8684","临河复式大床");
        myMap.put("R8685","复式双床房");
        myMap.put("R8686","豪华大床房");
        myMap.put("R8687","豪华套房");
        myMap.put("R8688","亲情家庭房");
        myMap.put("R8689","豪华圆床房");
        myMap.put("R8690","满庭芳豪华浴缸大床房");
        myMap.put("R8691","精致单人房");
        myMap.put("R8692","高级标准间");
        myMap.put("R8693","豪华大床房");
        myMap.put("R8694","榻榻米");
        myMap.put("R8695","家庭亲子房");
        myMap.put("R8696","豪华圆床房");
        myMap.put("R8697","特色圆床房");
        myMap.put("R8698","高级大床套房");
        myMap.put("R8699","高级标间");
        myMap.put("R8700","特色标准房");
        myMap.put("R8701","小南楼");
        myMap.put("R8702","东厢出尘房");
        myMap.put("R8703","若水房");
        myMap.put("R8704","浪漫之旅房");
        myMap.put("R8705","王与后房");
        myMap.put("R8706","欧郡家庭房");
        myMap.put("R8707","Hellokitty主题标准间");
        myMap.put("R8708","飞屋环游记房");
        myMap.put("R8709","霓裳");
        myMap.put("R8710","君遇");
        myMap.put("R8711","灵犀");
        myMap.put("R8712","豪华大床房");
        myMap.put("R8713","蒸汽时代房");
        myMap.put("R8714","帝胄房");
        myMap.put("R8715","唯美俏佳人房");

        return myMap;

    }
}
