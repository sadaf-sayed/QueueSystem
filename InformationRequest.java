public class InformationRequest extends Request{


 //fields 
 
 private String[] questions;
 
 //setter and getter
 
 public void setQuestions(String[] questions){
    
        this.questions = questions;
 
 }
 
 public String[] getQuestions(){
    
    return this.questions;
 
 }


//constructer

 
 public InformationRequest(String description, int priority, int difficulty, String[] questions){
 
    setDescription(description);
    setPriority(priority);
    setDifficulty(difficulty);
    
    setQuestions(questions);
    
    setFactor(1);
    setStatus(Status.NEW);
    
    setStartTime(0);
    setEndTime(0);
    setCompletionLevel(0);
    
    
 }


 //method from Parent class
 //@Override
 public int calculateProcessingTime(){

    int processingTime; 
    
    processingTime = getDifficulty() * getFactor() * this.questions.length;
    
    return processingTime;

}











//end class
}