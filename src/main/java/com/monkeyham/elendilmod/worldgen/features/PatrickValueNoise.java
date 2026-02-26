package com.monkeyham.elendilmod.worldgen.features;

import net.minecraft.util.RandomSource;

import java.util.Random;

public class PatrickValueNoise {

    private  int[][] values;
    private int m_size;

    public void init(RandomSource random, int size, int maxHeight)
    {
        m_size=size;
        values = new int[size][size];
        for(int i=0;i<size;++i)
        {
            for(int j=0;j<size;++j) {
                values[i][j] = random.nextInt(maxHeight);
            }
        }

    }

    public int getHeight(int x, int y)
    {
       x = Math.max(0, Math.min(4, x));
       y = Math.max(0, Math.min(4, y));
       return values[x][y];
    }

}
