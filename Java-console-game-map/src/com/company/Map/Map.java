package com.company.Map;

import com.company.GameProccess.Controllers.EnemyController;
import com.company.GameProccess.GameLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Map
{
    private Cell[][] render;
    private List<Cell> border = new ArrayList<>();
    private int xSize;
    private int ySize;

    public Map(int xSize, int ySize)
    {
        this.xSize = xSize;
        this.ySize = ySize;
        render = new Cell[ySize][xSize];
    }

    public boolean isBorder(Cell cell)
    {
        if(border.contains(cell))
            return true;
        return false;
    }

    public Cell[][] getRender() {
        return render;
    }

    public Cell getCell( Position pos){
        return render[pos.getY()][pos.getX()];
    }

    public List<Cell> getNearCells( Cell cell)
    {
        List<Cell> cells = new ArrayList<>();

        Arrays.stream(render[cell.getPosition().getY()+1]).filter(x -> !this.isBorder(x)
                && x.getSymbol() == ' '
                && (x.getPosition().getX() >= cell.getPosition().getX() - 1
                && x.getPosition().getX() <= cell.getPosition().getX() + 1))
                .forEach(cells::add);

        Arrays.stream(render[cell.getPosition().getY()]).filter(x -> !this.isBorder(x)
                && !x.getPosition().equals(cell.getPosition())
                && x.getSymbol() == ' '
                && (x.getPosition().getX() >= cell.getPosition().getX() - 1
                && x.getPosition().getX() <= cell.getPosition().getX() + 1))
                .forEach(cells::add);

        Arrays.stream(render[cell.getPosition().getY()-1]).filter(x -> !this.isBorder(x)
                && x.getSymbol() == ' '
                && (x.getPosition().getX() >= cell.getPosition().getX() - 1
                && x.getPosition().getX() <= cell.getPosition().getX() + 1))
                .forEach(cells::add);

        return cells;
    }

    public boolean checkPlayer( Cell cell)
    {
        if(render[cell.getPosition().getY() + 1][cell.getPosition().getX()].getSymbol() == '@') return true;
        if(render[cell.getPosition().getY() - 1][cell.getPosition().getX()].getSymbol() == '@') return true;
        if(render[cell.getPosition().getY()][cell.getPosition().getX() + 1].getSymbol() == '@') return true;
        if(render[cell.getPosition().getY()][cell.getPosition().getX() - 1].getSymbol() == '@') return true;
        else return false;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public void generateMap()
    {
        for (int i = 0; i < xSize; i++)
        {
            for (int j = 0; j < ySize; j++)
            {
                render[j][i] = new Cell(new Position(i,j), ' ');
                if (j == 0 || j == ySize-1)
                {
                    render[j][i].setSymbol('━'); border.add(render[j][i]);
                }
                else if (i == 0 || i == xSize-1)
                {
                    render[j][i].setSymbol('┃'); border.add(render[j][i]);
                }
                else render[j][i].setSymbol(' ');
            }
        }

        border.add(render[0][0]);
        border.add(render[0][xSize - 1]);
        border.add(render[ySize-1][0]);
        border.add(render[ySize-1][xSize-1]);

        render[0][0].setSymbol('┎');
        render[0][xSize-1].setSymbol('┓');
        render[ySize-1][0].setSymbol('┗');
        render[ySize-1][xSize-1].setSymbol('┛');
    }

    public void printMap()
    {
        for (Cell[] cells : render)
        {
            for (Cell cell : cells)
            {
                System.out.print(cell.getSymbol());
            }
            System.out.println();
        }
        try
        {
            TimeUnit.MILLISECONDS.sleep(500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        for (int i = 0; i < xSize; i++)
        {
            System.out.println();
        }

        System.out.println("Здоровье " + GameLogic.player.getName()
                + " " + GameLogic.player.getHealth());

        System.out.println("\nПобежденные противники: ");
        for (int i = 0; i < EnemyController.defeatedEnemies.size(); i++)
        {
            System.out.println((i+1) + ". "
                    + EnemyController.defeatedEnemies.get(i).getName());

        }
        System.out.println();
    }
}
