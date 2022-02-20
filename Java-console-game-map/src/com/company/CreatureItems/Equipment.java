package com.company.CreatureItems;

public class Equipment
{
    private final String name;
    private final int cost;
    private final int levelCost;

    public Equipment(String name, int cost, int levelCost)
    {
        this.name = name;
        this.cost = cost;
        this.levelCost = levelCost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getLevelCost() {
        return levelCost;
    }


}
