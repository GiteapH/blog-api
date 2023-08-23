package cn.springboot.blog.api.blog.dataframe;

import java.util.*;
public class TireNode {
    Character val;
    Set<TireNode> tireNodes = new HashSet<>();
    long features = 1;

    TireNode(Set<TireNode> tireNodes,long features,Character c){
        this.features = features;
        this.tireNodes = tireNodes;
        this.val = c;
    }
    TireNode(Character c){
        this.val = c;
    }

    @Override
    public int hashCode() {
        return val.hashCode();
    }
}
