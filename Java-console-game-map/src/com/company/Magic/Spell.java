package com.company.Magic;

import java.util.Scanner;

public class Spell<A extends Projectile, B extends  Projectile, C extends  Projectile>
{
    public A aard;
    public B aksiy;
    public C yrden;

    void useAard(int i)
    {
        aard.Weaken(i);
    }
    void useAksiy(int i)
    {
        aksiy.IncreasePlayerDamage();
    }
    void useYrden(int i)
    {
        yrden.ReduceEnemyDamage(i);
    }

    public static void UseSpell(int i)
    {
        Spell<Aard,Aksiy,Yrden> spell = new Spell<>();
        spell.aard = new Aard();
        spell.aksiy = new Aksiy();
        spell.yrden = new Yrden();

        //игрок может использовать 3 заклинания
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите заклинание: ");
        System.out.println("""
                1.Aard - Соперник пропускает ход и не наносит урон
                2.Aksiy - Урон от атаки игрока увеличивается
                3.Yrden - Урон от атаки врага уменьшается
                """);
        int tmpSpell = scanner.nextInt();

        switch (tmpSpell)
        {
            case 1 -> spell.useAard(i);
            case 2 -> spell.useAksiy(i);
            case 3 -> spell.useYrden(i);
        }
    }

}
