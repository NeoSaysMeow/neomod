package net.neo.neomod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.neo.neomod.item.ModItems;

import java.util.Objects;

public class CrystalItem extends Item {
    public CrystalItem(Settings settings){
        super(settings);
    }
    public static final String CRYSTAL_KEY = "Crystal";
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(!entity.world.isClient &&!entity.isDead() && hand == Hand.MAIN_HAND && !Objects.equals(entity.getType(), EntityType.ENDER_DRAGON) &&!Objects.equals(entity.getType(), EntityType.PLAYER)&&!user.getItemCooldownManager().isCoolingDown(this)){
            ItemStack itemStack = user.getStackInHand(hand);
            stack.decrement(1);
            Crystal type = Crystal.byId(entity.getType().toString());
            ItemStack newStack = setCrystalType(new ItemStack(ModItems.FILLED_CRYSTAL), type);
            entity.setRemoved(Entity.RemovalReason.DISCARDED);
            user.getInventory().insertStack(newStack);

            user.sendMessage(Text.of("The mob is " + entity.getType().toString()));
            user.getItemCooldownManager().set(this,50);
        }
        return ActionResult.PASS;
    }

    public static ItemStack setCrystalType(ItemStack stack, Crystal type) {
        Identifier identifier = ModRegistry.CRYSTAL.getId(type);
        stack.getOrCreateNbt().putString(CRYSTAL_KEY, identifier.toString());
        return stack;
    }
}
