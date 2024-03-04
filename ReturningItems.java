public class ReturningItems extends Request{

//fields
 
 private String[] itemsToReturn;
 
 //setters and getters
 
 public void setItemsToReturn(String[] itemsToReturn){
 
    this.itemsToReturn = itemsToReturn;
 
 }


 public String[] getItemsToReturn(){
 
    return this.itemsToReturn;
 
 }


//constructer


 public ReturningItems(String description, int priority, int difficulty, String[] itemsToReturn){
 
    setDescription(description);
    setPriority(priority);
    setDifficulty(difficulty);
    
    setItemsToReturn(itemsToReturn);
    
    setFactor(3);
    setStatus(Status.NEW);
    
    setStartTime(0);
    setEndTime(0);
    setCompletionLevel(0);
    
    
    
 }
 
  //method from Parent class
  
  @Override
  public int calculateProcessingTime(){

    int processingTime; 
    
    processingTime = getDifficulty() * getFactor() * this.itemsToReturn.length;
    
    return processingTime;

}



//end of class
}