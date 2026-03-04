package bee.weaponry.component;

import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.ladysnake.cca.api.v3.component.Component;

public class AmountOfExplosivesComponent implements Component {


    public AmountOfExplosivesComponent() {
    }
    private int amount = 0;

    public int getValue() {
        return amount;
    }

    public void setValue(int value) {
        amount = value;
    }


    @Override
    public void readData(ValueInput valueInput) {
        this.amount = valueInput.getIntOr("amount_of_explosives", 0);
    }

    @Override
    public void writeData(ValueOutput valueOutput) {
        valueOutput.putInt("amount_of_explosives", amount);
    }


}
