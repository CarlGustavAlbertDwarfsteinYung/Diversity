// 
// Decompiled by Procyon v0.5.36
// 

package diversity.utils;

public class DirectionTools
{
    public static final int[][] torch;
    public static final int[][] stair;
    public static final int[][] reversed_stairs;
    public static final int[][] log;
    
    static {
        torch = new int[4][4];
        stair = new int[4][4];
        reversed_stairs = new int[4][4];
        log = new int[4][2];
        DirectionTools.torch[0] = new int[] { 2, 1, 3, 4 };
        DirectionTools.torch[1] = new int[] { 4, 3, 2, 1 };
        DirectionTools.torch[2] = new int[] { 2, 1, 4, 3 };
        DirectionTools.torch[3] = new int[] { 4, 3, 1, 2 };
        DirectionTools.stair[0] = new int[] { 0, 1, 3, 2 };
        DirectionTools.stair[1] = new int[] { 2, 3, 0, 1 };
        DirectionTools.stair[2] = new int[] { 0, 1, 2, 3 };
        DirectionTools.stair[3] = new int[] { 2, 3, 1, 0 };
        DirectionTools.reversed_stairs[0] = new int[] { 4, 5, 7, 6 };
        DirectionTools.reversed_stairs[1] = new int[] { 6, 7, 4, 5 };
        DirectionTools.reversed_stairs[2] = new int[] { 4, 5, 6, 7 };
        DirectionTools.reversed_stairs[3] = new int[] { 6, 7, 5, 4 };
        DirectionTools.log[0] = new int[] { 4, 8 };
        DirectionTools.log[1] = new int[] { 8, 4 };
        DirectionTools.log[2] = new int[] { 4, 8 };
        DirectionTools.log[3] = new int[] { 8, 4 };
    }
}
