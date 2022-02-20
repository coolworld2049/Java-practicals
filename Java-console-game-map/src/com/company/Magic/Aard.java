package com.company.Magic;

import com.company.GameProccess.GameLogic;

public  class Aard implements Projectile
{
    private final int aardDamage = 50;

    @Override
    public void Weaken(int i)
    {
        System.out.println("\nСоперник пропускает ход и не наносит урон\n");
        GameLogic.enemyList.get(i).setDamage(0);
    }

    @Override
    public void IncreasePlayerDamage()
    {
        System.out.println("Урон от атаки игрока увеличивается на " + aardDamage + " едениц.\n");
        GameLogic.player.increaseDamage(aardDamage);
    }

    @Override
    public void ReduceEnemyDamage(int i)
    {
        System.out.println("Урон от атаки врага уменьшается на " + aardDamage + " едениц.\n");
        GameLogic.enemyList.get(i).reduceDamage(aardDamage);
    }
}
