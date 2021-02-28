package com.linkedlist.DoubleLinkedList;

class HeroNode2 {
    private int no;
    private String name;
    private String stickName;
    HeroNode2 pre;
    HeroNode2 next;

    public HeroNode2() {
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", stickName='" + stickName + '\'' +
                '}';
    }

    public HeroNode2(int no, String name, String stickName) {
        this.no = no;
        this.name = name;
        this.stickName = stickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStickName() {
        return stickName;
    }

    public void setStickName(String stickName) {
        this.stickName = stickName;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }
}
