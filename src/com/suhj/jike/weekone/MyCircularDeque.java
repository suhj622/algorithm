package com.suhj.jike.weekone;
/**
 * 
 * @author Haojie
 * 设计循环双端队列
 */
public class MyCircularDeque {
	
    int[] deque;
    int head;
    int tail;

    //初始化容量为k的数组
    //当前数组中无元素，head、tail默认为-1
    public MyCircularDeque(int k) {
        this.deque = new int[k];
        this.head=-1;
        this.tail=-1;
    }
    
    public boolean insertFront(int value) {
        //为空的情况
        if(this.isEmpty()){
            this.deque[0]=value;
            this.head=0;
            this.tail=0;
            return true;
        }

        //不为空的情况
        if(this.isFull()){//满了
            return false;
        }else{//未满
            //head在0的位置
            if(head==0){
                this.deque[this.deque.length-1]=value;
                this.head=this.deque.length-1;
            }else{//head在非0的位置
                this.deque[this.head-1]=value;
                this.head=this.head-1;
            }            
        }
        return true;         
    }
    
    public boolean insertLast(int value) {
        //为空的情况
        if(this.isEmpty()){
            this.deque[0]=value;
            this.head=0;
            this.tail=0;
            return true;
        }

       //不为空的情况
        if(this.isFull()){//满了
            return false;
        }else{//未满
            //tail在length-1的位置
            if(this.tail==this.deque.length-1){
                this.deque[0]=value;
                this.tail=0;
            }else{//tail在非length-1的位置
                this.deque[this.tail+1]=value;
                this.tail=this.tail+1;
            }            
        }
        return true;
    }
    
    public boolean deleteFront() {

        //空的情况
        if(this.isEmpty()){
            return false;
        }

        //只有一个节点的情况
        if(this.head==this.tail){
            this.head=-1;
            this.tail=-1;
        }

        //head节点在tail节点左边的情况
        if(this.head<this.tail){
            this.head+=1;
        }

        //head节点在tail节点右边的情况
        if(this.head>this.tail){
            //head节点在length-1位置
            if(this.head==this.deque.length-1){
                this.head=0;
            }else{//head节点在非length-1位置
                this.head+=1;
            }
        }
        
        return true;

    }
    
    public boolean deleteLast() {

        //空的情况
        if(this.isEmpty()){
            return false;
        }

        //只有一个节点的情况
        if(this.head==this.tail){
            this.head=-1;
            this.tail=-1;
        }

        //tail节点在head节点右边的情况
        if(this.head<this.tail){
            this.tail-=1;
        }

        //tail节点在head节点左边的情况
        if(this.head>this.tail){
            //tail节点在0位置
            if(this.tail==0){
                this.tail=this.deque.length-1;
            }else{//tail节点在非0位置
                this.tail-=1;
            }
        }        
        return true;
    }
    
    public int getFront() {

        //空的情况
        if(this.isEmpty()){
            return -1;
        }else{//非空的情况
            return this.deque[this.head];
        }        
    }
    
    public int getRear() {
        //空的情况
        if(this.isEmpty()){
            return -1;
        }else{//非空的情况
            return this.deque[this.tail];
        }
    }
    
    //只有一个节点时，head、tail同时指向该节点
    public boolean isEmpty() {
        if(this.head==-1 && this.tail==-1){
            return true;
        }        
        return false;
    }
    
    //head节点左边、tail节点在右边的情况
    //head节点在右边、tail节点在左边的情况
    public boolean isFull() {
        if((this.head==0 && this.tail==(this.deque.length-1)) || ((this.tail+1)==this.head) ){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */    

}
