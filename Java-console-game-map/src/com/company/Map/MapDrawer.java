package com.company.Map;

import com.company.GameProccess.GameCycle;
import com.company.Main;

public class MapDrawer implements Runnable
{
    @Override
    public void run()
    {
        while (GameCycle.play)
        {
            Main.map.printMap();
        }
    }
}
