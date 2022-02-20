package com.company.GameObjects;

import com.company.CreatureItems.Armor;
import com.company.CreatureItems.Equipment;
import com.company.CreatureItems.Weapon;
import com.company.GameProccess.GameCycle;

import java.util.ArrayList;
import java.util.List;

public class Creature extends GameCycle
{
    private String name;
    private int health;
    private int damage;
    private List<Equipment> equipment = new ArrayList<>();
    private int dps;

    public Creature(String name, int health, int damage)
    {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    //общие методы
    public boolean IsAlive()
    {
        return health > 0;
    }

    public int GetDamagePerSecond()
    {
        dps = getDamage() + equipment.stream()
                .filter(x -> x instanceof Weapon)
                .map(x -> (Weapon) x)
                .mapToInt(Weapon::getWeaponDamage)
                .sum();
       return dps;
    }

    public int GetStrengthArmor()
    {
       return 1 - equipment.stream()
                .filter(x -> x instanceof Armor)
                .map(x -> (Armor) x)
                .mapToInt(Armor::getArmorDefense)
                .sum()/100;
    }

    public void AddHealth(int health)
    {
        this.health += health;
    }

    public void AddEquipment(Equipment equipment)
    {
        this.equipment.add(equipment);
    }

    //нанести урон
    public void Damage(int damage)
    {
        this.health -= damage;
        System.out.println(getName() + " получил " + damage + " урона");
    }

    //изменения dps для магии
    public void setDamage(int newDamage)
    {
        dps = newDamage;
    }

    public void increaseDamage(int newDamage)
    {
        dps += newDamage;
    }

    public void reduceDamage(int newDamage)
    {
        dps -= newDamage;
    }


    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getArmorDefense()
    {
        return  equipment.stream()
                .filter(x -> x instanceof Armor)
                .map(x -> (Armor) x)
                .mapToInt(Armor::getArmorDefense)
                .sum();
    }

    public List<Equipment> getEquipment()
    {
        return equipment;
    }
}
