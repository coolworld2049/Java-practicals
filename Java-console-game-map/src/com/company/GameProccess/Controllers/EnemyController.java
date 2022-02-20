package com.company.GameProccess.Controllers;

import com.company.GameObjects.Enemy;
import com.company.GameProccess.GameCycle;
import com.company.GameProccess.GameLogic;
import com.company.Main;
import com.company.Map.Cell;
import com.company.Map.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class EnemyController implements Runnable
{
    Enemy enemy;
    Map map;
    Cell currentCell;
    public static List<Enemy> defeatedEnemies = new ArrayList<>();

    public EnemyController(Enemy enemy, Map map)
    {
        this.enemy = enemy;
        this.map = map;
    }

    @Override
    public void run()
    {
        int x = ThreadLocalRandom.current()
                .nextInt(2, map.getXSize() - 1);
        int y = ThreadLocalRandom.current()
                .nextInt(2, map.getYSize() - 1);

        currentCell = map.getRender()[y][x];
        currentCell.setSymbol(GameLogic.enemy.getName().charAt(0));

        while (enemy.IsAlive())
        {
            if(!GameCycle.play)
            {
                break;
            }
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if(map.checkPlayer(currentCell))
            {
                MapFighting();
                continue;
            }

            if(GameLogic.enemyList.size() == 0)
            {
                GameCycle.play = false;
            }
            walk();
        }
    }
    public void MapFighting()
    {
        GameLogic.player.Damage(enemy.getDamage());
        enemy.Damage(GameLogic.player.getDamage());

        if (!GameLogic.player.IsAlive())
        {
            GameLogic.player.getPlayerController().currentCell.setSymbol(' ');
            GameCycle.play = false;
            Main.executor.shutdownNow();
            Main.logs.add("Игра окончена");
            System.out.print("Игра окончена");
        }
        if (!enemy.IsAlive())
        {
            currentCell.setSymbol(' ');
            Main.logs.add("Вы победили");
            System.out.print("Вы победили");
            defeatedEnemies.add(this.enemy);
            enemy.DeathOnMap(this.enemy);
        }
    }
    public void walk()
    {
        if(currentCell.getSymbol() != ' ')
        {
            currentCell.setSymbol(' ');
        }
        List<Cell> nearCell = map.getNearCells(currentCell);
        currentCell = nearCell.get(ThreadLocalRandom.current().nextInt(nearCell.size()));
        currentCell.setSymbol(enemy.getName().charAt(0));
    }
}
