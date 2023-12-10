package Item;

import Entity.Avatar;

public interface Item {
    public void use(Avatar player);

    public int getPrice();

    public String getName();

    public int getItemType();

    public Object clone();
}
