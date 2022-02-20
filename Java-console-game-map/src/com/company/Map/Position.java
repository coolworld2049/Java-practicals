package com.company.Map;

public class Position
{
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Position pos)
    {
        return pos.getX() == this.x && pos.getY() == this.y;
    }
}
