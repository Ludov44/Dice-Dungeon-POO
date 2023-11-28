package Item;

import Entity.Avatar;

public class Equippable implements Item {
    private int value;
    private int bonus;
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void unuse(Avatar player) {
        // TODO
    }

    @Override
    public void use(Avatar player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
    
}
