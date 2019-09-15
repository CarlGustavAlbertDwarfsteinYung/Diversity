// 
// Decompiled by Procyon v0.5.36
// 

package diversity.cavegen;

import diversity.utils.Table3d;
import diversity.utils.Point;
import java.util.List;
import java.util.Random;

public interface ICaveGenerator
{
    List<Point> getControlPoints(final Random p0, final int p1, final int p2, final int p3);
    
    Table3d getCavePoints(final List<Point> p0, final Random p1);
    
    void generateBlockType(final Random p0, final Table3d p1, final int p2);
}
