package io.muic.ssc.zork.item;

public enum ItemType {
    SWORD("sword", WeaponItem.class),
    SHIELD("shield", WeaponItem.class),
    APPLE("apple", FoodItem.class),
    BREAD("bread", FoodItem.class);

    private final String itemName;
    private final Class<? extends Item> itemClass;

    ItemType(String itemName, Class<? extends Item> itemClass){
        this.itemName = itemName;
        this.itemClass = itemClass;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isWeapon(){
        return itemClass.equals(WeaponItem.class);
    }

    public boolean isFood(){
        return itemClass.equals(FoodItem.class);
    }
}
