package com.company.GameProccess;

import com.company.CreatureItems.Armor;
import com.company.CreatureItems.Weapon;
import com.company.GameObjects.Enemy;
import com.company.GameObjects.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GameLogic
{
    public static Player player;
    public static Enemy enemy;

    static final String[] enemyNames = {"Terrorist","Demon","Ghost","Boss","Hydra","Alien","Predator"};
    static final String[] weaponNames = {"AK-47","M4","AWP","Galil","Deagle", "P250","Glock"};
    static final String[] armorNames = {"Armor", "Helmet"};

    public static List<Enemy> enemyList = new ArrayList<>();
    public static List<Weapon> weaponList = new ArrayList<>();
    public static List<Armor> armorList = new ArrayList<>();

    public static void CreateItems()
    {
        for (int i = 0; i < weaponNames.length; i++)
        {
             Weapon weapon = new Weapon(
                    weaponNames[i],
                    500 + i*200,
                    1 + i,
                    10 + i*2);
            weaponList.add(weapon);
        }

        for (int i = 0; i < armorNames.length; i++)
        {
            Armor armor = new Armor(
                    armorNames[i],
                    250 + i*250,
                    1 + i,
                    50+ i*20);
            armorList.add(armor);
        }
    }

    public static void CreatePlayer()
    {
        player = new Player(
                "Coolworld",
                1000,
                200,
                0,
                0);
        player.AddEquipment(weaponList.get(ThreadLocalRandom.current().nextInt(weaponList.size())));
        player.AddEquipment(armorList.get(0));
        player.AddEquipment(armorList.get(1));

        player.startWalking();
    }

    public static void CreateEnemies()
    {
        for (int i = 0; i < 7; i++)
        {
            enemy = new Enemy(
                    enemyNames[i],
                    100 +i*5,
                    ThreadLocalRandom.current().nextInt(15,30));
            enemy.AddEquipment(weaponList.get(i));
            enemyList.add(enemy);

            enemy.startWalking();
        }
    }
}
