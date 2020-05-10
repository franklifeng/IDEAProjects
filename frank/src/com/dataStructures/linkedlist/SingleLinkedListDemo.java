package com.dataStructures.linkedlist;

/**
 * @author frank
 * @create 2020-04-10 13:19
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "lifeng", "shengren");
        HeroNode hero2 = new HeroNode(5, "liuyuan", "shengren");
        HeroNode hero3 = new HeroNode(3, "hehe", "shengren");
        HeroNode hero4 = new HeroNode(2, "peipei", "shengren");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
/*        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);*/


        singleLinkedList.addOrder(hero1);
        singleLinkedList.addOrder(hero2);
        singleLinkedList.addOrder(hero3);
        singleLinkedList.addOrder(hero4);
        singleLinkedList.list();
    }


}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("number is equal");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    public void list() {
        if (head.next == null) {
            System.out.println("nothing number");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}