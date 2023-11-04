package it.unibo.generics.graph.impl;

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl implements Graph<String>{

    Map<String, Set<String>> myMap = new HashMap<>();

    @Override
    public void addNode(String node) {
        if (node == null || myMap.keySet().contains(node)) {
            return;
        } else {
            myMap.put(node, new HashSet<String>());
        }
    }

    @Override
    public void addEdge(String source, String target) {
        if (source == null || target == null) {
            return;
        } else {
            Set<String> tempSet = myMap.get(source);
            tempSet.add(target);
            myMap.put(source, tempSet);
        }
    } 

    @Override
    public Set<String> nodeSet() {
        return myMap.keySet();
    }

    @Override
    public Set<String> linkedNodes(String node) {
        return myMap.get(node);
    }

    @Override
    public List<String> getPath(String source, String target) {
        Set<String> nodeVisited = new HashSet<>();
        List<String> path = new ArrayList<>();
        dfs_path(source, target, nodeVisited, path);
        return path;
    }

    private boolean dfs_path(String a, String dest, Set<String> visited, List<String> path) {
        visited.add(a);
        path.add(a);

        if (a == dest) {
            return true;
        }

        if (myMap.containsKey(a)) {
            for (String elem : myMap.get(a)) {
                if (!visited.contains(elem)) {
                    if (dfs_path(elem, dest, visited, path)) {
                        return true;
                    }
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

}
