package com.linkedlist.DoubleLinkedList;

import com.linkedlist.SingleLinkedList.HeroNode;

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
    //增加
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

    //修改
    public void update(HeroNode2 newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        Boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.getNo() ==newHeroNode.getNo()){
                flag =true;
                break;
            }
            temp = temp.next;
        }
    /*    if (flag){
            temp.getName() = newHeroNode.getName();
            temp.getStickName() = newHeroNode.getStickName();
        }else {
            System.out.println("没有找到这个"+newHeroNode.getNo()+"编号");
        }*/
    }

    //删除
    public void del(int no){
        if (head.next == null){
            System.out.println("链表为空");
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.getNo() == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }else {
                System.out.println("要删除的节点"+no+"不存在");
            }

        }
    }


}
