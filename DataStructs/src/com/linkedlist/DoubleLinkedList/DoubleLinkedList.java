package com.linkedlist.DoubleLinkedList;

public class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHeroNode() {
        return head;
    }



    //遍历
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 tmp = head.next;
        while (true){
            if (tmp == null){
                break;
            }
            System.out.println(tmp);
            tmp = tmp.next;
        }

    }
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

}
