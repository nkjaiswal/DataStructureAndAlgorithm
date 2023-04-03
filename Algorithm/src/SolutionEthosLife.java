/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
Problem Statement
Ethos is currently having issues with some of their libraries where packages are not being built in the correct order. You have been tasked to build a program that will ensure their packages are built correctly. You are given a list of packages to build and an array of dependencies where [Pi, Pj] indicates that you must build package Pj first if you want to take build Pi. Return the correct build order for the given list of packages.

Example:
* packages=["P1","P2","P3"] dependencies = [["P1","P2"],["P2","P3"],["P1","P3"]] Output: ["P3","P2","P1"]


* packages=["P1","P2"] dependencies = [] Output: ["P1", "P2"] or ["P2", "P1"]
* packages=["P0","P1","P2","P3"] dependencies = [["P2", "P0"],["P1","P2"],["P3","P1"],["P3","P2"]] Output: ["P0", "P2", "P1", "P3"]
P0
/\
|
P2 <-- P3
/\     |
|      |
P1 <----

P0 P2 P1 P3
P0 P2 P3
      P1 P3

 */

// memory = O(m+n)
class SolutionEthosLife {
    public static void main(String[] args) {
        String[] nodes = {"P1","P2","P3"};
        String[][] dependency = {{"P1","P2"},{"P2","P1"}};

        Map<String, List<String>> map = new HashMap<>();


        // O(m)
        for(int i=0; i<dependency.length; i++) {
            String[] currentDependecy = dependency[i];
            if(map.containsKey(currentDependecy[0])) {
                map.get(currentDependecy[0]).add(currentDependecy[1]);
            } else {
                List<String> newDep = new ArrayList<>();
                newDep.add(currentDependecy[1]);
                map.put(currentDependecy[0], newDep);
            }
        }

        Map<String, GNode> nodesMap = new HashMap<>();

        // O(n)
        for(int i=0; i<nodes.length; i++) {
            nodesMap.put(nodes[i], new GNode(nodes[i]));
        }

        // O(n + m)
        for(int i=0;i<nodes.length; i++) {
            List<String> dependecy = map.get(nodes[i]);
            if (dependecy == null) {
                continue;
            }
            for (int j = 0; j < dependecy.size(); j++) {
                nodesMap.get(nodes[i]).addDependecyChild(nodesMap.get(dependecy.get(j)));
            }
        }


        for(int i=0; i<nodes.length; i++) {
            nodesMap.get(nodes[i]).printIfNotVisited();
        }

    }

    static class GNode {
        public String name;
        public boolean visited;
        public boolean visiting;
        public List<GNode> dependsUpon;

        public GNode (String name) {
            this.name = name;
            visited = false;
            visiting = false;
            dependsUpon = new ArrayList<>();
        }

        public void addDependecyChild(GNode node) {
            dependsUpon.add(node);
        }


        public void printIfNotVisited() {

          if(visiting) {
            // System.out.println("Cycle found");
            throw new Exception("Cycle found");
          }

            visiting = true;

            if(visited) {
                return;
            }
            for(int i=0; i<dependsUpon.size(); i++) {
                dependsUpon.get(i).printIfNotVisited();
            }

            System.out.println(name + ",");
            visited = true;
        }
    }
}

// curr -> child --> curr
// 


