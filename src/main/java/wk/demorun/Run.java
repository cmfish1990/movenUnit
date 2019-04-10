

package wk.demorun;

public class Run {

    public static void main(String[] args) {
        Father f =getClassReturn();
    }

    public static  Son getClassReturn(){
        return new Son();
    }
}
