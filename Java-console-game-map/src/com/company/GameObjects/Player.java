package com.company.GameObjects;
import com.company.GameProccess.Controllers.EnemyController;
import com.company.GameProccess.Controllers.PlayerController;
import com.company.CreatureItems.Potion;
import com.company.GameProccess.GameLogic;
import com.company.Main;

public class Player extends Creature
{
    public int experience;
    public int currentLevel;
    private Potion potion = new Potion();

    PlayerController playerController = new PlayerController(this, Main.map);

    public Player(String name, int health, int damage,
                  int experience, int currentLevel)
    {
        super(name, health, damage);
        this.experience = experience;
        this.currentLevel = currentLevel;
    }

    public void startWalking(){
        Main.executor.execute(playerController);
    }

    public void AddLevel(int addExperience)
    {
        experience += addExperience;

        if(experience >= 100)
        {
            currentLevel += 1;
            System.out.println("\nВы повысили уровень персонажа " + getName()
                    + " Текущий уровень: " + currentLevel);
        }
    }

    public Potion getPotion()
    {
        return potion;
    }

    public void setPotion(Potion potion)
    {
        this.potion = potion;
    }

    public int getExperience() {
        return experience;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public  void PlayerInfo()
    {
        System.out.println("-----------------------------");

        System.out.println("Имя: " + GameLogic.player.getName() + "\nУровень: "
                + GameLogic.player.getCurrentLevel()
                + "\nЗдоровье: " + GameLogic.player.getHealth()
                + "\nБроня: " + GameLogic.player.getArmorDefense()
                + "\nУрон персонажа: " + GameLogic.player.getDamage()
                + "\nУрон персонажа за секунду: " + GameLogic.player.GetDamagePerSecond());

        System.out.println("Опыт: " + getExperience());
        System.out.println("\nЭкипировка [[Оружие/Броня/Шлем]|стоимость|необходимый уровень для покупки]");

        for (int i = 0; i < getEquipment().size(); i++)
        {
            System.out.println(i+1 + ". " + GameLogic.player.getEquipment().get(i).getName()
                    + " " + GameLogic.player.getEquipment().get(i).getCost()
                    + " " + GameLogic.player.getEquipment().get(i).getLevelCost());
        }
        System.out.println("-----------------------------");
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

}

