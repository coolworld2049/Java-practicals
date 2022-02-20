package com.company.CreatureItems;

public class Armor extends Equipment
{
    private final int defense;

    public Armor(String name, int cost, int levelCost, int defense)
    {
        super(name, cost, levelCost);
        this.defense = defense;
    }

    public int getArmorDefense() {
        return defense;
    }
}
