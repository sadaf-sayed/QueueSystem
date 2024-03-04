public class VIPClient extends Client implements Prioritizable{

    


//fields of VIPClient class

 private int memberSince;
 private int priority;
 
 
 //getters and setters
 
 public void setMemberSince(int memberSince){
 
    if (memberSince > 0)
        this.memberSince = memberSince;
 
 }


 public int getMemberSince(){
 
    return this.memberSince;
 }

 public void setPriority(int priority){

    this.priority = priority;

 }

 public int getPriority(){

    return this.priority;

 }


//constructer

 public VIPClient(String firstName, String lastName, int yearOfBirth, String gender, 
                int arrivalTime, int patience, Request[] requests, int memberSince, int priority)
            {
                    
               super(firstName, lastName, yearOfBirth, gender, arrivalTime, patience, requests);
                
               setMemberSince(memberSince);
               setPriority(priority);
               
            }


 //other methods
 
 @Override
 public String toString(){
 
    return super.toString() + "** VIP Since" +  "\t" + ": " + this.memberSince + "\n" + 
                            "** priority" +  "\t" + ": " + this.priority + "\n";
    
    }





// end of class
}