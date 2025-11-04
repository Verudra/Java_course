package practice;

public class EnumSwitchPt1 {
    enum LightColor{red,yellow,green}
    public static void main(String[] args){
        LightColor lc = LightColor.red;
        switch(lc){
            case red:
            System.out.println("red");
            break;
            case yellow:
            System.out.println("yellow");
            break;
            case green:
            System.out.println("green");
            break;
        }
    }
}
