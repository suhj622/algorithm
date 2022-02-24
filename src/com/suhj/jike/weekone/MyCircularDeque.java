package com.suhj.jike.weekone;
/**
 * 
 * @author Haojie
 * ���ѭ��˫�˶���
 */
public class MyCircularDeque {
	
    int[] deque;
    int head;
    int tail;

    //��ʼ������Ϊk������
    //��ǰ��������Ԫ�أ�head��tailĬ��Ϊ-1
    public MyCircularDeque(int k) {
        this.deque = new int[k];
        this.head=-1;
        this.tail=-1;
    }
    
    public boolean insertFront(int value) {
        //Ϊ�յ����
        if(this.isEmpty()){
            this.deque[0]=value;
            this.head=0;
            this.tail=0;
            return true;
        }

        //��Ϊ�յ����
        if(this.isFull()){//����
            return false;
        }else{//δ��
            //head��0��λ��
            if(head==0){
                this.deque[this.deque.length-1]=value;
                this.head=this.deque.length-1;
            }else{//head�ڷ�0��λ��
                this.deque[this.head-1]=value;
                this.head=this.head-1;
            }            
        }
        return true;         
    }
    
    public boolean insertLast(int value) {
        //Ϊ�յ����
        if(this.isEmpty()){
            this.deque[0]=value;
            this.head=0;
            this.tail=0;
            return true;
        }

       //��Ϊ�յ����
        if(this.isFull()){//����
            return false;
        }else{//δ��
            //tail��length-1��λ��
            if(this.tail==this.deque.length-1){
                this.deque[0]=value;
                this.tail=0;
            }else{//tail�ڷ�length-1��λ��
                this.deque[this.tail+1]=value;
                this.tail=this.tail+1;
            }            
        }
        return true;
    }
    
    public boolean deleteFront() {

        //�յ����
        if(this.isEmpty()){
            return false;
        }

        //ֻ��һ���ڵ�����
        if(this.head==this.tail){
            this.head=-1;
            this.tail=-1;
        }

        //head�ڵ���tail�ڵ���ߵ����
        if(this.head<this.tail){
            this.head+=1;
        }

        //head�ڵ���tail�ڵ��ұߵ����
        if(this.head>this.tail){
            //head�ڵ���length-1λ��
            if(this.head==this.deque.length-1){
                this.head=0;
            }else{//head�ڵ��ڷ�length-1λ��
                this.head+=1;
            }
        }
        
        return true;

    }
    
    public boolean deleteLast() {

        //�յ����
        if(this.isEmpty()){
            return false;
        }

        //ֻ��һ���ڵ�����
        if(this.head==this.tail){
            this.head=-1;
            this.tail=-1;
        }

        //tail�ڵ���head�ڵ��ұߵ����
        if(this.head<this.tail){
            this.tail-=1;
        }

        //tail�ڵ���head�ڵ���ߵ����
        if(this.head>this.tail){
            //tail�ڵ���0λ��
            if(this.tail==0){
                this.tail=this.deque.length-1;
            }else{//tail�ڵ��ڷ�0λ��
                this.tail-=1;
            }
        }        
        return true;
    }
    
    public int getFront() {

        //�յ����
        if(this.isEmpty()){
            return -1;
        }else{//�ǿյ����
            return this.deque[this.head];
        }        
    }
    
    public int getRear() {
        //�յ����
        if(this.isEmpty()){
            return -1;
        }else{//�ǿյ����
            return this.deque[this.tail];
        }
    }
    
    //ֻ��һ���ڵ�ʱ��head��tailͬʱָ��ýڵ�
    public boolean isEmpty() {
        if(this.head==-1 && this.tail==-1){
            return true;
        }        
        return false;
    }
    
    //head�ڵ���ߡ�tail�ڵ����ұߵ����
    //head�ڵ����ұߡ�tail�ڵ�����ߵ����
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
