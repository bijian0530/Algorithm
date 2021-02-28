package com.linkedlist.SingleLinkedList;

import static com.linkedlist.SingleLinkedList.SingleLinkedList.*;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero4 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero2 = new HeroNode(3,"吴用","智多星");
        HeroNode hero3 = new HeroNode(4,"林冲","豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);

        //加入按照编号顺序
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero2);

        //   //单链表的逆序打印
        System.out.println("单链表的逆序打印");
        reversePrint(singleLinkedList.getHead());


        System.out.println("将单向链表反转");

        // 将单链表反转
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        HeroNode newHeroNode = new HeroNode(1, "songjiang", "xiaoyu");

        singleLinkedList.update(newHeroNode);
        System.out.println("修改后的列表");
        singleLinkedList.list();

        System.out.println("删除后的列表");
        singleLinkedList.delete(1);
        singleLinkedList.list();

        //测试一下，单链表有效的节点个数
        System.out.println("有效节点个数"+getLength(singleLinkedList.getHead()));

        //查找单链表中的倒数第 k 个结点
        System.out.println("查找单链表中的倒数第 k 个结点");
        HeroNode heroNode1 = findLastIndexNode(singleLinkedList.getHead(),1);
        System.out.println(heroNode1);


    }
}
