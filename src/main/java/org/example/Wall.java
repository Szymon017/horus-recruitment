package org.example;

import java.util.*;

import java.util.List;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure, CompositeBlock{

    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(b -> b.getColor().equals(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {

        return Optional.ofNullable(blocks)
                .orElse(Collections.emptyList())
                .stream()
                .filter(b -> b.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return getBlocks().size();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String getColor() {
        return "GivenColor";
    }

    @Override
    public String getMaterial() {
        return "GivenMaterial";
    }
}
