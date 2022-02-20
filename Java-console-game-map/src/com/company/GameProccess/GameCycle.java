package com.company.GameProccess;

import com.company.GameProccess.Controllers.EnemyController;
import com.company.Main;

public class GameCycle implements Runnable
{
    public static boolean play = true;

    @Override
    public void run()
    {
        if(GameLogic.enemyList.size() == EnemyController.defeatedEnemies.size())
        {
            play = false;
            Main.executor.shutdownNow();
        }

        if (!play)
        {
            System.out.println("Fight over");
            System.out.println("\t\tInfo\n\n");
            Main.executor.shutdown();
            for (String log : Main.logs)
            {
                System.out.println(log);
            }
        }
    }
}
