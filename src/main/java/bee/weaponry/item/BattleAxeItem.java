package bee.weaponry.item;

import bee.weaponry.registry.ModEntityComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BattleAxeItem extends Item {

    public BattleAxeItem(Properties properties) {
        super(properties);
    }

    @Override
    public void postHurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        int amount = ModEntityComponents.AMOUNT_OF_EXPLOSIVES.get(target).getValue();
        if (attacker instanceof Player) {

            if (ModEntityComponents.EXPLODETIMER.get(target).getValue() > 0) {
                if (amount < 3) {
                    ModEntityComponents.AMOUNT_OF_EXPLOSIVES.get(target).setValue(amount + 1);
                }
            } else {
                ModEntityComponents.EXPLODETIMER.get(target).setValue(60);
            }

        }

        super.postHurtEnemy(itemStack, target, attacker);
    }


}
