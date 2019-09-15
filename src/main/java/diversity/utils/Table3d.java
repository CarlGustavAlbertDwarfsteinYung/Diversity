//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.utils;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Table3d extends TreeMap<Integer, Table<Integer, Integer, EnumCubeType>> {
    public Table<Integer, Integer, TreeMap<Integer, EnumCubeType>> mutation = HashBasedTable.create();

    public Table3d() {
    }

    @Override
    public void clear() {
        Iterator var1 = this.keySet().iterator();

        while(var1.hasNext()) {
            Integer y = (Integer)var1.next();
            ((Table)this.get(y)).clear();
        }

        super.clear();
    }

    public boolean containsKey(int x, int y, int z) {
        return this.containsKey(y) && ((Table)this.get(y)).contains(x, z);
    }

    public EnumCubeType get(int x, int y, int z) {
        return this.containsKey(x, y, z) ? (EnumCubeType)((Table)this.get(y)).get(x, z) : null;
    }

    public Set<Integer> rowKeySet(int y) {
        return this.containsKey(y) ? ((Table)this.get(y)).rowKeySet() : null;
    }

    public Set<Integer> columnKeySet(int y) {
        return this.containsKey(y) ? ((Table)this.get(y)).columnKeySet() : null;
    }

    public EnumCubeType put(int x, int y, int z, EnumCubeType cubeType) {
        if (!this.containsKey(y)) {
            Table<Integer, Integer, EnumCubeType> table = HashBasedTable.create();
            this.put(y, table);
        }

        ((Table)this.get(y)).put(x, z, cubeType);
        return cubeType;
    }

    public boolean remove(int x, int y, int z) {
        if (this.containsKey(x, y, z)) {
            ((Table)this.get(y)).remove(x, z);
            return true;
        } else {
            return false;
        }
    }

    public void mutateTable() {
        Iterator var1 = this.keySet().iterator();

        while(var1.hasNext()) {
            Integer y = (Integer)var1.next();
            Iterator var3 = this.rowKeySet(y).iterator();

            while(var3.hasNext()) {
                Integer x = (Integer)var3.next();
                Iterator var5 = this.columnKeySet(y).iterator();

                while(var5.hasNext()) {
                    Integer z = (Integer)var5.next();
                    if (this.mutation.get(x, z) == null) {
                        TreeMap map = new TreeMap();
                        map.put(y, this.get(x, y, z));
                        this.mutation.put(x, z, map);
                    } else {
                        ((TreeMap)this.mutation.get(x, z)).put(y, this.get(x, y, z));
                    }
                }
            }
        }

    }
}
