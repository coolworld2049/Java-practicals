package com.company.CreatureItems;

public class Weapon extends Equipment
{
    private final int weaponDamage;

    public Weapon(String name, int cost, int levelCost, int weaponDamage)
    {
        super(name, cost, levelCost);
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponDamage()
    {
        return weaponDamage;
    }

}
