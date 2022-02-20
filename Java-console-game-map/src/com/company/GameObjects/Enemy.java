package com.company.GameObjects;

import com.company.GameProccess.Controllers.EnemyController;
import com.company.GameProccess.GameLogic;
import com.company.Main;

public class Enemy extends Creature
{
    EnemyController enemyController = new EnemyController(this, Main.map);

    public Enemy(String name, int health, int damage)
    {
        super(name, health, damage); //конструкор суперкласса
    }

    public void startWalking()
    {
        Main.executor.execute(enemyController);
    }

    public void death(int i)
    {
        GameLogic.enemyList.remove(i);
    }

    public void DeathOnMap(Enemy enemy)
    {
        GameLogic.enemyList.remove(enemy);
    }

    public  void EnemyInfo()
    {
        System.out.println("-----------------------------");
        for (int i = 0; i < GameLogic.enemyList.size(); i++)
        {
            System.out.println(i + ".Имя: " + GameLogic.enemyList.get(i).getName()
                    + "\nЗдоровье: " + GameLogic.enemyList.get(i).getHealth()
                    + "\nБроня: " + GameLogic.enemyList.get(i).getArmorDefense()
                    + "\nУрон существа: " + GameLogic.enemyList.get(i).getDamage()
                    + "\nУрон персонажа за секунду: " + GameLogic.enemyList.get(i).GetDamagePerSecond());
            System.out.println();
        }

        System.out.println("Экипировка [оружие|стоимость|урон оружия]\n");
        for (int j = 0; j < GameLogic.weaponList.size(); j++)
        {
            System.out.println(j + ") " + GameLogic.weaponList.get(j).getName() +
                    " " + GameLogic.weaponList.get(j).getCost() +
                    " " + GameLogic.weaponList.get(j).getWeaponDamage());
        }

        System.out.println("-----------------------------");
    }
}
