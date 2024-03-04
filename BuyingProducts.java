public class BuyingProducts extends Request{



 //fields
 
 private String[] itemsToBuy;
 
 //getters and setters
 
 public void setItemsToBuy(String[] itemsToBuy){
 
    this.itemsToBuy = itemsToBuy;
 
 }

 public String[] getItemsToBuy(){
 
    return this.itemsToBuy;
 
 }

 //constructer
 
 public BuyingProducts(String description, int priority, int difficulty, String[] itemsToBuy){
 
    setDescription(description);
    setPriority(priority);
    setDifficulty(difficulty);
    
    setItemsToBuy(itemsToBuy);
    
    setFactor(2);
    setStatus(Status.NEW);
    
    setStartTime(0);
    setEndTime(0);
    setCompletionLevel(0);
   
 }

//method from Parent class 
  
  @Override
  public int calculateProcessingTime(){

    int processingTime; 
    
    processingTime = getDifficulty() * getFactor() * this.itemsToBuy.length;
    
    return processingTime;

}





//end class
}