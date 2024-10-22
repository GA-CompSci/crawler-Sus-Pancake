package main.monsters;

public abstract class Monster {
    //encapsulated variables
    private int health;
    private int levelModifier;
    private int minDamage;
    private int maxDamage;
    private String name;
    private boolean fastAttack;

    // blank constructor
    public Monster() {
        health = 100;
        levelModifier = 1;
        minDamage = 1;
        maxDamage = 10;
        name = "Monster";
        fastAttack = false;
    }

    // constructor with paramaters
    public Monster(int health, int l, int min, int max, String n, boolean fastAttack) {
        this.health = health;
        this.levelModifier = l;
        this.minDamage = min;
        this.maxDamage = max;
        this.name = n;
        this.fastAttack = fastAttack;
    }

    // health modifier
    public void setHealth(int health) {
        this.health = health;
    }

    // accessors
    public int getHealth() {
        return health;
    }

    public boolean isFastAttack() {
        return fastAttack;
    }

    public int getLevelModifier() {
        return levelModifier;
    }

    public int getDamage() {
        int x = (int) (Math.random() * (maxDamage - minDamage) + minDamage);
        return x;
    }

    public abstract void attack();
    public abstract void taunt();
}
