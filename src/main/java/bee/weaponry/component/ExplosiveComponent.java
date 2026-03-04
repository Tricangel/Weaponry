package bee.weaponry.component;

import bee.weaponry.registry.ModEntityComponents;
import bee.weaponry.registry.ModSounds;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

import java.util.Random;

public class ExplosiveComponent implements AutoSyncedComponent, CommonTickingComponent {

    private final LivingEntity livingEntity;

    public ExplosiveComponent(LivingEntity entity) {
        this.livingEntity = entity;
    }
    private int explosiveTimer = 0;

    public int getValue() {
        return explosiveTimer;
    }

    public void setValue(int value) {
        explosiveTimer = value;
    }


    @Override
    public void readData(ValueInput valueInput) {
        this.explosiveTimer = valueInput.getIntOr("explosiveTimer", 0);
    }

    @Override
    public void writeData(ValueOutput valueOutput) {
        valueOutput.putInt("explosiveTimer", explosiveTimer);
    }

    @Override
    public void tick() {
        if (getValue() != 0 && getValue() % 10 == 0 && livingEntity.level().isClientSide()) {
            if (livingEntity.isAlive() && livingEntity instanceof Player player) {
                ClientLevel level = (ClientLevel) livingEntity.level();
                level.playLocalSound(livingEntity, ModSounds.BOMB_TICK, SoundSource.PLAYERS, 1, new Random().nextFloat(0.8f, 1.2f));
            }
        }
        if (!livingEntity.level().isClientSide()) {
            if (getValue() == 1 && livingEntity.isAlive()) {
                livingEntity.hurtServer((ServerLevel) livingEntity.level(), livingEntity.damageSources().outOfBorder(), ModEntityComponents.AMOUNT_OF_EXPLOSIVES.get(livingEntity).getValue() * 2 + 1);
                livingEntity.level().playSound(null, livingEntity.getOnPos(), ModSounds.BOMB_EXPLODE, SoundSource.PLAYERS, 1000, 0.8f);
                setValue(0);
                ModEntityComponents.AMOUNT_OF_EXPLOSIVES.get(livingEntity).setValue(0);
            } else if (getValue() > 0) {
                setValue(getValue() - 1);
            }
            sync();
        }

    }

    public void sync() {
        ModEntityComponents.EXPLODETIMER.sync(livingEntity);
    }

}
