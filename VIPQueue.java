public class VIPQueue extends Queue{


//fields

 private boolean acceptingAnyClients;


//getters and setters

 public void setAcceptingAnyClients(boolean acceptingAnyClients){
    
    this.acceptingAnyClients = acceptingAnyClients;
 }


 public boolean getAcceptingAnyClients(){
 
    return acceptingAnyClients;
 }



//2 constructers


 public VIPQueue(String serverName, int queueSize, boolean acceptAnyClients){
    
    super(serverName, queueSize);
    setServerName(serverName);
    setQueueSize(queueSize);
    
    
    setAcceptingAnyClients(acceptAnyClients);
 
 
 }


public VIPQueue(String serverName, int queueSize){
    
   super(serverName, queueSize);
    
    setServerName(serverName);
    setQueueSize(queueSize);
    
 
 
 }




//end of class
}