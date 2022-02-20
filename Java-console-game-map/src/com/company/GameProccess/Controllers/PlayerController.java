package com.company.GameProccess.Controllers;

import com.company.GameObjects.Player;
import com.company.GameProccess.GameCycle;
import com.company.GameProccess.GameLogic;
import com.company.Main;
import com.company.Map.Cell;
import com.company.Map.Map;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class PlayerController implements  Runnable
{
    Player player;
    Map map;
    Cell currentCell;

    public PlayerController(Player player, Map map)
    {
        this.player = player;
        this.map = map;
    }

    @Override
    public void run()
    {
        currentCell = map.getRender()[1][1];
        currentCell.setSymbol('@');

        while (player.IsAlive())
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

            walk();
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
        currentCell.setSymbol('@');
    }
}
