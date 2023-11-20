package org.example;

import java.util.*;

import java.util.List;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(b -> b.getColor().equals(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return Optional.ofNullable(blocks).orElse(Collections.emptyList()).stream()
                .filter(b -> b.getMaterial().equals(material)).collect(Collectors.toList());
    }

    @Override
    public int count() {
        int count = 0;
        for (Block block : blocks) {
            count += countBlocks(block);
        }
        return count;
    }

    private int countBlocks(Block block) {
        int count = 1;
        if (block instanceof CompositeBlock) {
            List<Block> blocks1 = ((CompositeBlock) block).getBlocks();
            for (Block block1 : blocks1) {
                count += countBlocks(block1);
            }
        }
        return count;
    }
}

