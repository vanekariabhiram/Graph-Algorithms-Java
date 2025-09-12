package Graphs;

import java.util.*;

public class ALiens {
    public static String alienOrder(String[] words) {
        StringBuilder str=new StringBuilder();
        Map<Character, Set<Character>> graph=new HashMap<>();
        Map<Character,Integer>Indegrees=new HashMap<>();

        for(String word:words){
            for(char c:word.toCharArray()){
              graph.putIfAbsent(c,new HashSet<>());
              Indegrees.putIfAbsent(c,0);
            }
        }

        for (int i = 0; i <words.length-1; i++) {
            String w1=words[i];
            String w2=words[i+1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for (int j = 0; j <Math.min(w1.length(),w2.length()); j++) {
                char c1=w1.charAt(j);
                char c2=w2.charAt(j);
            if (c1!=c2){
                if( (graph.get(c1).add(c2))){
                    Indegrees.put(c2,Indegrees.get(c2)+1);
                }
                break;
            }
            }

        }
        Queue<Character>queue=new LinkedList<>();
     for(char c:Indegrees.keySet()){
         if (Indegrees.get(c)==0){
             queue.offer(c);
         }
     }
     while (!queue.isEmpty()){
         char node=queue.poll();
         str.append(node);
         for(char neighbour:graph.get(node)){
             Indegrees.put(neighbour,Indegrees.get(neighbour)-1);
             if (Indegrees.get(neighbour)==0){
                 queue.offer(neighbour);
             }
         }
     }
        return Indegrees.size()==str.length()? str.toString():"";
    }
}