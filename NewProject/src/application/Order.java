package application;

public class Order {
        private String _order;		//order variable
        private Double _price;		//price variable


        //two parameter constructor
        public Order(String order, Double price) {
                _order = order;
                _price = price;
        }

        //setter and getters of field variables
        public String getOrder() {
                return _order;
        }

        public void setOrder(String order) {
                _order = order;
        }

        public Double getPrice() {
                return _price;
        }

        public void setPrice(Double price) {
                _price = price;
        }

        //toString method
        public String toString(){
                return _order + "-------------------" + "$"+_price;
        }

}
