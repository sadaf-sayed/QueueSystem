public class Client{

 public static void main(String[] args){
 
    Client f = new Client("Sadaf", "Sayed", 2003, "FEMALE", 1);
    
    System.out.println(f.getID());
    
        System.out.println(f.getAge());
        
        System.out.println(f.getPatience());
        
        System.out.println(f.getDepartureTime());
        
         Client c = new Client("bob", "bob", 2003, "FEMALE", 10000);
        System.out.println(c.getID());
    
    System.out.println(c.getYearOfBirth());
        
        System.out.println(c.getPatience());
        
        System.out.println(c.getDepartureTime());
        
        System.out.println(c.toString());
 }
 
 
 
 
 private int id;
 
 private String firstName;
 
 private String lastName;
 
 private int yearOfBirth;
 
 private Gender gender;
 
 private Request[] requests;
 
 private int arrivalTime;
 
 private int waitingTime = 0;
 
 private int timeInQueue = 0; 

 private int serviceTime = 0;
 
 private int departureTime = 0;
 
 private int patience;


//additional fields

private int age; 

/** private, static int that will be only available in Client class as a way to track 
* each time a Client object is created, which means an id is assigned. It will only increment
* in the static setID method in Client class
*/
 
 private static int idVal = 0;
 

 //setters and getters for all private fields
 
 public void setID(){
 
    idVal++;
    
    this.id = idVal;
  }
  
 public int getID(){
 
    return this.id;
  }
  

 public void setFirstName(String firstName){
 
    this.firstName = firstName;
 }

 public String getFirstName(){
    
    return this.firstName;
 
 }
 
 public void setLastName(String lastName){
 
    this.lastName = lastName;
 }

 public String getLastName(){
    
    return this.lastName;
 
 }
 
 
 
 public void setYearOfBirth(int yearOfBirth){
 
    this.yearOfBirth = yearOfBirth;
 }

 public int getYearOfBirth(){
    
    return this.yearOfBirth;
 
 }
 
 public void setGender(String gender){
 
    switch(gender){
        
        case "MALE": this.gender = Gender.MALE;
            break;
        case "FEMALE": this.gender = Gender.FEMALE;
            break;
        }
    
    
    }
 
 
 public Gender getGender(){
 
    return this.gender;
 }
 
 
 public void setRequests(Request[] requests){
 
    this.requests = requests;
 
 }
 
 
 public Request[] getRequests(){
 
    return this.requests;
 
 }
 
 
 public void setArrivalTime(int arrivalTime){
 
    if (arrivalTime <= 0)
        this.arrivalTime = QueueSystem.getClock();
    else 
        this.arrivalTime = arrivalTime;
 
 }
 
 
 public int getArrivalTime(){
 
    return this.arrivalTime;
 
 }
 
 
 public void setWaitingTime(int waitingTime){
 
    this.waitingTime = waitingTime;
 
 }
 
 
 public int getWaitingTime(){
 
    return this.waitingTime;
 
 } 
 
 
 public void setTimeInQueue(int timeInQueue){
 
    this.timeInQueue = timeInQueue;
 
 }
 
 
 public int getTimeInQueue(){
 
    return this.timeInQueue;
 
 
 }
 
 
 public void setServiceTime(int serviceTime){
 
    this.serviceTime = serviceTime;
 
 }
 
 public int getServiceTime(){
 
    return this.serviceTime;
 
 }
 
 public void setDepartureTime(int departureTime){
 
    this.departureTime = departureTime;
 
 }
 
 
 public int getDepartureTime(){
 
    return this.departureTime;
 
 }
 
 
 public void setPatience(int patience){
 
    this.patience = patience;
 
 }
 
 public int getPatience(){
 
    return this.patience;
 
 }
 
 public int getAge(){
    
    return 2023 - getYearOfBirth();
 
 }
 
 
 
 //7 argument constructer
 public Client(String firstName, String lastName, int yearOfBirth, String gender, 
                    int arrivalTime, int patience, Request[] requests)
                 
    {
 
         setID();
         setFirstName(firstName);
         setLastName(lastName);
         setYearOfBirth(yearOfBirth);
         setGender(gender);
         setArrivalTime(arrivalTime);
         setPatience(patience);
         setRequests(requests);
         
         this.waitingTime = getWaitingTime();
         this.timeInQueue = getTimeInQueue();
         this.serviceTime = getServiceTime();
         this.departureTime = getDepartureTime();
         
          

    }


 //6 argument constructer 
 public Client(String firstName, String lastName, int yearOfBirth, String gender, 
                int patience, Request[] requests)
                 
    {
 
         setID();
         setFirstName(firstName);
         setLastName(lastName);
         setYearOfBirth(yearOfBirth);
         setGender(gender);
         
         setPatience(patience);
         setRequests(requests);
         
        
         this.arrivalTime = QueueSystem.getClock();
         this.waitingTime = getWaitingTime();
         this.timeInQueue = getTimeInQueue();
         this.serviceTime = getServiceTime();
         this.departureTime = getDepartureTime();
         
          

    }



 //5 argument constructer
 public Client(String firstName, String lastName, int yearOfBirth, String gender, int patience)
                 
    {
 
         setID();
         setFirstName(firstName);
         setLastName(lastName);
         setYearOfBirth(yearOfBirth);
         setGender(gender);
         setPatience(patience);
         
         
        
         this.arrivalTime = QueueSystem.getClock();
         this.waitingTime = getWaitingTime();
         this.timeInQueue = getTimeInQueue();
         this.serviceTime = getServiceTime();
         this.departureTime = getDepartureTime();
         
          

    }


//helper methods
public int totalProcessingTime(){
   int time = 0;
   for (int i = 0; i < requests.length; i++){
      time += requests[i].calculateProcessingTime();
   }

   return time;
}

public int remainingProcessingTime(){
   int remaining = totalProcessingTime() - serviceTime();

   return remaining;


}

 //other methods
 
 public int serviceTime(){
 
    return this.serviceTime;
 
 }

 
 public int estimateServiceLevel(){
 
    int level= 10;
    
    if (departureTime == 0)
        level = -1;
    
    else
    {
            
            
        if (waitingTime > 12)
            level -= 5;
        else if (waitingTime > 10)
            level -= 4;
        else if (waitingTime > 8)
            level -= 3;
        else if (waitingTime > 6)
            level -= 2;
        else if (waitingTime > 4)
            level -= 1;
        else 
            level -= 0;
            
        
        if (timeInQueue > 12)
            level -= 5;
        else if (timeInQueue > 10)
            level -= 4;
        else if (timeInQueue > 8)
            level -= 3;
        else if (timeInQueue > 6)
            level -= 2;
        else if (timeInQueue > 4)
            level -= 1;
        else 
            level -= 0;
        
    }
        

    
    return level;
 
 
 }
 
 public String toString(){
 
    return "Client: " + this.lastName + ", " + this.firstName + "\n" + 
            "** Arrival Time" +  "\t" + ": " + this.arrivalTime + "\n" + 
            "** Waiting Time" +  "\t" + ": " + this.waitingTime + "\n" + 
            "** Time In Queue" +  "\t" + ": " + this.timeInQueue + "\n" + 
            "** Service Time" +  "\t" + ": " + this.serviceTime + "\n" +
            "** Departure Time" +  "\t" + ": " + this.departureTime + "\n" +
           // "** Served By Server" +  "\t" + ": " + Queue.getServerName + "\n" +
            "** Service Level" +  "\t" + ": " + estimateServiceLevel() + "\n";
 
 
 }
 
 










//end of class
}