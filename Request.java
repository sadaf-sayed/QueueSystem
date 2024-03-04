public abstract class Request implements Prioritizable{

//fields

 private String description;
 private int priority;
 private int difficulty;
 private int factor;
 private int startTime;
 private int endTime;
 private int completionLevel;
 private Status status;

//getters and setter

 public void setDescription(String description){
 
    this.description = description;
 }

 public String getDescription(){

    return this.description;

 }

 
 public void setPriority(int priority){
 
    this.priority = priority;
 }


 public int getPriority(){
 
    return this.priority;
 
 }

public void setDifficulty(int difficulty){
 
    this.difficulty = difficulty;
 }


 public int getDifficulty(){
 
    return this.difficulty;
 
 }

 public void setFactor(int factor){
 
    this.factor = factor;
 }


 public int getFactor(){
 
    return this.factor;
 
 }
 
 public void setStartTime(int startTime){
 
    this.startTime = startTime;
 }


 public int getStartTime(){
 
    return this.startTime;
 
 }

 
 public void setEndTime(int endTime){
 
    this.endTime = endTime;
 }


 public int getEndTime(){
 
    return this.endTime;
 
 }

 public void setCompletionLevel(int completionLevel){
 
    this.completionLevel = completionLevel;
 }


 public int getCompletionLevel(){
 
    return this.completionLevel;
 
 }

 public void setStatus(Status status){
 
    this.status = status;
 }


 public Status getStatus(){
 
    return this.status;
 
 }

 
 //abstract method
 public abstract int calculateProcessingTime();




//end of class
}