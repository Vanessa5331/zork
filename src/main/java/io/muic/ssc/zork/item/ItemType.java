package io.muic.ssc.zork.item;

public enum ItemType {
    SWORD("sword", 0, 10, WeaponItem.class),
    SHIELD("shield", 5, 5, WeaponItem.class),
    APPLE("apple", 5, 0, FoodItem.class),
    BREAD("bread", 10, 0, FoodItem.class);

    private final String itemName;
    private final int health, strength;
    private final Class<? extends Item> itemClass;

    ItemType(String itemName, int health, int strength, Class<? extends Item> itemClass){
        this.itemName = itemName;
        this.health = health;
        this.strength = strength;
        this.itemClass = itemClass;
    }

    public String getItemName() {
        return itemName;
    }

    public void printItemStat() {
        System.out.printf("HP: +%d\t\tATK: +%d", health, strength);
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public Class<? extends Item> getItemClass() {
        return itemClass;
    }

    public boolean isWeapon(){
        return itemClass.equals(WeaponItem.class);
    }

    public boolean isFood(){
        return itemClass.equals(FoodItem.class);
    }
}
