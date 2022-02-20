package com.company.Magic;

import com.company.GameProccess.GameLogic;

public class Yrden implements Projectile
{
    private final int yrdenDamage = 100;

    @Override
    public void Weaken(int i)
    {
        System.out.println("\nСоперник пропускает ход и не наносит урон\n");
        GameLogic.enemyList.get(i).setDamage(0);
    }

    @Override
    public void IncreasePlayerDamage()
    {
        System.out.println("Урон от атаки игрока увеличивается на " + yrdenDamage + " едениц.\n");
        GameLogic.player.increaseDamage(yrdenDamage);
    }

    @Override
    public void ReduceEnemyDamage(int i)
    {
        System.out.println("Урон от атаки врага уменьшается на " + yrdenDamage + " едениц.\n");
        GameLogic.enemyList.get(i).reduceDamage(yrdenDamage);
    }
}
