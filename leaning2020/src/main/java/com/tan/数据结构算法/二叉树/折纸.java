package com.tan.数据结构算法.二叉树;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/17/16:23
 * @Description:
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。 如果从纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
 * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次。 请从上到下打印所有折痕的方向。
 * 例如:N=1时，打印: down N=2时，打印: down down up
 */
public class 折纸 {
    public static void main(String[] args) {
        printAllFolds(3);
    }
    public static  void  printAllFolds(int N){
        printProcess(1,N,true);
    }
    public static void printProcess(int i,int N,boolean down){
        if(i>N){ return;}
        printProcess(i+1,N,true);
        System.out.println(down?"凹":"凸");
        printProcess(i+1,N,false);
    }

}
