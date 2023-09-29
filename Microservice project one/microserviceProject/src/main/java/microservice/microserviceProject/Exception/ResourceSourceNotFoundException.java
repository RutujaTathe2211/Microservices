package microservice.microserviceProject.Exception;

public class ResourceSourceNotFoundException extends RuntimeException{
    //extra properties that you want to store/manage
    public ResourceSourceNotFoundException(){
        super("Resource not found on server!!");
    }
    public ResourceSourceNotFoundException(String message){
        super(message);
    }
}
