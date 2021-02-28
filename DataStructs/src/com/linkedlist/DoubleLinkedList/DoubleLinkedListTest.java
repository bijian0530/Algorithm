package com.linkedlist.DoubleLinkedList;

import com.linkedlist.SingleLinkedList.HeroNode;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
       HeroNode2 hero4 = new HeroNode2(1,"宋江","及时雨");
       HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
       HeroNode2 hero1 = new HeroNode2(3,"吴用","智多星");
       HeroNode2 hero3 = new HeroNode2(4,"林冲","豹子头");


        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
    }

}
