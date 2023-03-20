package me.xiaozhangup.hygen.inv;

public class InvHelper {

    public static int slotFrom(int x, int y) {
        return x - 1 + (9 * (y - 1));
    }
    //xy:1,2,3,4,5,6,7,8,9
    //: 1
    //: 2
    //: 3
    //: 4
    //: 5
    //: 6

}
