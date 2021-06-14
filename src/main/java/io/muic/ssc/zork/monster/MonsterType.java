package io.muic.ssc.zork.monster;

public enum MonsterType {
    COMMON("puppet", CommonMonster.class),
    BOSS("dragon", BossMonster.class);

    private String monsterName;
    private Class<? extends Monster> monsterClass;

    MonsterType(String monsterName, Class<? extends Monster> monsterClass) {
        this.monsterName = monsterName;
        this.monsterClass = monsterClass;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public Class<? extends Monster> getMonsterClass(){
        return monsterClass;
    }

}
