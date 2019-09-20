package application;

import java.util.ArrayList;

public class OrderList extends ArrayList<Order>{

        //constructor
        public OrderList(){
                super();
        }

        //method that adds the objects of Order into ArrayList
        public void addList(Order list){
                this.add(list);
        }

        //method to get index by index number
         public Order getOrder(int index) {
                return this.get(index);
         }

         //method to get the size of arrayList
         public int getSize(){
                 return this.size();
         }

}
