package com.esm.nightmare.MobBehavs;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.esm.nightmare.ESMConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class MobDamageBlock {
	public static final String Block_Blacklist = ESMConfig.BlocksEntitiesCannotDigThrough.get().toLowerCase();    
    
	private static final Logger LOGGER = LogManager.getLogger();
	//https://forums.minecraftforge.net/topic/108086-1181-preferred-way-of-programatically-breaking-blocks/
	//Cause entity to destroy a block
	public MobDamageBlock(Entity Entity_Class, Block Curr_Block, BlockPos Block_Pos)
	{
		String Block_Name = Curr_Block.getName().getString(); //Block Curr_Block
		//String Block_Name2 = Curr_Block.getBlock().toString();
		LOGGER.info("Mob is looking at: "+ Block_Name);
		//Can this block be broken?
		boolean isExcluded = isExcludedBlock(Block_Name);
		
		//If block can be broken
		if(!isExcluded)
		{
			Entity_Class.level().destroyBlock(Block_Pos, true);
		}
		
	}	
	
	//Is the given comparison material contains in the material allow list?
	boolean isExcludedBlock(String ComparisonBlockName)
	{
		return Block_Blacklist.contains(ComparisonBlockName.toLowerCase());
	}
}
