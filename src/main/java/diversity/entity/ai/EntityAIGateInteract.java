// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity.ai;

import diversity.entity.EntityGlobalVillager;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.entity.ai.EntityAIDoorInteract;

public abstract class EntityAIGateInteract extends EntityAIDoorInteract
{
    protected BlockFenceGate field_151504_e;
    boolean hasStoppedDoorInteraction;
    float entityPositionX;
    float entityPositionZ;
    
    public EntityAIGateInteract(final EntityLiving p_i1621_1_) {
        super(p_i1621_1_);
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theEntity.isCollidedHorizontally) {
            return false;
        }
        final PathNavigate pathnavigate = this.theEntity.getNavigator();
        final PathEntity pathentity = pathnavigate.getPath();
        if (pathentity != null && !pathentity.isFinished() && pathnavigate.getCanBreakDoors()) {
            for (int i = 0; i < Math.min(pathentity.getCurrentPathIndex() + 2, pathentity.getCurrentPathLength()); ++i) {
                final PathPoint pathpoint = pathentity.getPathPointFromIndex(i);
                this.entityPosX = pathpoint.xCoord;
                this.entityPosY = pathpoint.yCoord + 1;
                this.entityPosZ = pathpoint.zCoord;
                if (this.theEntity.getDistanceSq((double)this.entityPosX, this.theEntity.posY, (double)this.entityPosZ) <= 2.25) {
                    this.field_151504_e = this.func_151503_a(this.entityPosX, this.entityPosY, this.entityPosZ);
                    if (this.field_151504_e != null) {
                        return true;
                    }
                }
            }
            this.entityPosX = MathHelper.floor_double(this.theEntity.posX);
            this.entityPosY = MathHelper.floor_double(this.theEntity.posY + 1.0);
            this.entityPosZ = MathHelper.floor_double(this.theEntity.posZ);
            this.field_151504_e = this.func_151503_a(this.entityPosX, this.entityPosY, this.entityPosZ);
            return this.field_151504_e != null;
        }
        return false;
    }
    
    private BlockFenceGate func_151503_a(final int p_151503_1_, final int p_151503_2_, final int p_151503_3_) {
        final Block block = this.theEntity.worldObj.getBlock(p_151503_1_, p_151503_2_, p_151503_3_);
        return (block != Blocks.fence_gate) ? null : ((BlockFenceGate)block);
    }
    
    protected boolean onGateActivated(final World p_149727_1_, final int p_149727_2_, final int p_149727_3_, final int p_149727_4_, final EntityGlobalVillager p_149727_5_, final BlockFenceGate gate) {
        int i1 = p_149727_1_.getBlockMetadata(p_149727_2_, p_149727_3_, p_149727_4_);
        if (BlockFenceGate.isFenceGateOpen(i1)) {
            p_149727_1_.setBlockMetadataWithNotify(p_149727_2_, p_149727_3_, p_149727_4_, i1 & 0xFFFFFFFB, 2);
        }
        else {
            final int j1 = (MathHelper.floor_double(p_149727_5_.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3) % 4;
            final int k1 = BlockFenceGate.getDirection(i1);
            if (k1 == (j1 + 2) % 4) {
                i1 = j1;
            }
            p_149727_1_.setBlockMetadataWithNotify(p_149727_2_, p_149727_3_, p_149727_4_, i1 | 0x4, 2);
        }
        return true;
    }
}
