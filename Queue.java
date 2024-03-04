public class Queue{

 //fields
 
 private String serverName;
 private int queueSize;
 private Client clientBeingServed;
 private Request requestInProgress;
 private int processingStartTime;
 private Client[] clientsHistory;
 private Client[] clientsInQueue;
 
 //getters and setters

 public void setServerName(String serverName){

    this.serverName = serverName;
 }

 public String getServerName(){

    return this.serverName;
 }

 public void setQueueSize(int queueSize){

    this.queueSize = queueSize;
 }

 public int getQueueSize(){

    return this.queueSize;
 }

 public void setClientBeingServed(Client clientBeingServed){

    this.clientBeingServed = clientBeingServed;
 }

 public Client getClientBeingServed(){

    return this.clientBeingServed;
 }

 public void setRequestInProgress(Request requestInProgress){

    this.requestInProgress = requestInProgress;
 }

 public Request getRequestInProgress(){

    return this.requestInProgress;
 }


 public void setProcessingStartTime(int processingStartTime){

    this.processingStartTime = processingStartTime;
 }

 public int getProcessingStartTime(){

    return this.processingStartTime;
 }

 public void setClientsHistory(Client[] clientsHistory){

    this.clientsHistory = clientsHistory;
 }


 public Client[] getClientsHistory(){

    return this.clientsHistory;
 }

 public void setClientsInQueue(Client[] clientsInQueue){

    this.clientsInQueue = clientsInQueue;
 }

 public Client[] getClientsInQueue(){

    return this.clientsInQueue; 
 }

 //constructer

 public Queue(String serverName, int queueSize){

    setServerName(serverName);
    setQueueSize(queueSize);

    setClientsInQueue(new Client[queueSize]);


 }


 //helper methods

 public void addToHistory(Client c){

        Client[] tmp = new Client[getClientsHistory().length+1];

        for (int i = 0; i < getClientsHistory().length; i++){
            tmp[i] = this.clientsHistory[i];
        }

        tmp[tmp.length-1] = c; 

        setClientsHistory(tmp);
 }

 public static Client moveClient(Client c, Client[] arr){
    for (int i = 0; i < arr.length; i++){
       if (arr[i] == c)
          arr[i] = null;
    }
 
    return c; 
 }

 public void removeClient(Client c, Client[] arr){
    for (int i = 0; i < arr.length; i++){
       if (arr[i] == c)
          arr[i] = null;
    }
 }

 public void shiftClients(Client[] c){
    for (int i = 0; i < c.length - 1; i++){
       if (c[i] == null)
          c[i] = c[i + 1];
    }
 }

 public void shiftAllTheWay(Client[] arr){
     Client[] temp = new Client[arr.length];

     int count = 0;
     for (int i = 0; i < arr.length; i++){
     if (arr[i] != null){
        temp[count] = arr[i];
        count++;
        }
    }  
    
    setClientsInQueue(temp);
 }

 




 //other methods

 public String toString(){

    String system = ""; 
   
    for (int i = 0; i < QueueSystem.getQueues().length; i++){
        if (this == QueueSystem.getQueues()[i]){
            system += "[Queue:" + String.format("%01d", i+1) + "]";
            break;
        }
    }

   
   if (getClientBeingServed() == null)
      system += "[  ]";
   else 
      system += "[" + String.format("%02d", getClientBeingServed().getID()) + "]";

   system += "-----";

   for (int i = 0; i < getClientsInQueue().length; i++){
         if (getClientsInQueue()[i] == null)
            system += "[  ]";
         else 
            system += "[" + String.format("%02d", getClientsInQueue()[i].getID()) + "]";
      
   }

   system+=  "\n";

   return system;
 }

 //helper method for to string with processing times
 public String processingToString(){
    String system = ""; 

    for (int i = 0; i < QueueSystem.getQueues().length; i++){
        if (this == QueueSystem.getQueues()[i]){
            system += "[Queue:" + String.format("%01d", i+1) + "]";
            break;
        }
    }
   
    if (getClientBeingServed() == null)
       system += "[  ]";
    else 
       system += "[" + String.format("%02d", getClientBeingServed().remainingProcessingTime()) + "]";
 
    system += "-----";
 
    for (int i = 0; i < getClientsInQueue().length; i++){
          if (getClientsInQueue()[i] == null)
             system += "[  ]";
          else 
             system += "[" + String.format("%02d", getClientsInQueue()[i].totalProcessingTime()) + "]";
       
    }
 
    system+=  "\n";
 
    return system;

 } 
 
public String toString(boolean showID){
    String sys = "";
    if (showID == true){
        sys += toString();
    }

    else{
        sys += processingToString();

    }
    
    return sys;

}

 








//end of class
}