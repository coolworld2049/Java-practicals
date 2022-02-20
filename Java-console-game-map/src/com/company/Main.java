package com.company;

import com.company.GameProccess.GameCycle;
import com.company.GameProccess.GameLogic;
import com.company.Map.Map;
import com.company.Map.MapDrawer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
    public static Map map = new Map(8, 4);
    public static ExecutorService executor = Executors.newCachedThreadPool();
    public static MapDrawer mapDrawer = new MapDrawer();
    public static GameCycle gameCycle = new GameCycle();
    public static List<String> logs = new ArrayList<>();

    public static  void main(String[] args) throws Exception
    {
        map.generateMap();
        GenerateGameObject();
        Main.MainMenu();
    }

    public static void Start()
    {
        executor.execute(mapDrawer);
        executor.execute(gameCycle);
        executor.shutdown();
    }

    public static void Restart()
    {
        executor = Executors.newCachedThreadPool();
        logs.clear();
        map.generateMap();
        GenerateGameObject();
        GameLogic.player.startWalking();
        executor.execute(mapDrawer);
        executor.execute(gameCycle);
    }

    public static void GenerateGameObject()
    {
        GameLogic.CreateItems();
        GameLogic.CreateEnemies();
        GameLogic.CreatePlayer();
    }

    public static void MainMenu() throws Exception
    {
        System.out.println("""
                
                \t\tМЕНЮ
                
                1.Информация о игроке
                2.Информация о соперниках
                3.Начать игру
                4.Выход
                                
                №?:\s""");
        Scanner scanner = new Scanner(System.in);
        int tmp = scanner.nextInt();

        switch (tmp)
        {
            case 1:
                GameLogic.player.PlayerInfo();
                Thread.sleep(1000);
                MainMenu();
                break;
            case 2:
                GameLogic.enemy.EnemyInfo();
                Thread.sleep(1000);
                MainMenu();
                break;
            case 3:
                Start();
            case 4:
                break;
        }
    }

    public static void LooseMenu() throws Exception
    {
        System.out.println(
                """
                1.Перезапустить игру
                2.Выход в главное меню

                №?:\s""");
        Scanner scanner3 = new Scanner(System.in);
        int tmp4 = scanner3.nextInt();

        switch (tmp4)
        {
            case 1 -> Restart();
            case 2 -> MainMenu();
        }
    }
}
