package com.company.CreatureItems;

import com.company.GameObjects.Player;

import java.util.concurrent.ThreadLocalRandom;

public class Potion
{
    final int healPoints = ThreadLocalRandom.current().nextInt(0, 100);

    public void HealPlayer(Player player)
    {
        player.AddHealth(healPoints);
        System.out.println("\n" + player.getName() + " восстановил здоровье на "
                + healPoints + " очков. Здоровье: " + player.getHealth());
    }
}
