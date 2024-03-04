public class QueueSystem{




 public static void main(String[] args){
 
 /**
    QueueSystem q = new QueueSystem(100, true, true);
    
    System.out.println(q.getTvInWaitingArea());
    System.out.println(q.getClock());
    
 System.out.println(waitingLine.length);
 
 
    //q.increaseTime();
    System.out.println(q.getClock());
    
    Client f = new Client("Sadaf", "Sayed", 2003, "FEMALE", 1);
     Client c = new Client("bob", "bob", 2003, "FEMALE", 10000);
    
    Client[] cli = {c, f};
    setClientsWorld(cli);
    
    //q.increaseTime();
    
    
   //sortID(cli);
    
    System.out.println(getClock());
    System.out.print(cli.length);
    
    
    */
    /**
            QueueSystem.setClock(0);
			QueueSystem.setQueues(null);

			// Create the system objects for Test01
			Client client1 = new Client("John1", "Peter1", 1977, "MALE", 1, 50, null);
			String[] items1 = { "Q1" };
			InformationRequest r11 = new InformationRequest("IR1", 5, 5, items1);
			Request[] rList1 = { r11 };
			client1.setRequests(rList1);
			Queue q1 = new Queue("Noah", 2);
			QueueSystem qS = new QueueSystem(1, false, false);
			qS.setQueues(new Queue[1]);
			Client[] clientsInWorld = new Client[1];
			clientsInWorld[0] = client1;
			QueueSystem.setClientsWorld(clientsInWorld);
			qS.getQueues()[0] = q1;
			
			System.out.println(qS.getClock());
    
 */
 
 }
 
 
 //fields
 
 private static int clock;
 private static int totalWaitingTime;
 private static Client[] clientsWorld;
 private static int totalClientsInSystem;
 private static int waitingLineSize;
 private static Client[] waitingLine;
 private static boolean tvInWaitingArea;
 private static boolean coffeeInWaitingArea;
 private static Queue[] queues;


 
 
 
 
 
 //setters and getters

 public static void setClock(int clock){
 
    QueueSystem.clock = clock;
 
 }

 public static int getClock(){
    
    return clock;
 
 }

 public static void setTotalWaitingTime(int totalWaitingTime){
 
    QueueSystem.totalWaitingTime = totalWaitingTime;
 
 }

 public static int getTotalWaitingTime(){
    
    return totalWaitingTime;
 
 }

 public static void setClientsWorld(Client[] clientsWorld){
 
    QueueSystem.clientsWorld = clientsWorld;
 
 }

 public static Client[] getClientsWorld(){
    
    return clientsWorld;
 
 }

 
 public static void setTotalClientsInSystem(int totalClientsInSystem){
 
    QueueSystem.totalClientsInSystem = totalClientsInSystem;
 
 }

 public static int getTotalClientsInSystem(){
    
    return totalClientsInSystem;
 
 }
 
  public static void setWaitingLineSize(int waitingLineSize){
 
    QueueSystem.waitingLineSize = waitingLineSize;
 
 }
 
 
 public static int getWaitingLineSize(){
    
    return waitingLineSize;
 
 }

 
  public static void setWaitingLine(Client[] waitingLine){
 
    QueueSystem.waitingLine = waitingLine;
 
 }
 
 
 public static Client[] getWaitingLine(){
    
    return waitingLine;
 
 }
 
 public static void setTvInWaitingArea(boolean tvInWaitingArea){
 
    QueueSystem.tvInWaitingArea = tvInWaitingArea;
 }


 public static boolean getTvInWaitingArea(){
 
    return tvInWaitingArea;
 
 }

public static void setCoffeeInWaitingArea(boolean coffeeInWaitingArea){
 
    QueueSystem.coffeeInWaitingArea = coffeeInWaitingArea;
 }


 public static boolean getCoffeeInWaitingArea(){
 
    return coffeeInWaitingArea;
 
 }


 public static void setQueues(Queue[] queues){
 
    QueueSystem.queues = queues;
 
 }
 
 public static Queue[] getQueues(){
 
    return queues;
 }
 
 
 
 
 //1 constructer
 
 public QueueSystem(int waitingLineSize, boolean tvInWaitingArea, boolean coffeeInWaitingArea){
 
    setClock(0);
    setWaitingLineSize(waitingLineSize);
    
    setTvInWaitingArea(tvInWaitingArea);
    setCoffeeInWaitingArea(coffeeInWaitingArea);
    
    Client[] waitingLine = new Client[waitingLineSize];
    
    QueueSystem.waitingLine = waitingLine;
    
    //setWaitingLine(waitingLine);
    
    
    
 
 }

 //helper methods

 public static Client[] sortID(Client[] idArray){

   for (int i = 0; i < idArray.length; i++){
      for (int j = i + 1; j < idArray.length; j++){
         Client temp;
         if (idArray[i].getID() > idArray[j].getID()){
            temp = idArray[j];
            idArray[j] = idArray[i];
            idArray[i] = temp;
         }
      }
          
   }
   return idArray; 
}
 

public static Client moveClient(Client c, Client[] arr){
   for (int i = 0; i < arr.length; i++){
      if (arr[i] == c)
         arr[i] = null;
   }

   return c; 
}

public static void shiftClients(Client[] c){
   for (int i = 0; i < c.length - 1; i++){
      if (c[i] == null)
         c[i] = c[i + 1];
   }
}

public static void removeClient(Client c, Client[] arr){
   for (int i = 0; i < arr.length; i++){
      if (arr[i] == null)
         continue;
      if (arr[i] == c){
         arr[i] = null;
         break;
      }
   }
}


//to check if there are any spots in any of the queues
public static boolean anyAvailableSpotsInSystem(){
    
   boolean available = false;
   for (int i = 0; i < queues.length; i++){
       if (countAvailableSpots(queues[i].getClientsInQueue()) > 0){
       available = true;
       break; 
       }
   }

   return available; 
}


//to check how many spots available in a queue 
public static int countAvailableSpots(Client[] c){

   int count = 0;
   for (int i = 0; i < c.length; i++){
       if (c[i] == null)
           count++;

        }
    return count; 
   }
 

//returns the index of the queue with the most spots open 
public int mostAvailableSpots(Queue[] queues){
   int max = 0; //queues[0].getClientsInQueue;

   for (int i = 0; i < queues.length; i++){
       if (countAvailableSpots(queues[i].getClientsInQueue()) > countAvailableSpots(queues[i].getClientsInQueue())){
           max = i;
       }
   }

   return max;
}


 //methods
 
 public void increaseTime(){
   
   //increase the clock 
    clock+=1; 
    
    
    if (clock > 1){
    //going through each queue array of queues 
    if(queues != null){
    for (int i = 0; i < queues.length; i++){
      //looking at the request info of the client at the server
      if((queues[i] != null) && (queues[i].getClientBeingServed() != null)){
      for(int j = 0; j < queues[i].getClientBeingServed().getRequests().length; j++){
         
         //check to see if request in progress.. so then either continue or check if completion level is 100
         if (queues[i].getClientBeingServed().getRequests()[j].getStatus() == Status.IN_PROGRESS){
            
            //queues[i].getRequestInProgress().setCompletionLevel((int)((clock -  queues[i].getRequestInProgress().getStartTime())/ queues[i].getRequestInProgress().calculateProcessingTime()));
            //check if the completion level is 100 and if it is change status and set the end time for that request
            if (queues[i].getRequestInProgress().getCompletionLevel() == 100){
               queues[i].getRequestInProgress().setStatus(Status.PROCESSED);
               queues[i].getRequestInProgress().setEndTime(clock);
                  //checking if this is the last request of the client so the attributes can be set, and can be added to clients history 
                  if (j == queues[i].getClientBeingServed().getRequests().length - 1){
                     queues[i].getClientBeingServed().setDepartureTime(clock);
                     queues[i].getClientBeingServed().setServiceTime(queues[i].getClientBeingServed().getServiceTime() + 1);
                     queues[i].addToHistory(queues[i].getClientBeingServed());
                     queues[i].setClientBeingServed(null);


                  }

                  //if there are still more requests for the client
                  else {
                     queues[i].setRequestInProgress(queues[i].getClientBeingServed().getRequests()[j + 1]);
                     queues[i].getClientBeingServed().getRequests()[j+1].setStatus(Status.IN_PROGRESS);
                     //queues[i].setRequestInProgress(requests[j+1]);
                     queues[i].getRequestInProgress().setStartTime(clock);
                     queues[i].getClientBeingServed().setServiceTime(queues[i].getClientBeingServed().getServiceTime() + 1);
                  }
               }
              
                break;
         }
         
       

         //start the progress if it is NEW...this will most likely be for a newly added client at the server
         else if(queues[i].getClientBeingServed().getRequests()[j].getStatus() == Status.NEW){
               queues[i].getClientBeingServed().getRequests()[j].setStatus(Status.IN_PROGRESS);
               queues[i].setRequestInProgress(queues[i].getClientBeingServed().getRequests()[j]);
               queues[i].getRequestInProgress().setStartTime(clock);

               //check if it is 1st request of client 
               if (j == 0){

                  queues[i].setProcessingStartTime(clock); 
                  queues[i].getClientBeingServed().setServiceTime(queues[i].getClientBeingServed().getServiceTime() + 1); //queues[i].getClientBeingServed().getServiceTime() + 1);
            }

            queues[i].getRequestInProgress().setCompletionLevel((int)((clock -  queues[i].getRequestInProgress().getStartTime()) / queues[i].getRequestInProgress().calculateProcessingTime()));

            break;
         }
         
         

         //if a request is done, look at the next one 
         else {
            continue;
         }
      }
   }
   }
}


   /////check patience level for all in the system and see if any need to removed//////////
   
   if (queues != null){
   for (int i = 0; i < queues.length; i++){
      if (queues[i] != null){
      for (int j = 0; j < queues[i].getClientsInQueue().length; j++){
         if ( (queues[i].getClientsInQueue()[j] != null) && (queues[i].getClientsInQueue()[j].getPatience() < 0)){
            queues[i].getClientsInQueue()[j].setDepartureTime(clock);
            queues[i].removeClient(queues[i].getClientsInQueue()[j], queues[i].getClientsInQueue());
         }
       }
         queues[i].shiftAllTheWay(queues[i].getClientsInQueue());
      }
   }
   
}
   //checking if the next client in each queue can go to a server
   for (int i = 0; i < queues.length; i++){
      if (queues[i].getClientBeingServed() == null){
         //if a new client can be moved, then must move it from the queue and set to the clientbeingserved
         queues[i].setClientBeingServed(moveClient(queues[i].getClientsInQueue()[0], queues[i].getClientsInQueue()));
         queues[i].shiftClients(queues[i].getClientsInQueue());
         
      }
   }
   

   //moving from waitingline to queue if availabe spots
   while ((anyAvailableSpotsInSystem() == true) && (countAvailableSpots(waitingLine) != waitingLineSize)){
      if (getWaitingLine()[0] != null){
      queues[mostAvailableSpots(queues)].getClientsInQueue()[queues[mostAvailableSpots(queues)].getClientsInQueue().length-1] = moveClient(getWaitingLine()[0], getWaitingLine());
      shiftClients(getWaitingLine());
      }
   }


   ////update values///////////

    
}
   
   int entered = 0; //checking how many of the arrival time = the clock 

    for (int c = 0; c < clientsWorld.length; c++){

         if (clientsWorld[c].getArrivalTime() == clock)
            entered+=1;
   }
 
   Client[] enteredClients = new Client[entered];

   
   
   //for (int c = 0; c < enteredClients.length; c++){
      
      for (int i = 0; i < clientsWorld.length; i++){
         int enteredIndex = 0;
         if (clientsWorld[i].getArrivalTime() == clock){
            
         enteredClients[enteredIndex] = clientsWorld[i];
            enteredIndex++;
         
         }   
       }
   //}
   

   sortID(enteredClients); //organizes the clients that have the current arrival time by ID 

   //time to put them in the waiting line OR the server 

   //check if waiting line is full.... then just remove the clients from system.. so we dotn look at them again 
   if (waitingLine[waitingLine.length - 1] != null){
      for (int i = 0; i < enteredClients.length; i++){
         removeClient(enteredClients[i], enteredClients);
      }
   }

   //check if any servers r available
   if ((enteredClients.length != 0) && (queues.length != 0)){
   for(int i =0; i < queues.length; i++){
      int x = 0;
      if ((queues[i] != null) && (queues[i].getClientBeingServed() == null)){
         queues[i].setClientBeingServed(moveClient(enteredClients[x], enteredClients));
         shiftClients(enteredClients);
         if (x == entered-1)
            break;
         else
            x++;
      }
   }
   }

   if ((enteredClients.length != 0))
   for (int i = 0; i < waitingLine.length; i++){
      if (waitingLine[i] == null){
         waitingLine[i] = enteredClients[i];
            if (getTvInWaitingArea() == true)
               waitingLine[i].setPatience(waitingLine[i].getPatience() + 20);
            if (getCoffeeInWaitingArea() == true)
               waitingLine[i].setPatience(waitingLine[i].getPatience() + 15);
      }
   }

   



  /**  if (entered == 1 )
      index = 0;
      for (int i = 0; i < enteredClients.length; i++){
         waitingLine[i] = enteredClients[i];
      }

   
   
      for (int i = 0; i < enteredClients.length; i++){
         waitingLine[i] = enteredClients[i];
   }
*/



//end of icreaseTime   
}
 
 public void increaseTime(int time){

   for (int i = 0; i < time; i++)
      increaseTime();
 }
 

 public Client[] getClientsBeingServed(){
   
   int num = 0;
   for (int i = 0; i < queues.length; i++){
      if (queues[i].getClientBeingServed() != null)
         num++;
   }
   Client[] beingServed = new Client[num];
   int index = 0;
   for (int i = 0; i < queues.length; i++){
      if (queues[i].getClientBeingServed() != null){
         beingServed[index] = queues[i].getClientBeingServed();
         index++; 
      }

   }

   return beingServed;
 }
 

 //helper method for toString with processing times
 public String helpToString(Queue q){

   String system = ""; 
   
   if (q.getClientBeingServed() == null)
      system += "[  ]";
   else 
      system += "[" + String.format("%02d", q.getClientBeingServed().remainingProcessingTime()) + "]";

   system += "-----";

   for (int i = 0; i < q.getClientsInQueue().length; i++){
         if (q.getClientsInQueue()[i] == null)
            system += "[ ]";
         else 
            system += "[" + String.format("%02d", q.getClientsInQueue()[i].totalProcessingTime()) + "]";
      
   }

   system+=  "\n";

   return system;
   
}

//helper method for waiting line with processing times in toString 
public String waitingLineHelpToStringTimes(Client[] c){

   String system = "";

   system += "[WaitingLine]"; 

   for (int i = 0; i < c.length; i++){
      if (c[i] == null)
            system += "[  ]";
         else 
            system += "[" + String.format("%02d", c[i].totalProcessingTime()) + "]";
   }

   system+=  "\n";

   return system;
 }



 public String toString(){
   
   String sys = "";
   
   for (int j = 0; j < queues.length; j++){
      sys += "[Queue:" + String.format("%01d", j+1) + "]";
      sys += helpToString(queues[j]);
      }

      sys += "---";

      sys += waitingLineHelpToStringTimes(waitingLine);
  

  return sys;
   
 }

 
 
 
 //helper method for toString with ID
public String helpToStringID(Queue q){
   String system = ""; 
   
   if (q.getClientBeingServed() == null)
      system += "[  ]";
   else 
      system += "[" + String.format("%02d", q.getClientBeingServed().getID()) + "]";

   system += "-----";

   for (int i = 0; i < q.getClientsInQueue().length; i++){
         if (q.getClientsInQueue()[i] == null)
            system += "[  ]";
         else 
            system += "[" + String.format("%02d", q.getClientsInQueue()[i].getID()) + "]";
      
   }

   system+=  "\n";

   return system;
   

 }

 //helper method for waiting line with ID in toString 
 public String waitingLineHelpToStringID(Client[] c){

   String system = "";

   system += "[WaitingLine]"; 

   for (int i = 0; i < c.length; i++){
      if (c[i] == null)
            system += "[  ]";
         else 
            system += "[" + String.format("%02d", c[i].getID()) + "]";
   }

   system+=  "\n";

   return system;
 }

public String toString(boolean showID){
  
   String sys = "";
   if (showID == true){
      for (int j = 0; j < queues.length; j++){
         sys += "[Queue:" + String.format("%01d", j+1) + "]";
         sys += helpToStringID(queues[j]) + "\n";
      }

      sys += "---";

      sys += waitingLineHelpToStringID(waitingLine);
  }

  else{
   for (int j = 0; j < queues.length; j++){
      sys += "[Queue:" + String.format("%01d", j+1) + "]";
      sys += helpToString(queues[j]) + "\n";
   }

   sys += "---";
   sys += waitingLineHelpToStringTimes(waitingLine);

  }

  return sys;

}








//end of class
}