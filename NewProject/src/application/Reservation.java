package application;

public class Reservation {

        private String userName; 		//userName variable
        private int timing;				//time vaiable

        //two parameter constructor
        public Reservation(String _userName, int _timing){
                userName=_userName;
                 timing=_timing;
        }

        //setter and getters of field variables
        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public int getTiming() {
                return timing;
        }

        public void setTiming(int timing) {
                this.timing = timing;
        }

        //toString method
        public String toString(){
                return "Name:  " + userName + " \n" +
                           "Timing:    " + timing + " P.m." + "\n";
        }
}






