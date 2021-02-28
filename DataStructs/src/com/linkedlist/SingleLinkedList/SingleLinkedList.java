package com.linkedlist.SingleLinkedList;

import java.util.Stack;

public class SingleLinkedList {
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void addByOrder(HeroNode heroNode){
    HeroNode temp = head;
    boolean flag = false;
    while (true){
        if (temp.next == null){
            break;
        }
        if (temp.next.no > heroNode.no){
            break;
        }else if(temp.next.no ==heroNode.no){
            flag = true;
            break;
        }
        temp = temp.next;
    }
        if(flag){
            System.out.println("准备插入的英雄编号"+heroNode.no+"已经存在");
        }else {
            //插入链表中
            heroNode.next = temp.next;
            temp.next =heroNode;
        }
    }

    //修改节点的信息
    public void update(HeroNode newHeroNode){
        if (head.next == null){
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("没有找到"+newHeroNode.no+"的节点");
        }
    }

    //删除节点
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("要删除的"+no+"节点不存在");
        }
    }
    //查找节点个数
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
    //查找单链表倒数第k个节点
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next == null){
            return null;
        }
        int size = getLength(head);
        if(index < 0 || index > size){
            return null;
        }
        HeroNode cur = head.next; //3-1=2
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //将单链表反转
    public static void reverseList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //单链表的逆序打印
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }

    }


}
