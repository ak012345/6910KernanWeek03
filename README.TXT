I created 3 setter methods in the AbstractPlayer.java class, which isn't included 
in the Player interface, because I don't think the whole program should be 
able to modify the instance variables but the interface must be set to 'public', and 
it is not possible to down-grade access from a public interface.  

I think it would have been better to simply assign the instance variables in the abstract class to have the default access modifier,
and put all the common Player methods into the interface, but that would throw a checkstyle error. 
 
 Is there a reason this would be a bad idea?
 It seems to me that making an instance variable private, but a public setter method, defeats the purpose.