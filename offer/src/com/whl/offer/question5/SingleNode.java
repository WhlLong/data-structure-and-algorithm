package com.whl.offer.question5;


public class SingleNode {

    public String key;
    public String val;

    public SingleNode(String k,String v){
        this.key = k;
        this.val = v;
    }

    public SingleNode next;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }
}
