package com.company.Magic;

public interface Projectile
{
    //соперник пропускает ход
    void Weaken(int i);

    //урон от атаки игрока увеличивается
    void IncreasePlayerDamage();

    //урон от атаки врага уменьшается
    void ReduceEnemyDamage(int i);
}
