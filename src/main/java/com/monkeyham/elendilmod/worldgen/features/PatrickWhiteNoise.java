package com.monkeyham.elendilmod.worldgen.features;

public class PatrickWhiteNoise {
    public static double whiteNoise(int x, int y, long seed)
    {
        long n = (x*47932L + y*32153L + seed) ^ 0x82395274L;

        return (n&0x7ffffff) / (double) Integer.MAX_VALUE;
    }
}
